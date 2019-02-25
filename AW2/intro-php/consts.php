<?php
    // Defining a constant
        // Constants are automatically global
        // Declaration of case-insensitive constants is deprecated
    define("year", 2019);

    // Using a constant
    echo year;
    echo "\r\n";

    function thereIsConstant() {
        echo year;
    }

    thereIsConstant();
?>