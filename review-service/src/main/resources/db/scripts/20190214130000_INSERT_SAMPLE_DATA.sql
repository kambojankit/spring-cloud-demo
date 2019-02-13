--liquibase formatted sql
--changeset ankit.kamboj:001.2
INSERT INTO REVIEW VALUES(NULL, 'Good Quality Product', 4.5, 'ajay_1', 1);
INSERT INTO REVIEW VALUES(NULL, 'Not As Expected', 1, 'rahul', 2);
--rollback DELETE FROM REVIEW WHERE PRODUCT_ID in(1, 2);
