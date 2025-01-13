CREATE TABLE tb_product (
    id uuid not null, 
    NAME VARCHAR(60) NOT NULL,
    DESCRIPTION TEXT NOT NULL,
    AVAILABLE VARCHAR(255) NOT NULL, 
    PRICE NUMERIC(19, 2) DEFAULT NULL,
    primary key (id)
);
