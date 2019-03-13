<?php
    function execute1($gender, $weight, $height, $age) {
        $geb = 0;
        // strcasecmp (String Case [Insensitive] Compare) returns if two strings are equal without considering the differences between upper and lower cases
        if(strcasecmp($gender, "male")) {
            $geb = 66.47 + (13.75 * $weight) + (5 * $height) - (6.76 * $age);
        }
        else {
            $geb = 66.51 + (9.56 * $weight) + (1.85 * $height) - (4.67 * $age);
        }
        return $geb;
    }
?>