<?php
namespace App\Http\Controllers;

use Carbon\Carbon;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Auth;
use App\Models\Offer;
use App\Models\User;
use App\Models\UserData;
use App\Models\PropertyPhoto;
use Illuminate\Support\Facades\Log;
use Illuminate\Support\Facades\Storage;
use Illuminate\Support\Facades\File;


class WebController extends Controller{
     
    public function offerList(Request $request) {
        
        $query = DB::table('offer')
            ->leftJoin('users', 'offer.user_id', '=', 'users.id')
            ->leftJoin('user_data', 'users.id', '=', 'user_data.user_id')
            ->leftJoin('property_photos', function ($join) {
                $join->on('offer.id', '=', 'property_photos.offer_id')
                    ->whereRaw('property_photos.id = (
                        SELECT MIN(id) FROM property_photos
                        WHERE property_photos.offer_id = offer.id
                    )');
            });
    
        if ($request->has('city') && $request->filled('city')) {
            $query->where('offer.city', '=', $request->input('city'));
        }
    
        if ($request->has('min_price') && $request->filled('min_price')) {
            $query->where('offer.offer_price', '>=', $request->input('min_price'));
        }
    
        if ($request->has('max_price') && $request->filled('max_price')) {
            $query->where('offer.offer_price', '<=', $request->input('max_price'));
        }
    
        if ($request->has('min_area') && $request->filled('min_area')) {
            $query->where('offer.area_in_meters', '>=', $request->input('min_area'));
        }
    
        if ($request->has('max_area') && $request->filled('max_area')) {
            $query->where('offer.area_in_meters', '<=', $request->input('max_area'));
        }
    
        $currentDate = now()->toDateString();
        $query->where('offer.expiration_date', '>', $currentDate);
    
        $query->select(
            'offer.id',
            'offer.title',
            'offer.description',
            'offer.city',
            'offer.street',
            'offer.address',
            'offer.offer_postalcode',
            'offer.offer_price',
            'offer.area_in_meters',
            'property_photos.filepath'
        );
    
        $offers = $query->get();
    
        return view('offer_list', ['offers' => $offers]);
    }


    public function offer_getById($id) {
        
        $offer = DB::table('offer')
            ->where('id', $id)
            ->first();
    
        if (!$offer) {
            abort(404);
        }
    
        $user = DB::table('users')
            ->join('user_data', 'users.id', '=', 'user_data.user_id')
            ->where('users.id', $offer->user_id)
            ->first();
    
        $offerPhotos = DB::table('property_photos')
            ->where('offer_id', $id)
            ->get();
        
        return view('offer_getById', ['offer' => $offer, 'user' => $user, 'offerPhotos' => $offerPhotos]);
    }

    public function show_create_offer() {
        return view('offer_create');
    }

    public function storeOffer(Request $request)
    {

    $request->validate([
        'title' => 'required|string|max:50',
        'description' => 'required|string|max:2000',
        'offer_postalcode' => 'required|string|max:50',
        'offer_price' => 'required|integer',
        'area_in_meters' => 'required|integer',
        'expiration_date' => 'required|date',
        'street' => 'required|string|max:50',
        'address' => 'required|string|max:50',
        'city' => 'required|string|max:50',
        'photos.*' => 'image|mimes:jpeg,png,jpg,gif|max:2048',
    ]);

    $offer = Offer::create([
        'user_id' => auth()->id(),
        'title' => $request->input('title'),
        'description' => $request->input('description'),
        'offer_postalcode' => $request->input('offer_postalcode'),
        'offer_price' => $request->input('offer_price'),
        'area_in_meters' => $request->input('area_in_meters'),
        'expiration_date' => $request->input('expiration_date'),
        'street' => $request->input('street'),
        'address' => $request->input('address'),
        'city' => $request->input('city'),
    ]);

        if ($request->has('photos')) {
            foreach ($request->file('photos') as $photo) {    
                $filename = $offer->id . '_' . now()->format('Ymd') . '_' . uniqid() . '.' . $photo->getClientOriginalExtension();
                $photo->move(public_path('offerPhotos'), $filename);
            
                PropertyPhoto::create([
                    'offer_id' => $offer->id,
                    'filepath' => $filename,
                    'created_at' => now(),
                    'updated_at' => now(),
                ]);
            }
        }

        return redirect()->route('view_personal');
    }



