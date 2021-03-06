<?php
    function execute19($numbers) {
        if(!function_exists("isPrime")) {
            // This function comes from the 12th exercise
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
        }

        $total = 0;

        foreach($numbers as $number) {
            if(isPrime($number))
                $total += $number;
        }

        return [
            "total" => $total,
        ];
    }
?>