create database PersonnelManagementSystem2
use PersonnelManagementSystem2

create table Login (
    username varchar(25),
	password varchar(25)
)

insert into Login values
('admin', 'password')

select * from Login

create table Personnel (
    name varchar(70),
	id varchar(20),
	age varchar(10),
	education varchar(50),
	gender varchar(15),
	address varchar(100),
	position varchar(50),
	maritalstatus varchar(40),
	phone varchar(15),
	email varchar(100)
)
select * from Personnel
drop table Personnel

create table Salary (
    sid int identity(1,1) primary key,
	id varchar(20),
	name varchar(70),
	age varchar(10),
	position varchar(50),
	phone varchar(15),
	email varchar(100),
	basic float,
	bonus float,
	month_year varchar(50)
)
select * from Salary
drop table Salary