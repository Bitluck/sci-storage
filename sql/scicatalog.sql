-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Янв 17 2018 г., 12:14
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
  PRIMARY KEY (`a_id`),
  UNIQUE KEY `a_title` (`a_title`),
  KEY `a_owner_id` (`a_owner_id`),
  KEY `a_category_id` (`a_category_id`),
  KEY `a_owner_id_2` (`a_owner_id`),
  KEY `a_owner_id_3` (`a_owner_id`),
  KEY `a_owner_id_4` (`a_owner_id`),
  KEY `a_owner_id_5` (`a_owner_id`),
  KEY `a_category_id_2` (`a_category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Структура таблицы `sc_category`
--

CREATE TABLE IF NOT EXISTS `sc_category` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(100) NOT NULL,
  `c_description` varchar(500) NOT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `sc_article`
--
ALTER TABLE `sc_article`
  ADD CONSTRAINT `sc_article_ibfk_2` FOREIGN KEY (`a_category_id`) REFERENCES `sc_category` (`c_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sc_article_ibfk_1` FOREIGN KEY (`a_owner_id`) REFERENCES `sc_user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE;
  
ALTER TABLE  `sc_category` ADD UNIQUE (
`c_name`
)

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
