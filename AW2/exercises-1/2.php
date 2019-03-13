<?php
    function execute2($sideA, $sideB, $sideC) {
        $triangleType = "";

        if($sideA > ($sideB + $sideC))
            $triangleType = "not a triangle";
        else if($sideA == $sideB && $sideB == $sideC)
            $triangleType = "equilateral";
        else if(($sideA == $sideB) || ($sideA == $sideC) || ($sideB == $sideC))
            $triangleType = "isosceles";
        else
            $triangleType = "scalene";

        return $triangleType;
    }
?>