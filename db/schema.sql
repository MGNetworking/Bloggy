-- schema de données du blog

-- ---------------------------------------------
-- - role                                    ---
-- ---------------------------------------------
drop table IF EXISTS webblog.role;

CREATE TABLE role
(
    role    varchar(10) not null primary key
);

insert into webblog.roles(role)
values ('ADMIN');

-- ---------------------------------------------
-- - user                                    ---
-- ---------------------------------------------
CREATE TABLE webblog.user
(
    nom      varchar(50),
    password varchar(250)

);

insert into webblog.user(nom,password)
values ('maxime','123');

-- ---------------------------------------------
-- - user_role         table assoicatif      ---
-- ---------------------------------------------
CREATE TABLE webblog.user_role(

    user_role int NOT NULL ,
    nom int NOT NULL,

    CONSTRAINT PK_user_role PRIMARY KEY (nom,user_role)

);

insert into webblog.user_roles(nom,user_role)
values ('maxime','ADMIN');
