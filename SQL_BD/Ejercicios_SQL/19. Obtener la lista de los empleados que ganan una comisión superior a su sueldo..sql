/* 19. Obtener la lista de los empleados que ganan una comisión superior a su sueldo. */
SELECT nomEmp, salEmp, comisionE
FROM empleado
WHERE comisionE > salEmp;