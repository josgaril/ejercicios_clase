CREATE DEFINER=`root`@`localhost` PROCEDURE `clientesInsert`(IN _nombre VARCHAR(45), IN _apellidos VARCHAR(90), IN _dni CHAR(9))
BEGIN
	INSERT INTO clientes (nombre, apellidos, dni) VALUES(_nombre, _apellidos, _dni);
END