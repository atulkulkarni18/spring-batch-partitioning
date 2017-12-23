DROP TABLE IF EXISTS customer;

CREATE TABLE customer(
   id INT PRIMARY KEY,
   firstname VARCHAR(20) NOT NULL,
   lastname VARCHAR(20) NOT NULL
);