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
        "code" => "execute3(573)",
        "result" => execute3(573),
    ];

    $result["4"] = [
        "code" => "execute4(10, 5)",
        "result" => execute4(10, 5),
    ];

    $result["5"] = [
        "code" => "execute5(1, 7, 3, 2)",
        "result" => execute5(1, 7, 3, 2),
    ];

    $result["6"] = [
        "code" => "execute6(2100, 300)",
        "result" => execute6(2100, 300),
    ];

    $result["7"] = [
        "code" => "execute7(19)",
        "result" => execute7(19),
    ];

    $result["8"] = [
        "code" => "execute8(4, 3)",
        "result" => execute8(4, 3),
    ];

    $result["9"] = [
        "code" => "execute9([ 1, 2, 3, 4, 5, -1, 6 ])",
        "result" => execute9([ 1, 2, 3, 4, 5, -1, 6 ]),
    ];

    $result["10"] = [
        "code" => 'execute10([(object)["name"=>"Lucas Viana","grade"=>10.0,],(object)["name"=>"Roberto Bolgheroni","grade"=>9.0,],(object)["name"=>"Matheus Moreira","grade"=>6.0,],(object)["name"=>"Pedro Splugues","grade"=>7.0,],(object)["name"=>"Vitor Maia","grade"=>8.0,],])',
        "result" => execute10([
            (object) [
                "name" => "Lucas Viana",
                "grade" => 10.0,
            ],
            (object) [
                "name" => "Roberto Bolgheroni",
                "grade" => 9.0,
            ],
            (object) [
                "name" => "Matheus Moreira",
                "grade" => 6.0,
            ],
            (object) [
                "name" => "Pedro Splugues",
                "grade" => 7.0,
            ],
            (object) [
                "name" => "Vitor Maia",
                "grade" => 8.0,
            ],
        ]),
    ];

    $result["11"] = [
        "code" => 'execute11(["C"=>2,"R"=>3,])',
        "result" => execute11([
            "C" => 2,
            "R" => 3,
        ]),
    ];

    $result["12"] = [
        "code" => "execute12(13)",
        "result" => execute12(13),
    ];

    $result["13"] = [
        "code" => "execute13(5)",
        "result" => execute13(5),
    ];

    $result["14"] = [
        "code" => "execute14(732)",
        "result" => execute14(732),
    ];

    $result["19"] = [
        "code" => "execute19([3, 4, 5])",
        "result" => execute19([3, 4, 5]),
    ];
    
    // Returning results
    echo json_encode($result);
?>