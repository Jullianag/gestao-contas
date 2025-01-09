INSERT INTO tb_bank (name) VALUES ('Nubank');
INSERT INTO tb_bank (name) VALUES ('Banco do Brasil');
INSERT INTO tb_bank (name) VALUES ('Caixa');
INSERT INTO tb_bank (name) VALUES ('Itau');
INSERT INTO tb_bank (name) VALUES ('Santander');
INSERT INTO tb_bank (name) VALUES ('Bradesco');
INSERT INTO tb_bank (name) VALUES ('Inter');

INSERT INTO tb_user (name, email, phone, password, birth_date) VALUES ('Maria Brown', 'maria@gmail.com', '988888888', '$2a$10$AEbRx77cmlpSp/P4GpvyNu6KrfFxNMgELmCKVFy62f/I4MsnJHYUi', '2001-07-25');
INSERT INTO tb_user (name, email, phone, password, birth_date) VALUES ('Alex Green', 'alex@gmail.com', '977777777', '$2a$10$AEbRx77cmlpSp/P4GpvyNu6KrfFxNMgELmCKVFy62f/I4MsnJHYUi', '1987-12-13');

INSERT INTO tb_account (nickname, types, valor, img_url, instant, status, client_id) VALUES ('Alex', 'Pessoa Física', 3000.0, 'https://conceito.de/wp-content/uploads/2012/01/banknotes-159085_1280.png', TIMESTAMP WITH TIME ZONE '2022-07-25T15:00:00Z', 1, 2);
INSERT INTO tb_account (nickname, types, valor, img_url, instant, status, client_id) VALUES ('Mari', 'Pessoa Física', 5000.0, 'https://conceito.de/wp-content/uploads/2012/01/banknotes-159085_1280.png', TIMESTAMP WITH TIME ZONE '2024-08-07T15:00:00Z', 1, 1);

INSERT INTO tb_account_bank (account_id, bank_id) VALUES (1, 1);

INSERT INTO tb_role (authority) VALUES ('ROLE_CLIENT');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);