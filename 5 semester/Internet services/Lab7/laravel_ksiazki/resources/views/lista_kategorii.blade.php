<!DOCTYPE html>
<html lang="pl">
 @include('partials.head')
 <body>
 @include('partials.navi')
 <div id="zawartosc">
 <h2>Lista kategorii</h2>
 <table>
 <thead>
 <tr> <th>Kategoria</th> </tr>
 </thead>
 <tbody>
 @foreach($kategorie as $el)
 <tr> <td>{{$el->opis}}</td> </tr>
 @endforeach
 </tbody>
 </table>
 </div>
 </body>
</html>

