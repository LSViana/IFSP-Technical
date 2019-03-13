<?php
    function execute9(array $values) {
        $total = 0.0;
        $count = 0;

        for($i = 0; $i < count($values); $i++) {
            $value = $values[$i];
            
            if($value >= 0) {
                $count++;
                $total += $value;
            }
            else
                break;
        }

        $average = $total / $count;
        
        return $average;
    }
?>