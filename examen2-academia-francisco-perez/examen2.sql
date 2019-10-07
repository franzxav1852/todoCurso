-- MySQL Script generated by MySQL Workbench
-- Fri Sep 20 15:30:59 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema examen2
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema examen2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `examen2` DEFAULT CHARACTER SET utf8 ;
USE `examen2` ;

-- -----------------------------------------------------
-- Table `examen2`.`description`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `examen2`.`description` (
  `idDescription` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  `category` VARCHAR(45) NOT NULL,
  `precio` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idDescription`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `examen2`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `examen2`.`product` (
  `idProduct` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `precio` VARCHAR(45) NOT NULL,
  `Description_idDescription` INT(11) NOT NULL,
  PRIMARY KEY (`idProduct`),
  INDEX `fk_Product_Description_idx` (`Description_idDescription` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
