<?php
    $names = [
        "Lucas",
        "Vitor",
        "Pedro"
    ];

    foreach($names as $name) {
        echo $name . "<br>";
    }

    // array_map to execute a callback in each item
    echo "array_map<br>";
    $namesMapped = array_map(function($item) {
        // The variable $item represents each item of the array
        return [
            "name" => $item,
        ];
    }, $names);

    var_dump($names);
    var_dump($namesMapped);

    // array_pop to remove and return the last element of the array
    echo "array_pop<br>";
    var_dump($names);
    echo array_pop($names);
    var_dump($names);

    // array_push to insert an item in the end of the array (returns the amount of items in the array)
    echo "array_push<br>";
    var_dump($names);
    echo array_push($names, "Roberto");
    var_dump($names);

    // array_shift to remove and return the first element of the array
    echo "array_shift<br>";
    var_dump($names);
    echo array_shift($names);
    var_dump($names);

    // array_unshift to insert elements in the beginning of the array
    echo "array_unshift<br>";
    var_dump($names);
    echo array_unshift($names, "Vinícius", "Luiz");
    var_dump($names);

    // array_slice to extract $n elements starting from the $i position [array_slice($array, $i, $n)]
    echo "array_slice<br>";
    var_dump($names);
    var_dump(array_slice($names, 1, 2));

    // array_merge to merge the values from indexed arrays or key-value-pair in associative arrays (when there are similar keys, the last is kept)
    echo "array_merge<br>";
    $kvp1 = [
        "key1" => 1,
        "key2" => 2,
    ];
    $kvp2 = [
        "key1" => 10,
    ];
    var_dump(array_merge($kvp1, $kvp2));

    // array_sum

    // array_filter
?>