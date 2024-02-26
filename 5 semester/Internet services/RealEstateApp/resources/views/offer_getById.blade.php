<!DOCTYPE html>
<html lang="en">
@include('partials.head')
<body>
@include('partials.navi')
<div id="content">
    
    <div>
        <h1>{{ $offer->title }}</h1>
    </div>

    <div class="offer-container">
        <div class="row">
            
            <div class="gallery">
                <div class="scroll-container">
                    @if($offerPhotos->isNotEmpty())
                        @foreach($offerPhotos as $photo)
                            <img class="offer-photo" src="{{ asset('offerPhotos/' . $photo->filepath) }}" alt="Offer Photo" width="300">
                        @endforeach
                    @else
                        {{-- Default image if no photo is available --}}
                        <img src="{{ asset('images/defaultImage.jpg') }}" alt="Default Photo">
                    @endif
                </div>
            </div>

            <div class="personal-card">
                <h2>Seller Information</h2>
                <p><strong>First Name:</strong> {{ $user->user_firstname }}</p>
                <p><strong>Last Name:</strong> {{ $user->user_lastname }}</p>
                <p><strong>Email:</strong> {{ $user->email }}</p>
                <p><strong>Phone Number:</strong>  {{ $user->user_phonenumber }}</p>
            </div>
        </div>
        
        <div class="row">
            <div class="offer-details">
                <h2>{{ $offer->title }}</h2>
                <p>{{ $offer->description }}</p>

                <div class="offer-stats">
                    <h2>Offer Details</h2>
                    <p><strong>Price:</strong> ${{ $offer->offer_price }}</p>
                    <p><strong>Area (sqm):</strong> {{ $offer->area_in_meters }}</p>
                    <p><strong>Location:</strong> {{ $offer->city }}, {{ $offer->street }} {{ $offer->address }}, {{ $offer->offer_postalcode }}</p>
                </div>
            </div>
        </div>
        
    </div>
</div>

</body>
@include('partials.footer')
</html>
