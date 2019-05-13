<?php
    $userCookie = "user";
    $userFile = "user.json";
    $cookieExpires = 60 * 60; // 1 hour
    // Functions
    function isThereUser() {
        global $userCookie;
        return isset($_COOKIE[$userCookie]);
    }
    function setUserCookie() {
        global $userCookie;
        setcookie($userCookie, true);
    }
    function unsetUserCookie() {
        global $userCookie;
        setcookie($userCookie, true, 1); // 1 makes the cookie automatically expire
    }
    function saveUserInFile($user) {
        global $userFile;
        // Saving user to JSON file
        $file = fopen($userFile, "w");
        $userJson = json_encode($user);
        fwrite($file, $userJson);
        fclose($file);
    }
    function loadUserFromFile() {
        global $userFile;
        $file = fopen($userFile, "r");
        $fileLength = filesize($userFile);
        $userJson = fread($file, $fileLength);
        $user = json_decode($userJson, true);
        return $user;
    }
    function removeUserPictures() {
        $user = loadUserFromFile();
        if(isset($user)) {
            foreach($user as $key => $value) {
                if(strpos($key, "picture") !== false) {
                    // Removing the picture file
                    if(file_exists($value) && is_writable($value)) {
                        unlink($value);
                    }
                    // Removing the property from the user
                    unset($user[$key]);
                }
            }
            //
            saveUserInFile($user);
        }
    }
    function removeUserFile() {
        global $userFile;
        unlink($userFile);
    }
?>