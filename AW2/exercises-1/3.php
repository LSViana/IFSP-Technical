<?php
    // Constants
    $zero = "zero";

    $units = [
        "um",
        "dois",
        "três",
        "quatro",
        "cinco",
        "seis",
        "sete",
        "oito",
        "nove",
    ];

    $tens = [
        "dez",
        "vinte",
        "trinta",
        "quarenta",
        "cinquenta",
        "sessenta",
        "setenta",
        "oitenta",
        "noventa"
    ];

    $specialTens = [
        "dez",
        "onze",
        "doze",
        "treze",
        "quatorze",
        "quinze",
        "dezesseis",
        "dezessete",
        "dezoito",
        "dezenove",
    ];

    $specialHundred = "cem";

    $hundreds = [
        "cento",
        "duzentos",
        "trezentos",
        "quatrocentos",
        "quinhentos",
        "seiscentos",
        "setecentos",
        "oitocentos",
        "novecentos",
    ];

    function numberToText(int $number) : string {
        global $hundreds;
        global $specialHundred;
        global $tens;
        global $specialTens;
        global $units;
        global $zero;

        $text = "";

        $unit = $number % 10;
        $ten = $number % 100;
        $hundred = $number % 1000;

        // Adjusting $ten and $hundred
        $ten -= $unit;
        $hundred -= $ten;
        $hundred -= $unit;
        //
        $ten /= 10;
        $hundred /= 100;

        if($hundred > 0) {
            if($hundred == 1 && $ten == 0 && $unit == 0)
                $text .= $specialHundred;
            else
                $text .= $hundreds[$hundred - 1];
        }
        if($ten > 0) {
            if($hundred == 0 && $ten == 1) // Use $specialTens
                $text .= $specialTens[$unit];
            else {
                if(strlen($text) > 0)
                    $text .= " e ";
                $text .= $tens[$ten - 1];
            }
        }
        if($unit > 0) {
            if($hundred == 0 && $ten == 1) // Use $specialTens
            {}
            else {
                if(strlen($text) > 0)
                    $text .= " e ";
                $text .= $units[$unit - 1];
            }
        }
        else if($unit == 0 && $ten == 0 && $hundred == 0)
            $text .= $zero;

        return $text;
    }

    function execute3(int $number) {
        return numberToText($number);
    }
?>