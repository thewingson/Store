--
-- DROP SEQUENCE CATEGORY_SEQ_ID;
-- DROP SEQUENCE ORDR_PRODUCT_SEQ_ID;
-- DROP SEQUENCE ORDR_SEQ_ID;
-- DROP SEQUENCE PRODUCT_SEQ_ID;
-- DROP SEQUENCE ROLE_SEQ_ID;
-- DROP SEQUENCE USR_ROLE_SEQ_ID;
-- DROP SEQUENCE USR_SEQ_ID;
-- DROP SEQUENCE VENDOR_SEQ_ID;
--
-- ALTER TABLE USR_ROLE DROP CONSTRAINT USR_ROLE_USR_FK;
-- ALTER TABLE ORDR DROP CONSTRAINT ORDR_USR_FK;
-- ALTER TABLE ORDR_PRODUCT DROP CONSTRAINT OP_ORDR_FK;
-- ALTER TABLE ORDR_PRODUCT DROP CONSTRAINT OP_PRODUCT_FK;
-- ALTER TABLE PRODUCT DROP CONSTRAINT PRODUCT_CATEGORY_FK;
-- ALTER TABLE PRODUCT DROP CONSTRAINT PRODUCT_VENDOR_FK;
--
-- DROP TABLE USR;
-- DROP TABLE CATEGORY;
-- DROP TABLE ORDR;
-- DROP TABLE ORDR_PRODUCT;
-- DROP TABLE PRODUCT;
-- DROP TABLE ROLE;
-- DROP TABLE USR_ROLE;
-- DROP TABLE VENDOR;
-- DROP TABLE "flyway_schema_history";


create sequence USR_SEQ_ID start with 1 increment by  1;
create table USR (
ID number,
EMAIL varchar2(255) not null,
FIRST_NAME varchar2(255),
LAST_NAME varchar2(255),
PASSWORD varchar2(255) not null,
PHONE varchar2(255),
USRNAME varchar2(255) not null,
primary key (ID)
);


create table USR_ROLE (
USR_ID number not null,
ROLE varchar2(255) not null
);
alter table USR_ROLE add constraint USR_ROLE_USR_FK foreign key (USR_ID) references USR(ID) on delete cascade;


create sequence CATEGORY_SEQ_ID start with 1 increment by  1;
create table CATEGORY (
ID number,
NAME varchar2(255) not null,
primary key (ID)
);


create sequence VENDOR_SEQ_ID start with 1 increment by  1;
create table VENDOR (
ID number,
NAME varchar2(255) not null,
primary key (ID)
);


create sequence PRODUCT_SEQ_ID start with 1 increment by  1;
create table PRODUCT (
ID number,
NAME varchar2(255) not null,
PRICE number not null,
QUANTITY number not null,
CATEGORY_ID number not null,
VENDOR_ID number not null,
primary key (ID)
);
alter table PRODUCT add constraint PRODUCT_CATEGORY_FK foreign key (CATEGORY_ID) references CATEGORY(ID) on delete cascade;
alter table PRODUCT add constraint PRODUCT_VENDOR_FK foreign key (VENDOR_ID) references VENDOR(ID) on delete cascade;


create sequence ORDR_SEQ_ID start with 1 increment by  1;
create table ORDR (
ID number,
COMPLETE varchar2(255) not null,
CREATED_AT timestamp not null,
SHIP_DATE timestamp not null,
STATUS varchar2(255) not null,
USR_ID number not null,
primary key (ID)
);
alter table ORDR add constraint ORDR_USR_FK foreign key (USR_ID) references USR(ID) on delete cascade;


create sequence ORDR_PRODUCT_SEQ_ID start with 1 increment by  1;
create table ORDR_PRODUCT (
ID number,
QUANTITY number not null,
ORDR_ID number not null,
PRODUCT_ID number not null,
primary key (ID)
);
alter table ORDR_PRODUCT add constraint OP_ORDR_FK foreign key (ORDR_ID) references ORDR(ID) on delete cascade;
alter table ORDR_PRODUCT add constraint OP_PRODUCT_FK foreign key (PRODUCT_ID) references PRODUCT(ID) on delete cascade;