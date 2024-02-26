<!DOCTYPE html>
<html lang="pl">
@include('partials.head')
<body>
 @include('partials.navi')
 <div id="content">
 <h2>List Module Crew</h2>
 
 <table>
 <thead>
 <tr> <th>Ship module id</th> <th>Nick</th> <th>Gender</th> <th>age</th> <th>Edit</th> <th>Delete</th> </tr>
 </thead>
 <tbody>
 @foreach($module_crew as $el)
 <tr> 
    <td>{{$el->ship_module_id}}</td>
    <td>{{$el->nick}}</td> 
    <td>{{$el->gender}}</td> 
    <td>{{$el->age}}</td> 
    <td><a href="{{ route('moduleCrew.edit', ['id' => $el->id])  }}">Edit</a></td>
    <td><a href="{{ route('moduleCrew.show', ['id' => $el->id]) }}">Delete</a></td>
</tr>
 @endforeach
 </tbody>
 </table>


</div>
</body>
</html>

