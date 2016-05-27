-- phpMyAdmin SQL Dump
-- version 4.4.10
-- http://www.phpmyadmin.net
--
-- Client :  localhost:3306
-- Généré le :  Ven 27 Mai 2016 à 10:27
-- Version du serveur :  5.5.42
-- Version de PHP :  7.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `mission2registry`
--

-- --------------------------------------------------------

--
-- Structure de la table `table1`
--

CREATE TABLE `table1` (
  `id` int(11) NOT NULL,
  `col1` varchar(40) NOT NULL,
  `col2` varchar(40) NOT NULL,
  `col3` varchar(40) NOT NULL,
  `col4` varchar(40) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `table1`
--

INSERT INTO `table1` (`id`, `col1`, `col2`, `col3`, `col4`) VALUES
(1, 'Box', 'annee', 'acteur', 'note'),
(4, 'cdqfed', 'fedqsf', 'fedzf', 'fedz'),
(5, 'tinynode', 'jtable', 'tinynode', 'jtable'),
(6, 'tinynode', 'jtable', 'tinynode', 'jtable');

-- --------------------------------------------------------

--
-- Structure de la table `table2`
--

CREATE TABLE `table2` (
  `id` int(11) NOT NULL,
  `col1` varchar(22) NOT NULL,
  `col2` varchar(22) NOT NULL,
  `col3` varchar(22) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `table2`
--

INSERT INTO `table2` (`id`, `col1`, `col2`, `col3`) VALUES
(2, '2', 'engels', 'jtable'),
(4, '3', 'ok', 'ok');

-- --------------------------------------------------------

--
-- Structure de la table `table3`
--

CREATE TABLE `table3` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `age` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `table1`
--
ALTER TABLE `table1`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `table2`
--
ALTER TABLE `table2`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `table3`
--
ALTER TABLE `table3`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `table1`
--
ALTER TABLE `table1`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT pour la table `table2`
--
ALTER TABLE `table2`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `table3`
--
ALTER TABLE `table3`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
