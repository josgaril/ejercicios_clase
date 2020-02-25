-- 50. Hallar los departamentos que no tienen empleados 
SELECT e.nomEmp, d.nombreDpto, d.ciudad
FROM empleado e RIGHT JOIN departamento d ON e.codDepto = d.codDepto
WHERE e.codDepto is Null;

-- Otra opción
SELECT * 
FROM departamento d 
WHERE d.codDepto NOT IN(SELECT codDepto FROM empleado);


-- Comprobamos los empleados que tiene cada departamento
SELECT COUNT(e.codDepto) AS NumeroEmpleados,d.nombreDpto
FROM empleado e 
RIGHT JOIN departamento d ON e.codDepto = d.codDepto
GROUP BY d.nombreDpto
HAVING NumeroEmpleados>=0
ORDER BY NumeroEmpleados DESC;