<?php
    $cars = array("Mercedez", "Volvo", "Ferrari");

    echo "I like " . $cars[1] . " a lot!";

    var_dump($cars);

    for($x = 0; $x < count($cars); $x++) {
        echo $cars[$x];
        //
        echo "<br />";
    }
?>