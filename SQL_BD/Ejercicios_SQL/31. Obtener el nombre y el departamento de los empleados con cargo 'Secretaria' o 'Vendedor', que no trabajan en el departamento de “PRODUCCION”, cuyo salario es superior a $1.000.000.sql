-- 31. Obtener el nombre y el departamento de los empleados con cargo 'Secretaria' o 'Vendedor', que
--     no trabajan en el departamento de “PRODUCCION”, cuyo salario es superior a $1.000.000,
--     ordenados por fecha de incorporación.
SELECT e.nomEmp, e.cargoE, e.fecIncorporacion, d.nombreDpto
FROM empleado e
INNER JOIN departamento d ON e.codDepto=d.codDepto
WHERE e.cargoE IN('Secretaria', 'Vendedor') 
AND d.nombreDpto NOT LIKE 'PRODUCCION' 
AND e.salEmp>1000000
ORDER BY e.fecIncorporacion;