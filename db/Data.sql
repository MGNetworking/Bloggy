

insert into blog.user(name, firstName, avatar, password_user, email)
values ('maxime', 'ghalem', 'MGAvatar', '123456', 'maxime@gmail.com'),
       ('sylvain', 'syl-firstName', 'sylAvatar', '456123', 'sylvain@gmail.com'),
       ('fabien', 'fa-firstName', 'fabAvatar', '789123', 'fabien@gmail.com'),
       ('ernestas', 'er-firstName', 'ernesAvatar', '321123', 'ernestas@gmail.com');


insert into blog.role(role)
values ('ADMIN'),
       ('USER_ARTICLE');

insert into blog.user_role(id_user, role_name)
values ('1', 'ADMIN'),
       ('1', 'USER_ARTICLE'),
       ('2', 'USER_ARTICLE'),
       ('3', 'USER_ARTICLE'),
       ('4', 'USER_ARTICLE');
