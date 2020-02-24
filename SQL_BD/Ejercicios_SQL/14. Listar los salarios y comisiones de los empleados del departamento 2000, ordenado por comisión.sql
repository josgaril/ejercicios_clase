/* 14. Listar los salarios y comisiones de los empleados del departamento 2000, ordenado por comisión */
SELECT nomEmp, salEmp, comisionE
FROM empleado
WHERE codDepto = '2000'
ORDER BY comisionE;