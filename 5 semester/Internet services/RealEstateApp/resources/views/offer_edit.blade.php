<!DOCTYPE html>
<html lang="en">
@include('partials.head')
<body>
@include('partials.navi')
<div id="content">

    <div class="form-view">
        <h1>Offer actions</h1>

        <div class="input-row">
            <button onclick="window.location.href='{{ route('delete_offer', ['id' => $offer->id]) }}'">Delete Offer</button>
            <button onclick="window.location.href='{{ route('delete_offerPhotos', ['id' => $offer->id]) }}'">Delete Photos</button>
            
            <button onclick="window.location.href='{{ route('update_expirationDate', ['id' => $offer->id]) }}'">Update Expiration Date</button>
        </div>
        <div class="input-row">
            <span>Current expiration date: {{ $offer->expiration_date }}</span>
        </div>
        <div class="input-row">
            <span>(updating expiration date pushes it 3 months from now)</span>
        </div>
    </div>

    <div class="form-view">
    <h1>Edit Offer</h1>
    <form action="{{ route('update_offer', ['id' => $offer->id]) }}" method="post" enctype="multipart/form-data">
        @csrf
        @method('PATCH')

        <div class="input-row">
            <div>
                <label for="title">Title:</label>
                <br>
                <input type="text" name="title" id="title" value="{{ old('title', $offer->title) }}" placeholder="Enter title" required>
            </div>
        </div>

        <div class="input-row">
            <div>
                <label for="description">Description:</label>
                <br>
                <textarea name="description" id="description" rows="4" placeholder="Enter description" required>{{ old('description', $offer->description) }}</textarea>
            </div>
        </div>

        <div class="input-row">
            <div>
                <label for="offer_price">Price:</label>
                <br>
                <input type="number" name="offer_price" id="offer_price" value="{{ old('offer_price', $offer->offer_price) }}" placeholder="Enter price" required>
            </div>
            <div>
                <label for="area_in_meters">Area (m2):</label>
                <br>
                <input type="number" name="area_in_meters" id="area_in_meters" value="{{ old('area_in_meters', $offer->area_in_meters) }}" placeholder="Enter area" required>
            </div>
        </div>

        <div class="input-row">
            <div>
                <label for="city">City:</label>
                <br>
                <input type="text" name="city" id="city" value="{{ old('city', $offer->city) }}" placeholder="Enter city" required>
            </div>
            <div>
                <label for="offer_postalcode">Postal Code:</label>
                <br>
                <input type="text" name="offer_postalcode" id="offer_postalcode" value="{{ old('offer_postalcode', $offer->offer_postalcode) }}" placeholder="Enter postal code" required>
            </div>
        </div>

        <div class="input-row">
            <div>
                <label for="street">Street:</label>
                <br>
                <input type="text" name="street" id="street" value="{{ old('street', $offer->street) }}" placeholder="Enter street 101/21" required>
            </div>
            <div>
                <label for="address">Address:</label>
                <br>
                <input type="text" name="address" id="address" value="{{ old('address', $offer->address) }}" placeholder="Enter address" required>
            </div>
        </div>

        <div class="input-row">
            <div>
                <label for="expiration_date">Expiration Date:</label>
                <br>
                <input type="text" name="expiration_date" id="expiration_date" value="{{ old('expiration_date', $offer->expiration_date) }}" readonly>
            </div>
        </div>

        <div class="input-row">
            <div>
                <label for="photos">Upload new photos (you can delete previous on the top):</label>
                <br>
                <input type="file" name="photos[]" id="photos" accept="image/*" multiple>
            </div>
        </div>

        <div>
            <button type="submit">Update Offer</button>
        </div>
    </form>
</div>


</div>

<script>
    const currentDate = new Date();
    const expirationDate = new Date(currentDate);
    expirationDate.setMonth(currentDate.getMonth() + 3);

    const formattedExpirationDate = expirationDate.toISOString().split('T')[0];

    document.getElementById('expiration_date').value = formattedExpirationDate;
</script>

</body>
@include('partials.footer')
</html>
