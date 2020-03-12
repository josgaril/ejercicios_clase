-- SQL listar últimos 5 cursos    

SELECT *
FROM curso 
ORDER BY fInicio DESC 
LIMIT 5;

-- SQL listar últimos 5 usuarios creados 
 SELECT * 
 FROM alumno 
 ORDER BY codigo 
 DESC LIMIT 5;

-- SQL detalle curso + número de reseñas   
SELECT c.codigo, c.nombre, c.identificador, c.fInicio, c.fFin, c.nHoras, c.temario, c.activo, c.cliente_codigo, c.precio, c.profesor_codigo, COUNT(r.id) AS numeroResenas 
FROM curso c 
INNER JOIN resena r ON c.codigo = r.curso_codigo 
GROUP BY c.codigo;  

-- SQL listado usuarios ordenado por número de reseñas
SELECT a.codigo, a.nombre, a.apellidos, COUNT(r.id) NumeroResenas FROM alumno a
INNER JOIN resena r ON a.codigo=r.alumno_codigo
GROUP BY a.codigo
ORDER BY Numeroresenas DESC, a.nombre; 

-- SQL Resumen de número de cursos de todos los años
SELECT COUNT(*) AS "Numero de cursos" FROM curso;



