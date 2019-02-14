<!DOCTYPE html>
<html>
    <body>
        <h1>
            Introduction to PHP
        </h1>

        <?php
            // Single line comment

            # Single line comment

            /*
                Multiple line comment
            */

            // Partial line comment
            echo /* this is ignored :) */ "Greetings, universe! ";

            // Using variables
            $x = 5;

            // Keep clear that variable names are case sensitive
            $X = 3;

            echo $x;
            Echo $X;
            ECHo $x;

            // Using undefined variables throw warnings
            echo $y;
        ?>
    </body>
</html>