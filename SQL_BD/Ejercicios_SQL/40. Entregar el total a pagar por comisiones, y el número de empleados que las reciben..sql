-- 40. Entregar el total a pagar por comisiones, y el número de empleados que las reciben.
SELECT SUM(comisionE), COUNT(nomEmp)
FROM empleado 
WHERE comisionE > 0;

