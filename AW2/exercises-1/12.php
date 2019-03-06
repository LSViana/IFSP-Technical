<?php
    declare(strict_types=1);

    header("Content-Type: application/json");

    // Input values come from URL
    $number = intval($_GET["number"]);

    function isPrime(int $number) : bool {
        // Particular cases
        if($number < 2 || ($number > 2 && $number % 2 == 0))
            return false;
        // Other cases
        $dividers = 0;
        $i = 1;
        do {
            if($number % $i == 0)
                $dividers++;
        }
        while(++$i < $number / 2);
        // Not 2 because I am considering only until half of the number (considering the square root would be too expensive)
        return $dividers == 1;
    }

    $results = [];

    for ($j=0; $j < 1000; $j++) {
        $value = new stdClass();
        $value->number = $j;
        $value->isPrime = isPrime($j);
        if($value->isPrime)
            array_push($results, $value);
    }

    echo json_encode([
        // "isPrime" => isPrime($number),
        "results" => $results,
    ]);
?>