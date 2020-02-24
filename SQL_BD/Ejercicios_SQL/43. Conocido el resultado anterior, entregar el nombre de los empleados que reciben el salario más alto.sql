-- 43. Conocido el resultado anterior, entregar el nombre de los empleados que reciben el salario más alto
--     y más bajo. Cuanto suman estos salarios?
SELECT DISTINCT (SELECT  nomEmp FROM empleado WHERE salEmp IN (SELECT MAX(salEmp) from empleado)) AS "Empleado con mayor salario",
				(SELECT nomEmp FROM empleado WHERE salEmp IN (SELECT MIN(salEmp) from empleado)) AS "Empleado con menor salario",
				(MAX(salEmp) + MIN(salEmp)) AS "Suma de salarios"
FROM empleado;