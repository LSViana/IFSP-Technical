<?php
    function execute4($value1, $value2) {
        $isMultiple = ($value1 % $value2) == 0;
        return $isMultiple ? "$value1 e $value2 são múltiplos" : "$value1 e $value2 não são múltiplos";
    }
?>