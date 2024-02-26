<!DOCTYPE html>
<html>
@include('partials.head')
<body>
 @include('partials.navi')
 <div id="zawartosc">
 <h2>Dodaj wydawnictwo</h2>
 <form class="form-inline" action ="./dodaj_wydawnictwo" method = "post" >
 
 @csrf
 <p>
 <label for="nazwa">Nazwa</label>
 <input id="nazwa" name="nazwa" size="20" required>
</p>
<p>
 <label for="adres">Adres</label>
 <input id="adres" name="adres" size="20" required>
</p>
 <p><button type="submit" class="btn btn-primary mb-2">Dodaj</button></p>
 </form>

 <h2>Usuń wydawnictwo</h2>
 <form class="form-inline" action ="./usun_wydawnictwo" method = "post" >
 @csrf
 <p>
 <label for="id">Wybierz wydawnicto -> możliwy tylko wybór wydawnictwa, które nie jest przypisane żadnej książce</label>
 <br>
 <select name="id" id="id" required>
 <option value="">-</option>
 @foreach($wydawnictwo as $el)
 <option value={{$el->id}}>{{$el->nazwa}}, {{$el->adres}}</option>
 @endforeach
 </select>
 </p>
 <p><button type="submit" class="btn btn-primary mb-2">Usuń</button></p>
 </form>


 </div>
</body>
</html>
