-- 53. Entregar un reporte con el código y nombre de cada jefe, junto al número de empleados que dirige.
--     Puede haber empleados que no tengan supervisores, para esto se indicará solamente el numero de
--     ellos dejando los valores restantes en NULL
SELECT ej.nDIEmp, ej.nomEmp, COUNT(e.nomEmp) AS Empleados
FROM empleado e 
LEFT JOIN empleado ej ON  e.jefeID = ej.nDIEmp
GROUP BY ej.nDIEmp
ORDER BY Empleados DESC, ej.nDIEmp DESC;