CREATE TABLE products (
                          id SERIAL PRIMARY KEY,
                          title VARCHAR(255) NOT NULL,
                          price NUMERIC(10,2) NOT NULL,
                          description TEXT,
                          category VARCHAR(100),
                          image VARCHAR(255),
                          rating_rate NUMERIC(3,2),
                          rating_count INT
);
