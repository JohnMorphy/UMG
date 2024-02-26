<!DOCTYPE html>
<html>
@include('partials.head')
<body>
 @include('partials.navi')
 <div id="zawartosc">
 
 <h2>Dodaj książkę</h2>
 <form class="form-inline" action ="./dodaj_ksiazke" method = "post" >
 @csrf
 <p>
 <label for="tytul">Tytuł książki</label>
 <input id="tytul" name="tytul" size="20" required>
 </p>
 <p>
 @foreach($kategorie as $el)
 <input type="radio" name="idkat" value={{$el->id}} required>
 <span>{{$el->opis}}</span>
 @endforeach
 </p>

 <p>
 <label for="idwyd">Wybierz wydawnictwo</label>
 <select name="idwyd" id="idwyd" required>
 <option value="">-</option>
 @foreach($wydawnictwo as $el)
 <option value={{$el->id}}>{{$el->nazwa}}</option>
 @endforeach
 </select>
 </p>

 <p><button type="submit" class="btn btn-primary mb-2">Dodaj</button></p>
 </form>
 

 <br>


 <h2>Usun książkę</h2>
 <form class="form-inline" action ="./usun_ksiazke" method = "post" >
 @csrf

 <p>
 <label for="id">Wybierz ksiązkę do usunięcia</label>
 <select name="id" id="id" required>
 <option value="">-</option>

 @foreach($ksiazki as $el)
 <option value={{$el->id}}>{{$el->tytul}}, {{$el->opis}}</option>
 @endforeach
 </p>
 </select>

 <p><button type="submit" class="btn btn-primary mb-2">Usuń</button></p>
 </form>
 

</div>
</body>
</html>
