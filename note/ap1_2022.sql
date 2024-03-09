-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 15 fév. 2023 à 14:07
-- Version du serveur : 10.4.27-MariaDB
-- Version de PHP : 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `ap1_2022`
--

-- --------------------------------------------------------

--
-- Structure de la table `cr`
--

CREATE TABLE `cr` (
  `num` bigint(20) NOT NULL,
  `date` date DEFAULT NULL,
  `description` text DEFAULT NULL,
  `vu` tinyint(1) DEFAULT NULL,
  `num_utilisateur` int(10) NOT NULL,
  `datetime` datetime DEFAULT NULL,
  `note` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `cr`
--

INSERT INTO `cr` (`num`, `date`, `description`, `vu`, `num_utilisateur`, `datetime`, `note`) VALUES
(1, '2022-09-15', 'Si tu ne comprends pas, ou ne maîtrises pas, la notion de coefficient binomial, inutile de chercher à calculer toi-même les nombres de Catalan, que tu découvris dans cette obscure revue américaine d\'algèbre, croyant qu\'il s\'agissait de “nombres catalans” (l\'anglais Catalan numbers est équivoque), avant de faire le chemin historique et de découvrir qu\'ils auraient tout aussi bien pu se nommer suite d\'Euler, entiers de Seger, ou nombres de Ming Antu.\r\n\r\nDes textes en 16.796 signes ? Un roman de 58.786 mots ? Tu n\'y penses pas !', NULL, 1, '2022-09-12 14:22:50', 0),
(3, '2022-09-13', 'argh', NULL, 1, '2022-09-12 15:42:46', 0),
(8, '2022-09-13', 'compterenduaaa', NULL, 1, NULL, 0),
(12, '2022-11-15', 'dada', NULL, 1, '2022-11-07 14:11:36', 2),
(15, '2022-09-27', 'niopdada', NULL, 1, NULL, 4),
(16, '2022-11-10', 'dada', NULL, 1, '2022-11-07 14:26:38', 0),
(17, '2022-11-10', 'dada', NULL, 1, '2022-11-07 14:26:46', 0),
(18, '2022-11-28', 'podkf', NULL, 1, '2022-11-07 14:27:38', 0),
(19, '2022-11-24', 'cccccccccccccc', NULL, 1, '2022-11-07 14:29:03', 5);

-- --------------------------------------------------------

--
-- Structure de la table `stage`
--

CREATE TABLE `stage` (
  `num` int(10) NOT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `adresse` varchar(100) DEFAULT NULL,
  `CP` int(10) DEFAULT NULL,
  `ville` varchar(40) DEFAULT NULL,
  `tel` int(30) DEFAULT NULL,
  `libelleStage` varchar(500) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `num_tuteur` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `stage`
--

INSERT INTO `stage` (`num`, `nom`, `adresse`, `CP`, `ville`, `tel`, `libelleStage`, `email`, `num_tuteur`) VALUES
(1, 'stage', '55 stage', 75017, 'Paris', 146265912, 'libelle', 'ladka@gmail.com', 1),
(2, 'stagenom', '1 rue pierre', 75010, 'Paris', 762626252, 'stage pierre', 'stage@gmail.com', 2),
(3, 'stagenom', '5 rue du chocolat', 75010, 'Paris', 76262571, 'libellestage', 'stage@gmail.com', 3);

-- --------------------------------------------------------

--
-- Structure de la table `tuteur`
--

CREATE TABLE `tuteur` (
  `num` int(10) NOT NULL,
  `nom` varchar(40) DEFAULT NULL,
  `prenom` varchar(40) DEFAULT NULL,
  `tel` int(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `tuteur`
--

INSERT INTO `tuteur` (`num`, `nom`, `prenom`, `tel`, `email`) VALUES
(1, 'tuteurnom', 'tuteurprenom', 66666666, 'emailtuteur@gmail.com'),
(2, 'tuteurnom', 'tuteurprenom', 651562154, 'dadaec@gmail.com'),
(3, 'tuteurnom', 'tuteurprenom', 762626258, 'dadz@gmail.com');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `num` int(10) NOT NULL,
  `nom` varchar(100) DEFAULT NULL,
  `prenom` varchar(100) DEFAULT NULL,
  `tel` int(20) DEFAULT NULL,
  `login` varchar(100) DEFAULT NULL,
  `motdepasse` varchar(100) DEFAULT NULL,
  `type` int(1) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `option` int(1) NOT NULL,
  `num_stage` int(10) DEFAULT NULL,
  `naissance` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`num`, `nom`, `prenom`, `tel`, `login`, `motdepasse`, `type`, `email`, `option`, `num_stage`, `naissance`) VALUES
(1, 'nom', 'prenom', 611111211, 'login', 'd56b699830e77ba53855679cb1d252da', 0, 'yepmtx@gmail.com', 1, 1, '2015-02-03'),
(2, 'deux', 'prenomdeux', 1515649626, 'login2', '3b38c223cd0767c5e6f40a7fb86159b4', 1, 'a@gmail.com', 1, NULL, '2003-12-03'),
(9, 'nom2', 'prenom2', 611111211, 'login', 'd56b699830e77ba53855679cb1d252da', 0, 'yepmtx@gmail.com', 1, 2, '2015-02-03');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `cr`
--
ALTER TABLE `cr`
  ADD PRIMARY KEY (`num`),
  ADD KEY `num_utilisateur` (`num_utilisateur`);

--
-- Index pour la table `stage`
--
ALTER TABLE `stage`
  ADD PRIMARY KEY (`num`),
  ADD KEY `FK_stage` (`num_tuteur`);

--
-- Index pour la table `tuteur`
--
ALTER TABLE `tuteur`
  ADD PRIMARY KEY (`num`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`num`),
  ADD KEY `FK_Uuser` (`num_stage`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `cr`
--
ALTER TABLE `cr`
  MODIFY `num` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT pour la table `stage`
--
ALTER TABLE `stage`
  MODIFY `num` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `tuteur`
--
ALTER TABLE `tuteur`
  MODIFY `num` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `num` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `cr`
--
ALTER TABLE `cr`
  ADD CONSTRAINT `FK_cr` FOREIGN KEY (`num_utilisateur`) REFERENCES `utilisateur` (`num`),
  ADD CONSTRAINT `cr_ibfk_1` FOREIGN KEY (`num_utilisateur`) REFERENCES `utilisateur` (`num`);

--
-- Contraintes pour la table `stage`
--
ALTER TABLE `stage`
  ADD CONSTRAINT `FK_stage` FOREIGN KEY (`num_tuteur`) REFERENCES `tuteur` (`num`);

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `FK_Uuser` FOREIGN KEY (`num_stage`) REFERENCES `stage` (`num`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
