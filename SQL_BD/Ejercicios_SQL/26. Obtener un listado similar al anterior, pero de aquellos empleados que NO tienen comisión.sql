-- 26. Obtener un listado similar al anterior, pero de aquellos empleados que NO tienen comisión
SELECT  nDIEmp, nomEmp, salEmp, comisionE, salEmp+comisionE AS SalarioTotal
FROM empleado
WHERE comisionE=0
ORDER BY nDIEmp;