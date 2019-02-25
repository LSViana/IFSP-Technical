<?php
    $x = 1;

    // While loop
    print("While loop: \r\n");
    while($x <= 5) {
        print("Loop in x = " . $x);
        print("\r\n");
        $x++;
    }
    print("x after loop: " . $x);
    $x = 1;
    print("\r\n");

    // Do...while loop
    print("Do...while loop: \r\n");
    do {
        print("Loop in x = " . $x);
        print("\r\n");
        $x++;
    } while($x <= 5);
    print("x after loop: " . $x);
    $x = 1;
    print("\r\n");

    // For loop
    print("For loop: \r\n");
    for($y = 0; $y <= 10; $y++) {
        print("Loop in y = " . $y);
        print("\r\n");
    }
    print("\r\n");

    // Foreach loop (it works only over arrays)
    $colors = array("red", "green", "blue", "black");

    foreach($colors as $color) {
        print("Color: $color\r\n");
    }
?>