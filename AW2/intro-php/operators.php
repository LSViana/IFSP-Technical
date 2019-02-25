<?php
    function println($arg) {
        if($arg === false)
            echo "false";
        else if($arg === true)
            echo "true";
        echo $arg;
        echo "\r\n";
    }

    #region Arithmetic
        // Addition
        println(5 + 4);
        // Subtraction
        println(5 - 4);
        // Multiplication
        println(5 * 4);
        // Division
        println(5 / 4);
        // Modulus
        println(5 % 4);
        // Exponentiation
        println(5 ** 2);
    #endregion

    println("\t@");
    #region Assignment
        // Regular
        $x = 8;
        println($x);
        // Add and assign
        $x += 2;
        println($x);
        // Subtract and assign
        $x -= 1;
        println($x);
        // Multiplicate and assign
        $x *= 2;
        println($x);
        // Divide and assign
        $x /= 3;
        println($x);
        // Modulus and assign
        $x %= 5;
        println($x);
    #endregion

    println("\t@");
    #region Comparison
        // Equals
        $y = 1;
        println($x == $y);
        // Identical (Equals AND same type)
        $z = "1";
        println((($z === $x) == false) . " @ " . ($y === $x));
        // Not equal
        $w = 2;
        println($w != $x);
        println($w <> $x);
        // Not identical
        println($z !== $x);
        // Greater than
        println($w > $x);
        // Smaller than
        println($x < $w);
        // Greater or equal than
        println($x >= $y);
        // Smaller or equal than
        println($x <= $y);
    #endregion

    println("\t@");
    #region Increment and Decrement
        // Pre-Increment
        println(++$x);
        println($x);
        // Pos-Increment
        println($x++);
        println($x);
        // Pre-Decrement
        println(--$x);
        println($x);
        // Pos-Decrement
        println($x--);
        println($x);
    #endregion

    println("\t@");
    #region Logical
        function getTrue($id) {
            echo "Return true ($id)\r\n";
            return true;
        }
        function getFalse($id) {
            echo "Return false ($id)\r\n";
            return false;
        }
        // And
        println(getTrue(1) and getTrue(2));
        println(getTrue(2) and getFalse(1));
        println(getFalse(2) and getTrue(3)); // Short-circuit
        // Or
        println(getTrue(1) or getTrue(2)); // Short-circuit
        println(getTrue(3) | getTrue(4));
        println(getTrue(5) || getTrue(6)); // Short-circuit
        println(getFalse(1) or getTrue(7));
        println(getTrue(8) or getFalse(2)); // Short-circuit
        // Xor (there is no short-circuit available)
        println(getTrue(1) xor getTrue(2));
        println(getTrue(3) xor getFalse(1));
        println(getFalse(2) xor getTrue(4));
        println(getFalse(3) xor getFalse(4));
        // Not
    #endregion

    println("\t@");
    #region String
        $name = "Lucas";
        // Concatenation
        println($name . " " . "Viana");
        // Append and concatenate
        $name .= " " . "Souza";
        println($name);
    #endregion

    println("\t@");
    #region Array
        $array1 = array(1 => "1", 2 => "2");
        $array1Copy = array(1 => 1, 2 => 2);
        $array1Identity = array(1 => "1", 2 => "2");
        $array2 = array(3 => "3", 4 => "4");
        // Union
        $array3 = $array1 + $array2;
        print_r($array3);
        echo "\r\n";
        // Equality
        print_r($array1 == $array1Copy);
        echo "\r\n";
        // Identity
        echo "Identity 1: ";
        print_r($array1 === $array1Copy);
        echo "\r\n";
        echo "Identity 2: ";
        print_r($array1 === $array1Identity);
        echo "\r\n";
        // Inequality
        println($array1 != $array1Copy);
        println($array1 <> $array1Copy);
        // Non-identity
        println($array1 !== $array1Copy);
        println($array1 !== $array1Identity);

    #endregion
?>