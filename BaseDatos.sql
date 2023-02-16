/*
-- FUNCTION: public.truncate_if_exists(text, text)

-- DROP FUNCTION IF EXISTS public.truncate_if_exists(text, text);

CREATE OR REPLACE FUNCTION public.truncate_if_exists(
	_table text,
	_schema text DEFAULT NULL::text)
    RETURNS text
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
AS $BODY$
DECLARE
   _qual_tbl text := concat_ws('.', quote_ident(_schema), quote_ident(_table));
   _row_found bool;
BEGIN
   IF to_regclass(_qual_tbl) IS NOT NULL THEN   -- table exists
      EXECUTE 'SELECT EXISTS (SELECT FROM ' || _qual_tbl || ')'
      INTO _row_found;

      IF _row_found THEN                        -- table is not empty
         EXECUTE 'TRUNCATE ' || _qual_tbl || ' CASCADE';
         RETURN 'Table truncated: ' || _qual_tbl;
      ELSE  -- optional!
         RETURN 'Table exists but is empty: ' || _qual_tbl;
      END IF;
   ELSE  -- optional!
      RETURN 'Table not found: ' || _qual_tbl;
   END IF;
END
$BODY$;

ALTER FUNCTION public.truncate_if_exists(text, text)
    OWNER TO postgres;

*/

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


SELECT truncate_if_exists('customer', 'public');
SELECT truncate_if_exists('person', 'public');
SELECT truncate_if_exists('bank_user', 'public');
SELECT truncate_if_exists('account_type', 'public');
SELECT truncate_if_exists('gender', 'public');


INSERT INTO public.account_type(id, account_type_description) VALUES (21, 'AHORRO');
INSERT INTO public.account_type(id, account_type_description) VALUES (22, 'CORRIENTE');


INSERT INTO public.gender(id, gender_description) VALUES (1, 'AHORRO');
INSERT INTO public.gender(id, gender_description) VALUES (2, 'CORRIENTE');
INSERT INTO public.gender(id, gender_description) VALUES (3, 'NON-BINARY');
INSERT INTO public.gender(id, gender_description) VALUES (4, 'NOT-REPORTED');


INSERT INTO public.person(id, identification, name, gender_id, birthdate, address, phone) VALUES (
                           101, '123-000-100', 'Jose Lema', 4, TO_DATE('1980-10-14','YYYY-MM-DD'), 'Otavalo sn y principal', '098254785');
INSERT INTO public.person(id, identification, name, gender_id, birthdate, address, phone) VALUES (
                           102, '132-000-100', 'Marianela Montalvo', 4, TO_DATE('1970-01-30','YYYY-MM-DD'), 'Amazonas y NNUU', '097548965');
INSERT INTO public.person(id, identification, name, gender_id, birthdate, address, phone) VALUES (
                           103, '123-000-101', 'Juan Osorio', 4, TO_DATE('1999-07-27','YYYY-MM-DD'), '13 junio y Equinoccial', '098874587');


INSERT INTO public.bank_user(id, user_name, password, status) VALUES (201, 'jose.lema', '1234', true);
INSERT INTO public.bank_user(id, user_name, password, status) VALUES (202, 'marianela.montalvo', '5678', true);
INSERT INTO public.bank_user(id, user_name, password, status) VALUES (203, 'juan.osorio', '1245', true);


INSERT INTO public.customer(id, person_id, bank_user_id) VALUES (301, 101, 201);
INSERT INTO public.customer(id, person_id, bank_user_id) VALUES (302, 102, 202);
INSERT INTO public.customer(id, person_id, bank_user_id) VALUES (303, 103, 203);