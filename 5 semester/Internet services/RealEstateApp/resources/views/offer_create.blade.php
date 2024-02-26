<!DOCTYPE html>
<html lang="en">
@include('partials.head')
<body>
@include('partials.navi')
<div id="content">
    <div class="form-view">
        <h1>Create New Offer</h1>
        
        <form action="{{ route('offer_store') }}" method="post" enctype="multipart/form-data">
            @csrf

            <div class="input-row">
                <div>
                    <label for="title">Title:</label>
                    <br>
                    <input type="text" name="title" id="title" placeholder="Enter title" required>
                </div>
            </div>

            <div class="input-row">
                <div>
                    <label for="description">Description:</label>
                    <br>
                    <textarea name="description" id="description" rows="4" placeholder="Enter description" required></textarea>
                </div>
            </div>

            <div class="input-row">
                <div>
                    <label for="offer_price">Price:</label>
                    <br>
                    <input type="number" name="offer_price" id="offer_price" placeholder="Enter price" required>
                </div>
                <div>
                    <label for="area_in_meters">Area (m2):</label>
                    <br>
                    <input type="number" name="area_in_meters" id="area_in_meters" placeholder="Enter area" required>
                </div>
            </div>

            <div class="input-row">
                <div>
                    <label for="city">City:</label>
                    <br>
                    <input type="text" name="city" id="city" placeholder="Enter city" required>
                </div>
                <div>
                    <label for="offer_postalcode">Postal Code:</label>
                    <br>
                    <input type="text" name="offer_postalcode" id="offer_postalcode" placeholder="Enter postal code" required>
                </div>
            </div>

            
            <div class="input-row">
                <div>
                    <label for="street">Street:</label>
                    <br>
                    <input type="text" name="street" id="street" placeholder="Enter street 101/21" required>
                </div>
                <div>
                    <label for="address">Address:</label>
                    <br>
                    <input type="text" name="address" id="address" placeholder="Enter address" required>
                </div>
            </div>

            <div class="input-row">
                <div>
                    <label for="expiration_date">Expiration Date:</label>
                    <br>
                    <input type="text" name="expiration_date" id="expiration_date" readonly>
                </div>
            </div>

            <div class="input-row">
                <div>
                    <label for="photos">Upload Photos:</label>
                    <br>
                    <input type="file" name="photos[]" id="photos" accept="image/*" multiple>
                </div>
            </div>

            <div>
                <button type="submit">Create Offer</button>
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
