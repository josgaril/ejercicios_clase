SELECT c.codigo AS codigoCurso, c.nombre AS nombreCurso,c.identificador AS identificadorCurso, c.fInicio AS FechaInicio, c.fFin AS FechaFin, c.nHoras AS Duración, c.temario AS temarioCurso, c.activo AS activoCurso, cl.nombre AS nombreCliente, c.precio AS precioCurso, p.nombre AS nombreProfesor, p.apellidos AS apellidosProfesor, a.nombre AS nombreAlumno, a.apellidos AS apellidosAlumno, r.comentario AS comentarioResena
FROM resena r 
INNER JOIN curso c ON r.curso_codigo = c.codigo 
INNER JOIN cliente cl ON c.cliente_codigo = cl.codigo
INNER JOIN profesor p ON c.profesor_codigo = p.codigo
INNER JOIN alumno a ON r.alumno_codigo = a.codigo
WHERE c.codigo=1
ORDER BY nombreCurso;