<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="styles.css">
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
$eBike = new Bicycle("Polygon Collosus N8E - All Mountain eBike", 2023, "ebike.jpg", 6);
$eTruck = new Truck("Volvo FMX Electric", 2023, "eTruck.avif", 18);


$eTruckDescription = new SmallNoteDescription($eTruck);
$bikeDescription = new QuickDescription($bike);
$truckDescription = new QuickDescription($truck);
$motorboatDescription = new QuickDescription($motorboat);
$ebikeFullDescription = new FullDescription($eBike, 
"New, extremaly durable mountain eBike with great power!", "For sale now! Only 4,299$!");


$vechicleArray = array();
array_push($vechicleArray, $eTruckDescription);
array_push($vechicleArray, $bikeDescription);
array_push($vechicleArray, $truckDescription);
array_push($vechicleArray, $motorboatDescription);
array_push($vechicleArray, $ebikeFullDescription);

require_once("menu.php");
echo generateMenu($vechicleArray);

$typeToDisplay = (!empty($_GET["id"])) ? $_GET["id"] : "all";

foreach($vechicleArray as $description) {
    if ($typeToDisplay == "all" || $description->getObject() instanceof $typeToDisplay) {
        echo $description->generateDescription();
    }
}

?>

</table>

</body>
</html>

