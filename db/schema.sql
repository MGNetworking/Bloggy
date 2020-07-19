-- ce schema a était utiliser directemetn dans pgAdmin ( postgres )
CREATE DATABASE webblog;

DROP SCHEMA IF EXISTS blog CASCADE;
CREATE SCHEMA blog ;

drop table IF EXISTS blog.role CASCADE;
drop table IF EXISTS blog.user CASCADE;
drop table IF EXISTS blog.user_role CASCADE;

-- ---------------------------------------------
-- - role                                    ---
-- ---------------------------------------------
CREATE TABLE blog.role
(
    role varchar(10) not null primary key
);

insert into blog.role(role)
values ('ADMIN');

-- ---------------------------------------------
-- - user                                    ---
-- ---------------------------------------------
CREATE TABLE blog.user
(
    id_user  serial primary key,
    nom      varchar(50),
    password varchar(250)

);

insert into blog.user(nom, password)
values ('maxime', '123');

-- ---------------------------------------------
-- - user_role         table assoicatif      ---
-- ---------------------------------------------
CREATE TABLE blog.user_role
(

    id_user integer     NOT NULL references blog.user,
    role    varchar(10) not null references blog.role,

    CONSTRAINT PK_user_role PRIMARY KEY (id_user, role)

);

insert into blog.user_role(id_user, role)
values ('1', 'ADMIN');

-- ---------------------------------------------
-- - Table article                           ---
-- ---------------------------------------------
CREATE table blog.article(

    id_article SERIAL PRIMARY KEY ,
    date    TIMESTAMP NOT NULL ,
    page    varchar(20) NOT NULL ,
    titre   varchar(50) NOT NULL ,
    article text   NOT NULL ,
    pathimage varchar(255) NOT NULL ,
    commentimage varchar(50)NOT NULL
)
