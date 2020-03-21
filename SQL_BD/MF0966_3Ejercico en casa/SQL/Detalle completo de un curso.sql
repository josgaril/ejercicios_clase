SELECT c.codigo AS codigoCurso, c.nombre AS nombreCurso, c.identificador AS identificadorCurso , c.fInicio AS fInicioCurso, c.fFin AS fFinCurso, c.nHoras AS nHorasCurso, c.temario AS temarioCurso, c.activo AS activoCurso, c.precio AS precioCurso,
p.codigo AS codigoProfesor, p.nss AS nssProfesor, p.nombre AS nombreProfesor, p.apellidos AS apellidosProfesor, p.fNacimiento AS fNacimientoProfesor, p.dni AS dniProfesor, p.direccion AS direccionProfesor, p.poblacion AS poblacionProfesor, p.codigopostal AS codigopostalProfesor, p.telefono AS telefonoProfesor, p.email AS emailProfesor, p.activo AS activoProfesor,
cl.codigo AS codigoCliente, cl.nombre AS nombreCliente, cl.email AS emailCliente, cl.telefono as telefonoCliente, cl.direccion AS direccionCliente, cl.poblacion AS poblacionCliente, cl.codigopostal AS codigopostalCliente, cl.identificador AS identificadorCliente, cl.activo AS activoCliente,
r.codigo AS codigoResena, r.alumno_codigo AS codigoAlumno, a.nombre AS nombreAlumno, a.apellidos AS apellidosAlumno, r.comentario AS comentarioResena
FROM curso c
INNER JOIN profesor p ON c.profesor_codigo = p.codigo
INNER JOIN cliente cl ON c.cliente_codigo = cl.codigo
INNER JOIN resena r ON r.curso_codigo = c.codigo
INNER JOIN alumno a ON r.alumno_codigo = a.codigo
WHERE c.codigo=2
ORDER BY comentarioResena;