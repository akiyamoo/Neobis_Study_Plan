CREATE TABLE IF NOT EXISTS users
(
    user_id INT AUTO_INCREMENT UNIQUE NOT NULL PRIMARY KEY ,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);