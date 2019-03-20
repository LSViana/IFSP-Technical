<?php
    function execute6(...$numbers) {
        $factor = 10;
        $count = count($numbers);
        for($x = 0; $x < $count; $x++) {
            if($x % 2 == 0) {
                $numbers[$x] /= $factor;
            }
            else {
                $numbers[$x] *= $factor;
            }
        }
        return $numbers;
    }
?>