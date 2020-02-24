/* 5. Obtener los datos de los empleados vendedores, ordenado por nombre. */
SELECT *
FROM empleado
WHERE cargoE = 'Vendedor'
ORDER BY nomEmp;