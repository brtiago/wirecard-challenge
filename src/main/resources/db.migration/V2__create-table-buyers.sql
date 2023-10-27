create table buyers(
    id bigint not null generated always as identity,
    name varchar(100) not null,
    email varchar(100) not null,
    cpf varchar(11) not null,

    primary key(id)
);