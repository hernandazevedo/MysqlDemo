-- DDL
CREATE DATABASE PROJETO5;

USE PROJETO5;

CREATE TABLE `agenda` (
  `idagenda` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `telefone` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT 0,
  `endereco` character varying(100) NOT NULL,
  PRIMARY KEY (`idagenda`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 
        'root';