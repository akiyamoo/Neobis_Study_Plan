CREATE TABLE IF NOT EXISTS roles
(
    role_id INT AUTO_INCREMENT UNIQUE NOT NULL PRIMARY KEY,
    role_name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS user_roles
(
    user_id INT NOT NULL UNIQUE,
    role_id INT NOT NULL UNIQUE,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (role_id) REFERENCES roles(role_id)
);

INSERT roles(role_id, role_name)
VALUES(1, 'ROLE_USER');

INSERT roles(role_id, role_name)
VALUES(2, 'ROLE_ADMIN');