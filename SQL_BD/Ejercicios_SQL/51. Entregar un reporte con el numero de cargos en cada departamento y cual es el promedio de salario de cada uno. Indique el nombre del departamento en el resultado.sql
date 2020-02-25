-- 51. Entregar un reporte con el numero de cargos en cada departamento y cual es el promedio de salario
--     de cada uno. Indique el nombre del departamento en el resultado
SELECT d.codDepto, d.nombreDpto, COUNT(e.cargoE) AS Cargos, IFNULL(AVG(e.salEmp),0) AS "Promedio Salario"
FROM empleado e RIGHT JOIN departamento d ON e.codDepto = d.codDepto
GROUP BY d.codDepto
ORDER BY d.nombreDpto;