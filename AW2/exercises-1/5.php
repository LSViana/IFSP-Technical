<?php
    function execute5($i, $a, $b, $c) {
        $values = [ intval($a), intval($b), intval($c) ];

        $increasing = $i == 1;
    
        // It takes the array as reference, then the function can edit the array instance
        function orderArray(&$array, $increasing) {
            // Quick hand-made sorting algorithm
            for ($j = 0; $j < count($array) - 1; $j++) { 
                $firstIndex = $j;
                for($k = $j + 1; $k < count($array); $k++) {
                    if ($increasing && $array[$k] < $array[$firstIndex])
                        $firstIndex = $k;
                    else if(!$increasing && $array[$k] > $array[$firstIndex])
                        $firstIndex = $k;
                }
                if($firstIndex != $j)
                {
                    $exchange = $array[$j];
                    $array[$j] = $array[$firstIndex];
                    $array[$firstIndex] = $exchange;
                }
            }
        }
    
        orderArray($values, $increasing);

        return $values;
    }
?>