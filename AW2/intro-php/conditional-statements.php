<?php
    // @if
    if(true || false)
        print_r("True || false");
    echo "\r\n";
    
    // @else...if
    if(false)
        print_r("Will never reach here");
    else
        print_r("Will always reach here");
    
    echo "\r\n";

    // @if...else if...else
    #region Part 1
    if(false)
        print_r("Will never reach here");
    else if(true && false)
        print_r("Will never reach here");
    else
        print_r("Will always reach here");
    #endregion

    echo "\r\n";

    #region Part 2
    if(false && true)
        print_r("Will never reach here");
    else if(true)
        print_r("Will always reach here");
    else
        print_r("Will never reach here");
    #endregion

    echo "\r\n";

    // @switch
    $value = 3;
    switch($value) {
        case 1:
            print_r("Will never reach here");
            break;
        case 2:
            print_r("Will never reach here");
            break;
        case 3:
            print_r("Will always reach here");
            echo "\r\n";
        case 4:
            print_r("Will fall automatically here");
            break;
        default:
            print_r("Will never reach here");
            break;
    }

    echo "\r\n";

    switch($value) {
        case 1:
            print_r("Will never reach here");
            break;
        default:
            print_r("Will always reach here");
            break;
    }

    echo "\r\n";
?>