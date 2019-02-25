<?php
    // Data types in PHP are
        // String
        $name = "Lucas";
        // Integer
            // Decimal
            $age = 18;
            echo $age == 18;
            echo "\r\n";
            // Hexadecimal
            $age = 0x12;
            echo $age == 18;
            echo "\r\n";
            // Octal
            $age = 022;
            echo $age == 18;
            echo "\r\n";
        // Float (similar to double)
        $height = 1.74;
        // Boolean
        $male = true;
        // Array
            // First way to declare arrays
            $schools = [ "SENAI", "IFSP" ];
            // Second way to declare arrays
            $schools = array("SENAI", "IFSP");
        // Object
        class Person {
            function Person() {
                global $name, $age;
                $this->name = $name;
                $this->age = $age;
            }
            function printData() {
                echo "$this->name | $this->age";
                echo "\r\n";
            }
        }
        $person = new Person();
        // NULL
        $skillWithPhp = null;
        // Resource
    // Testing data types
    echo $name;
    echo "\r\n";
    echo $age;
    echo "\r\n";
    // Using var_dump() to return data type and value
    var_dump($name);
    echo $age;
    echo "\r\n";
    var_dump($age);
    //
    echo $height;
    echo "\r\n";
    var_dump($height);
    //
    echo $male;
    echo "\r\n";
    var_dump($male);
    // Can't convert array to string, then we're printing the array length (counting items)
    echo count($schools);
    echo "\r\n";
    var_dump($schools);
    //
    echo $person->name;
    echo "\r\n";
    echo $person->age;
    echo "\r\n";
    var_dump($person);
    $person->printData();
?>