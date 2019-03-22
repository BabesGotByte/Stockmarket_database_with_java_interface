create database AD7;
use AD7;
create table Signup(First_name varchar(30) not null,Middle_name varchar(20),Last_name varchar(30) not null,Mob varchar(11) not null,Email varchar(40) not null,Username varchar(30) not null,Password varchar(30) not null,Confirm_password varchar(30) not null);
insert into Signup values('Anshul','kumar','Agarwal',9359719876,'anshulagarwaliiita@gmail.com','Anshul','Anshul123','Anshul123');
insert into Signup values('Paras','kumar','Agarwal',9359719875,'parasagarwaliiita@gmail.com','Paras','Paras123','Paras123');


create table Stockmarket(Usr varchar(20),Dates varchar(20),Company varchar(30) not null,No_of_shares varchar(30) not null,NAV varchar(40) not null,Amount varchar(30) not null);
insert into Stockmarket values('Anshul','25-aug-2018','Reliance',200,10.0,50000);
insert into Stockmarket values('Paras','25-aug-2018','Tata',500,9.0,20000);
insert into Stockmarket values('Anshul','25-aug-2018','Tata',1000,8.5,75000);
insert into Stockmarket values('Anshul','25-aug-2018','ICIC',750,3.9,2000);
