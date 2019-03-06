<?php
    header("Content-Type: application/json");

    // The input number comes from the URL
    $number = intval($_GET["number"]);

    $result = 0;

    for ($i = 1; $i <= $number; $i++) { 
        $result += $i;
    }

    echo json_encode([
        "result" => $result,
    ]);
?>