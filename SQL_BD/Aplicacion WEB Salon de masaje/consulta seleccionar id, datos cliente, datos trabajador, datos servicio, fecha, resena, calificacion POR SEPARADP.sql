SELECT sesion.id, c.idclientes, c.nombre as Nombre_Cliente, c.apellidos as Apellidos_cliente, t.idtrabajadores, t.nombre as Nombre_trabajador, t.apellidos as Apellidos_trabajador, s.nombre as Nombre_servicio, sesion.fecha as fecha, sesion.resena as resena, sesion.calificacion as calificacion
FROM sesiones sesion
INNER JOIN clientes c ON sesion.clientes_idclientes=c.idclientes
INNER JOIN trabajadores t ON sesion.trabajadores_idtrabajadores=t.idtrabajadores
INNER JOIN servicios s ON sesion.servicios_idservicios=s.idservicios
ORDER BY sesion.id;