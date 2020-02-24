-- 53. Entregar un reporte con el código y nombre de cada jefe, junto al número de empleados que dirige.
--     Puede haber empleados que no tengan supervisores, para esto se indicará solamente el numero de
--     ellos dejando los valores restantes en NULL
SELECT e1.nDIEmp, e1.nomEmp, COUNT(e2.nomEmp) AS empleados
FROM empleado e1 
RIGHT JOIN empleado e2 ON e1.nDIEmp = e2.jefeID
GROUP BY e1.nDIEmp
ORDER BY empleados DESC;