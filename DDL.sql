DROP DATABASE IF EXISTS farmacy;

CREATE DATABASE farmacy;

USE farmacy;

CREATE TABLE cities (
    id VARCHAR(3) UNIQUE,
    name VARCHAR(30),
    CONSTRAINT pk_cities PRIMARY KEY (id)
);

CREATE TABLE districts (
    id INT UNIQUE AUTO_INCREMENT,
    name VARCHAR(35),
    city VARCHAR(3),
    CONSTRAINT pk_districts_id PRIMARY KEY (id),
    CONSTRAINT fk_districts_cities_id FOREIGN KEY (id) REFERENCES cities(id) 
);

CREATE TABLE type_id (
    id INT UNIQUE AUTO_INCREMENT,
    document VARCHAR(20),
    CONSTRAINT pk_type_id_id PRIMARY KEY (id)
);

CREATE TABLE clients (
    id INT UNIQUE,
    type_id INT,
    names VARCHAR(20),
    last_names VARCHAR(20),
    age SMALLINT,
    birth_date DATE,
    regist_date DATE,
    district INT,
    CONSTRAINT pk_clients_id PRIMARY KEY (id),
    CONSTRAINT fk_clients_districts_district FOREIGN KEY (district) REFERENCES districts(id),
    CONSTRAINT fk_clients_type_id_type_id FOREIGN KEY (type_id) REFERENCES type_id(id)
);