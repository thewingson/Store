

create sequence CATEGORY_SEQ_ID start with 1 increment by  1;
create table CATEGORY (
ID number(19,0) not null,
NAME varchar2(255 char) not null,
primary key (ID)
);
alter table PRODUCT add constraint PRODUCT_CATEGORY_FK foreign key (CATEGORY_ID) references CATEGORY(ID);


create sequence ORDR_SEQ_ID start with 1 increment by  1;
create table ORDR (
ID number(19,0) not null,
COMPLETE varchar2(255 char),
CREATED_AT timestamp not null,
SHIP_DATE timestamp not null,
STATUS varchar2(255 char) not null,
USR_ID number(19,0) not null, primary key (ID)
);
alter table ORDR add constraint ORDR_USR_FK foreign key (USR_ID) references USR(ID);


create sequence ORDR_PRODUCT_SEQ_ID start with 1 increment by  1;
create table ORDR_PRODUCT (
ID number(19,0) not null,
QUANTITY number(10,0) not null,
ORDR_ID number(19,0),
PRODUCT_ID number(19,0),
primary key (ID)
);
alter table ORDR_PRODUCT add constraint OP_ORDR_FK foreign key (ORDR_ID) references ORDR(ID);
alter table ORDR_PRODUCT add constraint OP_PRODUCT_FK foreign key (PRODUCT_ID) references PRODUCT(ID);


create sequence PRODUCT_SEQ_ID start with 1 increment by  1;
create table PRODUCT (
ID number(19,0) not null,
NAME varchar2(255 char) not null,
PRICE number(10,0) not null,
QUANTITY number(10,0) not null,
CATEGORY_ID number(19,0),
VENDOR_ID number(19,0),
primary key (ID)
);
alter table PRODUCT add constraint PRODUCT_VENDOR_FK foreign key (VENDOR_ID) references VENDOR(ID);


create sequence USR_SEQ_ID start with 1 increment by  1;
create table USR (
ID number(19,0) not null,
EMAIL varchar2(255 char),
FIRST_NAME varchar2(255 char),
LAST_NAME varchar2(255 char),
PASSWORD varchar2(255 char),
PHONE varchar2(255 char),
USRNAME varchar2(255 char),
primary key (ID)
);


create table USR_ROLE (
USR_ID number(19,0) not null,
ROLE_ID number(10,0)
);
alter table USR_ROLE add constraint FK3q3wpawdkoay92efnm7f8dsi2 foreign key (USR_ID) references USR(ID);


create sequence VENDOR_SEQ_ID start with 1 increment by  1;
create table VENDOR (
ID number(19,0) not null,
NAME varchar2(255 char) not null,
primary key (ID)
);