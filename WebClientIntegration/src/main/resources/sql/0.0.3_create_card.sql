CREATE TABLE carts (
                       id SERIAL PRIMARY KEY,
                       user_id INT NOT NULL REFERENCES users(id),
                       created_at DATE NOT NULL
);
