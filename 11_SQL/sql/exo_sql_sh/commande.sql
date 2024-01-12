-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Oct 20, 2019 at 10:17 AM
-- Server version: 5.7.19
-- PHP Version: 5.6.31
USE exo_2_sql_sh;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sql_sh`
--

-- --------------------------------------------------------

--
-- Table structure for table `commande`
--

DROP TABLE IF EXISTS `commande`;
CREATE TABLE IF NOT EXISTS `commande` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `client_id` int(10) UNSIGNED NOT NULL,
  `date_achat` date NOT NULL,
  `reference` varchar(255) NOT NULL,
  `cache_prix_total` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `commande`
--

INSERT INTO `commande` (`id`, `client_id`, `date_achat`, `reference`, `cache_prix_total`) VALUES
(1, 20, '2019-01-01', '004214', 0),
(2, 3, '2019-01-03', '007120', 0),
(3, 11, '2019-01-04', '002957', 0),
(4, 6, '2019-01-07', '003425', 0),
(5, 17, '2019-01-08', '008255', 0),
(6, 7, '2019-01-09', '000996', 0),
(7, 2, '2019-01-10', '000214', 0),
(8, 7, '2019-01-11', '008084', 0),
(9, 12, '2019-01-11', '009773', 0),
(10, 16, '2019-01-13', '004616', 0),
(11, 4, '2019-01-14', '003757', 0),
(12, 9, '2019-01-15', '004939', 0),
(13, 14, '2019-01-16', '003421', 0),
(14, 6, '2019-01-16', '002286', 0),
(15, 3, '2019-01-17', '001167', 0),
(16, 15, '2019-01-18', '008974', 0),
(17, 9, '2019-01-19', '001369', 0),
(18, 17, '2019-01-20', '009924', 0),
(19, 3, '2019-01-21', '005510', 0),
(20, 17, '2019-01-22', '007778', 0),
(21, 17, '2019-01-23', '002359', 0),
(22, 15, '2019-01-25', '008459', 0),
(23, 4, '2019-01-27', '005217', 0),
(24, 12, '2019-01-29', '000706', 0),
(25, 9, '2019-02-01', '007879', 0),
(26, 8, '2019-02-02', '007277', 0),
(27, 11, '2019-02-02', '002745', 0),
(28, 11, '2019-02-03', '001893', 0),
(29, 20, '2019-02-04', '001230', 0),
(30, 10, '2019-02-05', '000469', 0),
(31, 7, '2019-02-05', '008653', 0),
(32, 3, '2019-02-06', '001858', 0),
(33, 14, '2019-02-07', '003330', 0),
(34, 2, '2019-02-08', '001074', 0),
(35, 5, '2019-02-08', '005379', 0),
(36, 16, '2019-02-09', '003672', 0),
(37, 10, '2019-02-09', '002220', 0),
(38, 19, '2019-02-10', '000086', 0),
(39, 8, '2019-02-11', '003770', 0),
(40, 2, '2019-02-12', '008590', 0),
(41, 2, '2019-02-12', '001639', 0),
(42, 4, '2019-02-13', '002426', 0),
(43, 13, '2019-02-14', '007209', 0),
(44, 13, '2019-02-15', '008768', 0),
(45, 7, '2019-02-16', '002213', 0),
(46, 12, '2019-02-17', '004759', 0),
(47, 19, '2019-02-18', '007155', 0),
(48, 2, '2019-02-19', '001496', 0);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
