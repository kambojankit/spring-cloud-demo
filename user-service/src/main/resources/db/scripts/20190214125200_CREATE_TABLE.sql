--liquibase formatted sql
--changeset ankit.kamboj:001.1
CREATE TABLE USER (
  ID NUMBER NOT NULL AUTO_INCREMENT,
  NAME VARCHAR2(255) NULL,
  USER_NAME VARCHAR2(255) NULL,
  EMAIL VARCHAR2(255) NULL
);
--rollback DROP TABLE USER;
