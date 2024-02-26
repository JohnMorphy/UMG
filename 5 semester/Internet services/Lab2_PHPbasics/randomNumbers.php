<?php

error_reporting(E_ALL);
ini_set('display_errors', 1);

$i = 0;
$lowerBound = -10;
$upperBound = 10;

echo "<ul>";

do {
    $i = rand($lowerBound, $upperBound);
    
    if ($i < 0) {
        $color = "red";
    }
    elseif ($i > 0) {
        $color = "green";
    }
    else { 
        $color = "black";
    }

    echo "<li style=\"color: $color;\">$i</li>";

} while ($i != $lowerBound && $i != $upperBound);

echo "</ul>"

?>