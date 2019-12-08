
-- insert USR
insert into USR(ID, USRNAME, PASSWORD, EMAIL, FIRST_NAME, LAST_NAME, PHONE)
        values (USR_SEQ_ID.nextval, 'bekzat', 'almat', 'almat', 'almat', 'almat', '87081997727');
insert into USR(ID, USRNAME, PASSWORD, EMAIL, FIRST_NAME, LAST_NAME, PHONE)
        values (USR_SEQ_ID.nextval, 'admin', 'admin', 'admin', 'admin', 'admin', '88888888888');

-- insert USR_ROLE
insert into USR_ROLE(USR_ID, ROLE)
values (1, 'USER');
insert into USR_ROLE(USR_ID, ROLE)
values (2, 'ADMIN');

-- insert VENDOR
insert into VENDOR(ID, NAME)
        values (VENDOR_SEQ_ID.nextval, 'adidas');
insert into VENDOR(ID, NAME)
        values (VENDOR_SEQ_ID.nextval, 'nike');

-- insert CATEGORY
insert into CATEGORY(ID, NAME)
        values (CATEGORY_SEQ_ID.nextval, 'wear');
insert into CATEGORY(ID, NAME)
        values (CATEGORY_SEQ_ID.nextval, 'accessory');

-- insert PRODUCT
insert into PRODUCT (ID, NAME, PRICE, QUANTITY, CATEGORY_ID, VENDOR_ID)
        values (PRODUCT_SEQ_ID.nextval, 'shorty', 20, 100, 1,  1);
insert into PRODUCT (ID, NAME, PRICE, QUANTITY, CATEGORY_ID, VENDOR_ID)
        values (PRODUCT_SEQ_ID.nextval, 'futbolka', 15, 100, 1,  1);
insert into PRODUCT (ID, NAME, PRICE, QUANTITY, CATEGORY_ID, VENDOR_ID)
        values (PRODUCT_SEQ_ID.nextval, 'braslety', 5, 100, 2,  2);
insert into PRODUCT (ID, NAME, PRICE, QUANTITY, CATEGORY_ID, VENDOR_ID)
        values (PRODUCT_SEQ_ID.nextval, 'lenta', 5, 100, 2,  2);

-- -- insert ORDR
-- insert into ORDR (ID, CREATED_AT, SHIP_DATE, STATUS, COMPLETE, USR_ID)
-- values (ORDR_SEQ_ID.nextval,TO_TIMESTAMP('2014-07-02 06:14:00.742000000', 'YYYY-MM-DD HH24:MI:SS.FF'),
--         TO_TIMESTAMP('2014-07-02 06:14:00.742000000', 'YYYY-MM-DD HH24:MI:SS.FF'), 'PLACED', 'N', 1);
--
-- -- insert ORDR_PRODUCT
-- insert into ORDR_PRODUCT (ID, QUANTITY, ORDR_ID, PRODUCT_ID)
-- values (ORDR_PRODUCT_SEQ_ID.nextval, 2, 14, 2);
-- insert into ORDR_PRODUCT (ID, QUANTITY, ORDR_ID, PRODUCT_ID)
-- values (ORDR_PRODUCT_SEQ_ID.nextval, 1, 14, 1);

-- insert ORDR_STATUS
-- insert into ORDR_STATUS(ID, NAME)
--         values (ORDR_STATUS_SEQ_ID.nextval, 'PLACED');
-- insert into ORDR_STATUS(ID, NAME)
--         values (ORDR_STATUS_SEQ_ID.nextval, 'APPROVED');
-- insert into ORDR_STATUS(ID, NAME)
--         values (ORDR_STATUS_SEQ_ID.nextval, 'DELIVERED');

-- insert ROLE
-- insert into ROLE(ID, NAME)
--         values (ROLE_SEQ_ID.nextval, 'ADMIN');
-- insert into ROLE(ID, NAME)
--         values (ROLE_SEQ_ID.nextval, 'MODERATOR');
-- insert into ROLE(ID, NAME)
--         values (ROLE_SEQ_ID.nextval, 'USER');
-- insert into ROLE(ID, NAME)
--         values (ROLE_SEQ_ID.nextval, 'VENDOR');







