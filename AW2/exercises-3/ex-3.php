<?php
    // Variables
    $isGet = $_SERVER["REQUEST_METHOD"] == "GET";
    $isPost = $_SERVER["REQUEST_METHOD"] == "POST";
    // Functions
?>
<html>
    <head>
        <title>Exercício 3</title>
    </head>
    <body>
        <?php
            if($isPost) {
                // Variables
                $values1 = [];
                $values2 = [];
                $amount = $_POST["amount"];
                $expiration = $_POST["expiration"];
                $rate1 = $_POST["rate1"];
                $rate2 = $_POST["rate2"];
                // Calculus
                for($i = 1; $i <= $expiration; $i++) {
                    $value1 = $amount * ((1 + $rate1 / 100) ** $i);
                    $value2 = $amount * ((1 + $rate2 / 100) ** $i);
                    //
                    array_push($values1, $value1);
                    array_push($values2, $value2);
                }
            }
        ?>
        <section class="form">
            <h1>Informações</h1>
            <form method="post">
                <p>
                    <label for="amount">Capital inicial</label>
                    <input type="number" name="amount" id="amount" min="0" max="1000000000" value="<?php echo $isPost ? $_POST["amount"] : "5" ?>">
                </p>
                <p>
                    <label for="expiration">Prazo (meses)</label>
                    <input type="number" name="expiration" id="expiration" min="0" max="600" value="<?php echo $isPost ? $_POST["expiration"] : "5" ?>">
                </p>
                <div style="display: flex; flex-flow: row;">
                    <fieldset>
                        <legend>Cenário 1</legend>
                        <p>
                            <label for="rate1">Taxa:</label>
                            <input type="number" name="rate1" id="rate1" min="0" max="10000" value="<?php echo $isPost ? $_POST["rate1"] : "2" ?>">
                            <label for="rate1">%</label>
                        </p>
                        <p>
                        <textarea cols="30" rows="6"><?php
                            if($isPost) {
                                foreach($values1 as $value) {
                                    echo number_format($value, 2) . "\n";
                                }
                            }
                        ?></textarea>
                        </p>
                    </fieldset>
                    <fieldset>
                        <legend>Cenário 2</legend>
                        <p>
                            <label for="rate1">Taxa:</label>
                            <input type="number" name="rate2" id="rate2" min="0" max="10000" value="<?php echo $isPost ? $_POST["rate2"] : "5" ?>">
                            <label for="rate1">%</label>
                        </p>
                        <textarea cols="30" rows="6"><?php
                            if($isPost) {
                                foreach($values2 as $value) {
                                    echo number_format($value, 2) . "\n";
                                }
                            }
                        ?></textarea>
                    </fieldset>
                </div>
                <button>
                    Calcular
                </button>
            </form>
        </section>
    </body>
</html>