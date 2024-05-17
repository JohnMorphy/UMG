<?php
namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Auth;


class PodstawowyKontroler extends Controller{
     
 public function zwrocStroneDomowa(){
 return view('domowa');
 }

 public function walidujDlugosc(...$inputs) {
    
    foreach ($inputs as $input) {
        if (strlen($input) < 3 || strlen($input) > 50) {
            return false;
        }
    }
    return true;
}

 public function zwrocListeKsiazek()
{
 $ksiazkiZBazy = DB::table('ksiazka')->leftJoin('kategoria',
 'ksiazka.idkat', '=', 'kategoria.id') -> get();
 return view('lista_ksiazek', ['ksiazki' => $ksiazkiZBazy,]);
}

public function zwrocDodajKsiazke(){
 $kategorieZBazy = DB::table('kategoria')-> get();
 $wydawnictwaZBazy = DB::table('wydawnictwo')-> get();
 $ksiazkiZBazy = DB::table('ksiazka')
 ->select('ksiazka.id', 'ksiazka.tytul', 'kategoria.opis')
 ->leftJoin('kategoria', 'ksiazka.idkat', '=', 'kategoria.id')
 ->get();
 return view('dodaj_ksiazke', ['kategorie' => $kategorieZBazy, 'wydawnictwo' => $wydawnictwaZBazy,
'ksiazki' => $ksiazkiZBazy,]);
}
public function dodajKsiazke(Request $request){
    $tytulZFormularza = $request->tytul;
    $idKategoriiZFormularza = $request->idkat;
    $idWydawnictwaZFormularza = $request->idwyd;
 
    if ($tytulZFormularza !== null && $idKategoriiZFormularza !== null && $idWydawnictwaZFormularza !== null) {
        $isValid = $this->walidujDlugosc($tytulZFormularza);

        if($isValid) {
            DB::table('ksiazka')->insert([
                'tytul' => $tytulZFormularza,
                'idkat' => intval($idKategoriiZFormularza),
                'idwyd' => intval($idWydawnictwaZFormularza),
            ]);
        }
    }
    return redirect('/ksiazki');
}
public function usunKsiazke(Request $request){
    $idZFormularza = $request->id;

    DB::table('ksiazka')->delete($idZFormularza);
    return redirect('/ksiazki');
}


public function zwrocListeKategorii()
{
 $kategorieZBazy = DB::table('kategoria') -> get();
 return view('lista_kategorii', ['kategorie' => $kategorieZBazy,]);
}
public function zwrocDodajKategorie(){
$kategorieZBazyDoUsuniecia = DB::table('kategoria')
    ->leftJoin('ksiazka', 'ksiazka.idkat', '=', 'kategoria.id')
    ->whereNull('ksiazka.idkat')
    ->select('kategoria.*')
    ->get();
 return view('dodaj_kategorie', ['kategorie' => $kategorieZBazyDoUsuniecia]);
}
public function dodajKategorie(Request $request) {
    $opisZFormularza = $request->opis;

    $isValid = $this->walidujDlugosc($opisZFormularza);

    if ($isValid) {
        DB::table('kategoria')->insert([
            'opis' => $opisZFormularza,
        ]);
    }

    return redirect('/kategorie');
}

public function usunKategorie(Request $request){
 $idZFormularza = $request->id;
 DB::table('kategoria')->delete($idZFormularza);
 return redirect('/kategorie');
}

public function zwrocListeWydawnictw()
{
 $wydawnictwaZBazy = DB::table('wydawnictwo') -> get();
 return view('lista_wydawnictw', ['wydawnictwo' => $wydawnictwaZBazy,]);
}
public function zwrocDodajWydawnictwo(){
    $wydawnictwaZBazyDoUsuniecia = DB::table('wydawnictwo')
    ->leftJoin('ksiazka', 'ksiazka.idwyd', '=', 'wydawnictwo.id')
    ->whereNull('ksiazka.idwyd')
    ->select('wydawnictwo.*')
    ->get();
    return view('dodaj_wydawnictwo', ['wydawnictwo' => $wydawnictwaZBazyDoUsuniecia,]);
}
public function dodajWydawnictwo(Request $request){
    $nazwaZFormularza = $request->nazwa;
    $adresZFormularza = $request->adres;

    $isValid = $this->walidujDlugosc($nazwaZFormularza, $adresZFormularza);

    if ($isValid) {
        DB::table('wydawnictwo')->insert([
            'nazwa' => $nazwaZFormularza,
            'adres' => $adresZFormularza,
        ]);
    }

    return redirect('/wydawnictwa');
}


public function usunWydawnictwo(Request $request){
 $idZFormularza = $request->id;
 DB::table('wydawnictwo')->delete($idZFormularza);
 return redirect('/wydawnictwa');
}

public function zmienStanUwierzytelnienia()
{
 if(auth()->check()){
 $user = auth()->user();
 Auth::logout();
 return view('wylogowano');
 }
 else{
 return redirect('/register');
 }
}


}
