<?php
    header("Content-Type: application/json");

    // Import exercise files
    require "1.php";
    require "2.php";
    require "3.php";
    require "4.php";
    require "5.php";
    require "6.php";
    require "7.php";
    require "8.php";
    require "9.php";
    require "10.php";
    require "11.php";
    require "12.php";
    require "13.php";
    require "14.php";
    require "19.php";
    
    // Executing exercises
    $result = [];

    $result["1"] = [
        "code" => "execute1('male', 100, 1.7, 30)",
        "result" => execute1('male', 100, 1.7, 30)
    ];

    $result["2"] = [
        "code" => "execute2(3, 3, 5)",
        "result" => execute2(3, 3, 5),
    ];

    $result["3"] = [
        "code" => "",
        "result" => "",
    ];

    $result["4"] = [
        "code" => "",
        "result" => "",
    ];

    $result["5"] = [
        "code" => "",
        "result" => "",
    ];

    $result["6"] = [
        "code" => "",
        "result" => "",
    ];

    $result["7"] = [
        "code" => "",
        "result" => "",
    ];

    $result["8"] = [
        "code" => "",
        "result" => "",
    ];

    $result["9"] = [
        "code" => "",
        "result" => "",
    ];

    $result["10"] = [
        "code" => "",
        "result" => "",
    ];

    $result["11"] = [
        "code" => "",
        "result" => "",
    ];

    $result["12"] = [
        "code" => "",
        "result" => "",
    ];

    $result["13"] = [
        "code" => "",
        "result" => "",
    ];

    $result["14"] = [
        "code" => "",
        "result" => "",
    ];

    $result["19"] = [
        "code" => "",
        "result" => "",
    ];
    
    // Returning results
    echo json_encode($result);
?>