<?php
    include "1.php";
    include "2.php";
    include "3.php";
    include "4.php";
    include "5.php";
    include "6.php";
    include "7.php";
    include "8.php";
    include "9.php";

    $results = [];

    // Exercise 1
    $results[1] = [
        "code" => "execute1(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)",
        "result" => execute1(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
    ];

    // Exercise 2
    $results[2] = [
        "code" => "execute2(1, 2, 3, 4, 5, 2)",
        "result" => execute2(1, 2, 3, 4, 5, 2),
    ];

    // Exercise 3
    $results[3] = [
        "code" => "execute3(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)",
        "result" => execute3(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20),
    ];

    // Exercise 4
    $results[4] = [
        "code" => "execute4([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], [11, 12, 13, 14, 15, 16, 17, 18, 19, 20])",
        "result" => execute4([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], [11, 12, 13, 14, 15, 16, 17, 18, 19, 20]),
    ];

    // Exercise 5
    $results[5] = [
        "code" => "execute5(2, 4, 6, 8, 10, 1, 2, 3, 4, 5)",
        "result" => execute5(2, 4, 6, 8, 10, 1, 2, 3, 4, 5),
    ];

    // Exercise 6
    $results[6] = [
        "code" => "execute6(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)",
        "result" => execute6(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
    ];

    // Exercise 7
    $results[7] = [
        "code" => "execute7(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)",
        "result" => execute7(1, 2, 3, 4, 5, 6, 7, 8, 9),
    ];

    // Exercise 8
    $results[8] = [
        "code" => "execute8(1, 2, 3, 4, 5)",
        "result" => execute8(1, 2, 3, 4, 5),
    ];

    // Exercise 9
    $results[9] = [
        "code" => "",
        "result" => execute9([1, 2, 3, 4, 5], [4, 5, 6, 7, 8]),
        // "result" => execute9([1, 2, 3, 4, 5], [6, 7, 8, 9, 10]),
    ];

    // Returning the result
    header("Content-Type: application/json");
    echo json_encode($results);
?>