<?php

    class Pracownik {

        private $data = array(
            "nazwisko" => "",
            "imie" => "",
            "wiek" => "",
            "doswiadczenie" => "",
            "zainteresowania" => ""
        );

        private $idp = -1;

    public function __construct() {}

    public function getNazwisko() {
        return $this->data["nazwisko"];
    }
    public function setNazwisko($value) {
        $this->data["nazwisko"] = $value;
    }
    
    public function getImie() {
        return $this->data["imie"];
    }
    public function setImie($value) {
        $this->data["imie"] = $value;
    }

    public function getWiek() {
        return $this->data["wiek"];
    }
    public function setWiek($value) {
        $this->data["wiek"] = $value;
    }

    public function getDoswiadczenie() {
        return $this->data["doswiadczenie"];
    }
    public function setDoswiadczenie($value) {
        $this->data["doswiadczenie"] = $value;
    }

    public function getZainteresowania() {
        return $this->data["zainteresowania"];
    }
    public function setZainteresowania($value) {
        $this->data["zainteresowania"] = $value;
    }

    public function getIdp() {
        return $this->$idp;
    }
    public function setIdp($value) {
        $this->$idp = $value;
    }

    public function listaPracownikow() {
    
        $host = 'localhost';
        $port = '5432';
        $database = 's48432';
        $user = 's48432';
        $password = '';

        $conn_string = "host=$host port=$port dbname=$database user=$user password=$password";
        $conn = pg_connect($conn_string) or die("Can't connect to database\n");

        $query = 'SELECT * FROM rekrutacja.pracownicy';
        $result = pg_query($conn, $query) or die("Query error: ".preg_last_error());

        $pracownicyTabela = array();

        while ($line = pg_fetch_assoc($result)) {
            $temp = new Pracownik();
            $temp->setNazwisko($line['nazwisko']);
            $temp->setImie($line['imie']);
            $temp->setWiek($line['wiek']);
            $temp->setDoswiadczenie($line['doswiadczenie']);
            $temp->setZainteresowania($line['zainteresowania']);
            $temp->setIdp($line['idp']);

            array_push($pracownicyTabela, $temp);
        }

        pg_free_result($result);
        pg_close($conn);

        return $pracownicyTabela;
    }

    public function dodajPracownika() {

        $nazwisko = $this->getNazwisko();
        $imie = $this->getImie();
        $wiek = $this->getWiek();
        $doswiadczenie = $this->getDoswiadczenie();
        $zainteresowania = $this->getZainteresowania();

        $host = 'localhost';
        $port = '5432';
        $database = 's48432';
        $user = 's48432';
        $password = '';

        $conn_string = "host=$host port=$port dbname=$database user=$user password=$password";
        $conn = pg_connect($conn_string) or die("Can't connect to postgres\n");

        $query = "INSERT INTO rekrutacja.pracownicy 
        (nazwisko, imie, wiek, doswiadczenie, zainteresowania)
        VALUES
        ('$nazwisko', '$imie', $wiek, '$doswiadczenie', '$zainteresowania');";
        
        $result = pg_query($conn, $query) or die("Query error: ".preg_last_error());

        if ($result !== false) {
            echo "Pracownik dodany pomyślnie";
        }

        pg_free_result($result);
        pg_close($conn);

    }

    public function usunPracownika($deleteID) {

        $host = 'localhost';
        $port = '5432';
        $database = 's48432';
        $user = 's48432';
        $password = '';

        $conn_string = "host=$host port=$port dbname=$database user=$user password=$password";
        $conn = pg_connect($conn_string) or die("Can't connect to postgres\n");

        $query = 
        "DELETE FROM rekrutacja.pracownicy
        WHERE idp = '$deleteID';";
        
        $result = pg_query($conn, $query) or die("Query error: ".preg_last_error());

        if ($result !== false) {
            echo "Pracownik pomyślnie usunięty";
        }

        pg_free_result($result);
        pg_close($conn);

    }

    
    public function toString() {
        return "<p>".$this->getNazwisko()." ".$this->getImie()."</p>";
    }


    }

?>