-- 47. Entregar la lista de los empleados cuyo salario es mayor o igual que el promedio de la empresa.
--     Ordenarlo por departamento.
SELECT e.codDepto, e.nomEmp, e.salEmp, em.media
FROM empleado e, (SELECT AVG(salEmp) AS media
FROM empleado) em
WHERE e.salEmp>em.media
ORDER BY e.codDepto;