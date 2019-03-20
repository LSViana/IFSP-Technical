<?php
    $ages = array("Maia"=>22, "Pepe"=>32);

    echo "Pepe: " . $ages["Pepe"] . "<br />";

    foreach($ages as $key => $value) {
        echo "Name: " . $key . " => Age: " . $value . "<br>";
    }
?>