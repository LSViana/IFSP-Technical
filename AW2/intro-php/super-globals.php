<?php
    $globalName = "z";

    $x = 50;
    $y = 25;

    function sum() {
        global $globalName;
        $GLOBALS[$globalName] = $GLOBALS["x"] + $GLOBALS["y"];
    }

    sum();

    // Access from "variable variable"
    echo "Sum: " . $$globalName;
    echo "\n";
    // Direct access
    echo "Sum: " . $z;
?>