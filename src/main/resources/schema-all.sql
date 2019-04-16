DROP TABLE settlement IF EXISTS;

CREATE TABLE settlement  (
    settlement_id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    externalRef VARCHAR(50),
    transactionAmount VARCHAR(20)
);