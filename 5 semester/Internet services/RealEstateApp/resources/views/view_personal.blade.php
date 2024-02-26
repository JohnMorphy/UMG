<!DOCTYPE html>
<html lang="en">
@include('partials.head')
<body>
@include('partials.navi')
<div id="content">

    <div class="personal-card">
        <h2>User Information</h2>
        <p><strong>First Name:</strong> {{ auth()->user()->userData->user_firstname }}</p>
        <p><strong>Last Name:</strong> {{ auth()->user()->userData->user_lastname }}</p>
        <p><strong>Email:</strong> {{ auth()->user()->email }}</p>
        <p><strong>Phone Number:</strong> {{ auth()->user()->userData->user_phonenumber }}</p>

        <form action="{{ route('user_data_edit', ['id' => auth()->id()]) }}" method="get">
            @csrf
            <button type="submit">Edit Personal Data</button>
        </form>
    </div>

    <table class="offer-table">
        @if($offers->isNotEmpty())
        <h1>Your Offers</h1>
        @foreach($offers as $offer)
        
        <tr class="offer-row">
            <td onclick="window.location.href='{{ route('offer_getById', ['id' => $offer->id]) }}';" >
                @if($offer->filepath)
                    <img class="offer-photo" src="{{ asset('offerPhotos/' . $offer->filepath) }}" alt="Offer Photo" width="100">                
                @else
                    {{-- Default image if no photo is available --}}
                    <img class="offer-photo" src="{{ asset('images/defaultImage.jpg') }}" alt="Default Photo" width="100">
                @endif
            </td>
            <td onclick="window.location.href='{{ route('offer_getById', ['id' => $offer->id]) }}';" > 
                <div>
                    <h2>{{ $offer->title }}</h2>
                    <p>{{ \Illuminate\Support\Str::limit($offer->description, 200) }}</p>
                </div>
            </td>
            <td class = "list-offer-info" onclick="window.location.href='{{ route('offer_getById', ['id' => $offer->id]) }}';" >
                <div>
                    <p><strong>Address:</strong> {{ $offer->city }}, {{ $offer->street }} {{ $offer->address }}</p>
                    <p><strong>Postal Code:</strong> {{ $offer->offer_postalcode }}</p>
                    <p><strong>Price:</strong> ${{ $offer->offer_price }}</p>
                    <p><strong>Area:</strong> {{ $offer->area_in_meters }} m2</p>
                </div>
            </td>

            <td class="table-button" onclick="window.location.href='{{ route('show_edit_offer', ['id' => $offer->id]) }}';">
                @csrf                
                <span>Edit</span>
            </td>
        </tr>
        
        @endforeach
        @else
            <h1>You haven't created any offers yet.</h1>
        @endif
    </table>

</div>

</body>
@include('partials.footer')
</html>
