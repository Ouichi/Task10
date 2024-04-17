DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id int unsigned AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  phone VARCHAR(255) NOT NULL UNIQUE,
  PRIMARY KEY(id)
);

INSERT INTO users (name,phone) VALUES ("yonetu","05012345678");
