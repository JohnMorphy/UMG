<!DOCTYPE html>
<html lang="pl">
@include('partials.head')
<body>
 @include('partials.navi')
 <div id="content">
 <h2>Confirmation - delete id: {{$crewSkills->id}}</h2>
 
 <form class="form-inline" action="{{ route('crewSkills.delete', ['id' => $crewSkills->id]) }}" method="post">
 @csrf

 <p>
    <label for="id">Id</label>
    <input id="id" name="id" value="{{$crewSkills->id}}" readonly>
 </p>

 <p>
    <label for="module_crew_id">Crew id:</label>
    <input id="module_crew_id" name="module_crew_id" value="{{$crewSkills->module_crew_id}}" size="25" readonly required>
 </p>
 
 <p>
    <label for="name">Skill name:</label>
    <input id="name" name="name" size="25" value="{{$crewSkills->name}}" readonly required>
 </p>
 
 <p><button type="submit" class="btn btn-primary mb-2">Delete</button></p>

 </form>

 
</div>
</body>
</html>

