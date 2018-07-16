drop table products if exists;

create table products (
id varchar(25) primary key,
name varchar(50),
description varchar(250),
unit_price DECIMAL,
manufacturer varchar(50),
category varchar(50),
condition varchar(50),
units_in_stock bigint,
units_in_order bigint,
discounted boolean
);

create table customers (
id varchar(25) primary key,
name varchar(100),
address varchar(1000),
makesOrder integer
);