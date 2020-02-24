-- 49. Obtener la lista de empleados jefes, que tienen al menos un empleado a su cargo. Ordene el informe
--     inversamente por el nombre.
SELECT e.nDIEmp, e.nomEmp, e3.numEmp FROM empleado e
INNER JOIN(	SELECT e2.jefeID, COUNT(e1.nomEmp) AS numEmp
			FROM empleado e1, empleado e2
			WHERE e1.nDIEmp = e2.jefeID
			GROUP BY e2.jefeID
			HAVING COUNT(e2.nDIEmp)>= 1) e3
ON e.nDIEmp = e3.jefeID ORDER BY e.nomEmp DESC;