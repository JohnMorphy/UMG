<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>

<form action="task3_randomReal.php" method="post">
  <label for="lBound">Lower bound:</label><br>
  <input type="number" id="lBound" name="lBound"><br>
  <label for="uBound">Upper bound:</label><br>
  <input type="number" id="uBound" name="uBound"><br>
  <label for="count">Count:</label><br>
  <input type="number" id="count" name="count"><br>
  
  <label for="negative">show negative number count</label>
  <input type="checkbox" id="negative" name="negative" value=True><br>
  <label for="average">show average value</label>
  <input type="checkbox" id="average" name="average" value=True>
  

  <br><br>
  <input type="submit">
</form>

<?php

error_reporting(E_ALL);
ini_set('display_errors', 1);

function rand_float($st_num, $end_num, $comaPlaces)
{
    if ($st_num > $end_num) {
        return false;
    }
    
    return mt_rand($st_num*pow(10, $comaPlaces), $end_num*pow(10, $comaPlaces))/pow(10, $comaPlaces);
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    
    $lBound = $_POST["lBound"];
    $uBound = $_POST["uBound"];
    $count = $_POST["count"];
        
    echo "<br><br><table>";

    $values = array();

    for ($i = 0; $i < $count; $i++) {

    $randValue1 = rand_float($lBound, $uBound, 1);
    
    echo "<tr>";
    echo "<th>$randValue1</th>";
    echo "</tr>";
    array_push($values, $randValue1);

    }

    if(isset($_POST['negative']) && $_POST['negative'] == True) {
        
        $negativeCount = 0;
        for ($i = 0; $i < count($values); $i++) {
            if($values[$i] < 0) {
                $negativeCount++;
            }
        }
    
        echo "<tr><th>Negative number count: $negativeCount</th></tr>";
    }
    

    if(isset($_POST['average']) && $_POST['average'] == True) {

        $sum = 0;
        for ($i = 0; $i < count($values); $i++) {
            $sum += $values[$i];
        }
        
        $average = $sum/count($values);
        echo "<tr><th>Average: $average</th></tr>";
    }
    
    echo "</table>";
}

?>

</body>
</html>

