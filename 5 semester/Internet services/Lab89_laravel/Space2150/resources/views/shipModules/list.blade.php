<!DOCTYPE html>
<html lang="pl">
@include('partials.head')
<body>
 @include('partials.navi')
 <div id="content">
 <h2>List Ship Modules</h2>
 
 <table>
 <thead>
 <tr> <th>Module name</th> <th>Is workable</th> <th>Edit</th> <th>Delete</th> </tr>
 </thead>
 <tbody>
 @foreach($ship_modules as $el)
 <tr>
    <td><a href="{{ route('shipModules.assignedCrew', ['id' => $el->id])  }}">{{$el->module_name}}</a></td>
    <td>{{$el->is_workable}}</td>
    <td><a href="{{ route('shipModules.edit', ['id' => $el->id])  }}">Edit</a></td>
    <td><a href="{{ route('shipModules.show', ['id' => $el->id]) }}">Delete</a></td>
 </tr>
 @endforeach
 </tbody>
 </table>


</div>
</body>
</html>

