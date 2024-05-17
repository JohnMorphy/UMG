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

require_once("task1_vechicles.php");
require_once("task2_dataDescription.php");

$bike = new Bicycle("Polygon Siskiu T8 Dual Suspension Mountain Bike", 2023, "bike.jpg", 6);
$truck = new Truck("Freightliner Cascadia MINT UNIT", 2019, "truck.jpg", 24);
$motorboat = new Motorboat("Maxim 2400 SCR 25 foot Powerboat", 2000, "motorboat.jpg", 7.62);


// Below -> basic viev using methods from task1
/*
echo "Bike Gear Count: " . $bike->getGearCount();
echo "<br>";
echo "<img src='" . $bike->getImage() . "'>";
echo "<br>";
echo "Truck Tonnage: " . $truck->getTonnage();
echo "<br>";
echo "<img src='" . $truck->getImage() . "'>";
echo "<br>";
echo "Motorboat Length: " . $motorboat->getLength();
echo "<br>";
echo "<img src='" . $motorboat->getImage() . "'>";
echo "<br>";
*/

$bikeDescription = new QuickDescription($bike);
$truckDescription = new QuickDescription($truck);
$motorboatDescription = new QuickDescription($motorboat);

echo $bikeDescription->generateDescription();
echo $truckDescription->generateDescription();
echo $motorboatDescription->generateDescription();

?>

</table>

</body>
</html>

