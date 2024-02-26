<!DOCTYPE html>
<html lang="pl">
@include('partials.head')
<body>
 @include('partials.navi')
 <div id="content">
 <h2>Add Module Crew</h2>
 
 <form class="form-inline" action="{{ route('moduleCrew.save') }}" method="post">
 @csrf
 <p>
    <label for="ship_module_id">Module id:</label>
    <input id="ship_module_id" name="ship_module_id" size="25" required>
 </p>
 
 <p>
    <label for="nick">Nick:</label>
    <input id="nick" name="nick" size="25" required>
 </p>

 <p>
    <label for="age">Age:</label>
    <input id="age" name="age" size="25" required>
 </p>

 <p>
    <label for="gender">Gender</label>

    <input type="radio" name="gender" id="gender" value="N" checked required>
    <label for="gender">Not specified</label> 
    <input type="radio" name="gender" id="gender" value="M" required>
    <label for="gender">Male</label>
    <input type="radio" name="gender" id="gender" value="M" required>
    <label for="gender">Female</label>
 </p>
    
 <p><button type="submit" class="btn btn-primary mb-2">Save</button></p>
</form>
 <p>
    @if ($errors->any())
    <div class="alert alert-danger">
        <ul>
            @foreach ($errors->all() as $error)
                <li>{{ $error }}</li>
            @endforeach
        </ul>
    </div>
    @endif
 </p>

</div>
</body>
</html>

