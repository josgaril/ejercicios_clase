-- 20. Listar los empleados cuya comisión es menor o igual que el 30% de su sueldo.
SELECT nomEmp, salEmp, comisionE
FROM empleado
WHERE comisionE <= salEmp*(30/100);