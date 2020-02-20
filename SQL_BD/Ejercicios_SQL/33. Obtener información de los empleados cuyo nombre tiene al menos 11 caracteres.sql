-- 33. Obtener información de los empleados cuyo nombre tiene al menos 11 caracteres
SELECT nomEmp, char_length(nomEmp) AS Caracteres
FROM empleado
WHERE char_length(nomEmp) >= 11
;