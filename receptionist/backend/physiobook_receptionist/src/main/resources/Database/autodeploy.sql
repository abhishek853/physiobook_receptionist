CREATE DATABASE IF NOT EXISTS receptionist;

USE receptionist;

CREATE TABLE IF NOT EXISTS patientdetails (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT,
    gender VARCHAR(10),
    address VARCHAR(255),
    phone VARCHAR(20),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
