<?php
    header("Content-Type: application/json");

    // Input value comes from the URL and is treated as integer, to perform the calculus
    $number = intval($_GET["number"]);

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
    echo json_encode([
        "unit" => $unit,
        "ten" => $ten,
        "hundred" => $hundred,
    ]);
?>