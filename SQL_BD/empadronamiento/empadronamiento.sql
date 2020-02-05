-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema empadronamiento
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema empadronamiento
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `empadronamiento` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish2_ci ;
USE `empadronamiento` ;

-- -----------------------------------------------------
-- Table `empadronamiento`.`municipios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empadronamiento`.`municipios` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `codigo` VARCHAR(45) NULL,
  `nombre` VARCHAR(200) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empadronamiento`.`viviendas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empadronamiento`.`viviendas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `codigo` VARCHAR(45) NULL,
  `calle` VARCHAR(200) NULL,
  `numero` INT NULL,
  `municipio_id` INT NOT NULL,
  PRIMARY KEY (`id`, `municipio_id`),
  INDEX `fk_viviendas_municipios1_idx` (`municipio_id` ASC) VISIBLE,
  CONSTRAINT `fk_viviendas_municipios1`
    FOREIGN KEY (`municipio_id`)
    REFERENCES `empadronamiento`.`municipios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empadronamiento`.`personas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empadronamiento`.`personas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `dni` CHAR(9) NOT NULL,
  `nombre` VARCHAR(200) NULL,
  `apellidos` VARCHAR(200) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empadronamiento`.`personas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empadronamiento`.`personas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `dni` CHAR(9) NOT NULL,
  `nombre` VARCHAR(200) NULL,
  `apellidos` VARCHAR(200) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empadronamiento`.`municipios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empadronamiento`.`municipios` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `codigo` VARCHAR(45) NULL,
  `nombre` VARCHAR(200) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empadronamiento`.`viviendas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empadronamiento`.`viviendas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `codigo` VARCHAR(45) NULL,
  `calle` VARCHAR(200) NULL,
  `numero` INT NULL,
  `municipio_id` INT NOT NULL,
  PRIMARY KEY (`id`, `municipio_id`),
  INDEX `fk_viviendas_municipios1_idx` (`municipio_id` ASC) VISIBLE,
  CONSTRAINT `fk_viviendas_municipios1`
    FOREIGN KEY (`municipio_id`)
    REFERENCES `empadronamiento`.`municipios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empadronamiento`.`situacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empadronamiento`.`situacion` (
  `persona_id` INT NOT NULL,
  `vivienda_id` INT NOT NULL,
  `empadronado` TINYINT NULL,
  `propietario` TINYINT NULL,
  PRIMARY KEY (`persona_id`, `vivienda_id`),
  INDEX `fk_personas_has_viviendas_viviendas1_idx` (`vivienda_id` ASC) VISIBLE,
  INDEX `fk_personas_has_viviendas_personas1_idx` (`persona_id` ASC) VISIBLE,
  CONSTRAINT `fk_personas_has_viviendas_personas1`
    FOREIGN KEY (`persona_id`)
    REFERENCES `empadronamiento`.`personas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_personas_has_viviendas_viviendas1`
    FOREIGN KEY (`vivienda_id`)
    REFERENCES `empadronamiento`.`viviendas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
