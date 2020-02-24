/* 25. Listar el salario, la comisión, el salario total (salario + comisión), documento de identidad del
       empleado y nombre, de aquellos empleados que tienen comisión superior a $1.000.000, ordenar el
       informe por el número del documento de identidad */
SELECT  nDIEmp, nomEmp, salEmp, comisionE, salEmp+comisionE AS SalarioTotal
FROM empleado
WHERE comisionE>1000000
ORDER BY nDIEmp;