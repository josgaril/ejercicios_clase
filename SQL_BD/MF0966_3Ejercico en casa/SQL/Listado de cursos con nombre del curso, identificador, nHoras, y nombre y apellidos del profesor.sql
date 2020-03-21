SELECT c.nombre AS nombreCurso, c.identificador AS identificadorCurso, c.nHoras AS nHorasCurso, p.nombre AS nombreProfesor, p.apellidos AS apellidosProfesor
FROM curso c 
INNER JOIN profesor p ON c.profesor_codigo = p.codigo
ORDER BY nombreCurso;