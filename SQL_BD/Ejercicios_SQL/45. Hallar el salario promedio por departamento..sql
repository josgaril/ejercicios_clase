-- 45. Hallar el salario promedio por departamento.
SELECT codDepto, AVG(salEmp) AS "Salario promedio"
FROM empleado
GROUP BY codDepto
ORDER BY codDepto;