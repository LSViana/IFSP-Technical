<?php
    /*
        Rules for variables in PHP

        1. Must start with $
        2. After $ must be there letter [a-zA-Z] or underscore [_]
        3. Can't be there a number after $
        4. Only alphanumeric characters in the name
        5. Variable names are case sensitive
    */

    // Declaring variables in PHP (they act as containers for storing data)
    $text = "Lucas Viana";
    $x = "3";
    $y = 4;
    $z = 5;

    // Operating numbers and numbers
    echo ($y + $z); // 4 + 5 = 9

    echo ' @ ';

    // Operating text and numbers
    echo ($x + $y); // "3" + 4 = 7

    echo ' @ ';

    // Output variables in PHP through echo
    $bestSchool = "SENAI Informática";
    echo "I love/like/adore/want " . $bestSchool . "!"; // Instead of (+), use (.) to concatenate strings
?>