-- phpMyAdmin SQL Dump
-- version 3.2.0.1
-- http://www.phpmyadmin.net
--
-- Serveur: localhost
-- Généré le : Dim 17 Août 2014 à 20:16
-- Version du serveur: 5.1.30
-- Version de PHP: 5.3.0

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `gestionpersonnel`
--

-- --------------------------------------------------------

--
-- Structure de la table `directeur`
--

CREATE TABLE IF NOT EXISTS `directeur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) DEFAULT NULL,
  `prenom` varchar(20) DEFAULT NULL,
  `sexe` varchar(20) DEFAULT NULL,
  `dateNaissance` varchar(20) DEFAULT NULL,
  `ville` varchar(20) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `Email` varchar(20) DEFAULT NULL,
  `motDePasse` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `directeur`
--

INSERT INTO `directeur` (`id`, `nom`, `prenom`, `sexe`, `dateNaissance`, `ville`, `telephone`, `Email`, `motDePasse`) VALUES
(2, 'Zarouk', 'Amine', 'Homme', '12/02/1985', 'Fes', '0669621432', 'Zarouk_Amine@gmail.f', ' ');

-- --------------------------------------------------------

--
-- Structure de la table `employe`
--

CREATE TABLE IF NOT EXISTS `employe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) DEFAULT NULL,
  `prenom` varchar(20) DEFAULT NULL,
  `sexe` varchar(20) DEFAULT NULL,
  `dateNaissance` varchar(20) DEFAULT NULL,
  `ville` varchar(20) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `Email` varchar(40) DEFAULT NULL,
  `motDePasse` varchar(20) DEFAULT NULL,
  `poste` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=58 ;

--
-- Contenu de la table `employe`
--

INSERT INTO `employe` (`id`, `nom`, `prenom`, `sexe`, `dateNaissance`, `ville`, `telephone`, `Email`, `motDePasse`, `poste`) VALUES
(49, 'Senhaji', 'Mustapha', 'Homme', '09/08/1989', 'Fes', '0669621455', 'senhaji_Mustapha@hotmail.com', '2', 'Chef Projets'),
(52, 'Senhaji', 'Mahmoud', 'Homme', '15/05/1991', 'Fes', '0669621434', 'sema_ma@hotmail.fr', '1', 'Developpeur'),
(38, 'badaoui', 'Ikram', 'Femme', '12/02/1989', 'Fes', '0669632541', 'Badaoui_Ikram@gmail.fr', '2', 'Chef Projets'),
(54, 'Senhaji', 'Zouhair', 'Homme', '19/08/2014', 'Fes', '0669621434', 'Senhaji_Zouhair@gmail.fr', '3', 'Developpeur');
