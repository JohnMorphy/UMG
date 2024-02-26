<!DOCTYPE html>
<html lang="en">
@include('partials.head')
<body>
@include('partials.navi')

<div id="content">
    <div class="form-view">
        <h1>Set User Data</h1>
        
        <form action="{{ route('user_data_update') }}" method="post">
            @csrf
            @method('PATCH')

            <div class = "input-row">
                <input type="text" name="user_firstname" id="user_firstname" value="{{ old('user_firstname', $userData->user_firstname) }}" placeholder="First name" required>
                <input type="text" name="user_lastname" id="user_lastname" value="{{ old('user_lastname', $userData->user_lastname) }}" placeholder="Last name" required>
            </div>
            
            <div class = "input-row">
                <input type="number" name="user_phonenumber" id="user_phonenumber" value="{{ old('user_phonenumber', $userData->user_phonenumber) }}" placeholder="Phone number in format 123456789" required>
            </div>

            <div class = "input-row">
                <button type="submit">Update User Data</button>
            </div>
        </form>
    </div>
</div>

</body>
@include('partials.footer')
</html>
