<?php
    session_start();
    // Verifying if it should change the offset
    $offsetDelta = isset($_GET["offset"]) ? $_GET["offset"] : 0;
    // Initializing variables
    $page_size = 10;
    $offset = isset($_SESSION["offset"]) ? $_SESSION["offset"] : 0;
    $count = isset($_SESSION["count"]) ? $_SESSION["count"] : 0;
    $offset += $offsetDelta;
    // Querying database
    $db = mysqli_connect("localhost", "root", "");
    $db->query("USE user_page");
    // Querying count
    $result = $db->query("SELECT COUNT(id) as count FROM user");
    $row = $result->fetch_assoc();
    $count = $row["count"];
    // Fixing possible out of range values
    if($offset < 0)
        $offset = 0;
    if($offset >= $count)
        $offset = $count;
    // Querying with offset
    $result = $db->query("SELECT * FROM user LIMIT $offset, $page_size");
    // Setting values
    $_SESSION["count"] = $count;
    $_SESSION["offset"] = $offset;
    // Variables to format view
    $any_previous = $offset > 0;
    $any_next = $offset + $page_size < $count;
?>
<html>
    <head>
        <title>User Credit</title>
        <style>
            .data-table, .data-table * {
                border-collapse: collapse;
                border: 1px solid black;
                padding: 2px;
            }
        </style>
    </head>
    <body>
        <section class="users">
            <form action="../controller/user.php" method="POST">
                <table class="data-table">
                    <tr>
                        <th>id</th>
                        <th>name</th>
                        <th>actions</th>
                    </tr>
                    <?php while($user = $result->fetch_assoc()) { ?>
                        <tr>
                            <td>
                                <?php echo $user["id"] ?>
                            </td>
                            <td>
                                <?php echo $user["name"] ?>
                            </td>
                            <td>
                                <button name="delete" value="<?php echo $user["id"] ?>">
                                    Delete
                                </button>
                            </td>
                        </tr>
                    <?php } ?>
                </table>
            </form>
            <form>
                <?php
                    if($any_previous) {
                ?>
                    <button name="offset" value="<?php echo $page_size * -1 ?>" type="submit">
                        Previous
                    </button>
                <?php
                    }
                ?>
                <?php
                    if($any_next) {
                ?>
                    <button name="offset" value="<?php echo $page_size ?>" type="submit">
                        Next
                    </button>
                <?php
                    }
                ?>
            </form>
        </section>
    </body>
</html>