<!DOCTYPE html>
<html lang="pl">
@include('partials.head')
<body>
 @include('partials.navi')
 <div id="content">
 
 <h2>{{ $type_of_message }}</h2>
 <p>{{ $message }}</p>

 </div>
</body>
</html>

