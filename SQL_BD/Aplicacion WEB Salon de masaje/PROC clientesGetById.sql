CREATE DEFINER=`root`@`localhost` PROCEDURE `clientesGetById`(IN _id INT)
BEGIN
    SELECT 
        idclientes,
        nombre,
        apellidos,
        dni
    FROM
        clientes
	WHERE idclientes=_id;
END