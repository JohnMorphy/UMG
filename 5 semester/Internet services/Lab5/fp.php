<?php

include_once("pracownik.php");

session_start();

if (!isset($_SESSION["page"])) {
    $_SESSION["page"] = 1;
    $_SESSION["pracownik"] = new Pracownik();
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    
    if (isset($_POST["page"])) {
        $_SESSION["page"] = $_POST["page"];
    }

    if (isset($_POST["nazwisko"])) {
        $_SESSION["pracownik"]->setNazwisko($_POST["nazwisko"]);
    }
    if (isset($_POST["imie"])) {
        $_SESSION["pracownik"]->setImie($_POST["imie"]);
    }
    if (isset($_POST["wiek"])) {
        $_SESSION["pracownik"]->setWiek($_POST["wiek"]);  
    }

    if (isset($_POST["doswiadczenie"])) {
        $_SESSION["pracownik"]->setDoswiadczenie($_POST["doswiadczenie"]);  
    }
    if (isset($_POST["zainteresowania"])) {
        $_SESSION["pracownik"]->setZainteresowania($_POST["zainteresowania"]);  
    }
}

$form = "f".$_SESSION["page"].".html";
include_once($form);
?>


