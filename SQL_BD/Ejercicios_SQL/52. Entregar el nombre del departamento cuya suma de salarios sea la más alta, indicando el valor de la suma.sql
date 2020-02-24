/* 52. Entregar el nombre del departamento cuya suma de salarios sea la más alta, indicando el valor de la suma. */
SELECT d.codDepto,d.nombreDpto, SUM(e.salEmp) AS sumaSalarios
FROM empleado e INNER JOIN departamento d on e.codDepto = d.codDepto
GROUP BY d.codDepto
ORDER BY sumaSalarios DESC
LIMIT 1;