<?php
    header("Content-Type: application/json");

    // All the inputs for this exercise come from the URL
    $sideA = $_GET["a"];
    $sideB = $_GET["b"];
    $sideC = $_GET["c"];

    $triangleType = "";

    if($sideA > ($sideB + $sideC))
        $triangleType = "not a triangle";
    else if($sideA == $sideB && $sideB == $sideC)
        $triangleType = "equilateral";
    else
        $triangleType = "isosceles";
    
    echo json_encode(array(
        "result" => $triangleType,
    ));
?>