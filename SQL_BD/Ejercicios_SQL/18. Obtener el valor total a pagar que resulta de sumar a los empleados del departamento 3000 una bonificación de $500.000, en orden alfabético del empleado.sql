-- 18. Obtener el valor total a pagar que resulta de sumar a los empleados del departamento 3000 una
--     bonificación de $500.000, en orden alfabético del empleado

-- Opcion en la que entiendo que se suman 500.000 al sueldo de cada empleado	
SELECT nomEmp, salEmp, salEmp + 500000 as Total_A_Pagar 
FROM empleado 
WHERE codDepto ='3000'
ORDER BY nomEmp;

-- Opcion en la que entiendo que se suman 500.000 al sueldo de cada empleado y se muestra el total a pagar del departamento 3000
SELECT SUM(salEmp + 500000) as Total_A_Pagar 
FROM empleado 
WHERE codDepto ='3000';

-- Opcion en la que entiendo que se suman los sueldos de los empleados, y se añaden 500.000 al total de todos los sueldos del departamento 3000
SELECT SUM(salEmp) + 500000 as Total_A_Pagar 
FROM empleado 
WHERE codDepto ='3000';