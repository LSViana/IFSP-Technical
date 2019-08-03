<?php
    session_start();
    //
    $method = $_SERVER["REQUEST_METHOD"];
    $is_post = $method == "POST";
    //
    if($is_post && isset($_POST["login"])) {
        if(!isset($_POST["email"]) || !isset($_POST["password"])) {
            http_response_code(422);
            return;
        }
        $email = $_POST["email"];
        $password = $_POST["password"];
        // Verify if there's such user in database
        $db = mysqli_connect("localhost", "root", "");
        if($db->connect_error) {
            http_response_code(500);
            return;
        } else {
            $db->query("USE login_restrict");
            $sql = "SELECT * FROM user WHERE email = '$email' AND password = '$password'";
            $result = $db->query($sql);
            if($result && $result->num_rows == 1) {
                // User found
                $row = $result->fetch_assoc();
                $_SESSION["email"] = $row["email"];
                $_SESSION["password"] = $row["password"];
                header("Location: ../view/restrict.php");
            } else {
                // User not found
                $_SESSION["login_error"] = "Invalid credentials";
                header("Location: ../view/login.php");
            }
        }
    } else if($is_post && isset($_POST["logout"])) {
        session_destroy();
        header("Location: ../view/login.php");
    } else {
        // Return method not allowed
        http_response_code(405);
        return;
    }
?>