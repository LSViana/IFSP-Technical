<?php
    header("Content-Type: application/json");

    $items = [
        "C" => [
            "name" => "Cachorro quente",
            "price" => 2.0,
        ],
        "R" => [
            "name" => "Refrigerante",
            "price" => 2.5,
        ],
        "S" => [
            "name" => "Sobremesa",
            "price" => 1.5,
        ],
    ];

    // The input of the orders will come from the URL
    $orders = json_decode($_GET["orders"]);

    $results = [];
    $total = 0;

    foreach($orders as $type => $amount) {
        if(array_key_exists($type, $items)) {
            $order = $items[$type];
            $total += $order["price"] * $amount;
            array_push($results, [
                "item" => $order,
                "amount" => $amount,
                "total" => $order["price"] * $amount
            ]);
        }
    }

    echo json_encode([
        "total" => $total,
        "results" => $results,
    ]);

    // Test JSON
    /*
    {"C": 2, "R": 3}
    */
?>