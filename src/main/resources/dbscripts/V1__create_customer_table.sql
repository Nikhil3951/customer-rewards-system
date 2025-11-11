CREATE TABLE IF NOT EXISTS customers(
    customer_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    customer_name varchar(100) NOT NULL,
    customer_email varchar(100) NOT NULL
);

--INSERT THE CUSTOMER RECORDS INTO THE TABLE---
INSERT INTO CUSTOMERS(customer_name,customer_email) VALUES('JOHN','john@gmail.com');
INSERT INTO CUSTOMERS(customer_name,customer_email) VALUES('PAUL','paul@gmail.com');
INSERT INTO CUSTOMERS(customer_name,customer_email) VALUES('SAM','sam@gmail.com');
INSERT INTO CUSTOMERS(customer_name,customer_email) VALUES('TOM','tom@gmail.com');
INSERT INTO CUSTOMERS(customer_name,customer_email) VALUES('JERRY','jerry@gmail.com');
