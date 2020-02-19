CREATE DEFINER=`root`@`localhost` PROCEDURE `clientesGetAll`()
BEGIN
	SELECT *
    FROM clientes;
END