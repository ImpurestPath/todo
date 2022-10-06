create table  todo
(
    id integer not null auto_increment,
    name varchar not null,
    description varchar,
    done bool,
    primary key(id)
);