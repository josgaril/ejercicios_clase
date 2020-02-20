-- 24. Divida los empleados, generando un grupo cuyo nombre inicie por la letra J y termine en la letra Z.
--     Liste estos empleados y su cargo por orden alfabético
-- Entiendo que quiere mostrar los empleados cuyo nombre empieza por J y acaba por z
SELECT nomEmp, cargoE
FROM empleado
WHERE nomEmp LIKE 'J%z' 
ORDER BY nomEMp;

-- Entiendo que quiere mostrar el nombre de todos los empleados que empiezan por J hasta los que empiezan por Z
SELECT grupo.nomEmp, grupo.cargoE
FROM (SELECT * FROM empleado WHERE nomEmp>'J' AND nomEmp<'Z') grupo
ORDER BY nomEmp; 