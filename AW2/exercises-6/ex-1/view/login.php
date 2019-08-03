<?php
    require '../model/login.php';
    //
    session_start();
    //
    $login_error = isset($_SESSION["login_error"]) ? $_SESSION["login_error"] : false;
    if($login_error) {
        unset($_SESSION["login_error"]);
    }
?>
<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <section class="login">
            <form action="../controller/user.php" method="POST">
                <p>
                    <label for="email">E-mail</label>
                    <input type="email" name="email" id="email" value="1@1.com">
                </p>
                <p>
                    <label for="password">Password</label>
                    <input type="password" name="password" id="password" value="Asdf1234">
                </p>
                <?php
                    if($login_error) {
                ?>
                    <h5 style="color: red">
                        <?php echo $login_error ?>
                    </h5>
                <?php
                    }
                ?>
                <button name="login" value="login" type="submit">Login</button>
            </form>
        </section>
    </body>
</html>