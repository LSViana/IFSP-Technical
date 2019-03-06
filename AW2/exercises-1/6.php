<?php
    header("Content-Type: application/json");

    // All the inputs for this exercise come from URL
    $extraHours = intval($_GET["extra"]);
    $missingHours = intval($_GET["missing"]);

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

    echo json_encode([
        "extra" => $extraHours,
        "missing" => $missingHours,
        "reward" => getRewardFromHours($totalHours),
    ]);
?>