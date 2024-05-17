<!DOCTYPE html>
<html lang="pl">
@include('partials.head')
<body>
 @include('partials.navi')
 <div id="content">
 <h2>Confirmation - delete id: {{$moduleCrew->id}}</h2>
 
 <form class="form-inline" action="{{ route('moduleCrew.delete', ['id' => $moduleCrew->id]) }}" method="post">
 @csrf

 <p>
    <label for="id">Id</label>
    <input id="id" name="id" value="{{$moduleCrew->id}}" readonly>
 </p>

 <p>
    <label for="nick">Nick:</label>
    <input id="nick" name="nick" value="{{$moduleCrew->nick}}" size="25" readonly required>
 </p>
 
 <p><button type="submit" class="btn btn-primary mb-2">Delete</button></p>

 </form>

 
</div>
</body>
</html>

