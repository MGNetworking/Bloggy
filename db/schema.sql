-- this diagram is used for the management of the site
------------------------------------------------------
/*DROP DATABASE IF EXISTS webblog;
-- create to web site database
------------------------------------------------------
CREATE DATABASE webblog
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;

COMMENT ON DATABASE webblog
    IS 'Databases for ECF number 3';


-- create to schema for webblog
------------------------------------------------------
DROP SCHEMA IF EXISTS blog CASCADE;
CREATE SCHEMA blog
    AUTHORIZATION postgres;

COMMENT ON SCHEMA blog
    IS 'schema to user management and web site articletexte';*/
------------------------------------------------------
-- for delete table
------------------------------------------------------
drop table IF EXISTS blog.role CASCADE;
drop table IF EXISTS blog.user CASCADE;
drop table IF EXISTS blog.user_role CASCADE;
drop table IF EXISTS blog.article CASCADE;

------------------------------------------------------
-- role
------------------------------------------------------
CREATE TABLE blog.role
(
    role varchar(30) not null primary key
);

insert into blog.role(role)
values ('ADMIN'),
       ('USER_ARTICLE');

------------------------------------------------------
-- user
------------------------------------------------------
CREATE TABLE blog.user
(
    id_user       serial primary key,
    name          varchar(255) NOT NULL,
    firstName     varchar(255) NOT NULL,
    avatar        varchar(30)  NOT NULL,
    password_user varchar(255) NOT NULL,
    email         varchar(255) NOT NULL,
    token         varchar(100),
    tokenDate     TIMESTAMP check ( tokenDate > now() )

);

------------------------------------------------------
-- user_role : associtive table
------------------------------------------------------
CREATE TABLE blog.user_role
(

    id_user   integer     NOT NULL references blog.user (id_user),
    role_name varchar(30) NOT NULL references blog.role (role),

    CONSTRAINT PK_user_role PRIMARY KEY (id_user, role_name)

);

------------------------------------------------------
-- - Table articletexte
------------------------------------------------------
CREATE table blog.article
(

    id_article   SERIAL PRIMARY KEY,
    id_user      INTEGER      NOT NULL,
    date         TIMESTAMP    NOT NULL,
    page         varchar(30)  NOT NULL,
    title        varchar(50)  NOT NULL,
    articletexte text         NOT NULL,
    pathimage    varchar(255) NOT NULL,
    commentimage varchar(50)  NOT NULL,

    CONSTRAINT FK_id_user_ARTICLE FOREIGN KEY (id_user) REFERENCES blog.user (id_user)
);
