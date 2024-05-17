<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>

<?php
error_reporting(E_ALL);
ini_set('display_errors', 1);

function getSmaller($number1, $number2) {
    
    if($number1 > $number2) {
        return $number2;
    } else {
        return $number1;
    }
}

function rand_float($st_num, $end_num, $comaPlaces)
{
    if ($st_num > $end_num) {
        return false;
    }
    
    return mt_rand($st_num*pow(10, $comaPlaces), $end_num*pow(10, $comaPlaces))/pow(10, $comaPlaces);
}

$lowerBound = -25;
$upperBound = 25;
$iterationCount = 29;

echo "<table>";

for ($i = 0; $i < $iterationCount; $i++) {

    $randValue1 = rand_float($lowerBound, $upperBound, 3);
    $randValue2 = rand_float($lowerBound, $upperBound, 3);
    
    $smallerValue = getSmaller($randValue1, $randValue2);

    if ( 0.7*(($randValue1 + $randValue2)/2) < $smallerValue ) {
        $color = "red";
    } else { 
        $color = "black";
    }
 
    echo "<tr>";
    echo "<th style=\"color: $color;\">$randValue1</th>";
    echo "<th style=\"color: $color;\">$randValue2</th>";
    echo "<th style=\"color: $color;\">$smallerValue</th>";
    echo "</tr>";
}

echo "</table>"

?>

</body>
</html>

