<!DOCTYPE html>
<html lang="pl">
 @include('partials.head')
 <body>
 @include('partials.navi')
 <div id="zawartosc">
 <h2>Lista książek</h2>
 <table>
 <thead>
 <tr> <th>Tytuł</th> <th>Kategoria</th> </tr>
 </thead>
 <tbody>
 @foreach($ksiazki as $el)
 <tr> <td>{{$el->tytul}}</td> <td>{{$el->opis}}</td> </tr>
 @endforeach
 </tbody>
 </table>
 </div>
 </body>
</html>

