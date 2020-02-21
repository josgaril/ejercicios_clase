-- 47. Entregar la lista de los empleados cuyo salario es mayor o igual que el promedio de la empresa.
--     Ordenarlo por departamento.

-- POR TERMINAR
SELECT e.nomEmp, e.salEmp, m.media
FROM empleado e
INNER JOIN (SELECT AVG(salEmp) AS media FROM empleado) m ON e=m;
