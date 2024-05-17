insert into books.category(idc,description) values (1,'WWW');
insert into books.category(idc,description) values (2,'HTML');
insert into books.category(idc,description) values (3,'JavaScript');
insert into books.category(idc,description) values (4,'Java');

insert into books.publisher(idp,name,address) values (1,'Helion','Gliwice, Polska');
insert into books.publisher(idp,name,address) values (2,'PWN','Warszawa, Polska');
insert into books.publisher(idp,name,address) values (3,'OREILLY','Boston, USA');

insert into books.book(title,publisher_idp,category_idc) values ('Java. Podstawy',1,4);
insert into books.book(title,publisher_idp,category_idc) values ('Projektownie serwisów WWW. Standardy sieciowe',1,1);
insert into books.book(title,publisher_idp,category_idc) values ('Zrozumieć JavaScript',1,3);
insert into books.book(title,publisher_idp,category_idc) values ('Head first Java',3,4);
insert into books.book(title,publisher_idp,category_idc) values ('HTML5. Komponenty',2,2);
insert into books.book(title,publisher_idp,category_idc) values ('Wydajny JavaScript',2,3);

insert into books.users(password, username)
values
('$2a$10$0V5m9xz/2gEY1h2M0WJb6.rqHunYLC9YGimLYEKyCISEc2CELQYI2',
'user1');

insert into books.users(password, username)
values
('$2a$10$CO5bXTjhytDMWUYquraf2ucvlkHI2HHnNfPTQU/Cdol35c8FEAYDu',
'user2');

insert into books.roles(name) values ('ADMIN');
insert into books.roles(name) values ('BOOK_MANAGER');

insert into books.user_roles(user_id, role_id) values (1,1);
insert into books.user_roles(user_id, role_id) values (2,2);
insert into books.user_roles(user_id, role_id) values (1,2);