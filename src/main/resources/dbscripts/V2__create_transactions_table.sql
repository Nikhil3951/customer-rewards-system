CREATE TABLE IF NOT EXISTS transactions(
    transaction_id varchar(20) PRIMARY KEY,
    customer_id varchar(10) NOT NULL,
    transaction_amount DECIMAL(10,2) NOT NULL CHECK (transaction_amount>=0),
    transaction_date DATE NOT NULL,
    CONSTRAINT fk_customer FOREIGN KEY(customer_id)
        REFERENCES customers(customer_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

--INSERT CUSTOMER TRANSACTIONS INTO THE TABLE---
-- Transactions
INSERT INTO TRANSACTIONS(transaction_id, customer_id, transaction_amount, transaction_date) VALUES ('TXN1001', 'CUST001', 120.0, '2025-08-15');
INSERT INTO TRANSACTIONS(transaction_id, customer_id, transaction_amount, transaction_date) VALUES ('TXN1002', 'CUST001', 75.0, '2025-09-03');
INSERT INTO TRANSACTIONS(transaction_id, customer_id, transaction_amount, transaction_date) VALUES ('TXN1021', 'CUST001', 78.0, '2025-09-01');
INSERT INTO TRANSACTIONS(transaction_id, customer_id, transaction_amount, transaction_date) VALUES ('TXN1022', 'CUST001', 153.0, '2025-10-08');
INSERT INTO TRANSACTIONS(transaction_id, customer_id, transaction_amount, transaction_date) VALUES ('TXN1003', 'CUST002', 200.0, '2025-08-20');
INSERT INTO TRANSACTIONS(transaction_id, customer_id, transaction_amount, transaction_date) VALUES ('TXN1004', 'CUST002', 45.0, '2025-09-10');
INSERT INTO TRANSACTIONS(transaction_id, customer_id, transaction_amount, transaction_date) VALUES ('TXN1023', 'CUST002', 243.0, '2025-10-10');
INSERT INTO TRANSACTIONS(transaction_id, customer_id, transaction_amount, transaction_date) VALUES ('TXN1005', 'CUST003', 95.0, '2025-07-25');
INSERT INTO TRANSACTIONS(transaction_id, customer_id, transaction_amount, transaction_date) VALUES ('TXN1006', 'CUST003', 150.0, '2025-08-05');
INSERT INTO TRANSACTIONS(transaction_id, customer_id, transaction_amount, transaction_date) VALUES ('TXN1007', 'CUST004', 60.0, '2025-09-15');
INSERT INTO TRANSACTIONS(transaction_id, customer_id, transaction_amount, transaction_date) VALUES ('TXN1008', 'CUST004', 110.0, '2025-10-01');
INSERT INTO TRANSACTIONS(transaction_id, customer_id, transaction_amount, transaction_date) VALUES ('TXN1024', 'CUST004', 18.0, '2025-09-30');
INSERT INTO TRANSACTIONS(transaction_id, customer_id, transaction_amount, transaction_date) VALUES ('TXN1025', 'CUST004', 23.0, '2025-11-02');
INSERT INTO TRANSACTIONS(transaction_id, customer_id, transaction_amount, transaction_date) VALUES ('TXN1026', 'CUST004', 58.0, '2025-09-28');
INSERT INTO TRANSACTIONS(transaction_id, customer_id, transaction_amount, transaction_date) VALUES ('TXN1027', 'CUST004', 132.0, '2025-10-02');
INSERT INTO TRANSACTIONS(transaction_id, customer_id, transaction_amount, transaction_date) VALUES ('TXN1009', 'CUST005', 30.0, '2025-08-30');
INSERT INTO TRANSACTIONS(transaction_id, customer_id, transaction_amount, transaction_date) VALUES ('TXN1010', 'CUST005', 80.0, '2025-09-20');
INSERT INTO TRANSACTIONS(transaction_id, customer_id, transaction_amount, transaction_date) VALUES ('TXN1011', 'CUST006', 140.0, '2025-08-18');
INSERT INTO TRANSACTIONS(transaction_id, customer_id, transaction_amount, transaction_date) VALUES ('TXN1012', 'CUST006', 50.0, '2025-09-22');
INSERT INTO TRANSACTIONS(transaction_id, customer_id, transaction_amount, transaction_date) VALUES ('TXN1013', 'CUST007', 70.0, '2025-08-10');
INSERT INTO TRANSACTIONS(transaction_id, customer_id, transaction_amount, transaction_date) VALUES ('TXN1014', 'CUST007', 120.0, '2025-09-05');
INSERT INTO TRANSACTIONS(transaction_id, customer_id, transaction_amount, transaction_date) VALUES ('TXN1015', 'CUST008', 95.0, '2025-08-12');
INSERT INTO TRANSACTIONS(transaction_id, customer_id, transaction_amount, transaction_date) VALUES ('TXN1016', 'CUST008', 130.0, '2025-09-25');
INSERT INTO TRANSACTIONS(transaction_id, customer_id, transaction_amount, transaction_date) VALUES ('TXN1017', 'CUST009', 55.0, '2025-08-28');
INSERT INTO TRANSACTIONS(transaction_id, customer_id, transaction_amount, transaction_date) VALUES ('TXN1018', 'CUST009', 160.0, '2025-09-18');
INSERT INTO TRANSACTIONS(transaction_id, customer_id, transaction_amount, transaction_date) VALUES ('TXN1019', 'CUST010', 85.0, '2025-08-07');
INSERT INTO TRANSACTIONS(transaction_id, customer_id, transaction_amount, transaction_date) VALUES ('TXN1020', 'CUST010', 125.0, '2025-09-30');