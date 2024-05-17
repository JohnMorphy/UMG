<!DOCTYPE html>
<html lang="pl-PL">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>Edycja pracowników</title>
</head>
    <body>

    <?php

    include_once("pracownik.php");
    $klasaPracownik = new Pracownik();

    $pracownicy = $klasaPracownik->listaPracownikow();

    echo '<table>';
    echo '<tr><th>Nazwisko</th><th>Imię</th><th>Wiek</th><th>Doswiadczenie</th><th>Zainteresowania</th></tr>';

    foreach ($pracownicy as $pracownik) {
        echo '<tr>';
        echo '<td>'.$pracownik->getNazwisko().'</td>';
        echo '<td>'.$pracownik->getImie().'</td>';
        echo '<td>'.$pracownik->getWiek().'</td>';
        echo '<td>'.$pracownik->getDoswiadczenie().'</td>';
        echo '<td>'.$pracownik->getZainteresowania().'</td>';
        echo '<td>
        <form class="removeForm" action="Zadanie2.php" method="post">
        <input type="hidden" id="deleteID" name="deleteID" value="'.$pracownik->getIdp().'">
        <input type="submit" value="Usuń">
        </form>
        </td>';
        echo '</tr>';
    }

    echo '</table>';

    ?>

    

    <form action="fp.php" method="post">
        <input type="hidden" name="page" value="1">
        <input type="submit" value="Utwórz pracownika">
    </form>

    <?php
        
        if ($_SERVER["REQUEST_METHOD"] == "POST") {
        
            if (isset($_POST["deleteID"])) {
                $deleteID = $_POST["deleteID"];
                $klasaPracownik->usunPracownika($deleteID);
            
                $pracownicy = $klasaPracownik->listaPracownikow();
            }
        }

    ?>


    </body>
</html>