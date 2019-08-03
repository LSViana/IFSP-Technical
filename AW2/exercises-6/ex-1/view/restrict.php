<?php
    session_start();
    //
    if(!isset($_SESSION["email"])) {
        header("Location: ./login.php");
        return;
    }
?>
<html>
    <head>
        <title>Restrict</title>
    </head>
    <body>
        <h2>Congratulations, you reached a restrict page, <?php echo $_SESSION["email"] ?>!</h2>
        <form action="../controller/user.php" method="POST">
            <button name="logout" value="logout" type="submit">Logout</button>
        </form>
    </body>
</html>