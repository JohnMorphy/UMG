<?php

$randomArray = array();

echo "<table><tr>";
for ($i=0; $i < 10; $i++) { 
    array_push($randomArray, rand(-100,100));
    echo "<td>".$randomArray[$i]."</td>";
}
echo "</tr></table><br>";

if(!session_id()) {
    session_start();    
}

if(! isset($_SESSION["myArray"])) {
    $_SESSION["myArray"] = $randomArray;
}

echo "<table><tr>";
    for ($i=0; $i < 10; $i++) { 
        echo "<td>".$_SESSION["myArray"][$i]."</td>";
    }
echo "</tr></table><br>";

?>