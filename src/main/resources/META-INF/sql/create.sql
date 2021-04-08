-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 08 avr. 2021 à 11:18
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `topaidi`
--

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE IF NOT EXISTS `categorie` ( `id` int(11) NOT NULL AUTO_INCREMENT, `libelle` varchar(55) DEFAULT NULL, PRIMARY KEY (`id`) ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

CREATE TABLE IF NOT EXISTS `commentaire` ( `id` int(11) NOT NULL AUTO_INCREMENT, `dateCreation` datetime(6) DEFAULT NULL, `texte` varchar(255) DEFAULT NULL, `idee_id` int(11) DEFAULT NULL, `utilisateur_id` int(11) DEFAULT NULL,  PRIMARY KEY (`id`),  KEY `FK6wagnriytv6q6k1fnj4lle5nf` (`idee_id`), KEY `FK2op25qo0f35iwsqnb86mhw3va` (`utilisateur_id`) ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `idee`
--

CREATE TABLE IF NOT EXISTS `idee` (  `id` int(11) NOT NULL AUTO_INCREMENT,  `dateCreation` datetime(6) DEFAULT NULL, `description` varchar(125) DEFAULT NULL, `image` longblob,  `titre` varchar(55) DEFAULT NULL, `categorie_id` int(11) DEFAULT NULL, `utilisateur_id` int(11) DEFAULT NULL,  PRIMARY KEY (`id`), KEY `FKqunh2u1b4164baj2ma1fpexda` (`categorie_id`),  KEY `FKfvj9cmelluthx8t8643rdage` (`utilisateur_id`) ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (  `DTYPE` varchar(31) NOT NULL,  `id` int(11) NOT NULL AUTO_INCREMENT,  `desactive` bit(1) NOT NULL, `email` varchar(255) DEFAULT NULL, `hash` varchar(60) DEFAULT NULL, `nom` varchar(255) DEFAULT NULL,  `prenom` varchar(255) DEFAULT NULL,  `valide` bit(1) NOT NULL, PRIMARY KEY (`id`) ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `vote`
--

CREATE TABLE IF NOT EXISTS `vote` (  `id` int(11) NOT NULL AUTO_INCREMENT,   `top` bit(1) NOT NULL,   `idee_id` int(11) DEFAULT NULL, `utilisateur_id` int(11) DEFAULT NULL,  PRIMARY KEY (`id`), KEY `FKifvlnsk4x8s7mkq5hdmgrg6ks` (`idee_id`),  KEY `FKop71cq2atm23nqbploawerqpm` (`utilisateur_id`) ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `commentaire`
--
ALTER TABLE `commentaire` ADD CONSTRAINT `FK2op25qo0f35iwsqnb86mhw3va` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateur` (`id`),  ADD CONSTRAINT `FK6wagnriytv6q6k1fnj4lle5nf` FOREIGN KEY (`idee_id`) REFERENCES `idee` (`id`);

--
-- Contraintes pour la table `idee`
--
ALTER TABLE `idee`  ADD CONSTRAINT `FKfvj9cmelluthx8t8643rdage` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateur` (`id`),  ADD CONSTRAINT `FKqunh2u1b4164baj2ma1fpexda` FOREIGN KEY (`categorie_id`) REFERENCES `categorie` (`id`);

--
-- Contraintes pour la table `vote`
--
ALTER TABLE `vote` ADD CONSTRAINT `FKifvlnsk4x8s7mkq5hdmgrg6ks` FOREIGN KEY (`idee_id`) REFERENCES `idee` (`id`), ADD CONSTRAINT `FKop71cq2atm23nqbploawerqpm` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateur` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
