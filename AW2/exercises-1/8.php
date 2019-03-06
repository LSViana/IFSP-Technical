<?php
    header("Content-Type: application/json");

    // Input values come from the URL
    $base = intval($_GET["base"]);
    $exponent = intval($_GET["exponent"]);

    $power = $base ** $exponent;

    echo json_encode([
        "power" => $power,
    ]);
?>