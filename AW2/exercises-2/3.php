<?php
    function execute3(...$numbers) {
        $count = count($numbers);
        //
        $result = [];
        // Setting the original vector
        $result["input"] = $numbers;
        // Calculating the output
        $output = [];
        for($x = 0; $x < ($count / 2); $x++) {
            $output[$x] = $numbers[($count - 1) - $x];
            $output[($count - 1) - $x] = $numbers[$x];
        }
        $result["output"] = $output;
        // Returning the result
        return $result;
    }
?>