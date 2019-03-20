<?php
    function execute9($first, $second) {
        $sum = [];
        $product = [];
        $difference = [];
        $intersection = [];
        $union = [];
        //
        $count = count($first);
        for($x = 0; $x < $count; $x++) {
            $sum[$x] = $first[$x] + $second[$x];
            $product[$x] = $first[$x] * $second[$x];                        
            $difference[$x] = $first[$x] - $second[$x];
            // Performing the intersection
            $secondContainsFirst = array_search($first[$x], $second);
            if($secondContainsFirst !== false && (array_search($first[$x], $intersection) === false)) {
                array_push($intersection, $first[$x]);
            }
            // Performing the union
            if(array_search($first[$x], $union) === false) {
                array_push($union, $first[$x]);
            }
            if(array_search($second[$x], $first) === false) {
                array_push($union, $second[$x]);
            }
        }
        // Return the result
        return [
            "sum" => $sum,
            "product" => $product,
            "difference" => $difference,
            "intersection" => $intersection,
            "union" => $union,
        ];
    }
?>