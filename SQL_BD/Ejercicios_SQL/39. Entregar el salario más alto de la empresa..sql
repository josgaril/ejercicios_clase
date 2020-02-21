-- 39. Entregar el salario más alto de la empresa.
SELECT nomEmp, MAX(salEmp) AS "Salario Máximo"
FROM empleado 
WHERE salEmp IN (SELECT MAX(salEmp) FROM empleado);

