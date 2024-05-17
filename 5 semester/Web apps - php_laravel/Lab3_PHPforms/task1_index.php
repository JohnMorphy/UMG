<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>

<form action="task1_index.php" method="post">
  <label for="power">Pick the power:</label><br>
  <input type="number" id="power" name="power"><br>
  <input type="submit">
</form>

<?php
error_reporting(E_ALL);
ini_set('display_errors', 1);


if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $n = $_POST["power"];

    if($n > 64) {
        echo "Max number is 64!";
        return;
    }

    echo "<ul>";

    for ($i = 1; $i <= $n; $i++) {

        echo "<li>2<span style=\"vertical-align: super\">$i</span>=".pow(2,$i)."</li>";
    }

    echo "</ul>";
}

?>

</body>
</html>

