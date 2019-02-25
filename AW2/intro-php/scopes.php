<?php
    /*
    There are 3 types of scopes in PHP:
        • local: only variables declared inside bracket-bodied expressions, like functions, will be available inside this same block
        • global: all variables declared *directly* inside the <?php ... ?> are global variables, and they can be used in the same region
        • static: 
    */

    #region Local scope
    $x = 5;
    
    function localScope()
    {
        // The next line is commented to avoid the error
        // echo("Variable x inside localScope() is: " . $x);
    }

    localScope();

    echo("Variable x in global scope is: " . $x . "\r\n");
    #endregion

    echo("\r\n");

    #region Global scopes
    function globalScope()
    {
        global $x;
        echo("Variable x inside globalScope() is: ". $x . "\r\n");
        $x = 6; // Direct access to the global variable through 'global' keyword
        echo("Variable x inside globalScope() changed to: ". $x . "\r\n");
        $GLOBALS["x"] = 7;
        echo("Variable x inside globalScope() changed to: ". $x . "\r\n");
    }

    globalScope();

    echo("Variable x in global scope is: " . $x . "\r\n");
    #endregion

    echo("\r\n");

    #region Static scope
    function nonStaticScope()
    {
        $y = 10;
        echo("Variable y inside NONStaticScope(): " . $y . "\r\n");
    }

    function staticScope()
    {
        static $y = 10;
            // This is not allowed, because echo isn't a function, but a language construct
        // echo("Multiple", "parameters", "fail");
            // This is valid, because these are redudant parentheses, therefore, they're not ignored and it's similar as if they weren't there
        // echo("Multiple"), "parameters", ("success");
        echo("Variable y inside staticScope(): " . $y . "\r\n");
        $y++;
    }

    nonStaticScope();
    nonStaticScope();
    nonStaticScope();

    staticScope();
    staticScope();
    staticScope();
    #endregion

    echo("\r\n");
?>