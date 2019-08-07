<?php
    class CalculatorController {
        public function operate($operation) {
            $results = [];
            $value1 = $operation["value1"];
            $value2 = $operation["value2"];
            switch($operation["operation"]) {
                case "sum":
                    $results["value"] = $value1 + $value2;
                    break;
                case "subtraction":
                    $results["value"] = $value1 - $value2;
                    break;
                    case "multiply":
                    $results["value"] = $value1 * $value2;
                    break;
                case "divide":
                    if($value2 == 0)
                        throw new Exception("Can't perform division with zero as divider");
                    $results["value"] = $value1 / $value2;
                    break;
                case "modulus":
                    if($value2 == 0)
                        throw new Exception("Can't perform division with zero as divider");
                    $results["value"] = $value1 % $value2;
                    break;
                case "sqrt":
                    if($value1 < 0)
                        throw new Exception("Can't perform sqrt on negative values");
                    $results["value"] = sqrt($value1);
                    break;
                default:
                    throw new Exception("Invalid operation requested", 1);
                    break;
            }
            return $results;
        }
    }
?>