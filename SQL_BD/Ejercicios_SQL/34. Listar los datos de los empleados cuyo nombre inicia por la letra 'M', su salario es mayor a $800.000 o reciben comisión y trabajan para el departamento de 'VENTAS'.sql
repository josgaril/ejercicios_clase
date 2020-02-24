-- 34. Listar los datos de los empleados cuyo nombre inicia por la letra 'M', su salario es mayor a $800.000
--     o reciben comisión y trabajan para el departamento de 'VENTAS' alter
SELECT e.nomEmp, e.salEmp, e.comisionE, d.nombreDpto
FROM empleado e
INNER JOIN departamento d ON e.codDepto = d.codDepto
WHERE e.nomEmp LIKE 'M%' AND (e.salEmp>800000 OR e.comisionE>0) AND d.nombreDpto = 'VENTAS';