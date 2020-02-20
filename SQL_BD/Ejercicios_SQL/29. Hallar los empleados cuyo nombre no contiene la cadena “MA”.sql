-- 29. Hallar los empleados cuyo nombre no contiene la cadena “MA”
SELECT nomEmp
FROM empleado
WHERE nomEmp NOT LIKE 'Ma%';
