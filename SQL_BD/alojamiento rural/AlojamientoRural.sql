-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Alojamiento_rural
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Alojamiento_rural
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Alojamiento_rural` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish2_ci ;
USE `Alojamiento_rural` ;

-- -----------------------------------------------------
-- Table `Alojamiento_rural`.`trabajadores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Alojamiento_rural`.`trabajadores` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(200) NULL,
  `direccion` VARCHAR(200) NULL,
  `NIF` VARCHAR(9) NULL,
  `alojamiento_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_trabajadores_alojamientos_idx` (`alojamiento_id` ASC) VISIBLE,
  CONSTRAINT `fk_trabajadores_alojamientos`
    FOREIGN KEY (`alojamiento_id`)
    REFERENCES `Alojamiento_rural`.`alojamientos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '				';


-- -----------------------------------------------------
-- Table `Alojamiento_rural`.`alojamientos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Alojamiento_rural`.`alojamientos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(200) NULL,
  `direccion` VARCHAR(45) NULL,
  `telefono` INT(9) NULL,
  `persona_contacto` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_alojamientos_trabajadores1_idx` (`persona_contacto` ASC) VISIBLE,
  CONSTRAINT `fk_alojamientos_trabajadores1`
    FOREIGN KEY (`persona_contacto`)
    REFERENCES `Alojamiento_rural`.`trabajadores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Alojamiento_rural`.`tipos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Alojamiento_rural`.`tipos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(20) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Alojamiento_rural`.`habitaciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Alojamiento_rural`.`habitaciones` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `wc` TINYINT NULL,
  `precio` DECIMAL NULL,
  `tipo_id` INT NOT NULL,
  `alojamiento_id` INT NOT NULL,
  PRIMARY KEY (`id`, `tipo_id`),
  INDEX `fk_habitaciones_tipos1_idx` (`tipo_id` ASC) VISIBLE,
  INDEX `fk_habitaciones_alojamientos1_idx` (`alojamiento_id` ASC) VISIBLE,
  CONSTRAINT `fk_habitaciones_tipos1`
    FOREIGN KEY (`tipo_id`)
    REFERENCES `Alojamiento_rural`.`tipos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_habitaciones_alojamientos1`
    FOREIGN KEY (`alojamiento_id`)
    REFERENCES `Alojamiento_rural`.`alojamientos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Alojamiento_rural`.`actividades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Alojamiento_rural`.`actividades` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(200) NULL,
  `descripcion` VARCHAR(200) NULL,
  `nivel` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
COMMENT = '		';


-- -----------------------------------------------------
-- Table `Alojamiento_rural`.`alojamientos_has_actividades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Alojamiento_rural`.`alojamientos_has_actividades` (
  `alojamiento_id` INT NOT NULL,
  `actividad_id` INT NOT NULL,
  `dias` VARCHAR(45) NULL,
  PRIMARY KEY (`alojamiento_id`, `actividad_id`),
  INDEX `fk_alojamientos_has_actividades_actividades1_idx` (`actividad_id` ASC) VISIBLE,
  INDEX `fk_alojamientos_has_actividades_alojamientos1_idx` (`alojamiento_id` ASC) VISIBLE,
  CONSTRAINT `fk_alojamientos_has_actividades_alojamientos1`
    FOREIGN KEY (`alojamiento_id`)
    REFERENCES `Alojamiento_rural`.`alojamientos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_alojamientos_has_actividades_actividades1`
    FOREIGN KEY (`actividad_id`)
    REFERENCES `Alojamiento_rural`.`actividades` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
