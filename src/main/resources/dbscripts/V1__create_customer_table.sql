CREATE TABLE IF NOT EXISTS customers(
    customer_id varchar(10) PRIMARY KEY,
    customer_name varchar(100) NOT NULL,
    customer_email varchar(100) NOT NULL
);

--INSERT THE CUSTOMER RECORDS INTO THE TABLE---
INSERT INTO CUSTOMERS(customer_id, customer_name, customer_email) VALUES ('CUST001', 'John Doe', 'john.doe@gmail.com');
INSERT INTO CUSTOMERS(customer_id, customer_name, customer_email) VALUES ('CUST002', 'Jane Smith', 'jane.smith@gmail.com');
INSERT INTO CUSTOMERS(customer_id, customer_name, customer_email) VALUES ('CUST003', 'Michael Brown', 'michael.brown@gmail.com');
INSERT INTO CUSTOMERS(customer_id, customer_name, customer_email) VALUES ('CUST004', 'Emily Davis', 'emily.davis@gmail.com');
INSERT INTO CUSTOMERS(customer_id, customer_name, customer_email) VALUES ('CUST005', 'David Wilson', 'david.wilson@gmail.com');
INSERT INTO CUSTOMERS(customer_id, customer_name, customer_email) VALUES ('CUST006', 'Sarah Johnson', 'sarah.johnson@gmail.com');
INSERT INTO CUSTOMERS(customer_id, customer_name, customer_email) VALUES ('CUST007', 'Robert Miller', 'robert.miller@gmail.com');
INSERT INTO CUSTOMERS(customer_id, customer_name, customer_email) VALUES ('CUST008', 'Laura Taylor', 'laura.taylor@gmail.com');
INSERT INTO CUSTOMERS(customer_id, customer_name, customer_email) VALUES ('CUST009', 'James Anderson', 'james.anderson@gmail.com');
INSERT INTO CUSTOMERS(customer_id, customer_name, customer_email) VALUES ('CUST010', 'Olivia Thomas', 'olivia.thomas@gmail.com');

