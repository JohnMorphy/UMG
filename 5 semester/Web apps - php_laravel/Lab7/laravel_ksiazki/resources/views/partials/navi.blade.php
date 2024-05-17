<nav>
 <div>
 <a href="./domowa">Strona domowa</a>

 <a href="./ksiazki">Książki</a>
 @if(Auth::check()) 
 <a href="./dodaj_ksiazke">Dodaj/usuń książkę</a>
 @endif

 <a href="./kategorie">Kategorie</a>
 @if(Auth::check()) 
 <a href="./dodaj_kategorie">Dodaj/usuń kategorię</a>
 @endif

 <a href="./wydawnictwa">Wydawnictwa</a>
 @if(Auth::check()) 
 <a href="./dodaj_wydawnictwo">Dodaj/usuń wydawnictwo</a>
 @endif
 
 @if(Auth::check()) 
    <a href="./wyloguj">Wyloguj</a>
 @else
    <a href="./loguj">Zaloguj</a>
 @endif
</div>
</nav>
