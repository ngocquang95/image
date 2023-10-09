drop database if exists product_management;
create database product_management;

use product_management;

create table product (
    id int primary key auto_increment,
    name varchar(50),
    image longtext
);

select id, name, image from product;