insert into mark(name) values ('Audi');
insert into mark(name) values ('MB');
insert into mark(name) values ('BMW');

insert into model(name, mark_id) values ('RS6',1);
insert into model(name, mark_id) values ('RSQ8',1);
insert into model(name, mark_id) values ('S222',2);
insert into model(name, mark_id) values ('S223',2);
insert into model(name, mark_id) values ('525',3);
insert into model(name, mark_id) values ('M5',3);

insert into store(name, mark_id) values ('AudiStore', 1);
insert into store(name, mark_id) values ('MBStoreLuxury', 2);
insert into store(name, mark_id) values ('BMWStore', 3);