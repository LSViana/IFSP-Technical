DROP DATABASE IF EXISTS login_restrict;

CREATE DATABASE login_restrict;

USE login_restrict;

CREATE TABLE user (
    id INT AUTO_INCREMENT,
    email VARCHAR(32) NOT NULL,
    password VARCHAR(32) NOT NULL,
    PRIMARY KEY(id),
    UNIQUE (email)
);