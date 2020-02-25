/* 49. Obtener la lista de empleados jefes, que tienen al menos un empleado a su cargo. Ordene el informe inversamente por el nombre. */
SELECT ej.nDIEmp, ej.nomEmp, COUNT(e.jefeID) AS "Numero de Empleados"
FROM empleado e
INNER JOIN empleado ej ON e.jefeID = ej.nDIEmp
GROUP BY ej.nDIEmp
ORDER BY ej.nomEmp DESC;