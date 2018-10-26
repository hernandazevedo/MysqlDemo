-- DDL
CREATE DATABASE PROJETO5;

USE PROJETO5;

CREATE TABLE `livro` (
  `idlivro` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) NOT NULL,
  `preco` float DEFAULT NULL,
  `estoque` int(11) DEFAULT 0,
  `idgenero` int(11) NOT NULL,
  `ideditora` int(11) NOT NULL,
  PRIMARY KEY (`idlivro`,`idgenero`,`ideditora`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

  INSERT INTO `livro` (titulo, preco, estoque, idgenero, ideditora) 
values ('livro1', 20,1,1,1); 