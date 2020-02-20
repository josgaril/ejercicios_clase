-- 34. Listar los datos de los empleados cuyo nombre inicia por la letra 'M', su salario es mayor a $800.000
--     o reciben comisión y trabajan para el departamento de 'VENTAS' alter

-- POR TERMINAR
SELECT nomEmp, salEmp, comisionE
FROM empleado
WHERE nomEmp LIKE 'M%' AND salEmp>800000 OR comisionE>0
;