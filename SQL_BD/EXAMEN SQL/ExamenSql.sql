-- MySQL Workbench Synchronization
-- Generated: 2020-02-26 13:08
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Curso

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

ALTER TABLE `examensql`.`facturas` 
DROP FOREIGN KEY `fk_facturas_clientes`;

ALTER TABLE `examensql`.`productos` 
DROP FOREIGN KEY `fk_productos_categorias1`;

ALTER TABLE `examensql`.`ventas` 
DROP FOREIGN KEY `fk_facturas_has_productos_facturas1`,
DROP FOREIGN KEY `fk_facturas_has_productos_productos1`;

ALTER TABLE `examensql`.`facturas` 
CHANGE COLUMN `fecha` `fecha` DATE NULL DEFAULT NULL ;

ALTER TABLE `examensql`.`facturas` 
ADD CONSTRAINT `fk_facturas_clientes`
  FOREIGN KEY (`id_cliente`)
  REFERENCES `examensql`.`clientes` (`id_cliente`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `examensql`.`productos` 
DROP FOREIGN KEY `fk_productos_proveedores1`;

ALTER TABLE `examensql`.`productos` ADD CONSTRAINT `fk_productos_proveedores1`
  FOREIGN KEY (`id_proveedor`)
  REFERENCES `examensql`.`proveedores` (`id_proveedor`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_productos_categorias1`
  FOREIGN KEY (`id_categoria`)
  REFERENCES `examensql`.`categorias` (`id_categoria`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `examensql`.`ventas` 
ADD CONSTRAINT `fk_facturas_has_productos_facturas1`
  FOREIGN KEY (`id_factura`)
  REFERENCES `examensql`.`facturas` (`id_factura`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_facturas_has_productos_productos1`
  FOREIGN KEY (`id_producto`)
  REFERENCES `examensql`.`productos` (`id_producto`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
