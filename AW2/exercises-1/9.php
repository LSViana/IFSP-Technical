<?php
    header("Content-Type: application/json");

    $values = json_decode($_GET["values"]);
    $total = 0.0;
    $count = 0;

    for($i = 0; $i < count($values); $i++) {
        $value = $values[$i];
        
        if($value >= 0) {
            $count++;
            $total += $value;
        }
        else
            break;
    }

    $average = $total / $count;

    echo json_encode([
        "average" => $average
    ]);
?>