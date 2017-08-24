-- Creating schema/database and setting up default collation to avoid problems with data losing
create database `registeringstudents` default character set utf8 collate utf8_general_ci;

-- Creating table to Business' objects
use registeringStudents;
create table Student (
	enrollment varchar(127) primary key not null,
	studentName varchar(127) not null,
	email varchar(127) not null,
	telephone char(13) not null
);