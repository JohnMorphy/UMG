<!DOCTYPE html>
<html lang="en">
@include('partials.head')
<body>
@include('partials.navi')
<div id="content">

    <div class ="form-view">   
    <h1>Search offers</h1>

    <form id="search-bar" action="{{ route('offers') }}" method="get">

        <div class = "input-row">
            <img class='icon' src="{{ URL::asset('images/locationIcon.png') }}" alt="" width="20" height="20">
            <input type="text" name="city" id="city" placeholder="City">
            <button type="submit">Search</button>
        </div>

        <div class = "input-row">
            <input type="number" name="min_price" id="min_price" placeholder="Min Price">
            <span> - </span>
            <input type="number" name="max_price" id="max_price" placeholder="Max Price">
        </div>
        
        <div class = "input-row">
            <input type="number" name="min_area" id="min_area" placeholder="Min Area">
            <span> - </span>
            <input type="number" name="max_area" id="max_area" placeholder="Max Area">
        </div>

    </form>
    </div>

    <h1>Results</h1>
    <table class="offer-table">
        
        @if($offers->isNotEmpty())
            @foreach($offers as $offer)
                <tr class="offer-row" onclick="window.location.href='{{ route('offer_getById', ['id' => $offer->id]) }}';">
                    <td>
                        @if($offer->filepath)
                            <img class="offer-photo" src="{{ asset('offerPhotos/' . $offer->filepath) }}" alt="Offer Photo" width="100">
                        @else
                            <img class="offer-photo" src="{{ asset('images/defaultImage.jpg') }}" alt="Default Photo" width="100">
                        @endif
                    </td>
                    <td>
                        <div>
                            <h2>{{ $offer->title }}</h2>
                            <p>{{ \Illuminate\Support\Str::limit($offer->description, 200) }}</p>
                        </div>
                    </td>
                    <td class="list-offer-info">
                        <div>
                            <p><strong>Address:</strong> {{ $offer->city }}, {{ $offer->street }} {{ $offer->address }}</p>
                            <p><strong>Postal Code:</strong> {{ $offer->offer_postalcode }}</p>
                            <p><strong>Price:</strong> ${{ $offer->offer_price }}</p>
                            <p><strong>Area:</strong> {{ $offer->area_in_meters }} m2</p>
                        </div>
                    </td>  
                </tr>
            @endforeach
        @else
            <h1>No offers matching a given criterion</h1>
        @endif
    </table>

</div>

</body>

@include('partials.footer')
</html>
