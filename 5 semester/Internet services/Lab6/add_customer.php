<?php

    require_once 'stripe-php-13.0.0/init.php';

    $stripe = new \Stripe\StripeClient('key removed');
    
    $customer = $stripe->customers->create([
    'description' => 'Klient edukacyjny',
    'email' => 'r.lasko@domena.pl',
    'name' => 'Robert Laskowski',
    ]);
    echo $customer;

?>
