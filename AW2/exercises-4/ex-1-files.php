<?php
    function savePicture($pictureInfo) {
        // Saving picture
        if($pictureInfo && !$pictureInfo["error"]) {
            copy($pictureInfo["tmp_name"], $pictureInfo["name"]);
        }
    }
?>