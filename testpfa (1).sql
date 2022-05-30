-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 27 mai 2022 à 02:52
-- Version du serveur : 10.4.24-MariaDB
-- Version de PHP : 8.0.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `testpfa`
--

-- --------------------------------------------------------

--
-- Structure de la table `affectation`
--

CREATE TABLE `affectation` (
  `id` int(11) NOT NULL,
  `date_fin` date DEFAULT NULL,
  `datedebut` date DEFAULT NULL,
  `boitier_id` int(11) DEFAULT NULL,
  `parcelle_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `alert`
--

CREATE TABLE `alert` (
  `id` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  `humidite` float DEFAULT NULL,
  `luminosite` float DEFAULT NULL,
  `temperature` float DEFAULT NULL,
  `boitier_id` int(11) DEFAULT NULL,
  `parcelle_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `alert`
--

INSERT INTO `alert` (`id`, `date`, `humidite`, `luminosite`, `temperature`, `boitier_id`, `parcelle_id`) VALUES
(580, '1900-01-05', 7, NULL, NULL, NULL, 8),
(579, '1900-01-19', 7, NULL, NULL, NULL, 7),
(578, '2022-05-11', NULL, 7, NULL, NULL, 6),
(577, '2022-05-19', NULL, NULL, 62, NULL, 6),
(576, '2022-05-18', NULL, NULL, 20, NULL, 6),
(575, '2022-05-17', NULL, NULL, 12, NULL, 6),
(574, '2022-05-03', 7, NULL, NULL, NULL, 6),
(573, '2022-05-02', 7, NULL, NULL, NULL, 6),
(572, '2022-05-01', 7, NULL, NULL, NULL, 6);

-- --------------------------------------------------------

--
-- Structure de la table `boitier`
--

CREATE TABLE `boitier` (
  `id` int(11) NOT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `branche`
--

CREATE TABLE `branche` (
  `id` int(11) NOT NULL,
  `branche` int(11) NOT NULL,
  `boitier_id` int(11) DEFAULT NULL,
  `capteur_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `capteur`
--

CREATE TABLE `capteur` (
  `id` int(11) NOT NULL,
  `description` float DEFAULT NULL,
  `image` float DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `employe`
--

CREATE TABLE `employe` (
  `id` int(11) NOT NULL,
  `date_embauche` date DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `salaire` double NOT NULL,
  `machine_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `ferme`
--

CREATE TABLE `ferme` (
  `id` int(11) NOT NULL,
  `nbr_parcel` int(11) NOT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `user_user_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `ferme`
--

INSERT INTO `ferme` (`id`, `nbr_parcel`, `photo`, `user_user_id`) VALUES
(75, 10, 'img/fermes/ticketing.png', 2),
(76, 200, 'img/fermes/download (3).jpg', 2),
(77, 8000, 'img/fermes/plante7.jpg', 2);

-- --------------------------------------------------------

--
-- Structure de la table `grandeur`
--

CREATE TABLE `grandeur` (
  `id` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `valeur` float DEFAULT NULL,
  `parcelle_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `grandeur`
--

INSERT INTO `grandeur` (`id`, `date`, `type`, `valeur`, `parcelle_id`) VALUES
(16, '1900-01-05', 'humedite', 7, 8),
(15, '1900-01-19', 'humedite', 1, 7),
(14, '2022-05-01', 'humedite', 4, 6),
(13, '2022-05-02', 'humedite', 5, 6),
(12, '2022-05-03', 'humedite', 7, 6),
(17, '2022-05-17', 'temperature', 12, 6),
(18, '2022-05-18', 'temperature', 20, 6),
(19, '2022-05-19', 'temperature', 62, 6),
(20, '2022-05-11', 'luminosite', 7, 6),
(21, '2022-05-19', 'temperature', 32, 6),
(22, '2022-05-20', 'temperature', 10, 6),
(23, '2022-05-21', 'temperature', 42, 6),
(24, '2022-05-22', 'temperature', 32, 6),
(25, '2022-05-23', 'temperature', 12, 6);

-- --------------------------------------------------------

--
-- Structure de la table `historique`
--

CREATE TABLE `historique` (
  `id` int(11) NOT NULL,
  `string_arosage` varchar(255) DEFAULT NULL,
  `qtt_eau` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `machine`
--

CREATE TABLE `machine` (
  `id` int(11) NOT NULL,
  `date_achat` date DEFAULT NULL,
  `prix` double NOT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `marque_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `marque`
--

CREATE TABLE `marque` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `parcelle`
--

CREATE TABLE `parcelle` (
  `id` int(11) NOT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `surface` float NOT NULL,
  `ferme_id` int(11) DEFAULT NULL,
  `type_sole_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `parcelle`
--

INSERT INTO `parcelle` (`id`, `photo`, `surface`, `ferme_id`, `type_sole_id`) VALUES
(6, 'img/parcelles/download (3).jpg', 3000, 76, 3),
(7, 'img/parcelles/smart.jpg', 2000, 75, 3),
(8, 'img/parcelles/ticketing.png', 1000, 75, 1),
(23, 'img/parcelles/parcelle5.jpg', 10, 77, 2);

-- --------------------------------------------------------

--
-- Structure de la table `plantage`
--

CREATE TABLE `plantage` (
  `id` int(11) NOT NULL,
  `string` varchar(255) DEFAULT NULL,
  `dateplantage` date DEFAULT NULL,
  `nbrplante` int(11) NOT NULL,
  `parcelle_id` int(11) DEFAULT NULL,
  `plante_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `plantage`
--

INSERT INTO `plantage` (`id`, `string`, `dateplantage`, `nbrplante`, `parcelle_id`, `plante_id`) VALUES
(2, 'plantage 1', '2022-05-25', 100, 6, 5),
(3, 'plantage 2', '2022-05-31', 10, 6, 6),
(4, 'plantage 3', '2022-06-01', 15, 6, 7);

-- --------------------------------------------------------

--
-- Structure de la table `plante`
--

CREATE TABLE `plante` (
  `id` int(11) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `racine` varchar(255) DEFAULT NULL,
  `type_plante_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `plante`
--

INSERT INTO `plante` (`id`, `libelle`, `photo`, `racine`, `type_plante_id`) VALUES
(5, 'blé', 'img/plantes/plante9.jpg', 'napiformes', 1),
(6, 'alwivera', 'img/plantes/plante10.jpg', 'napiformes', 2),
(7, 'Oignons', 'img/plantes/plante6.jpg', 'de stockage', 3);

-- --------------------------------------------------------

--
-- Structure de la table `privilige`
--

CREATE TABLE `privilige` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `date_achat` date DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prix` double NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `role`
--

INSERT INTO `role` (`id`, `nome`) VALUES
(1, 'Administrateur'),
(2, 'Agreculteur');

-- --------------------------------------------------------

--
-- Structure de la table `type_plante`
--

CREATE TABLE `type_plante` (
  `id` int(11) NOT NULL,
  `etat` varchar(255) DEFAULT NULL,
  `humidite_max` float DEFAULT NULL,
  `humidite_min` float DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `luminosite` float DEFAULT NULL,
  `temperature_max` float DEFAULT NULL,
  `temperature_min` float DEFAULT NULL,
  `temperature` float DEFAULT NULL,
  `besoin_deau` float DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `type_plante`
--

INSERT INTO `type_plante` (`id`, `etat`, `humidite_max`, `humidite_min`, `libelle`, `luminosite`, `temperature_max`, `temperature_min`, `temperature`, `besoin_deau`) VALUES
(1, 'etat 1', 20, 8, 'type 1', 10, 40, 34, NULL, 0.5),
(2, 'etat 1', 40, 8, 'type 2', 10, 40, 34, NULL, 0.7),
(3, 'etat 2', 30, 8, 'type 3', 20, 50, 44, NULL, 1.5);

-- --------------------------------------------------------

--
-- Structure de la table `type_sole`
--

CREATE TABLE `type_sole` (
  `id` int(11) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `type_sole`
--

INSERT INTO `type_sole` (`id`, `libelle`, `type`) VALUES
(1, 'type 1', 'type 1'),
(2, 'type 2', 'type 2'),
(3, 'type 3', 'type 3'),
(11, 'type 4', 'type 4');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`user_id`, `email`, `password`, `username`, `role_id`) VALUES
(1, 'admin@gmail.com', 'admin', 'admin', 1),
(2, 'agreculteur@gmail.com', 'agreculteur', 'agreculteur', 2);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `affectation`
--
ALTER TABLE `affectation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKexlrkpup0yecnpi7077nikwr0` (`boitier_id`),
  ADD KEY `FKd3jopo3va78u6frlk4xvd110r` (`parcelle_id`);

--
-- Index pour la table `alert`
--
ALTER TABLE `alert`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKca83sxq1fqria08p9uvfjh6e6` (`boitier_id`),
  ADD KEY `FKpah6rkm7h95xn13m1mu8n200` (`parcelle_id`);

--
-- Index pour la table `boitier`
--
ALTER TABLE `boitier`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `branche`
--
ALTER TABLE `branche`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK2fusp2f8l3v1eh8oajoioxg5v` (`boitier_id`),
  ADD KEY `FKdlkfve9t65spqac9m7rwlfec8` (`capteur_id`);

--
-- Index pour la table `capteur`
--
ALTER TABLE `capteur`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `employe`
--
ALTER TABLE `employe`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKfixoboo5se1vgn9olbq8rlprc` (`machine_id`);

--
-- Index pour la table `ferme`
--
ALTER TABLE `ferme`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3pvtcnq4k6kiwmyn3ma8auk0u` (`user_user_id`);

--
-- Index pour la table `grandeur`
--
ALTER TABLE `grandeur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKlphcui5oygjx0n0b2w07irji0` (`parcelle_id`);

--
-- Index pour la table `historique`
--
ALTER TABLE `historique`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `machine`
--
ALTER TABLE `machine`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKersxyhbmn35gwyprdybaoy73b` (`marque_id`);

--
-- Index pour la table `marque`
--
ALTER TABLE `marque`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `parcelle`
--
ALTER TABLE `parcelle`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKjmgo5kb6kll2ruq6hb0twxwg9` (`ferme_id`),
  ADD KEY `FKlmrmcnl28uaibbexm80iexvtv` (`type_sole_id`);

--
-- Index pour la table `plantage`
--
ALTER TABLE `plantage`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKj1f8ldnxqoeujjwbdq9wrngw1` (`parcelle_id`),
  ADD KEY `FKodihn7crutkhm0m21byfoipks` (`plante_id`);

--
-- Index pour la table `plante`
--
ALTER TABLE `plante`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmykk93ysnuqmdctl5kjgqsxjw` (`type_plante_id`);

--
-- Index pour la table `privilige`
--
ALTER TABLE `privilige`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK43bnjksu2inxvcjtv48b43ajv` (`role_id`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `type_plante`
--
ALTER TABLE `type_plante`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `type_sole`
--
ALTER TABLE `type_sole`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD KEY `FKn82ha3ccdebhokx3a8fgdqeyy` (`role_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `affectation`
--
ALTER TABLE `affectation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `alert`
--
ALTER TABLE `alert`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=581;

--
-- AUTO_INCREMENT pour la table `boitier`
--
ALTER TABLE `boitier`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `branche`
--
ALTER TABLE `branche`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `capteur`
--
ALTER TABLE `capteur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `employe`
--
ALTER TABLE `employe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `ferme`
--
ALTER TABLE `ferme`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=79;

--
-- AUTO_INCREMENT pour la table `grandeur`
--
ALTER TABLE `grandeur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT pour la table `historique`
--
ALTER TABLE `historique`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `machine`
--
ALTER TABLE `machine`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `marque`
--
ALTER TABLE `marque`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `parcelle`
--
ALTER TABLE `parcelle`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT pour la table `plantage`
--
ALTER TABLE `plantage`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `plante`
--
ALTER TABLE `plante`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `privilige`
--
ALTER TABLE `privilige`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `type_plante`
--
ALTER TABLE `type_plante`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `type_sole`
--
ALTER TABLE `type_sole`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
