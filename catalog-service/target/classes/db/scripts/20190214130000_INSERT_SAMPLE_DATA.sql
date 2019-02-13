--liquibase formatted sql
--changeset ankit.kamboj:001.2
INSERT INTO PRODUCT VALUES(NULL,  'ABC Sports Shoe', 3000);
INSERT INTO PRODUCT VALUES(NULL, 'XYZ Bag', 1000);
--rollback DELETE FROM  WHERE PRODUCT_NAME in('ABC Sports Shoe', 'XYZ Bag');
