<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>

<form action="task2_validation.php" method="post">
  <label for="power">Validate value in format ZZZ9999; sum of numbers should be below 20: </label><br>
  <input type="text" id="power" name="value"><br>
  <input type="submit">
</form>

<?php

error_reporting(E_ALL);
ini_set('display_errors', 1);

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    
    $str = $_POST["value"];
    $pattern = "/^[A-Z]{3}\d{4}$/";


    if (preg_match($pattern, $str)) {
        
        $digitSum = $str[3] + $str[4] + $str[5] + $str[6];
        
        if($digitSum < 20) {
            echo "<p>Everything all right</p>";
        } else {
            echo "<p>Too big of a number</p>";
        }

    } else {
        echo "<p>Value doesn't match regex</p>";    
    }

}

?>

</body>
</html>

