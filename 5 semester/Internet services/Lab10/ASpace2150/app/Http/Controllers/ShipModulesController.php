<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\ShipModules;
use App\Models\ModuleCrew;
use Illuminate\Validation\Rule;

use Illuminate\Support\Facades\Http;

class ShipModulesController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        $myShipModules = ShipModules::all();

        return view('shipModules.list', ['ship_modules' => $myShipModules]);
    }

    // api version of index
    public function index_api()
    {
        $myAPI_URL = config('app.url')."api/shipModules/list";
        
        $response = Http::withBasicAuth('student','student')->get($myAPI_URL);
        if ($response->successful()) {
            $myShipModules = json_decode(json_encode($response->json()['data']));
            return view('shipModules.list', ['ship_modules' => $myShipModules,]);
        } else {
            return view('shipModules.list', ['ship_modules' => []]);
        }

    }
    
    public function assignedCrew($id) {
        $crew = ModuleCrew::all()->where('ship_module_id',$id);
        $module = ShipModules::find($id);
    
        if ($crew == null || $module == null) 
        {
            $error_message = "Crew for module=".$id." not found";
            return view("shipModules.message", ['message'=>$error_message,'type_of_message'=>'Error']);
        }
        
        if ($crew->count() == 0) 
        {
            $error_message = "There is no crew for module ".$module->module_name;
            return view("shipModules.message", ['message'=>$error_message,'type_of_message'=>'No crew members']);
        }
        
        if ($crew->count() > 0) {
            return view('shipModules.assignedCrew', ['crew' => $crew, 'module' => $module]);
        }
    }

    public function assignedCrew_api($id) {
        
        $getCrew_URL = config('app.url')."api/moduleCrew/assignedCrew/".$id;
        $getModule_URL = config('app.url')."api/shipModules/find/".$id;
        $responseCrew = Http::withBasicAuth('student','student')->get($getCrew_URL);
        $responseModule = Http::withBasicAuth('student','student')->get($getModule_URL);
    

        if ($responseCrew->successful() && $responseModule->successful()) {
            $crew = json_decode(json_encode($responseCrew->json()['data']));
            $module = json_decode(json_encode($responseModule->json()['data']));
        
            if (empty($crew)) {
                $error_message = "There is no crew for module ".$module->module_name;
                return view("shipModules.message", ['message'=>$error_message,'type_of_message'=>'No crew members']);
            } else {
                return view('shipModules.assignedCrew', ['crew' => $crew, 'module' => $module]);
            }
        } else {
            $error_message = "Crew for module=".$id." not found";
            return view("shipModules.message", ['message'=>$error_message,'type_of_message'=>'Error']);
        }

    }

    /**
     * Show the form for creating a new resource.
     */
    public function create()
    {
        return view('shipModules.add');
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        $validated = $request->validate([
            'module_name' => 'required|min:3|max:25|unique:ship_modules',
            'is_workable' => 'required',
        ]);

        if($validated)
        {
            $mod_ship = new ShipModules();

            $mod_ship->module_name = $request->module_name;
            $mod_ship->is_workable = $request->is_workable;

            $mod_ship->save();
            return redirect('/shipModules/list');
        }

    }

    public function store_api(Request $request)
    {
        
        $myAPI_URL = config('app.url')."api/shipModules/new";
            
        $response = Http::withBasicAuth('student','student')->post($myAPI_URL, $request);
        return redirect('/shipModules/list');
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        $myShipModule = ShipModules::find($id);
        
        if ($myShipModule == null) 
        {
            $error_message = "Ship module id=".$id." not found";
            return view("shipModules.message", ['message'=>$error_message,'type_of_message'=>'Error']);
        }

        if ($myShipModule->count() > 0) {
            return view('shipModules.show', ['shipModule' => $myShipModule]);
        }
    }

    public function show_api($id) {
        $myAPI_URL = config('app.url')."api/shipModules/find/".$id;
    
        $response = Http::withBasicAuth('student','student')->get($myAPI_URL);
    
        if ($response->successful()) {
            $myShipModule = json_decode(json_encode($response->json()['data']));
            return view('shipModules.show', ['shipModule' => $myShipModule]);
        } else {
            $error_message = "Ship module id=".$id." not found";
            return view("shipModules.message", ['message'=>$error_message,'type_of_message'=>'Error']);
        }
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(string $id)
    {
        $myShipModule = ShipModules::find($id);

        if ($myShipModule == null) 
        {
            $error_message = "Ship module id=".$id." not found";
            return view("shipModules.message", ['message'=>$error_message,'type_of_message'=>'Error']);
        }

        if ($myShipModule->count() > 0) {
            return view('shipModules.edit', ['shipModule' => $myShipModule]);
        }
    }

    public function edit_api(string $id)
    {
        $myAPI_URL = config('app.url')."api/shipModules/find/".$id;
    
        $response = Http::withBasicAuth('student','student')->get($myAPI_URL);
    
        if ($response->successful()) {
            $myShipModule = json_decode(json_encode($response->json()['data']));
            return view('shipModules.edit', ['shipModule' => $myShipModule]);
        } else {
            $error_message = "Ship module id=".$id." not found";
            return view("shipModules.message", ['message'=>$error_message,'type_of_message'=>'Error']);
        }
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, string $id)
    {
        $validated = $request->validate([
            'module_name' => [
                'required',
                'min:3',
                'max:25',
                Rule::unique('ship_modules')->ignore($id),
            ],
            'is_workable' => 'required',
        ]);

        if($validated) {
            $mod_ship = ShipModules::find($id);

            if($mod_ship != null) {
                $mod_ship->module_name = $request->module_name;
                $mod_ship->is_workable = $request->is_workable;
                $mod_ship->save();

                return redirect('/shipModules/list');
            }
            else
            {
                $error_message = "Ship module id=".$id." not found";
                return view('shipModules.message', ['message'=>$error_message,'type_of_message'=>'Error']);
            }
        }
    }

    public function update_api(Request $request, string $id)
    {
        $myAPI_URL = config('app.url')."api/shipModules/update/".$id;
    
        $response = Http::withBasicAuth('student','student')->patch($myAPI_URL, $request);
        return redirect('/shipModules/list');
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy($id)
    {
        $mod_ship = ShipModules::find($id);
        if($mod_ship != null) {
            $mod_ship->delete();
            return redirect('/shipModules/list');
        }
        else {
            $error_message = "Delete ship module id=".$id." not found";
            return view('shipModules.message', ['message'=>$error_message,'type_of_message'=>'Error']);
        }

    }

    public function destroy_api($id)
    {
        $myAPI_URL = config('app.url')."api/shipModules/delete/".$id;
        $response = Http::withBasicAuth('student','student')->delete($myAPI_URL);
        return redirect('/shipModules/list');
    }
}