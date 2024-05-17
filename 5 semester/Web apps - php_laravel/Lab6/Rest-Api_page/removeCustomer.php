<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Usuwanie klientów</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        
        <?php
        include_once("menu.php");
        ?>
        
        <h2>Formularz do usuwania klientów</h2>
       
        <div class = "container">
        
        <div>
        <form action = "removeCustomer.php" method = "POST">
            
            <label for="id">Wybierz klienta do usunięcia</label><br>
            <select id="id" name="id" required>
                <option value="">-</option>
                <?php
                include_once("StripeConnection.php");
                $StripeConnection = new StripeConnection();
                $StripeConnection->customerOptionList();
                ?>
            </select>

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

                if (isset($_POST["id"])) {
                    $StripeConnection = new StripeConnection();
                    echo "<br>".$StripeConnection->removeCustomer($_POST["id"]);
                    header("Refresh:0");
                }
            }

        ?>
        
    </body>
</html>