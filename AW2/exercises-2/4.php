<?php
    function execute4($first, $second) {
        $result = [];
        // Get the amount of items to iterate over
        $count = count($first);
        // Perform the operations
        for($x = 0; $x < $count; $x++) {
            $result[$x] = $first[$x] * $second[$x];
        }
        // Return the result
        return $result;
    }
?>