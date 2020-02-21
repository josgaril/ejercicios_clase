-- 44. Entregar el número de empleados de sexo femenino y de sexo masculino, por departamento.
SELECT codDepto, sexEmp, COUNT(nomEmp) AS "Nº Empleados"
FROM empleado
GROUP BY codDepto, sexEmp
ORDER BY codDepto;