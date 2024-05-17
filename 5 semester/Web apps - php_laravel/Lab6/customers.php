<?php

    require_once 'stripe-php-13.0.0/init.php';

    $stripe = new \Stripe\StripeClient('key removed');
    $max_3_customers = $stripe->customers->all();


    header('Content-Type: application/json');
    echo json_encode($max_3_customers, JSON_PRETTY_PRINT);

?>