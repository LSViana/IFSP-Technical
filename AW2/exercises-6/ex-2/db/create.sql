DROP DATABASE IF EXISTS user_credit;

CREATE DATABASE user_credit;

USE user_credit;

CREATE TABLE user (
    id INT AUTO_INCREMENT,
    name VARCHAR(32) NOT NULL,
    creditlimit FLOAT NOT NULL,
    PRIMARY KEY (id)
);