CREATE DATABASE IF NOT EXISTS `ms_library_author` ;
CREATE DATABASE IF NOT EXISTS `ms_library_book` ;
CREATE DATABASE IF NOT EXISTS `ms_library_borrow` ;
CREATE DATABASE IF NOT EXISTS `ms_library_review` ;
CREATE DATABASE IF NOT EXISTS `ms_library_user` ;

USE `ms_library_author`;
CREATE TABLE IF NOT EXISTS `author` (
      id BIGINT PRIMARY KEY AUTO_INCREMENT,
      firstname VARCHAR(255) DEFAULT NULL,
      lastname VARCHAR(255) DEFAULT NULL,
      birthDate DATE DEFAULT NULL
);

INSERT INTO author (firstname, lastname, birthDate)
VALUES ('Victor', 'Hugo', '1802-02-26'),
       ('George', 'Orwell', '1903-06-25');

-- CREATE DATABASE `ms_library_book` IF NOT EXISTS;
-- CREATE DATABASE `ms_library_borrow` IF NOT EXISTS;
-- CREATE DATABASE `ms_library_review` IF NOT EXISTS;
--
-- CREATE DATABASE `ms_library_user` IF NOT EXISTS;
