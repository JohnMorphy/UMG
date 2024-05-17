<?php

class StripeConnection  {

    public function listCustomers() {
        require_once '../stripe-php-13.0.0/init.php';

        $stripe = new \Stripe\StripeClient('key removed');
        $customerList = $stripe->customers->all();
    
        return $customerList;
    }

    public function addCustomer($description, $email, $name) {

        require_once '../stripe-php-13.0.0/init.php';

        $stripe = new \Stripe\StripeClient('key removed');
                
        $customer = $stripe->customers->create([
            'description' => $description,
            'email' => $email,
            'name' => $name
        ]);

        return $customer;
    
    }

    public function plainCustomerList() {
        
        $customerList = $this->listCustomers();
       
        echo "<table>";
       
        echo "<tr>";
        echo "<td>Full name</td>";
        echo "<td>email</td>";
        echo "<td>id</td>";
        echo "</tr>";

        foreach($customerList as $jsonCustomer) {
            
            $formattedJson = str_replace('Stripe\Customer JSON: ', '', $jsonCustomer);
            $customerObj = json_decode($formattedJson);

            echo "<tr>";
            echo "<td>" . $customerObj->name . "</td>";
            echo "<td>" . $customerObj->email . "</td>";
            echo "<td>" . $customerObj->id . "</td>";
            echo "</tr>";
        }

        echo "</table>";
    }

    public function customerOptionList() {
        $customerList = $this->listCustomers();
       
        foreach($customerList as $jsonCustomer) {
            
            $formattedJson = str_replace('Stripe\Customer JSON: ', '', $jsonCustomer);
            $customerObj = json_decode($formattedJson);

            echo "<option value=".$customerObj->id.">".$customerObj->name.", ".$customerObj->email."</option>";
        }
    }

    public function removeCustomer($id) {
        require_once '../stripe-php-13.0.0/init.php';

        $stripe = new \Stripe\StripeClient('key removed');
        
        $customer = $stripe->customers->delete($id, []);
        return $customer;
    }

    public function updateCustomer($id, $description, $email, $name) {
        require_once '../stripe-php-13.0.0/init.php';

        $stripe = new \Stripe\StripeClient('key removed');
        
        $customer = $stripe->customers->update($id, [
            'description' => $description,
            'email' => $email,
            'name' => $name
        ]);

        return $customer;
    }

}



?>