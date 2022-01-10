create table mark (
    id int AUTO_INCREMENT   PRIMARY KEY,
    name varchar(255) not null
);
create table model (
    id int AUTO_INCREMENT PRIMARY KEY,
    name varchar (255),
    mark_id int,
    FOREIGN KEY (mark_id) REFERENCES mark (id)
);
create table store (
    id int AUTO_INCREMENT PRIMARY KEY,
    name varchar (255),
    mark_id int,
    FOREIGN KEY (mark_id) REFERENCES mark (id)
);