<?php
    function execute5(...$numbers) {
        $highestIndex = 0;
        $count = count($numbers);
        $lastValueLastIndex = $numbers[$count - 1];
        // Declaring the result
        $result = [];
        // Getting the highest value
        for($x = 0; $x < $count; $x++) {
            $current = $numbers[$x];
            if($numbers[$highestIndex] < $current) {
                $highestIndex = $x;
            }
        }
        // Show the index of the highest
        $result["highestIndex"] = $highestIndex;
        // Show the highest
        $result["highest"] = $numbers[$highestIndex];
        // Swap the highest and last
        $numbers[$count - 1] = $numbers[$highestIndex];
        $numbers[$highestIndex] = $lastValueLastIndex;
        // Show the last
        $result["last"] = $lastValueLastIndex;
        // The original input array
        $result["input"] = $numbers;
        // Return the result
        return $result;
    }
?>