

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
alter table USR_ROLE add constraint USR_ROLE_USR_FK foreign key (USR_ID) references USR(ID);


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
alter table PRODUCT add constraint PRODUCT_CATEGORY_FK foreign key (CATEGORY_ID) references CATEGORY(ID);
alter table PRODUCT add constraint PRODUCT_VENDOR_FK foreign key (VENDOR_ID) references VENDOR(ID);


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
alter table ORDR add constraint ORDR_USR_FK foreign key (USR_ID) references USR(ID);


create sequence ORDR_PRODUCT_SEQ_ID start with 1 increment by  1;
create table ORDR_PRODUCT (
ID number,
QUANTITY number not null,
ORDR_ID number not null,
PRODUCT_ID number not null,
primary key (ID)
);
alter table ORDR_PRODUCT add constraint OP_ORDR_FK foreign key (ORDR_ID) references ORDR(ID);
alter table ORDR_PRODUCT add constraint OP_PRODUCT_FK foreign key (PRODUCT_ID) references PRODUCT(ID);