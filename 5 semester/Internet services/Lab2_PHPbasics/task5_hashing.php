<?php

function getMd5($value) {
    return hash('md5', $value);
}

function getSha1($value) {
    return hash('sha1', $value);
}

function getSha256($value) {
    return hash('sha256', $value);
}

echo "<table>";

echo "<tr>
        <th>Tekst niezaszyfrowany</th>
        <th>Md5</th>
        <th>Sha1</th>
        <th>Sha256</th>
    </tr>";

$a = array("Wydział Elektryczny", "Kierunek Informatyka", "Projektowanie Serwisów Internetowych");

for ($i = 0; $i < 3; $i++) {
    
    echo "<tr>
        <th>$a[$i]</th>
        <th>" . getMd5($a[$i]) . "</th>
        <th>" . getSha1($a[$i]) . "</th>
        <th>" . getSha256($a[$i]) . "</th>
    </tr>";
}

echo "</table>";
?>