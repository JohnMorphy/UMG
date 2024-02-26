<!DOCTYPE html>
<html lang="en">
@include('partials.head')
<body>
@include('partials.admin_menu')

<div id="content">
    <h1>Offer List</h1>
    
    <table class="offer-table">
        <tr>
            <th>User ID</th>
            <th>ID</th>
            <th>Title</th>
            <th>City</th>
            <th>Price</th>
            <th>Delete</th>
        </tr>
        @foreach($offers as $offer)
            <tr class="offer-row">
                <td>{{ $offer->user_id }}</td>
                <td>{{ $offer->id }}</td>
                <td>{{ $offer->title }}</td>
                <td>{{ $offer->city }}</td>
                <td>${{ $offer->offer_price }}</td>
                <td class="table-button" onclick="window.location.href='{{ route('admin_delete_offer', ['id' => $offer->id]) }}';">
                    <span>Delete</span>
                </td>
            </tr>
        @endforeach
    </table>
</div>

</body>

@include('partials.footer')
</html>