    public function editUserData()
    {
        $id = auth()->id();
        $user = User::find($id);

        if (!$user || $id !== $user->id) {
            abort(403);
        }

        $userData = UserData::where('user_id', $user->id)->first();

        return view('user_data_edit', [
            'user' => $user,
            'userData' => $userData,
        ]);
    }


    public function updateUserData(Request $request)
    {
        $id = auth()->id();
        $user = User::find($id);
        
        if (!$user || $id !== $user->id) {
            abort(403);
        }

        $request->validate([
            'user_firstname' => ['required', 'string', 'max:50'],
            'user_lastname' => ['required', 'string', 'max:50'],
            'user_phonenumber' => ['required', 'integer'],
        ]);

        $userData = UserData::where('user_id', $id)->first();

        if (!$userData) {
            UserData::create([
                'user_id' => $user->id,
                'user_firstname' => '',
                'user_lastname' => '',
                'user_phonenumber' => null,
            ]);
        }

        // Update user data
        $userData->update([
            'user_firstname' => $request->input('user_firstname'),
            'user_lastname' => $request->input('user_lastname'),
            'user_phonenumber' => $request->input('user_phonenumber'),
        ]);

        return redirect()->route('view_personal');
    }

    public function show_edit_offer($id) {
        
        $userId = auth()->id();

        $offer = DB::table('offer')
            ->where('id', $id)
            ->first();
    
        if (!$offer) {
            abort(404);
        }

        if (!$userId || $userId !== $offer->user_id) {
            abort(403);
        }
    
        $user = DB::table('users')
            ->join('user_data', 'users.id', '=', 'user_data.user_id')
            ->where('users.id', $offer->user_id)
            ->first();
    
        $offerPhotos = DB::table('property_photos')
            ->where('offer_id', $id)
            ->get();
        
        return view('offer_edit', ['offer' => $offer, 'user' => $user, 'offerPhotos' => $offerPhotos]);
    }

public function update_offer(Request $request, $id) {

    $request->validate([
        'title' => 'required|string|max:50',
        'description' => 'required|string|max:2000',
        'offer_postalcode' => 'required|string|max:50',
        'offer_price' => 'required|integer',
        'area_in_meters' => 'required|integer',
        'expiration_date' => 'required|date',
        'street' => 'required|string|max:50',
        'address' => 'required|string|max:50',
        'city' => 'required|string|max:50',
        'photos.*' => 'image|mimes:jpeg,png,jpg,gif|max:2048',
    ]);

    $offer = Offer::find($id);

    if ($offer) {

        $userId = auth()->id();
        if(!$userId || $userId !== $offer->user_id) {
            abort(403);
        }

        $offer->update([
            'title' => $request->input('title'),
            'description' => $request->input('description'),
            'offer_postalcode' => $request->input('offer_postalcode'),
            'offer_price' => $request->input('offer_price'),
            'area_in_meters' => $request->input('area_in_meters'),
            'expiration_date' => $request->input('expiration_date'),
            'street' => $request->input('street'),
            'address' => $request->input('address'),
            'city' => $request->input('city'),
        ]);

        if ($request->has('photos')) {

            foreach ($request->file('photos') as $photo) {
                $filename = $offer->id . '_' . now()->format('Ymd') . '_' . uniqid() . '.' . $photo->getClientOriginalExtension();
                $photo->move(public_path('offerPhotos'), $filename);

                PropertyPhoto::create([
                    'offer_id' => $offer->id,
                    'filepath' => $filename,
                    'created_at' => now(),
                    'updated_at' => now(),
                ]);
            }
        }

            return redirect()->route('view_personal')->with('success', 'Offer updated successfully');
        } else {
            // Offer not found
            return redirect()->route('view_personal')->with('error', 'Offer not found');
        }
    }


    public function delete_offer($id) {

        $offer = Offer::find($id);

        if ($offer) {

            $user = auth()->user();

            if (!$user) {
                abort(403);
            }

            if (!($user->user_role_id === 2 || $user->id === $offer->user_id)) {
                abort(403);
            }

            $photos = PropertyPhoto::where('offer_id', $offer->id)->get();

            foreach ($photos as $photo) {
                File::delete('offerPhotos/' . $photo->filepath);
                $photo->delete();
            }

            $offer->delete();

            return redirect('view_personal')->with('success', 'Offer deleted successfully');
        } else {
            return redirect('view_personal')->with('error', 'Offer not found');
        }
    }

