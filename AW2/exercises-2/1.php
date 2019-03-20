<?php
    function execute1(...$numbers) {
        $numbersSquare = array_map(function($item) {
            return $item ** 2;
        }, $numbers);
        return [
            "input" => $numbers,
            "output" => $numbersSquare,
        ];
    };
?>