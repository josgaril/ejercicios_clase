/* 23. Listar los empleados cuyo salario es menor o igual que el 40% de su comisión */
SELECT nomEmp, salEmp, comisionE
FROM empleado
WHERE salEmp<= comisionE*(40/100);