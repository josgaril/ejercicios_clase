-- 30. Obtener los nombres de los departamentos que no sean “Ventas” ni “Investigación” NI ‘MANTENIMIENTO’, ordenados por ciudad.
SELECT nombreDpto, ciudad
FROM departamento
WHERE nombreDpto NOT IN('VENTAS' , 'INVESTIGACION' , 'MANTENIMIENTO')
ORDER BY ciudad;
