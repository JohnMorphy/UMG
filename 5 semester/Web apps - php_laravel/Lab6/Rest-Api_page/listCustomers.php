<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>List klientów</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        
        <?php
        include_once("menu.php");
        ?>
        
        <h2>Oto podstrona wyświetlająca listę klientów</h2>
       
        <?php
        include_once("StripeConnection.php");
        $StripeConnection = new StripeConnection();
        $StripeConnection->plainCustomerList();
        ?>

    </body>
</html>