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
