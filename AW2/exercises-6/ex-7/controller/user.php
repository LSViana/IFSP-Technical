<?php
    // Verify if request is POST
    $method = $_SERVER["REQUEST_METHOD"];
    $is_post = $method == "POST";
    if(!$is_post) {
        // Method not allowed
        http_response_code(405);
        return;
    }
    // Verify if there's an ID to delete
    if(!isset($_POST["delete"])) {
        // Bad request
        http_response_code(400);
        return;
    }
    $id = $_POST["delete"];
    // Delete the register
    $db = mysqli_connect("localhost", "root", "");
    // The same database as exercise 3 is used
    $db->query("USE user_page");
    $result = $db->query("DELETE FROM user WHERE id = $id");
    // Verify possible errors
    if(!$result) {
        http_response_code(500);
        return;
    }
    // Redirect to view/users.php
    header("Location: ../view/users.php");
?>