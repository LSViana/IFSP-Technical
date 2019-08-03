DROP DATABASE IF EXISTS user_page;

CREATE DATABASE user_page;

USE user_page;

CREATE TABLE user (
    id INT AUTO_INCREMENT,
    name VARCHAR(32) NOT NULL,
    PRIMARY KEY (id)
);