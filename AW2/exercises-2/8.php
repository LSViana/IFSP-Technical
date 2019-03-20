<?php
    function execute8(...$numbers) {
        $count = count($numbers);
        $highestIndex = 0;
        $lowestIndex = 0;
        $average = 0;
        // Calculate the average, highest and lowest values
        for($x = 0; $x < $count; $x++) {
            $current = $numbers[$x];
            //
            $average += $current;
            //
            if($current > $numbers[$highestIndex])
                $highestIndex = $x;
            //
            else if($current < $numbers[$highestIndex])
                $highestIndex = $x;
        }
        $average /= $count;
        // Find the element which is nearest to the average
        $indexNearestToAverage = 0;
        $lowestDistanceToAverage = abs($numbers[$indexNearestToAverage] - $average);
        for($x = 0; $x < $count; $x++) {
            $currentDistanceToAverage = abs($numbers[$x] - $average);
            if($currentDistanceToAverage < $lowestDistanceToAverage) {
                $lowestDistanceToAverage = $currentDistanceToAverage;
                $indexNearestToAverage = $x;
            }
        }
        // Return the results
        return [
            "average" => $average,
            "highest" => [
                "value" => $numbers[$highestIndex],
                "index" => $highestIndex,
            ],
            "lowest" => [
                "value" => $numbers[$lowestIndex],
                "index" => $lowestIndex,
            ],
            "nearestToAverage" => [
                "value" => $numbers[$indexNearestToAverage],
                "index" => $indexNearestToAverage,
            ],
        ];
    }
?>