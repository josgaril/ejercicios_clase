-- 46. Hallar el salario promedio por departamento, considerando aquellos empleados cuyo salario supera
--     $900.000, y aquellos con salarios inferiores a $575.000. Entregar el código y el nombre del departamento
-- Promedio de salario por departamento
SELECT d.codDepto, d.nombreDpto, e.promedio
FROM departamento d
INNER JOIN  (SELECT codDepto, AVG(salEmp) AS promedio
			 FROM empleado
			 WHERE salEmp > 900000 AND salEmp > 575000
		 	 GROUP BY codDepto) e
ON e.codDepto = d.codDepto;