<!DOCTYPE html>
<html lang="en">
@include('partials.head')
<body>
@include('partials.admin_menu')

<div id="content">
    <h1>User List</h1>
    
    <table class="offer-table">
        <tr class>
            <th>ID</th>
            <th>Email</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Phone Number</th>
            <th>Delete</th>
        </tr>
        @foreach($users as $user)
            <tr class = "offer-row">
                <td>{{ $user->id }}</td>
                <td>{{ $user->email }}</td>
                <td>{{ $user->user_firstname }}</td>
                <td>{{ $user->user_lastname }}</td>
                <td>{{ $user->user_phonenumber }}</td>
                <td class="table-button" onclick="window.location.href='{{ route('admin_delete_user', ['id' => $user->id]) }}';">
                    <span>Delete</span>
                </td>
            </tr>
        @endforeach
    </table>
</div>

</body>

@include('partials.footer')
</html>
