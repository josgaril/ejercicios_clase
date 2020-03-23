SELECT c.codigo AS codigoCurso, a.nombre AS nombreAlumno, a.apellidos AS apellidosAlumno, r.comentario AS comentarioResena
FROM resena r 
INNER JOIN curso c ON r.curso_codigo = c.codigo 
INNER JOIN alumno a ON r.alumno_codigo = a.codigo
WHERE c.codigo=1
ORDER BY apellidosAlumno, nombreAlumno;