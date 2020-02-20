-- 28. Hallar el conjunto complementario del resultado del ejercicio anterior.
SELECT  nomEmp, salEmp, jefeID
FROM empleado
WHERE salEmp<=1000000 AND jefeID='31.840.269';