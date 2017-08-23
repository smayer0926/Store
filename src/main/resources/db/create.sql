SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS products (
    id int PRIMARY KEY auto_increment,
    productName VARCHAR,
    price FLOAT,
    description VARCHAR
);

CREATE TABLE IF NOT EXISTS stores (
    id int PRIMARY KEY auto_increment,
    name VARCHAR,
    location VARCHAR,
    phone VARCHAR
);

CREATE TABLE IF NOT EXISTS products_stores (
    id int PRIMARY KEY auto_increment,
    storeId INTEGER,
    productId INTEGER
);

CREATE TABLE IF NOT EXISTS sold_products (
    id int PRIMARY KEY auto_increment,
    storeId INTEGER,
    productId INTEGER,
    onSale BOOLEAN,
    sellDate TIMESTAMP
);