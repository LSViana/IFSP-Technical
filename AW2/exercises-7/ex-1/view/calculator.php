<?php
    class CalculatorPage {
        public function view($value1, $value2, $operation, $results, $errors) {
?>
<html>
    <head>
        <title>Calculator</title>
        <style>
            form.calculator-form input:checked ~ label {
                font-weight: bold
            }
        </style>
    </head>
    <body>
        <section>
            <h1>
                PHP Calculator
            </h1>
            <form method="post" class="calculator-form">
                <p>
                    <label for="operation">Operation</label>
                    <div>
                        <p>
                            <input type="radio" name="operation" id="operation-sum" value="sum" <?php if($operation == "sum") echo "checked" ?>>
                            <label for="operation-sum">Sum</label>
                        </p>
                        <p>
                            <input type="radio" name="operation" id="operation-subtraction" value="subtraction" <?php if($operation == "subtraction") echo "checked" ?>>
                            <label for="operation-subtraction">Subtraction</label>
                        </p>
                        <p>
                            <input type="radio" name="operation" id="operation-multiply" value="multiply" <?php if($operation == "multiply") echo "checked" ?>>
                            <label for="operation-multiply">Multiply</label>
                        </p>
                        <p>
                            <input type="radio" name="operation" id="operation-divide" value="divide" <?php if($operation == "divide") echo "checked" ?>>
                            <label for="operation-divide">Divide</label>
                        </p>
                        <p>
                            <input type="radio" name="operation" id="operation-modulus" value="modulus" <?php if($operation == "modulus") echo "checked" ?>>
                            <label for="operation-modulus">Modulus</label>
                        </p>
                        <p>
                            <input type="radio" name="operation" id="operation-sqrt" value="sqrt" <?php if($operation == "sqrt") echo "checked" ?>>
                            <label for="operation-sqrt">Square Root</label>
                        </p>
                    </div>
                </p>
                <p>
                    <label for="values">Values</label>
                    <div>
                        <p>
                            <label for="value1">Value 1</label>
                            <input type="number" name="value1" id="value1" value="<?php echo $value1 ?>">
                            <?php if(isset($errors["value1"])) { ?>
                                <p style="color: red"><?php echo $errors["value1"] ?></p>
                            <?php
                            }
                            ?>
                        </p>
                        <p>
                            <label for="value2">Value 2</label>
                            <input type="number" name="value2" id="value2" value="<?php echo $value2 ?>">
                            <?php if(isset($errors["value2"])) { ?>
                                <p style="color: red"><?php echo $errors["value2"] ?></p>
                            <?php
                            }
                            ?>
                        </p>
                    </div>
                </p>
                <?php if(isset($errors["general"])) { ?>
                    <label for="errors">Error</label>
                    <p style="color: red"><?php echo $errors["general"] ?></p>
                <?php
                }
                ?>
                <?php
                    if($results) {
                ?>
                    <p>
                        <label for="results">Results</label>
                        <h3>
                            <?php echo $results["value"]; ?>
                        </h3>
                    </p>
                <?php
                    }
                ?>
                <button type="submit">
                    Calculate
                </button>
            </form>
        </section>
    </body>
</html>
<?php
        }
    }
?>