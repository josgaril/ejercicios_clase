/* 22. Hallar el salario y la comisión de aquellos empleados cuyo número de documento de identidad es superior al '19.709.802' */
SELECT   nDIEmp, nomEmp, salEmp, comisionE
FROM empleado
WHERE nDIEmp > '19,709.802';