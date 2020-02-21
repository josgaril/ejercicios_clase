-- 42. Hallar el salario más alto, el más bajo y la diferencia entre ellos.
SELECT MAX(salEmp) AS "Salario Máximo", MIN(salEmp) AS "Salario Mínimo", (MAX(salEmp) - MIN(salEmp)) AS Diferencia
FROM empleado;

