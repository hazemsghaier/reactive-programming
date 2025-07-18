CREATE TABLE cart_items (
                            id SERIAL PRIMARY KEY,
                            cart_id INT NOT NULL REFERENCES carts(id) ON DELETE CASCADE,
                            product_id INT NOT NULL REFERENCES products(id),
                            quantity INT NOT NULL CHECK (quantity > 0)
);
