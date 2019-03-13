<?php
    function execute14($number) {
        $unit = $number % 10;
        $ten = $number % 100;
        $hundred = $number % 1000;
        // Adjusting values to remove lower-order values (for example, remove units from the tens)
        $ten -= $unit;
        $hundred -= $ten;
        $hundred -= $unit;
        // Dividing to adjust the values in the range [0, 9]
        $ten /= 10;
        $hundred /= 100;

        // Returning the result
        return [
            "unit" => $unit,
            "ten" => $ten,
            "hundred" => $hundred,
        ]; 
    }
?>