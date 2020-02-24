/* 12. Obtener el nombre y cargo de todos los empleados, en orden inverso por cargo*/ 
SELECT nomEmp, cargoE, salEmp
FROM empleado
ORDER BY cargoE DESC;