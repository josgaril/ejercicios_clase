-- 50. Hallar los departamentos que no tienen empleados 
SELECT e.nomEmp, d.nombreDpto
FROM empleado e RIGHT JOIN departamento d ON e.codDepto = d.codDepto
WHERE e.codDepto is Null;

-- Comprobamos los empleados que tiene cada departamento
SELECT COUNT(e.codDepto) AS NumeroEmpleados,d.nombreDpto
FROM empleado e 
RIGHT JOIN departamento d ON e.codDepto = d.codDepto
GROUP BY d.nombreDpto
HAVING NumeroEmpleados>=0
ORDER BY NumeroEmpleados DESC;