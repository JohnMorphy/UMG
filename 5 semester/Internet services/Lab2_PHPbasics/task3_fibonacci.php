<?php

error_reporting(E_ALL);
ini_set('display_errors', 1);

function fibonacci($n) {
    $fib = [0, 1];

    for ($i = 2; $i <= $n; $i++) {
        $fib[$i] = $fib[$i - 1] + $fib[$i - 2];
    }

    return $fib[$n];
}

function fibonacciTillN($n) {
    $fib = [0, 1];

    $sum = 0;

    for ($i = 2; $i <= $n; $i++) {
        $fib[$i] = $fib[$i - 1] + $fib[$i - 2];
        $sum = $sum + $fib[$i];
    }

    return $sum;
}

echo "<table>";

echo "<tr>
        <th>n</th>
        <th>F(n)</th>
        <th>F(1) + ... + F(n)</th>
    </tr>";

for ($j = 1; $j < 6; $j++) {
   
    echo "<tr>
        <th>$j</th>
        <th>" . fibonacci($j) . "</th>
        <th>" . fibonacciTillN($j) . "</th>
    </tr>";
}

echo "</table>";

?>