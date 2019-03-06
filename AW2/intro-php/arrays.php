<?php
    /*
        In PHP, there are 3 types of arrays:
            * Indexed: numbers as indexes;
            * Associative: text as indexes;
            * Multidimensional: arrays which contain arrays inside its indexes.
    */

    #region Indexed arrays
    // This create a new array with the specified itesm
    $indexed1 = array("Chevrolet", "Jaguar", "Jeep");
    // If this variable wasn't used before, this create a new array with the item in the specified index (which doesn't have to start in 0)
    $indexed2[1] = "Chevrolet";

    echo "\n";
    #endregion

    #region Counting items of the array
    $numbersArray = array(1, 2, 3, 4);

    $amountOfNumbers = count($numbersArray);
    #endregion

    #region Looping through an indexed array
    $indexed3 = [ 1, 2, 3, 4, 5 ];
    $indexed3Length = count($indexed3);

    for($i = 0; $i < $indexed3Length; $i++) {
        echo "[$i] => $indexed3[$i]\n";
    }
    #endregion

    #region Associative arrays
    $profiles = array("Lucas" => 100, "Roberto" => 102);
    #endregion

    #region Looping through an associative array
    $profiles = array("Lucas" => 100, "Roberto" => 101);

    foreach ($profiles as $name => $id) {
        echo "User [$name] has ID [$id]\n";
    }
    #endregion

    echo "\n";
?>