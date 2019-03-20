<?php
    function execute2(...$numbers) {
        $code = $numbers[5]; // The code to be analysed
        if($code == 0)
            return null;
        else if ($code == 1) {
            return array_slice($numbers, 0, 5);
        }
        else if ($code == 2) {
            $result = [];
            for($i = 0; $i < 5; $i++)
                $result[$i] = $numbers[4 - $i]; // 4 here is to use 0-based index
            return $result;
        }
        else {
            return "Invalid code";
        }
    }
?>