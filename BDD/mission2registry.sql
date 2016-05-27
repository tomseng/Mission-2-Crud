-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 26 Mai 2016 à 11:14
-- Version du serveur :  10.1.9-MariaDB
-- Version de PHP :  5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `mission2registry`
--
CREATE DATABASE IF NOT EXISTS `mission2registry` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `mission2registry`;

-- --------------------------------------------------------

--
-- Structure de la table `table1`
--

CREATE TABLE `table1` (
  `col1` varchar(40) NOT NULL,
  `col2` varchar(40) NOT NULL,
  `col3` varchar(40) NOT NULL,
  `col4` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `table1`
--

INSERT INTO `table1` (`col1`, `col2`, `col3`, `col4`) VALUES
('titre', 'annee', 'acteur', 'note');

-- --------------------------------------------------------

--
-- Structure de la table `table2`
--

CREATE TABLE `table2` (
  `col1` varchar(22) NOT NULL,
  `col2` varchar(22) NOT NULL,
  `col3` varchar(22) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
