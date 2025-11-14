DROP TABLE IF EXISTS user_profile;
DROP TABLE IF EXISTS user_credentials;
DROP TABLE IF EXISTS user_education;
DROP TABLE IF EXISTS registration_address;
DROP TABLE IF EXISTS city_info;

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


insert into user_profile(id, first_name, middle_name, birthday)
values ('4dc908cb-1538-480f-81ff-a7f4ca88f2f1',
        'Oleg',
        'Olegovich',
        '2000-11-10 12:54:55');

insert into user_credentials(user_id, login, password)
values ('4dc908cb-1538-480f-81ff-a7f4ca88f2f1',
        'rimza',
        'testPassword');

insert into user_education(user_id, institute, date_start, date_end)
values ('4dc908cb-1538-480f-81ff-a7f4ca88f2f1',
        'БГУТ',
        '2020-08-10',
        '2024-08-10'),
       ('4dc908cb-1538-480f-81ff-a7f4ca88f2f1',
        'МГУ',
        '2000-08-10',
        '2004-08-10');

insert into city_info(population,name,info)
values (
        64365,
        'город Горки',
        'Известна с начала XVIII века, как деревня в Минском повете Минском воеводстве Великого княжества Литовского. В 1707 году в деревне насчитывается 3 двора, является владением К. Друцкого-Соколинского. После второго раздела Речи Посполитой, в 1793 году — в составе Российской империи.'
       );

insert into registration_address(user_id, region, city, street)
values ('4dc908cb-1538-480f-81ff-a7f4ca88f2f1',
        'Московская область',
        1,
        'Сергиево-Посадский район')
