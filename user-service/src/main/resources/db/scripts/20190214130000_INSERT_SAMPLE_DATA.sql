--liquibase formatted sql
--changeset ankit.kamboj:001.2
INSERT INTO USER VALUES(NULL, 'Ajay', 'ajay_1', 'ajay@gmail.com');
INSERT INTO USER VALUES(NULL, 'Rahul', 'rahul', 'rahul@gmail.com');
--rollback DELETE FROM USER WHERE NAME in('Ajay', 'Rahul');
