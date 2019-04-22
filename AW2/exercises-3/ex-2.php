<?php
    // Variables
    $isGet = $_SERVER["REQUEST_METHOD"] == "GET";
    $isPost = $_SERVER["REQUEST_METHOD"] == "POST";
    // Functions
?>
<html>
    <head>
        <title>Exercício 2</title>
        <style>
            .get-hidden {
                display: none;
            }
        </style>
    </head>
    <body>
        <section class="input-form">
            <h1>Informações</h1>
            <form method="post">
                <p>
                    <label for="name">Nome</label>
                    <input type="text" name="name" id="name" <?php if($isPost) echo "disabled value='$_POST[name]'" ?>>
                </p>
                <p>
                    <label for="enrollment">Prontuário</label>
                    <input type="text" name="enrollment" id="enrollment" <?php if($isPost) echo "disabled value='$_POST[enrollment]'" ?>>
                </p>
                <p>
                    <label for="date">Data de Nascimento</label>
                    <input type="date" name="date" id="date" <?php if($isPost) echo "disabled value='$_POST[date]'"; else echo "value='2001-01-01'"; ?>>
                </p>
                <p>
                    <label for="name">E-mail</label>
                    <input type="email" name="email" id="email" <?php if($isPost) echo "disabled value='$_POST[email]'" ?>>
                </p>
                <p>
                    <label for="gender">Masculino</label>
                    <input type="radio" name="gender" value="male" <?php if($isPost) echo "disabled " . ($_POST["gender"] == "male" ? "checked" : ""); else echo "checked"; ?>>
                    <label for="gender">Feminino</label>
                    <input type="radio" name="gender" value="female" <?php if($isPost) echo "disabled " . ($_POST["gender"] == "female" ? "checked" : ""); ?>>
                </p>
                <button>
                    Enviar
                </button>
            </form>
        </section>
        <section class="result <?php if($isGet) echo "get-hidden" ?>">
            <h1>Resultado</h1>
            <?php
                if(!$isGet) {
                    // Creates a datetime value from string date
                    $bornDate = new DateTime($_POST["date"]);
                    $now = new DateTime();
                    $interval = $now->diff($bornDate);
                }
            ?>
            <h3>
                Idade: <?php if(!$isGet) echo $interval->format("%y ano(s), %m mês(es) and %d dia(s)") ?>
            </h3>
            <p style="color: gray">
                O PHP considera diferentes timezones, isto pode interferir no resultado em algumas horas.
            </p>
        </section>
    </body>
</html>