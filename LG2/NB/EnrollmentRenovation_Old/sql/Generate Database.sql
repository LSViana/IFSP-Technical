create database if not exists `enrollmentrenovation` default character set utf8 collate utf8_general_ci;

use `enrollmentrenovation`;

create table state (
	id int primary key auto_increment,
	`name` varchar(64) not null,
	initials varchar (6) not null
);

create table city (
	id int primary key auto_increment,
	`name` varchar(64) not null,
	idstate int not null,
	constraint foreign key(idstate) references state(id)
);

create table school (
	id int primary key auto_increment,
	idcity int not null,
	constraint foreign key (idcity) references City (id)
);

create table  discipline (
	id int primary key auto_increment,
	`name`varchar(64) not null
);

create table restriction (
	idrequired int not null,
	idprovided int not null,
	constraint primary key(idrequired, idprovided),
	constraint foreign key(idrequired) references discipline(id),
	constraint foreign key(idprovided) references discipline(id)
);

create table course (
	id int primary key auto_increment,
	`name` varchar(64),
	idschool int not null,
	constraint foreign key(idschool) references school(id)
);

create table user (
	id char(7) primary key,
	firstname varchar(64) not null,
	lastname varchar(64) not null,
	birthday date not null,
	`password` varchar(64) not null,
	idstate int not null,
	type int not null,
	constraint foreign key(idstate) references state(id)
);

create table credits (
	idstudent char(7) not null,
	iddiscipline int not null,
	idcourse int not null,
	daterequeriment date not null,
	constraint foreign key (idstudent) references `user`(id),
	constraint foreign key (iddiscipline) references discipline(id),
	constraint foreign key (idcourse) references course(id),
	primary key(idstudent, iddiscipline, idcourse)
);

create table coursestructure (
	idcourse int,
	iddiscipline int,
	semester tinyint,
	facultative bit,
	constraint primary key(idcourse, iddiscipline)
	on delete cascade,
	constraint foreign key(idcourse) references course(id)
	on delete cascade
);

create table `time` (
	id int primary key auto_increment,
	`time` time(1) not null
);

create table class (
	id int primary key auto_increment,
	iddiscipline int not null,
	day tinyint not null,
	idinitialtime int not null,
	idfinaltime int not null,
	initialdate date not null,
	enddate date not null,
	constraint foreign key(iddiscipline) references discipline(id),
	constraint foreign key(idfinaltime) references time(id),
	constraint foreign key(idinitialtime) references time(id)
);

create table enrollment (
	idstudent char(7) not null,
	idclass int not null,
	idcourse int not null,
	semester tinyint not null,
	`status` tinyint not null,
	grade float not null,
	constraint primary key(idstudent, idclass, idcourse),
	constraint foreign key(idstudent) references `user`(id),
	constraint foreign key(idclass) references class(id),
	constraint foreign key(idcourse) references course(id)
);