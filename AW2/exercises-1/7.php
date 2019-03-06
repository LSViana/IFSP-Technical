<?php
    header("Content-Type: application/json");

    // The entry time comes from the URL
    $entryTime = intval($_GET["entry"]);

    $leavingTime = ($entryTime + 6) % 24;

    echo json_encode([
        "leaving" => $leavingTime,
    ]);
?>