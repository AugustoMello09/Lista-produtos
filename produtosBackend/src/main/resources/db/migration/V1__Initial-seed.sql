CREATE TABLE tb_product (
    id binary(16) not null, 
    name VARCHAR(60) not null,
    description TEXT not null,
    available VARCHAR(255) not null, 
    price NUMERIC(19, 2) not null,
    primary key (id)
);
