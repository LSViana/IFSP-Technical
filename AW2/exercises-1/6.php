<?php
    function execute6($extraHours, $missingHours) {
        $totalHours = $extraHours - (2/3) * $missingHours;

        function getRewardFromHours($totalHours) : float {
            if($totalHours > 2400)
                return 500;
            else if($totalHours > 1800)
                return 400;
            else if($totalHours > 1200)
                return 300;
            else if($totalHours >= 600) // There is an equal here because the PDF says "600 até 1200"
                return 200;
            else
                return 100;
        }

        return [
            "extra" => $extraHours,
            "missing" => $missingHours,
            "reward" => getRewardFromHours($totalHours),
        ];
    }
?>