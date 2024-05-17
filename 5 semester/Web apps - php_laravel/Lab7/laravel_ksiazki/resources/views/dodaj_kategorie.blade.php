<!DOCTYPE html>
<html>
@include('partials.head')
<body>
 @include('partials.navi')
 <div id="zawartosc">
 
 <h2>Dodaj kategorie</h2>
 <form class="form-inline" action ="./dodaj_kategorie" method = "post" >
 
 @csrf
 <p>
 <label for="opis">Kategoria</label>
 <input id="opis" name="opis" size="20" required>
 </p>
 <p><button type="submit" class="btn btn-primary mb-2">Dodaj</button></p>
 </form>

 <h2>Usuń kategorie</h2>
 <form class="form-inline" action ="./usun_kategorie" method = "post" >
 
 @csrf
 <p>
 <label for="id">Wybierz kategorię -> możliwy tylko wybór kategorii, które nie są przypisane żadnej książce</label>
 <br>
 <select name="id" id="id" required>
 <option value="">-</option>
 @foreach($kategorie as $el)
 <option value={{$el->id}}>{{$el->opis}}</option>
 @endforeach
 </select>
 </p>
 <p><button type="submit" class="btn btn-primary mb-2">Usuń</button></p>
 </form>
 
 </div>
</body>
</html>
