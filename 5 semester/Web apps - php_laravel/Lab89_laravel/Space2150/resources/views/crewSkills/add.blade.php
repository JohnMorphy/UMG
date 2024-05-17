<!DOCTYPE html>
<html lang="pl">
@include('partials.head')
<body>
 @include('partials.navi')
 <div id="content">
 <h2>Add Crew Skills</h2>
 
 <form class="form-inline" action="{{ route('crewSkills.save') }}" method="post">
 @csrf
 <p>
    <label for="module_crew_id">Crew id:</label>
    <input id="module_crew_id" name="module_crew_id" size="25" required>
 </p>
 
 <p>
    <label for="name">Skill name:</label>
    <input id="name" name="name" size="25" required>
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

