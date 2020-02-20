-- 27. Hallar el nombre de los empleados que tienen un salario superior a $1.000.000, y tienen como jefe al
--     empleado con documento de identidad '31.840.269'
SELECT  nomEmp, salEmp, jefeID
FROM empleado
WHERE salEmp>1000000 AND jefeID='31.840.269';