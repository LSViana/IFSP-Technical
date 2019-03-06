<?php

// This makes type verification for all parameters passed to string. In practice, it avoids string("5") being cast to int(5)
declare(strict_types=1);

#region Function Name
    $name = "Lucas";

    function writeName($name) {
        echo $name;
    }

    writeName("Lucas");
    echo "\n";
    writename("Viana");
    echo "\n";
    WriteName("Soares");
    echo "\n";
    WriteName("Souza");
    echo "\n";
#endregion

#region Function Sum
    function sum(int $a, int $b) {
        return $a + $b;
    }

    echo sum(1, 2);
    echo "\n";
    echo sum(3, 5);
    echo "\n";
#endregion

#region Function with default argument value
    function writeValue(int $value = 50) {
        echo "Value: $value";
    }

    writeValue(10);
    echo "\n";
    writeValue();
    echo "\n";
#endregion

#region Function with specified return type
    function multiply(int $value1, int $value2) : int { // You can return int if the type declared is float, it is, return types which "inherits" from the specified one
        return $value1 * $value2;
    }

    echo multiply(2, 3);
#endregion

#region Function returning inherited types
    class Animal {
        function Animal(string $name = "Lucas") {
            $this->name = $name;
        }
        function getName() {
            return $this->name;
        }
    }

    class Mammal extends Animal {
        function Mammal() {
            $this->gestationTime = 9;
        }
    }

    function generateAnimal() : Animal {
        return new Mammal();
    }

    $mammal = generateAnimal();
#endregion
?>