    public function delete_offerPhotos($id)
    {
        $offer = Offer::find($id);

        if (!$offer) {
            abort(404);
        }

        $userId = auth()->id();
        if(!$userId || $userId !== $offer->user_id) {
            abort(403);
        }

        $photos = PropertyPhoto::where('offer_id', $offer->id)->get();

        foreach ($photos as $photo) {
            File::delete('offerPhotos/' . $photo->filepath);
            $photo->delete();
        }

        return redirect()->back()->with('success', 'Offer photos deleted successfully.');
    }

    public function update_expirationDate($id) {

        $offer = Offer::find($id);

        if ($offer) {
            $offer->expiration_date = Carbon::now()->addMonths(3);

            $offer->save();
            return redirect('view_personal')->with('success', 'Expiration date updated successfully');
        } else {
            return redirect('view_personal')->with('error', 'Offer not found');
        }
    }

    public function view_personal() {
        
        $id = auth()->id();

        if(!$id) {
            abort(403);
        }

        $userData = DB::table('users')
            ->leftJoin('user_data', 'users.id', '=', 'user_data.user_id')
            ->where('users.id', '=', $id)
            ->select(
                'users.name',
                'users.email',
                'user_data.user_firstname',
                'user_data.user_lastname',
                'user_data.user_phonenumber'
            )
            ->get();

        $offers = DB::table('offer')
            ->leftJoin('users', 'offer.user_id', '=', 'users.id')
            ->leftJoin('user_data', 'users.id', '=', 'user_data.user_id')
            ->leftJoin('property_photos', function ($join) {
                $join->on('offer.id', '=', 'property_photos.offer_id')
                    ->whereRaw('property_photos.id = (
                        SELECT MIN(id) FROM property_photos
                        WHERE property_photos.offer_id = offer.id
                    )');
            }) 
            ->where('offer.user_id','=',$id)
            ->select(
                'offer.id',
                'offer.title',
                'offer.description',
                'offer.city',
                'offer.street',
                'offer.address',
                'offer.offer_postalcode',
                'offer.offer_price',
                'offer.area_in_meters',
                'property_photos.filepath'
            )
            ->get();

            
        return view('view_personal', ['offers' => $offers, 'user' => $userData]);

    }

    public function admin_dashboard_users() {
        $user = auth()->user();
    
        if (!$user) {
            abort(403);
        }

        if ($user->user_role_id !== 2) {
            abort(403);
        }
    
        $users = DB::table('users')
            ->join('user_data', 'users.id', '=', 'user_data.user_id')
            ->where('users.user_role_id', '!=', 2) // Filter users where user_role_id is not equal to 2
            ->get();
    
        return view('admin_dashboard_users', ['users' => $users]);
    }

    public function admin_delete_user($id) {
    
        if (!auth()->user() || auth()->user()->user_role_id !== 2) {
            abort(403);
        }

        $offers = Offer::where('user_id', $id)->get();

        foreach ($offers as $offer) {
            
            $this->delete_offer($offer->id);
        }

        $userData = UserData::where('user_id', $id)->first();

        if ($userData) {
            $userData->delete();
        }
        
        $user = User::find($id);

        if ($user) {
            $user->delete();
        }
    
        return redirect('admin_dashboard_users');;
    }

    public function admin_delete_offer($id) {
    
        if (!auth()->user() || auth()->user()->user_role_id !== 2) {
            abort(403);
        }

        $offer = Offer::where('id', $id)->get()->first();

        $this->delete_offer($offer->id);

        return redirect('admin_dashboard_offers');;
    }

    public function admin_dashboard_offers() {
        $user = auth()->user();
        
        if (!$user) {
            abort(403);
        }

        if ($user->user_role_id !== 2) {
            abort(403);
        }

        $offers = Offer::orderBy('user_id')->get();
    
        return view('admin_dashboard_offers', ['offers' => $offers]);
    }

    public function changeAuthorizationStatus() {
        if(auth()->check()){
            $user = auth()->user();
            Auth::logout();
            return redirect('offers');
        } else {
            return redirect('/register');
        }
    }


}
