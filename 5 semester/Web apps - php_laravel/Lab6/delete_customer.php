<?php

    require_once 'stripe-php-13.0.0/init.php';

    $stripe = new \Stripe\StripeClient('key removed');
    
    $customer = $stripe->customers->delete(
        'cus_OxMp2KqrA2mhVf',
        []);
    echo $customer;

?>
