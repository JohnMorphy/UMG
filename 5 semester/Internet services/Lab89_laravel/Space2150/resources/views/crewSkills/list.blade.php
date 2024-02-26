<!DOCTYPE html>
<html lang="pl">
@include('partials.head')
<body>
 @include('partials.navi')
 <div id="content">
 <h2>List Crew Skills</h2>
 
 <table>
 <thead>
 <tr> <th>Skill owner Id</th> <th>Name</th> <th>Edit</th> <th>Delete</th> </tr>
 </thead>
 <tbody>
 @foreach($crewSkills as $el)
 <tr> 
    <td>{{$el->module_crew_id}}</td>
    <td>{{$el->name}}</td>
    <td><a href="{{ route('crewSkills.edit', ['id' => $el->id])  }}">Edit</a></td>
    <td><a href="{{ route('crewSkills.show', ['id' => $el->id]) }}">Delete</a></td>
</tr>
 @endforeach
 </tbody>
 </table>


</div>
</body>
</html>

