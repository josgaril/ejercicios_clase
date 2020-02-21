-- 36. Suponga que la empresa va a aplicar un reajuste salarial del 7%. Listar los nombres de los empleados, su
--     salario actual y su nuevo salario, indicando para cada uno de ellos si tiene o no comisión
SELECT nomEmp, salEmp, salEmp*1.07 AS salActual, comisionE
FROM empleado;

