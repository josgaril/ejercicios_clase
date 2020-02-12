SELECT sesion.id, CONCAT(c.idclientes, "-", c.nombre, " ", c.apellidos) as cliente , CONCAT(t.nombre, " ", t.apellidos) as trabajador, s.idservicios as servicio, sesion.fecha as fecha, sesion.resena as resena, sesion.calificacion as calificacion
FROM sesiones sesion
INNER JOIN clientes c ON sesion.clientes_idclientes=c.idclientes
INNER JOIN trabajadores t ON sesion.trabajadores_idtrabajadores=t.idtrabajadores
INNER JOIN servicios s ON sesion.servicios_idservicios=s.idservicios
ORDER BY sesion.id;