CREATE TABLE IF NOT EXISTS account_type
(
	id SERIAL           NOT NULL PRIMARY KEY,
	account_type_description  VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS gender
(
	id SERIAL           NOT NULL PRIMARY KEY,
	gender_description  VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS person
(
	id SERIAL           NOT NULL PRIMARY KEY,
	identification      VARCHAR(50) NOT NULL UNIQUE,
    name                VARCHAR(500) NOT NULL,
    gender_id           INTEGER,
    birthdate           DATE,
    address             VARCHAR(500),
    phone               VARCHAR(20),

    CONSTRAINT fk_person_gender FOREIGN KEY(gender_id)
            REFERENCES gender(id)
            ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS bank_user
(
	id SERIAL           NOT NULL PRIMARY KEY,
    user_name           VARCHAR(50) NOT NULL UNIQUE,
    password            VARCHAR(50) NOT NULL,
    status              BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS customer
(
	id SERIAL           NOT NULL PRIMARY KEY,
	person_id           INTEGER UNIQUE,
	bank_user_id        INTEGER UNIQUE,

	CONSTRAINT fk_customer_person FOREIGN KEY(person_id)
                REFERENCES person(id)
                ON DELETE SET NULL,

    CONSTRAINT fk_customer_bank_user FOREIGN KEY(bank_user_id)
            REFERENCES bank_user(id)
            ON DELETE SET NULL
);


-- Postgres Root: postgres/123456

-- # Creando base de datos, usuario, privilegios y esquema
-- create database banking_db;
-- create user banking_user with password '--MySecuredPassw0rd';
-- grant all privileges on database banking_db to banking_user;
-- \connect banking_db;
-- ## Si es necesario crear un Schema
-- create schema if not exists banking_schema;

