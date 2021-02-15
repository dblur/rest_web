create database if not exists jarSoftTest;

use jarSoftTest;

create table if not exists Category (
                                        id bigint auto_increment primary key,
                                        name varchar(255) unique not null,
                                        req_name varchar(255) unique not null,
                                        deleted boolean default 0 not null
);

create table if not exists Banner (
                                      id bigint auto_increment primary key,
                                      name varchar(255) unique not null,
                                      price decimal(8,2) not null,
                                      category_id bigint not null,
                                      content text not null,
                                      deleted boolean default 0 not null ,
                                      foreign key (category_id) references category (id) on delete restrict
);

create table if not exists Request (
                                       id bigint auto_increment primary key,
                                       banner_id bigint not null,
                                       user_agent text,
                                       ip_address varchar(255),
                                       date datetime,
                                       foreign key (banner_id) references banner(id) on delete restrict
);