<?php
    $indexed = [ 8, 2, 9, 0, 10 ];
    $associative = [
        "Banana" => 102,
        "Abacaxi" => 99,
        "Caju" => 100,
    ];

    // Ascending sort indexed arrays
    echo "Initial state:\n";
    var_export($indexed);
    echo "\n";
    sort($indexed);
    echo "After ascending order:\n";
    var_export($indexed);
    echo "\n";

    // Descending sort indexed arrays
    echo "After descending order:\n";
    rsort($indexed);
    var_export($indexed);
    echo "\n";

    echo "\n\n";

    // Ascending sort associative arrays BY VALUE
    echo "Initial state:\n";
    var_export($associative);
    echo "\n";
    asort($associative);
    echo "After ascending BY VALUE:\n";
    var_export($associative);
    echo "\n";

    // Descending sort associative arrays BY VALUE
    echo "After descending BY VALUE:\n";
    arsort($associative);
    var_export($associative);
    echo "\n";

    // Ascending sort associative arrays BY KEY
    echo "After ascending BY KEY:\n";
    ksort($associative);
    var_export($associative);
    echo "\n";

    // Descending sort associative arrays BY KEY
    echo "After descending BY KEY:\n";
    krsort($associative);
    var_export($associative);
    echo "\n";
?>