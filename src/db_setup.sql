create

    database "notes" with owner postgres;

create extension if not exists "uuid-ossp";

create table if not exists users

(

    id UUID unique not null default uuid_generate_v1(),

    username varchar(50) unique not null,

    password varchar(255) not null

);

create table if not exists notes

(

    id UUID unique not null default uuid_generate_v1() primary key,

    username varchar(50) not null,

    text varchar(50) not null

);