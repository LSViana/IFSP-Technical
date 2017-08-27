CREATE SCHEMA school DEFAULT CHARACTER SET utf8;

USE school;
CREATE TABLE student (
	enrollment varchar(7) not null primary key,
    studentName varchar(127) not null,
    age int not null
);

SELECT * FROM student;