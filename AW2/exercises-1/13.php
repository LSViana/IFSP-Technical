<?php
    function execute13($number) {
        $result = 0;

        for ($i = 1; $i <= $number; $i++) { 
            $result += $i;
        }
    
        return [
            "result" => $result,
        ];
    }
?>