<?php
    function execute7(...$numbers) {
        $count = count($numbers);
        for($x = 0; $x < $count / 2; $x++) {
            // Swap the values
            $first = $numbers[$x];
            $numbers[$x] = $numbers[($count - 1) - $x];
            $numbers[($count - 1) - $x] = $first;
        }
        return $numbers;
    }
?>