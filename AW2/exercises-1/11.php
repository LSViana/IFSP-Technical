<?php
    function execute11(array $orders) {
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
    
        return [
            "total" => $total,
            "results" => $results,
        ];
    }

    // Test JSON
    /*
    {"C": 2, "R": 3}
    */
?>