create database easemystay;

use easemystay;

create table admin(id int primary key,username varchar(25),password varchar(25));

create table user(user_id int primary key,name varchar(25),email varchar(25),password varchar(25),contact varchar(25),dob varchar(25));

create table hotel_owner(owner_id int primary key, owner_name varchar(25),email varchar(25),password varchar(25),contact varchar(25),id_proof varchar(25));

create table hotel(hotel_id int primary key, name varchar(25),city varchar(25),state varchar(25),address varchar(80),contact varchar(25),pincode int, no_of_rooms int); 

create table rooms(room_id int primary key,hotel_id int,status varchar(25),room_desc varchar(100),price int);

create table booking(book_id int primary key, room_id int,user_id int,check_in varchar(25),check_out varchar(25));

create table payment(payment_id int primary key, book_id int,amount int, date varchar(25));