/* 24. Divida los empleados, generando un grupo cuyo nombre inicie por la letra J y termine en la letra Z.
     Liste estos empleados y su cargo por orden alfabético */

/* Opción que muestra los empleados cuyo nombre empieza por J y acaba por z (no hay por lo que el resultado es 0)*/
SELECT nomEmp, cargoE
FROM empleado
WHERE nomEmp LIKE 'J%z' 
ORDER BY nomEMp;

/* Opción que muestra el nombre de todos los empleados que empiezan por J hasta los que empiezan por Z */
SELECT grupo.nomEmp, grupo.cargoE
FROM (SELECT * FROM empleado WHERE nomEmp>='J' AND nomEmp<='Z') grupo
ORDER BY nomEmp; 