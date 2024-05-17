<!DOCTYPE html>
<html lang="pl">
@include('partials.head')
<body>
 @include('partials.navi')
 <div id="content">
 <h2>Crew assigned to module {{$module->module_name}}</h2>
 
 <table>
 <thead>
 <tr> <th>Module name</th> <th>Is workable</th> <th>Edit</th> <th>Delete</th> </tr>
 </thead>
 <tbody>
 @foreach($crew as $el)
 <tr>
    <td>{{$el->nick}}</td> 
    <td>{{$el->gender}}</td> 
    <td>{{$el->age}}</td> 
 </tr>
 @endforeach
 </tbody>
 </table>


</div>
</body>
</html>

