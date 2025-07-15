CREATE TABLE tasks (
                       id SERIAL PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       description TEXT,
                       status VARCHAR(50) DEFAULT 'TODO',
                       user_id BIGINT NOT NULL,
                       created_at TIMESTAMP,
                       updated_at TIMESTAMP,
                       FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);