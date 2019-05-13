<?php
    // This method must be called everytime you need to handle the session, even if it's to destroy it
    session_start();
    // Possible errors
    $sameTeam = false;
    // Infrastructure
    $method = $_SERVER["REQUEST_METHOD"];
    $isGet = $method == "GET";
    $isPost = $method == "POST";
    // Session lifecyle
    if($isPost && isset($_POST["clear"])) {
        session_destroy();
    }
    // Variables
    $drawScore = 1;
    $winScore = 3;
    $teams = [
        "Ferroviária",
        "Ituano",
        "RB Brasil",
        "Bragantino",
        "Ponte Preta"
    ];
    $results = [];
    foreach($teams as $team) {
        $results[$team] = 0;
    }
    if(isset($_SESSION["results"]))
        $results = $_SESSION["results"];
    // Processing
    if($isPost) {
        if(isset($_POST["clear"])) {
            $results = [];
        } else {
            // Getting values from request
            $teamA = $_POST["team-a"];
            $scoreTeamA = $_POST["score-a"];
            $teamB = $_POST["team-b"];
            $scoreTeamB = $_POST["score-b"];
            // Verifying errors
            if($teamA == $teamB) {
                $sameTeam = true;
            }
            else {
                // Get the winner
                $draw = $scoreTeamA == $scoreTeamB;
                if($draw) {
                    if(!isset($results[$teamA])) {
                        $results[$teamA] = 0;
                    }
                    if(!isset($results[$teamB])) {
                        $results[$teamB] = 0;
                    }
                    //
                    $results[$teamA] += $drawScore;
                    $results[$teamB] += $drawScore;
                }
                else {
                    $winner = $scoreTeamA > $scoreTeamB ? $teamA : $teamB;
                    // Creating the winner key if it doesn't exist yet
                    if(!isset($results[$winner])) {
                        $results[$winner] = 0;
                    }
                    // Adding the points to the winner
                    $results[$winner] += $winScore;
                }
            }
        }
        // Saving values to session
        $_SESSION["results"] = $results;
    }
    // Ordering results
    uasort($results, function ($a, $b) {
        // Order ascendant
        return $a < $b;
    });
?>
<html>
    <head>
        <title>Championship</title>
        <style>
            .error {
                color: red;
            }
            .table, .table * {
                padding: 4px;
                border-collapse: collapse;
                border: 1px black solid;
            }
        </style>
    </head>
    <body>
        <section class="form">
            <form method="POST">
                <p>
                    <label for="team-a">Team A</label>
                    <select name="team-a" id="team-a">
                        <?php
                            foreach($teams as $team) {
                        ?>
                            <option value="<?php echo $team ?>">
                                <?php echo $team ?>
                            </option>
                        <?php
                            }
                        ?>
                    </select>
                    <input type="number" name="score-a" value="0">
                </p>
                <p>
                    <label for="team-b">Team B</label>
                    <select name="team-b" id="team-b">
                        <?php
                            foreach($teams as $team) {
                        ?>
                            <option value="<?php echo $team ?>">
                                <?php echo $team ?>
                            </option>
                        <?php
                            }
                        ?>
                    </select>
                    <input type="number" name="score-b" value="0">
                </p>
                <?php
                    if($sameTeam) {
                ?>
                    <p class="error">You must select different teams!</p>
                <?php
                    }
                ?>
                <button>Register Match</button>
                <button name="clear" value="true">Clear</button>
            </form>
        </section>
        <section class="matches">
            <h3>Results</h3>
            <table class="table">
                <thead>
                    <tr>
                        <th>Team</th>
                        <th>Score</th>
                    </tr>
                </thead>
                <tbody>
                    <?php foreach($results as $team => $score) { ?>
                        <tr>
                            <td><?php echo $team; ?></td>
                            <td><?php echo $score; ?></td>
                        </tr>
                    <?php } ?>
                </tbody>
            </table>
        </section>
    </body>
</html>
