<?php
    // Data
    $options = [
        [
            "name" => "Cachorro quente",
            "code" => 100,
            "price" => 1.2
        ],
        [
            "name" => "Bauru simples",
            "code" => 101,
            "price" => 1.3
        ],
        [
            "name" => "Bauru com ovo",
            "code" => 102,
            "price" => 1.5
        ],
        [
            "name" => "Hamburger",
            "code" => 103,
            "price" => 1.2
        ],
        [
            "name" => "Cheeseburger",
            "code" => 104,
            "price" => 1.3
        ],
        [
            "name" => "Refrigerante",
            "code" => 105,
            "price" => 1.0
        ],        
    ];
    $fillingBonus = 0.25;
    // Functions
    function printOptions() {
        echo "option";
    }
    // Variables
    $isGet = $_SERVER["REQUEST_METHOD"] == "GET";
?>
<html>
    <head>
        <title>Exercício 1</title>
        <style>
            .border-table, .border-table th, .border-table td {
                border-collapse: collapse;
                border: 1px solid black;
            }
            .get-hidden {
                display: none;
            }
        </style>
    </head>
    <body>
        <section class="options">
            <table class="border-table">
                <thead>
                    <tr>
                        <th>Especificação</th>
                        <th>Código</th>
                        <th>Preço</th>
                    </tr>
                </thead>
                <tbody>
                        <h1>Opções</h1>
                        <?php
                            foreach($options as $option) {
                                echo <<<item
                                <tr>
                                    <td>$option[name]</td>
                                    <td>$option[code]</td>
                                    <td>$option[price]</td>
                                </tr>
item;
                            }
                        ?>
                </tbody>
            </table>
        </section>
        <section class="orders">
            <form method="post">
                <p>
                    <label for="option">Lanche</label>
                    <select name="option" id="option">
                        <?php
                            foreach($options as $option) {
                                echo <<<option
                                    <option value="$option[code]">$option[name]</option>
option;
                            }
                        ?>
                    </select>
                </p>
                <p>
                    <label for="amount">Quantidade</label>
                    <input type="number" name="amount" id="amount" min="1" max="500" value="1">
                </p>
                <p>
                    <label for="filling">Recheio extra</label>
                    <input type="checkbox" name="filling" id="filling">
                </p>
                <p>
                    <button>
                        Pedir
                    </button>
                </p>
            </form>
        </section>
        <section class="result <?php if($isGet) echo "get-hidden" ?>">
            <h1>Resultado</h1>
            <?php
                if(!$isGet) {
                    // Get value from request
                    $filling = isset($_POST["filling"]);
                    $amount = $_POST["amount"];
                    $code = $_POST["option"];
                    // Calculating prices
                    // The call to array values reset indexes to start from zero
                    $selectedOption = array_values(array_filter($options, function($item) { // This function filters the array to get the element by code
                        global $code;
                        return $item["code"] == $code;
                    }))[0];
                    $unitPrice = $selectedOption["price"];
                    if($filling) {
                        $unitPrice += $fillingBonus;
                    }
                    $totalPrice = $unitPrice * $amount;
                    // Showing result
                    echo <<<result
                        <h4>Preço total: R$ $totalPrice</h4>
result;
                }
            ?>
        </section>
    </body>
</html>