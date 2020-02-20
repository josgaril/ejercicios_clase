-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema ejercicios_sql
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ejercicios_sql
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ejercicios_sql` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci ;
USE `ejercicios_sql` ;

-- -----------------------------------------------------
-- Table `ejercicios_sql`.`empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ejercicios_sql`.`empleado` (
  `nDIEmp` VARCHAR(12) NOT NULL,
  `nomEmp` VARCHAR(30) NOT NULL,
  `sexEmp` CHAR(1) NOT NULL,
  `fecNac` DATE NOT NULL,
  `fecIncorporacion` DATE NOT NULL,
  `salEmp` FLOAT NOT NULL,
  `comisionE` FLOAT NOT NULL,
  `cargoE` VARCHAR(15) NOT NULL,
  `jefeID` VARCHAR(12) NULL,
  `codDepto` VARCHAR(4) NOT NULL,
  PRIMARY KEY (`nDIEmp`),
  INDEX `fk_empleado_departamento_idx` (`codDepto` ASC) VISIBLE,
  INDEX `fk_empleado_empleado1_idx` (`jefeID` ASC) VISIBLE,
  CONSTRAINT `fk_empleado_departamento`
    FOREIGN KEY (`codDepto`)
    REFERENCES `ejercicios_sql`.`departamento` (`codDepto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_empleado_empleado1`
    FOREIGN KEY (`jefeID`)
    REFERENCES `ejercicios_sql`.`empleado` (`nDIEmp`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_spanish2_ci;


-- -----------------------------------------------------
-- Table `ejercicios_sql`.`departamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ejercicios_sql`.`departamento` (
  `codDepto` VARCHAR(4) NOT NULL,
  `nombreDpto` VARCHAR(20) NOT NULL,
  `ciudad` VARCHAR(15) NULL,
  `codDirector` VARCHAR(12) NULL,
  PRIMARY KEY (`codDepto`),
  INDEX `fk_departamento_empleado1_idx` (`codDirector` ASC) VISIBLE,
  CONSTRAINT `fk_departamento_empleado1`
    FOREIGN KEY (`codDirector`)
    REFERENCES `ejercicios_sql`.`empleado` (`nDIEmp`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_spanish2_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
