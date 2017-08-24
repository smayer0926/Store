SET MODE PostgreSQL;


CREATE TABLE IF NOT EXISTS stores (
    id int PRIMARY KEY auto_increment,
    name VARCHAR,
    location VARCHAR,
    type VARCHAR,
    coffeeTypes INTEGER,
    hasWifi BOOLEAN,
    hasWorkSpace BOOLEAN,
    hasVegan BOOLEAN,
    phone VARCHAR,
    sellsPets BOOLEAN
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