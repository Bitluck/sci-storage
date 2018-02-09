-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Фев 09 2018 г., 15:05
-- Версия сервера: 5.5.25
-- Версия PHP: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `scicatalog`
--
CREATE DATABASE `scicatalog` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `scicatalog`;

-- --------------------------------------------------------

--
-- Структура таблицы `sc_article`
--

CREATE TABLE IF NOT EXISTS `sc_article` (
  `a_id` int(11) NOT NULL AUTO_INCREMENT,
  `a_title` varchar(200) NOT NULL,
  `a_authors` varchar(300) NOT NULL,
  `a_upload_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `a_owner_id` int(11) NOT NULL,
  `a_category_id` int(11) NOT NULL,
  `a_path` varchar(200) NOT NULL,
  `a_tags` varchar(100) NOT NULL,
  `a_annotation` varchar(1000) NOT NULL,
  PRIMARY KEY (`a_id`),
  UNIQUE KEY `a_title` (`a_title`),
  KEY `a_owner_id` (`a_owner_id`),
  KEY `a_category_id` (`a_category_id`),
  KEY `a_owner_id_2` (`a_owner_id`),
  KEY `a_owner_id_3` (`a_owner_id`),
  KEY `a_owner_id_4` (`a_owner_id`),
  KEY `a_owner_id_5` (`a_owner_id`),
  KEY `a_category_id_2` (`a_category_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=140 ;

--
-- Дамп данных таблицы `sc_article`
--

INSERT INTO `sc_article` (`a_id`, `a_title`, `a_authors`, `a_upload_date`, `a_owner_id`, `a_category_id`, `a_path`, `a_tags`, `a_annotation`) VALUES
(129, 'QUARK DYNAMICS IN ATOMIC NUCLEI AND QUARK SHELLS', 'Alexander Trunev', '2018-02-08 10:49:30', 69, 5, '1413718959_dinamika-kvarkov-v-atomnyh-yadrah-i-kvarkovye-obolochki.pdf', 'BINDING ENERGY, QUARKS, MAGNETIC MOMENT, METRIC, PROTON, NEUTRON, NUCLEI', 'In this paper we consider a system of Dirac equations describing the dynamics of quarks in the metric of the atomic nuclei. We found out, that the binding energy of the nucleons for all known nuclides depends on the content of the quarks. The resulting dependence of the energy of the nucleons shows a quark shells, similar electron shells.'),
(130, 'HIGH ACCURACY SEMIDEFINITE PROGRAMMING BOUNDS FOR KISSING NUMBERS', 'HANS D. MITTELMANN AND FRANK VALLENTIN', '2018-02-08 10:56:37', 69, 3, '2081736319_High accuracy semidefinite programming bounds for kissing numbers.pdf', 'KISSING NUMBERS, SPHERE PACKING', 'The kissing number in n-dimensional Euclidean space is the maximal\r\nnumber of non-overlapping unit spheres which simultaneously can touch\r\na central unit sphere. Bachoc and Vallentin developed a method to find upper\r\nbounds for the kissing number based on semidefinite programming. This paper\r\nis a report on high accuracy calculations of these upper bounds for n â¤ 24.\r\nThe bound for n = 16 implies a conjecture of Conway and Sloane.'),
(132, 'The Upgraded DÃ Detector', 'DÃ Collaboration', '2018-02-08 11:23:04', 68, 5, '1084133372_LHC.pdf', 'Fermilab, DZero, D0, detector', 'The DÃ experiment enjoyed a very successful data-collection run at the Fermilab Tevatron collider between 1992 and 1996. Since then, the detector has been upgraded to take advantage of improvements to the Tevatron and to enhance its physics capabilities. We describe the new elements of the detector, including the silicon microstrip tracker, central fiber tracker, solenoidal magnet, preshower detectors, forward muon detector, and forward proton detector. The uranium/liquid-argon\r\ncalorimeters and central muon detector, remaining from Run I, are discussed briefly. We also present the associated electronics, triggering, and data acquisition systems, along with the design and implementation of software specific to DÃ.'),
(133, 'Overview of Java application configuration frameworks', 'Victor S. Denisov', '2018-02-08 11:29:28', 68, 6, '560271618_overview-of-java-application-configuration-frameworks.pdf', 'application configuration management, application settings management, framework, Java', 'This paper reviews three major application\r\nconfiguration frameworks for Java-based applications: java.util.Properties, Apache Commons Configuration and Preferences API. Basic functionality of each framework is illustrated with code examples. Pros and cons of each framework are described in moderate detail. Suggestions are made about typical use cases for each framework.'),
(134, 'The Riemann Zeta Function', 'John Winter', '2018-02-08 11:35:23', 70, 3, '957592344_The Riemann Zeta Function.pdf', 'MATH, Riemann, Riemann Zeta Function, ZETA', 'In this note, I will sketch some of the main properties of the Riemann zeta function,\nÎ¶(x). For x > 1, we define.'),
(135, 'Zen', 'Wikipedia', '2018-02-08 11:37:57', 70, 4, '1983506862_Дзен.pdf', 'Zen, East, Spirit', 'Chan (Chinese: ç¦ª; pinyin: ChÃ¡n; Korean: ì ) is a school of Mahayana Buddhism that originated in China during the Tang dynasty as Chan Buddhism. Zen school was strongly influenced by Taoism and developed as a distinct school of Chinese Buddhism. From China, Chan Buddhism spread south to Vietnam, northeast to Korea and east to Japan, where it became known as Japanese Zen and known as Seon Buddhism in Korea.'),
(136, 'The Medical & Scientific Approval of Hypnotherapy', ' Donald Robertson', '2018-02-08 12:16:02', 71, 7, '495350888_Hypnosis-Medical-Scientific-Article.pdf', 'hypnosis, hypnotherapy, neurypnology', 'The therapeutic use of âtranceâ, in its generic sense, is found in virtually every culture across the world and most likely stretches back into ancient prehistory. The hypnotic state as we know it today has its precursor in the convulsive âemotional crisesâ and âsomnambulistic trancesâ of 18th century mesmerism. However, the modern scientific understanding of hypnosis really originated with the pioneering work of a Scottish physician named James Braid (1795-1860). Braid, who coined the term âhypnotismâ, categorically rejected any supernatural explanations of âtranceâ and grounded the study of hypnosis on a firm neuro-psychological basis, publishing his findings in Neurypnology (1843), arguably the first book on âhypnotherapyâ per se.'),
(137, 'THE CHOICE OF SORBENT FOR ADSORPTION EXTRACTION OF CHLOROFORM FROM DRINKING WATER', 'T. A. Krasnova, I. V. Timoshchuk, A. K. Gorelkina, and J. Dugarjav', '2018-02-08 12:18:51', 71, 7, '2003510319_the-choice-of-sorbent-for-adsorption-extraction-of-chloroform-from-drinking-water.pdf', 'Adsorption, active carbons, polymeric sorbents, chloroform', 'At present, providing the population with clean drinking water is one of the most important urgent problems of our time. Due to seasonal changes in water composition and violation of water treatment technology, the conventional process is not always effective to ensure water purification of organic compounds.'),
(138, 'Bioinformatics and tools for computer analysis and visualization of macromolecules', 'Dmitry A. Tikhvinskiy, Yuri B. Porozov', '2018-02-08 12:25:54', 72, 6, '284322014_bioinformatics-and-tools-for-computer-analysis-and-visualization-of-macromolecules.pdf', 'bioinformatics, scientific visualization, macromolecules', 'The goals and objectives of some topics of structural bioinformatics are presented in the article. The main methods and approaches used in computer biology are highlighted. Areas in which bioinformatic science can greatly facilitate and speed up the work of practical biologist and pharmacologist are revealed. The features of both the basic packages and software devices for complete, thorough analysis of macromolecules and for development and modeling of ligands and binding centers are described.'),
(139, 'COMPUTER OPTICS AND ITS DEVELOPMENT', 'Yang-Xun, Yang-Xiao', '2018-02-08 12:29:39', 72, 6, '1528717110_computer-optics-and-its-development.pdf', 'COMPUTER OPTICS, DEVELOPMENT, OPTICS TECHNOLOGIES', 'Nowadays, many important discipline intercourse and penetrate each other. New subjects are sprung up without end. A new technology revolution is rising over the world. Mankind are facing the severe challenge of information science and technology.');

-- --------------------------------------------------------

--
-- Структура таблицы `sc_category`
--

CREATE TABLE IF NOT EXISTS `sc_category` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(100) NOT NULL,
  `c_description` varchar(500) NOT NULL,
  PRIMARY KEY (`c_id`),
  UNIQUE KEY `c_name` (`c_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- Дамп данных таблицы `sc_category`
--

INSERT INTO `sc_category` (`c_id`, `c_name`, `c_description`) VALUES
(3, 'mathematics', 'Articles of mathematics themes.'),
(4, 'spirit', 'Articles of spirit themes.'),
(5, 'physics', 'Articles of physics themes.'),
(6, 'computer science', 'Articles of computer science themes.'),
(7, 'medicine', 'Articles of medicine themes.');

-- --------------------------------------------------------

--
-- Структура таблицы `sc_user`
--

CREATE TABLE IF NOT EXISTS `sc_user` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_email` varchar(50) NOT NULL,
  `u_password` varchar(32) NOT NULL,
  `u_first_name` varchar(50) NOT NULL,
  `u_last_name` varchar(50) NOT NULL,
  `u_register_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`u_id`),
  UNIQUE KEY `u_email` (`u_email`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=73 ;

--
-- Дамп данных таблицы `sc_user`
--

INSERT INTO `sc_user` (`u_id`, `u_email`, `u_password`, `u_first_name`, `u_last_name`, `u_register_date`) VALUES
(68, 'user1', 'useruser', 'us', 'er', '2018-02-07 17:53:23'),
(69, 'test', 'test', 'test', 'testov', '2018-02-07 17:54:00'),
(70, 'qwerty', '`1234`', 'first', 'last', '2018-02-07 17:56:54'),
(71, 'asd', '********', '***', '*******', '2018-02-07 17:57:20'),
(72, 'username', 'password', 'name', 'asd', '2018-02-07 17:58:46');

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `sc_article`
--
ALTER TABLE `sc_article`
  ADD CONSTRAINT `sc_article_ibfk_1` FOREIGN KEY (`a_owner_id`) REFERENCES `sc_user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sc_article_ibfk_2` FOREIGN KEY (`a_category_id`) REFERENCES `sc_category` (`c_id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
