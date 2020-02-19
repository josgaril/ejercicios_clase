CREATE DEFINER=`root`@`localhost` PROCEDURE `clientesDelete`(IN _id INT)
BEGIN
	DELETE FROM clientes WHERE idclientes=_id;
END