<?php
    require_once "./view/calculator.php";
    require_once "./controller/calculator.php";
    //
    $method = $_SERVER["REQUEST_METHOD"];
    $isGet = $method == "GET";
    $isPost = $method == "POST";
    //
    if($isGet) {
        $view = new CalculatorPage();
        $view->view(0, 0, "sum", null, null);
    } else {
        $errors = [];
        $operation = [];
        if(isset($_POST["value1"])) {
            $operation["value1"] = $_POST["value1"];
        } else {
            $operation["value1"] = 0;
            $errors["value1"] = "Fill a valid value";
        }
        if(isset($_POST["value2"])) {
            $operation["value2"] = $_POST["value2"];
        } else {
            $operation["value2"] = 0;
            $errors["value2"] = "Fill a valid value";
        }
        if(isset($_POST["operation"])) {
            $operation["operation"] = $_POST["operation"];
        } else {
            $operation["operation"] = "sum";
            $errors["operation"] = "Select one operation";
        }
        $controller = new CalculatorController();
        $results = [];
        try {
            if(count($errors) == 0) {
                $results = $controller->operate($operation);
            }
        } catch (Exception $e) {
            $errors["general"] = $e->getMessage();
        } finally {
            $view = new CalculatorPage();
            $view->view($operation["value1"], $operation["value2"], $operation["operation"], $results, $errors);
        }
    }
?>