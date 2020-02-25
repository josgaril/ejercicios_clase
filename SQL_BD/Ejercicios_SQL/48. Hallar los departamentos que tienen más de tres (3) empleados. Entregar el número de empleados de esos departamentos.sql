-- 48. Hallar los departamentos que tienen más de tres (3) empleados. Entregar el número de empleados de esos departamentos.
SELECT d.codDepto, d.nombreDpto,  COUNT(*) AS Empleados
FROM empleado e
INNER JOIN departamento d ON e.codDepto = d.codDepto 
GROUP BY d.codDepto
HAVING Empleados>3
ORDER BY d.codDepto;