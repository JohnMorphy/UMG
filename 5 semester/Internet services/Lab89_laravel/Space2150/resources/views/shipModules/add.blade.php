<!DOCTYPE html>
<html lang="pl">
@include('partials.head')
<body>
 @include('partials.navi')
 <div id="content">
 <h2>Add Ship Module</h2>
 
 <form class="form-inline" action="{{ route('shipModules.save') }}" method="post">
 @csrf
 <p>
    <label for="module_name">Module Name:</label>
    <input id="module_name" name="module_name" size="25" required>
 </p>
 
 <p>
    <label for="is_workable">Is Workable</label>

    <input type="radio" name="is_workable" id="is_workable" value=1 checked required>
    <label for="is_workable">True</label> 
    <input type="radio" name="is_workable" id="is_workable" value=0 required>
    <label for="is_workable">False</label>
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

