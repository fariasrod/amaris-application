INSERT INTO TBL_BRAND (NAME)
VALUES ('ZARA');

INSERT INTO TBL_PRODUCT (NAME)
VALUES ('PANTALÓN CONJUNTO ESTRUCTURA');

INSERT INTO TBL_PRICE (BRAND_ID, PRODUCT_ID, CURRENCY, START_DATE, END_DATE, PRICE, PRICE_LIST, PRIORITY)
VALUES (1, 1, 'EUR', to_timestamp('2020-06-14-00.00.00', 'yyyy-mm-dd-hh24:mi:ss'), to_timestamp('2020-12-31-23.59.59', 'yyyy-mm-dd-hh24:mi:ss'), '35.50', 1, 0),
       (1, 1, 'EUR', to_timestamp('2020-06-14-15.00.00', 'yyyy-mm-dd-hh24:mi:ss'), to_timestamp('2020-06-14-18.30.00', 'yyyy-mm-dd-hh24:mi:ss'), '25.45', 2, 1),
       (1, 1, 'EUR', to_timestamp('2020-06-15-00.00.00', 'yyyy-mm-dd-hh24:mi:ss'), to_timestamp('2020-06-15-11.00.00', 'yyyy-mm-dd-hh24:mi:ss'), '30.50', 3, 1),
       (1, 1, 'EUR', to_timestamp('2020-06-15-16.00.00', 'yyyy-mm-dd-hh24:mi:ss'), to_timestamp('2020-12-31-23.59.59', 'yyyy-mm-dd-hh24:mi:ss'), '38.95', 4, 1);