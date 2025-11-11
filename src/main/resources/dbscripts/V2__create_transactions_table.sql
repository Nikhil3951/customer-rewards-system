CREATE TABLE IF NOT EXISTS transactions(
    transaction_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    customer_id BIGINT NOT NULL,
    transaction_amount DECIMAL(10,2) NOT NULL CHECK (transaction_amount>=0),
    transaction_date DATE NOT NULL,
    CONSTRAINT fk_customer FOREIGN KEY(customer_id)
        REFERENCES customers(customer_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

--INSERT CUSTOMER TRANSACTIONS INTO THE TABLE---
INSERT INTO TRANSACTIONS(customer_id,transaction_amount,transaction_date) VALUES(1,125,'2025-10-11');
INSERT INTO TRANSACTIONS(customer_id,transaction_amount,transaction_date) VALUES(1,125,'2025-12-11');
INSERT INTO TRANSACTIONS(customer_id,transaction_amount,transaction_date) VALUES(1,125,'2025-11-11');
INSERT INTO TRANSACTIONS(customer_id,transaction_amount,transaction_date) VALUES(1,125,'2025-12-13');