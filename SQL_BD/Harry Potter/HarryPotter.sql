-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Harry_Potter
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Harry_Potter
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Harry_Potter` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish2_ci ;
USE `Harry_Potter` ;

-- -----------------------------------------------------
-- Table `Harry_Potter`.`profesores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Harry_Potter`.`profesores` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
COMMENT = '				';


-- -----------------------------------------------------
-- Table `Harry_Potter`.`casas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Harry_Potter`.`casas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `fundador/a` VARCHAR(100) NOT NULL,
  `jefe_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_casas_profesores1_idx` (`jefe_id` ASC) VISIBLE,
  CONSTRAINT `fk_casas_profesores1`
    FOREIGN KEY (`jefe_id`)
    REFERENCES `Harry_Potter`.`profesores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '			';


-- -----------------------------------------------------
-- Table `Harry_Potter`.`habitaciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Harry_Potter`.`habitaciones` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `numero_camas` VARCHAR(45) NOT NULL,
  `casa_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_habitaciones_casas1_idx` (`casa_id` ASC) VISIBLE,
  CONSTRAINT `fk_habitaciones_casas1`
    FOREIGN KEY (`casa_id`)
    REFERENCES `Harry_Potter`.`casas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Harry_Potter`.`alumnos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Harry_Potter`.`alumnos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(200) NOT NULL,
  `apellidos` VARCHAR(200) NOT NULL,
  `numero_mago` INT NOT NULL,
  `año_nacimiento` DATETIME NOT NULL,
  `casa_id` INT NOT NULL,
  `habitacion_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_alumnos_casas_idx` (`casa_id` ASC) VISIBLE,
  INDEX `fk_alumnos_habitaciones1_idx` (`habitacion_id` ASC) VISIBLE,
  CONSTRAINT `fk_alumnos_casas`
    FOREIGN KEY (`casa_id`)
    REFERENCES `Harry_Potter`.`casas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_alumnos_habitaciones1`
    FOREIGN KEY (`habitacion_id`)
    REFERENCES `Harry_Potter`.`habitaciones` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Harry_Potter`.`asignaturas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Harry_Potter`.`asignaturas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Harry_Potter`.`cursos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Harry_Potter`.`cursos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATETIME NOT NULL,
  `alumnos_id` INT NOT NULL,
  `asignaturas_id` INT NOT NULL,
  `profesores_id` INT NOT NULL,
  `nota` DECIMAL NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cursos_asignaturas1_idx` (`asignaturas_id` ASC) VISIBLE,
  INDEX `fk_cursos_profesores1_idx` (`profesores_id` ASC) VISIBLE,
  INDEX `fk_cursos_alumnos1_idx` (`alumnos_id` ASC) VISIBLE,
  CONSTRAINT `fk_cursos_asignaturas1`
    FOREIGN KEY (`asignaturas_id`)
    REFERENCES `Harry_Potter`.`asignaturas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cursos_profesores1`
    FOREIGN KEY (`profesores_id`)
    REFERENCES `Harry_Potter`.`profesores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cursos_alumnos1`
    FOREIGN KEY (`alumnos_id`)
    REFERENCES `Harry_Potter`.`alumnos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Harry_Potter`.`partidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Harry_Potter`.`partidos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATETIME NOT NULL,
  `resultado` VARCHAR(45) NOT NULL,
  `arbitro_id` INT NOT NULL,
  `mvp_id` INT NOT NULL,
  `casa1_id` INT NOT NULL,
  `casa2_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_historial_partidos_profesores1_idx` (`arbitro_id` ASC) VISIBLE,
  INDEX `fk_partidos_alumnos1_idx` (`mvp_id` ASC) VISIBLE,
  INDEX `fk_partidos_casas2_idx` (`casa1_id` ASC) VISIBLE,
  INDEX `fk_partidos_casas1_idx` (`casa2_id` ASC) VISIBLE,
  CONSTRAINT `fk_historial_partidos_profesores1`
    FOREIGN KEY (`arbitro_id`)
    REFERENCES `Harry_Potter`.`profesores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_partidos_alumnos1`
    FOREIGN KEY (`mvp_id`)
    REFERENCES `Harry_Potter`.`alumnos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_partidos_casas2`
    FOREIGN KEY (`casa1_id`)
    REFERENCES `Harry_Potter`.`casas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_partidos_casas1`
    FOREIGN KEY (`casa2_id`)
    REFERENCES `Harry_Potter`.`casas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Harry_Potter`.`alumnos_has_partidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Harry_Potter`.`alumnos_has_partidos` (
  `alumno_id` INT NOT NULL,
  `partido_id` INT NOT NULL,
  PRIMARY KEY (`alumno_id`, `partido_id`),
  INDEX `fk_alumnos_has_partidos_partidos1_idx` (`partido_id` ASC) VISIBLE,
  INDEX `fk_alumnos_has_partidos_alumnos1_idx` (`alumno_id` ASC) VISIBLE,
  CONSTRAINT `fk_alumnos_has_partidos_alumnos1`
    FOREIGN KEY (`alumno_id`)
    REFERENCES `Harry_Potter`.`alumnos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_alumnos_has_partidos_partidos1`
    FOREIGN KEY (`partido_id`)
    REFERENCES `Harry_Potter`.`partidos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
