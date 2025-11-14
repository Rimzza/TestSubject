create table user_profile
(
    id          uuid primary key,
    first_name  varchar(30) not null,
    middle_name varchar(30) not null,
    birthday    date        not null
);

create table city_info
(
    id int primary key generated always as identity ,
    name varchar not null ,
    population serial not null,
    info text
);

create table user_credentials
(
    user_id  uuid primary key references user_profile (id),
    login    varchar not null,
    password varchar not null
);

create table user_education
(
    id         int primary key generated always as identity,
    user_id    uuid references user_profile (id),
    institute  varchar not null,
    date_start date    not null,
    date_end   date    not null
);


create table registration_address
(
    user_id uuid primary key references user_profile (id),
    region  varchar(100) not null,
    city    int references city_info(id),
    street  varchar(30)  not null
);