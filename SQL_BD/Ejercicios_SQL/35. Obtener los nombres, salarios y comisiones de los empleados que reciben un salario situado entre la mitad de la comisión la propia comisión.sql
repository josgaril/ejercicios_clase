-- 35. Obtener los nombres, salarios y comisiones de los empleados que reciben un salario situado entre la
--     mitad de la comisión la propia comisión
SELECT nomEmp, salEmp, comisionE
FROM empleado
WHERE salEmp>comisionE/2 and salEmp<=comisionE;