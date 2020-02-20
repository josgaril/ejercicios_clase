-- 21. Elabore un listado donde para cada fila, figure ‘Nombre’ y ‘Cargo’ antes del valor respectivo para cada empleado
SELECT CONCAT('Nombre: ', nomEmp) as NombreEmpleado, CONCAT('Cargo: ', cargoE) as CargoEmpleado
FROM empleado;

-- Opción que crea una columna para 'Nombre' y otra para 'Cargo'
SELECT 'Nombre: ' as '', nomEmp, 'Cargo: ' as '', cargoE
FROM Empleado;
