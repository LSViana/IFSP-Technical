<?php
    require("./ex-1-user.php");
    require("./ex-1-files.php");
    //
    $method = $_SERVER["REQUEST_METHOD"];
    $isPost = $method == "POST";
    $isGet = $method == "GET";
?>

<?php
    // Validating field's values on post
    $errors = [];
    //
    if(!isset($_POST["clear"])) {
        if($isPost) {
            foreach($_POST as $key => $value) {
                if($key == "email") {
                    if(!filter_var($value, FILTER_VALIDATE_EMAIL)) {
                        $errors["email"] = true;
                    }
                } else {
                    // Files save the name of the files, then to verify if there's a file it's enough verifying if the string isn't empty
                    if(strlen($value) == 0) {
                        $errors[$key] = true;
                    }
                }
            }
        }
        // If there's any user, save it to use later
        if(isThereUser()) {
            $user = loadUserFromFile();
        }
    }
?>
<html>
    <head>
        <title>Personal Data</title>
        <style>
            .hidden {
                display: none;
            }
            .error {
                color: red;
            }
        </style>
    </head>
    <body>
        <!-- Name, E-mail, Gender, School Level, Telephone, Cellphone, Birthday, Picture, Login, Password -->
        <?php
            if($isPost) {
                if(isset($_POST["clear"])) {
                    unsetUserCookie();
                    removeUserPictures();
                    removeUserFile();
                }
                else {
                    // Set the cookie
                    setUserCookie();
                    // Recover values sent through HTTP POST
                    $name = $_POST["name"];
                    $email = $_POST["email"];
                    $gender = $_POST["gender"];
                    $telephone = $_POST["telephone"];
                    $cellphone = $_POST["cellphone"];
                    $birthday = $_POST["birthday"];
                    $schoolLevel = $_POST["school-level"];
                    $login = $_POST["login"];
                    $password = $_POST["password"];
                    // Create the user associative array
                    $user = [
                        "name" => $name,
                        "email" => $email,
                        "gender" => $gender,
                        "telephone" => $telephone,
                        "cellphone" => $cellphone,
                        "birthday" => $birthday,
                        "school-level" => $schoolLevel,
                        "login" => $login,
                        "password" => $password
                    ];
                    if(isThereUser())
                        $userFromFile = loadUserFromFile();
                    // Processing all pictures
                    for($i = 1; $i <= 6; $i++) {
                        $picture = null;
                        if(isset($_FILES["picture-" . $i])) {
                            $pictureInfo = $_FILES["picture-" . $i];
                            if(!$pictureInfo["error"]) {
                                $picture = $pictureInfo["name"];
                                $user["picture-" . $i] = $picture;
                                // Save the picture
                                savePicture($pictureInfo);
                            }
                        }
                        if(isThereUser() && $picture == null && isset($userFromFile["picture-" . $i])) {
                            $user["picture-" . $i] = $userFromFile["picture-" . $i];
                        }
                    }
                    // Saving user's data in files
                    saveUserInFile($user);
                }
            } else {
                if(isThereUser()) {
                    $user = loadUserFromFile();
                }
            }
        ?>
        <section class="form">
            <form method="post" enctype="multipart/form-data">
                <p>
                    <label for="name">Name</label>
                    <input type="text" name="name" id="name" <?php if(isThereUser()) echo "readonly"; ?>
                        value="<?php if(isset($user["name"])) echo $user["name"]; ?>">
                    <?php if($isPost && isset($errors["name"])) { ?>
                        <p class="error">You must fill a non-empty value for 'name'</p>
                    <?php } ?>
                </p>
                <p>
                    <label for="email">E-mail</label>
                    <input type="email" name="email" id="email"
                        value="<?php if(isset($user["email"])) echo $user["email"]; ?>">
                    <?php if($isPost && isset($errors["email"])) { ?>
                        <p class="error">You must fill a valid value for 'email'</p>
                    <?php } ?>
                </p>
                <p>
                    <p>Gender</p>
                    <p>
                        <input type="radio" name="gender" value="male" id="gender-male"
                            <?php if(isset($user["gender"])) { if($user["gender"] == "male") echo "checked"; } else echo "checked"; ?>>
                        <label for="gender-male">Male</label>
                    </p>
                    <p>
                        <input type="radio" name="gender" value="female" id="gender-female"
                            <?php if(isset($user["gender"])) { if($user["gender"] == "female") echo "checked"; }?>>
                        <label for="gender-female">Female</label>
                    </p>
                    <?php if($isPost && isset($errors["gender"])) { ?>
                        <p class="error">You must fill a non-empty value for 'gender'</p>
                    <?php } ?>
                </p>
                <p>
                    <label for="school-level">School level</label>
                    <select type="text" name="school-level" id="school-level">
                        <option value="high-school" <?php if(isset($user["school-level"]) && $user["school-level"] == "high-school") echo "selected='true'"; ?>>
                            High School
                        </option>
                        <option value="bachelor" <?php if(isset($user["school-level"]) && $user["school-level"] == "bachelor") echo "selected='true'"; ?>>
                            Bachelor
                        </option>
                        <option value="master" <?php if(isset($user["school-level"]) && $user["school-level"] == "master") echo "selected='true'"; ?>>
                            Master
                        </option>
                        <option value="doctoral" <?php if(isset($user["school-level"]) && $user["school-level"] == "doctoral") echo "selected='true'"; ?>>
                            Doctoral
                        </option>
                    </select>
                    <?php if($isPost && isset($errors["school-level"])) { ?>
                        <p class="error">You must fill a non-empty value for 'school level'</p>
                    <?php } ?>
                </p>
                <p>
                    <label for="telephone">Telephone</label>
                    <input type="text" name="telephone" id="telephone"
                        value="<?php if(isset($user["telephone"])) echo $user["telephone"]; ?>">
                    <?php if($isPost && isset($errors["telephone"])) { ?>
                        <p class="error">You must fill a non-empty value for 'telephone'</p>
                    <?php } ?>
                </p>
                <p>
                    <label for="cellphone">Cellphone</label>
                    <input type="text" name="cellphone" id="cellphone"
                        value="<?php if(isset($user["cellphone"])) echo $user["cellphone"]; ?>">
                    <?php if($isPost && isset($errors["cellphone"])) { ?>
                        <p class="error">You must fill a non-empty value for 'cellphone'</p>
                    <?php } ?>
                </p>
                <p>
                    <label for="birthday">Birthday</label>
                    <input type="date" name="birthday" id="birthday"
                        value="<?php if(isset($user["birthday"])) echo $user["birthday"]; ?>">
                    <?php if($isPost && isset($errors["birthday"])) { ?>
                        <p class="error">You must fill a non-empty value for 'birthday'</p>
                    <?php } ?>
                </p>
                <?php
                    $limit = isThereUser() ? 6 : 1;
                    for($i = 1; $i <= $limit; $i++) { ?>
                        <p>
                            <label for="picture-<?php echo $i ?>">Picture <?php echo $i ?></label>
                            <input type="file" accept="image/*" name="picture-<?php echo $i ?>" id="picture-<?php echo $i ?>">
                            <?php if(isset($user["picture-" . $i])) { ?>
                                <p>
                                    <img src="<?php echo $user["picture-" . $i]; ?>" alt="User's picture <?php echo $i ?>">
                                </p>
                            <?php } ?>
                            <?php if($isPost && isset($errors["picture-" . $i])) { ?>
                                <p class="error">You must fill a non-empty value for 'picture'</p>
                            <?php } ?>
                        </p>
                <?php
                    }
                ?>
                <p>
                    <label for="login">Login</label>
                    <input type="text" name="login" id="login"
                        value="<?php if(isset($user["login"])) echo $user["login"]; ?>">
                    <?php if($isPost && isset($errors["login"])) { ?>
                        <p class="error">You must fill a non-empty value for 'login'</p>
                    <?php } ?>
                </p>
                <p>
                    <label for="password">Password</label>
                    <input type="password" name="password" id="password"
                        value="<?php if(isset($user["password"])) echo $user["password"]; ?>">
                    <?php if($isPost && isset($errors["password"])) { ?>
                        <p class="error">You must fill a non-empty value for 'password'</p>
                    <?php } ?>
                </p>
                <button>Register</button>
                <button name="clear" value="true">Clear</button>
            </form>
        </section>
    </body>
</html>