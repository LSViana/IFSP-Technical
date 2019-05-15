<?php
    define("SEPARATOR", ";");

    function readData($filename) {
        // Get the handler for the file
        $testFile = fopen($filename, "r");
        // Parse the values from the raw content
        $result = [];
        // Read headers
        if(!feof($testFile)) {
            $headerLine = str_replace("\n", "", fgets($testFile));
            $headers = explode(";", $headerLine);
            foreach($headers as $header) {
                $result[$header] = [];
            }
        }
        // Read lines
        while(!feof($testFile)) {
            $line = str_replace("\n", "", fgets($testFile));
            if(strlen($line) > 0) {
                $values = explode(";", $line);
                array_push($result["ano"], $values[0]);
                array_push($result["producao"], $values[1]);
            }
        }
        // Dispose the file handler
        fclose($testFile);
        // Return the result
        return $result;
    }
?>