<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>

<form action="task4_formsContinued.php" method="post">
  <label for="n">Positive, integer n</label><br>
  <input type="number" id="n" name="n"><br>
  <label for="z">Positive integer z</label><br>
  <input type="number" id="z" name="z"><br>

  <label for="highlight">Choose witch to highlight:</label>
    <select name="highlight" id="highlight">
    <option value="even">even</option>
    <option value="divisableBy3">divisable by 3</option>
  </select>

  <br><br>
  <input type="submit">
</form>

<?php
error_reporting(E_ALL);
ini_set('display_errors', 1);

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $n = $_POST["n"];
    $z = $_POST["z"];

    $n = intval($n);
    $z = intval($z);

    $highlightOption = $_POST["highlight"];

    if (!(is_int($n) && $n > 0 && is_int($z) && $z > 0)) {
        echo "<span>Wrong Input! Numbers need to be positive integers</span>";
        return;
    }

    echo "is n smaller than z/2 (div): " . ($n < intdiv($z, 2) ? "true" : "false") . "<br><br>" ;

    $upperLimit = ($n > $z) ? $z : $n;
    $values = array();
    
    for ($i=0; $i < $upperLimit; $i++) { 
        array_push($values, rand(0, $z));
        if(!array_unique($values)) {
            $i--;
            array_pop($values);
        }
    }

    sort($values);

    $classMapping = [
        "even" => "even-background",
        "divisableBy3" => "divisableBy3-background",
    ];

    for ($i=0; $i < $upperLimit; $i++) { 
        $cssClass = "";
        if ($highlightOption === "even" && $values[$i] % 2 == 0) {
            $cssClass = $classMapping[$highlightOption];
        } elseif ($highlightOption === "divisableBy3" && $values[$i] % 3 == 0) {
            $cssClass = $classMapping[$highlightOption];
        }
        echo "<span class='$cssClass'>$values[$i]  </span>";
    }


}

?>

</body>
</html>