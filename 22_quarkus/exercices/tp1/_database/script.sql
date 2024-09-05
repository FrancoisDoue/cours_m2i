CREATE DATABASE IF NOT EXISTS `ms_library_author` ;
CREATE DATABASE IF NOT EXISTS `ms_library_book` ;
CREATE DATABASE IF NOT EXISTS `ms_library_borrow` ;
CREATE DATABASE IF NOT EXISTS `ms_library_review` ;
CREATE DATABASE IF NOT EXISTS `ms_library_user` ;

USE `ms_library_author`;
CREATE TABLE IF NOT EXISTS `author` (
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    firstname   VARCHAR(255) DEFAULT NULL,
    lastname    VARCHAR(255) DEFAULT NULL,
    birthDate   DATE DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO author (firstname, lastname, birthDate)
VALUES ('Victor', 'Hugo', '1802-02-26'),
       ('George', 'Orwell', '1903-06-25');

USE `ms_library_book`;
CREATE TABLE IF NOT EXISTS `book` (
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    title       VARCHAR(255),
    author_id   BIGINT,
    quantity    INT,
    isbn        VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO book (title, quantity, isbn, author_id)
VALUES ('Les misérables', 2, 'guylmyif', 1),
       ('Notre-Dame', 3, 'azertyuio', 1),
       ('1984', 1, 'qsdfghjk', 2);

USE `ms_library_user`;

CREATE TABLE IF NOT EXISTS `account` (
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(255),
    username    VARCHAR(255) UNIQUE NOT NULL,
    password    VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO account (name, username, password)
VALUES ('Georges Abitbol', 'gabitbol', '123456'),
       ('Bernard', 'nanard', '123456'),
       ('Jean-eude', 'eeeuh', '123456');

USE `ms_library_borrow`;

CREATE TABLE IF NOT EXISTS `borrow` (
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    borrow_date DATE DEFAULT NULL,
    return_date DATE DEFAULT NULL,
    book_id     BIGINT DEFAULT NULL,
    user_id     BIGINT DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO borrow (user_id, book_id, borrow_date, return_date)
VALUES (1,1, '2024-08-15', NULL),
       (3,3, '2024-08-01', '2024-08-08');

USE `ms_library_review`;

CREATE TABLE IF NOT EXISTS `review` (
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id     BIGINT DEFAULT NULL,
    book_id     BIGINT DEFAULT NULL,
    notation    INT DEFAULT 0,
    content     VARCHAR(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO review (user_id, book_id, notation, content)
VALUES (1, 1, 7, 'Plutôt pas mal'),
       (1, 2, 5, 'Le héros meurt à la fin'),
       (3, 3, 10, 'trop bieng');

