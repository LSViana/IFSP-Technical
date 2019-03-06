<?php
    header("Content-Type: application/json");

    // The numbers for this exercise come from the URL
    $value1 = $_GET["value1"];
    $value2 = $_GET["value2"];

    $isMultiple = ($value1 % $value2) == 0;

    echo json_encode([
        "result" => $isMultiple ? "$value1 e $value2 são múltiplos" : "$value1 e $value2 não são múltiplos",
    ]);
?>