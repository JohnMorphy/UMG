<!DOCTYPE html>
<html lang="pl">
@include('partials.head')
<body>
 @include('partials.navi')
 <div id="content">
 <h2>Confirmation - delete id: {{$shipModule->id}}</h2>
 
 <form class="form-inline" action="{{ route('shipModules.delete', ['id' => $shipModule->id]) }}" method="post">
 @csrf

 <p>
    <label for="id">Id</label>
    <input id="id" name="id" value="{{$shipModule->id}}" readonly>
 </p>

 <p>
    <label for="module_name">Module Name:</label>
    <input id="module_name" name="module_name" value="{{$shipModule->module_name}}" size="25" readonly required>
 </p>
 
 <p><button type="submit" class="btn btn-primary mb-2">Delete</button></p>

 </form>

 
</div>
</body>
</html>

