<?php

error_reporting(E_ALL);
ini_set('display_errors', 1);

function factorial($n) {
    $sum = 1;

    for($j = $n; $j > 1; $j--) {
        $sum = $sum*$j;
    }

    return $sum;
}

$i = 0;
$lowerBound = 0;
$upperBound = 10;
$a = array();

for ($j = 0; $j < 6; $j++) {
    $i = factorial(rand($lowerBound, $upperBound));
    array_push($a,$i);
}

sort($a);

echo "<ul>";

for ($j = 0; $j < 6; $j++) {
    
    if($j%2 == 0) {
        $color = "red";
    } else {
        $color = "blue";
    }

    echo "<li style=\"background-color: $color;\">$a[$j]</li>";
}

echo "</ul>";

?>