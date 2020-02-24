/* 9. Listar el nombre de los departamentos, ordenado por ciudad, en orden inverso */ 
SELECT DISTINCT nombreDpto, ciudad 
FROM departamento
ORDER BY ciudad DESC;