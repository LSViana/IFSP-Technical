<?php
    $name = "Lucas Viana";

    // Getting the length of the string
    echo(strlen($name));
    echo "\r\n";

    // Count the number of words in a string
    echo(str_word_count($name));
    echo "\r\n";

    // Reverse a string
    echo(strrev($name));
    echo "\r\n";

    // Search for text in the string (similar to IndexOf in C#)
    $foundPosition = strpos($name, "ucas"); // Finding
    echo($foundPosition);
    echo "\r\n";
    $notFoundPosition = strpos($name, "ucas", 2); // Not finding
    var_export($notFoundPosition);
    echo "\r\n";

    // Replace text within the string (similar to Replace in C#)
    $replacedName =
        // 1st: search string, string to replace, total string
        str_replace("Viana", "Souza", $name);
    var_export($replacedName);
    echo "\r\n";
    //
    
?>