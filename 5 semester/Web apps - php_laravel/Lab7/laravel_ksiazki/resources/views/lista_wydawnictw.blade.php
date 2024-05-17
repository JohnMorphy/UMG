<!DOCTYPE html>
<html lang="pl">
 @include('partials.head')
 <body>
 @include('partials.navi')
 <div id="zawartosc">
 <h2>Lista wydawnictw</h2>
 <table>
 <thead>
 <tr> <th>Nazwa</th> <th>Adres</th> </tr>
 </thead>
 <tbody>
 @foreach($wydawnictwo as $el)
 <tr> <td>{{$el->nazwa}}</td> <td>{{$el->adres}}</td> </tr>
 @endforeach
 </tbody>
 </table>
 </div>
 </body>
</html>

