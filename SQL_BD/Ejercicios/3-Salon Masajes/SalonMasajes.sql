-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema SalonDeMasajes
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema SalonDeMasajes
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `SalonDeMasajes` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish2_ci ;
USE `SalonDeMasajes` ;

-- -----------------------------------------------------
-- Table `SalonDeMasajes`.`servicios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SalonDeMasajes`.`servicios` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `precio` DECIMAL NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
COMMENT = '	';


-- -----------------------------------------------------
-- Table `SalonDeMasajes`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SalonDeMasajes`.`clientes` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(50) NOT NULL,
  `apellidos` VARCHAR(100) NOT NULL,
  `dni` VARCHAR(9) NOT NULL,
  `telefono` INT(9) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `dni_UNIQUE` (`dni` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SalonDeMasajes`.`trabajadores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SalonDeMasajes`.`trabajadores` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(50) NOT NULL,
  `apellidos` VARCHAR(100) NOT NULL,
  `dni` VARCHAR(9) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `dni_UNIQUE` (`dni` ASC) VISIBLE)
ENGINE = InnoDB
COMMENT = '						';


-- -----------------------------------------------------
-- Table `SalonDeMasajes`.`calificacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SalonDeMasajes`.`calificacion` (
  `id` INT NOT NULL,
  `valoracion` VARCHAR(20) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SalonDeMasajes`.`actuacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SalonDeMasajes`.`actuacion` (
  `servicios_id` INT NOT NULL,
  `trabajadores_id` INT NOT NULL,
  `clientes_id` INT NOT NULL,
  `fecha` DATETIME NOT NULL,
  `opinion` TEXT NULL,
  `calificacion_id` INT NULL,
  PRIMARY KEY (`servicios_id`, `trabajadores_id`, `clientes_id`, `fecha`),
  INDEX `fk_servicios_has_trabajadores_trabajadores1_idx` (`trabajadores_id` ASC) VISIBLE,
  INDEX `fk_servicios_has_trabajadores_servicios_idx` (`servicios_id` ASC) VISIBLE,
  INDEX `fk_servicios_has_trabajadores_valoraciones1_idx` (`calificacion_id` ASC) VISIBLE,
  INDEX `fk_servicios_has_trabajadores_clientes1_idx` (`clientes_id` ASC) VISIBLE,
  UNIQUE INDEX `actuacion_UNIQUE` (`servicios_id` ASC, `trabajadores_id` ASC, `clientes_id` ASC, `fecha` ASC) VISIBLE,
  CONSTRAINT `fk_servicios_has_trabajadores_servicios`
    FOREIGN KEY (`servicios_id`)
    REFERENCES `SalonDeMasajes`.`servicios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_servicios_has_trabajadores_trabajadores1`
    FOREIGN KEY (`trabajadores_id`)
    REFERENCES `SalonDeMasajes`.`trabajadores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_servicios_has_trabajadores_valoraciones1`
    FOREIGN KEY (`calificacion_id`)
    REFERENCES `SalonDeMasajes`.`calificacion` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_servicios_has_trabajadores_clientes1`
    FOREIGN KEY (`clientes_id`)
    REFERENCES `SalonDeMasajes`.`clientes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
