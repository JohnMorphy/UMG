<?php
session_start();
$_SESSION["myVariable"] = "Jan Kaiser";
echo "My name is ".$_SESSION["myVariable"]."<br>";
echo session_id();
?>