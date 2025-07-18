CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       email VARCHAR(100) NOT NULL,
                       username VARCHAR(50) NOT NULL,
                       password VARCHAR(100) NOT NULL,
                       firstname VARCHAR(50),
                       lastname VARCHAR(50),
                       city VARCHAR(100),
                       street VARCHAR(100),
                       number INT,
                       zipcode VARCHAR(20),
                       phone VARCHAR(30)
);