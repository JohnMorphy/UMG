<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Dodawanie klientów</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        
        <?php
        include_once("menu.php");
        ?>
        
        <h2>Formularz do dodawnia klientów</h2>
       
        <div class = "container">
        
        <div>
        <form action = "addCustomer.php" method = "POST">
            <label for="name">Full name</label><br>
            <input type="text" id="name" name="name" required><br>
            <label for="email">Email</label><br>
            <input type="email" id="email" name="email" required><br>
            <label for="description">Description</label><br>
            <input type="text" id="description" name="description" required><br><br>

            <input type="submit" value="Send">

        </form>
        </div>
        
        <div>
        <h3>Lista klientów</h3>
        <?php
        include_once("StripeConnection.php");
        $StripeConnection = new StripeConnection();
        $StripeConnection->plainCustomerList();
        ?>
        </div>
        </div>

        <?php

            include_once("StripeConnection.php");

            if ($_SERVER["REQUEST_METHOD"] == "POST") {
                

                if (isset($_POST["description"]) && isset($_POST["email"]) && isset($_POST["name"]) ) {

                    $StripeConnection = new StripeConnection();
                    echo $StripeConnection->addCustomer($_POST["description"], $_POST["email"], $_POST["name"]);
                    header("Refresh:0");
                }
            }

        ?>
        
    </body>
</html>