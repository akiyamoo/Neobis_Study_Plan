CREATE TABLE IF NOT EXISTS users
(
    user_id INT AUTO_INCREMENT UNIQUE NOT NULL,
    user_first_name TEXT NOT NULL,
    user_last_name TEXT NOT NULL,
    email VARCHAR(20) UNIQUE NOT NULL,
    password VARCHAR(16) NOT NULL
);