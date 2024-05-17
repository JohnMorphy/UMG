<?php

function generateMenu($array) {

    $menuItems = [];
    $addedTypes = [];

    $s = "<div id=\"menu\">";
    $s .= "<a href=\"task3_display.php?id=all\">All items</a>";
    $s .= "<a href=\"task3_display.php?id=Bicycle\">Bicycles</a>";
    $s .= "<a href=\"task3_display.php?id=Truck\">Trucks</a>";
    $s .= "<a href=\"task3_display.php?id=Motorboat\">Motorboats</a>";
    $s .= "</div>";

    return $s;
}


?>