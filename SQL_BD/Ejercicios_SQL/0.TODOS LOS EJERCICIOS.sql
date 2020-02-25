/*1. Obtener los datos completos de los empleados.*/
SELECT * FROM empleado;

/* 2. Obtener los datos completos de los departamentos */
SELECT * FROM departamento;

/* 3. Obtener los datos de los empleados con cargo 'Secretaria' */
SELECT * 
FROM ejercicios_sql.empleado
WHERE cargoE = 'Secretaria';

/* 4. Obtener el nombre y salario de los empleados */
SELECT nomEmp, salEmp FROM empleado;

/* 5. Obtener los datos de los empleados vendedores, ordenado por nombre. */
SELECT *
FROM empleado
WHERE cargoE = 'Vendedor'
ORDER BY nomEmp;

/* 6. Listar el nombre de los departamentos */
SELECT DISTINCT nombreDpto
FROM departamento;

/* 7. Listar el nombre de los departamentos, ordenado por nombre */
SELECT DISTINCT nombreDpto 
FROM departamento
ORDER BY nombreDpto;

/* 8. Listar el nombre de los departamentos, ordenado por ciudad */
SELECT DISTINCT nombreDpto 
FROM departamento
ORDER BY ciudad;

/* 9. Listar el nombre de los departamentos, ordenado por ciudad, en orden inverso */ 
SELECT DISTINCT nombreDpto, ciudad 
FROM departamento
ORDER BY ciudad DESC;

/* 10. Obtener el nombre y cargo de todos los empleados, ordenado por salario */
SELECT nomEmp, cargoE, salEmp
FROM empleado
ORDER BY salEmp;

/* 11. Obtener el nombre y cargo de todos los empleados, ordenado por cargo y por salario */
SELECT nomEmp, cargoE, salEmp
FROM empleado
ORDER BY cargoE, salEmp;

/* 12. Obtener el nombre y cargo de todos los empleados, en orden inverso por cargo*/ 
SELECT nomEmp, cargoE, salEmp
FROM empleado
ORDER BY cargoE DESC;

/* 13. Listar los salarios y comisiones de los empleados del departamento 2000 */
SELECT nomEmp, salEmp, comisionE
FROM empleado
WHERE codDepto = '2000';

/* 14. Listar los salarios y comisiones de los empleados del departamento 2000, ordenado por comisión */
SELECT nomEmp, salEmp, comisionE
FROM empleado
WHERE codDepto = '2000'
ORDER BY comisionE;

/* 15. Listar todas las comisiones */
SELECT comisionE
FROM empleado;

/* 16. Listar las comisiones que sean diferentes, ordenada por valor */
SELECT DISTINCT comisionE
FROM empleado
ORDER BY comisionE;

/* 17. Listar los diferentes salarios */
SELECT DISTINCT salEmp
FROM empleado
order by salEmp;

/* 18. Obtener el valor total a pagar que resulta de sumar a los empleados del departamento 3000 una
       bonificación de $500.000, en orden alfabético del empleado */

		/* Opcion en la que entiendo que se suman 500.000 al sueldo de cada empleado */	
		SELECT nomEmp, salEmp, salEmp + 500000 as Total_A_Pagar 
		FROM empleado 
		WHERE codDepto ='3000'
		ORDER BY nomEmp;

		/* Opcion en la que entiendo que se suman 500.000 al sueldo de cada empleado y se muestra el total a pagar del departamento 3000 */
		SELECT SUM(salEmp + 500000) as Total_A_Pagar 
		FROM empleado 
		WHERE codDepto ='3000';

		/* Opcion en la que entiendo que se suman los sueldos de los empleados, y se añaden 500.000 al total de todos los sueldos del
		   departamento 3000 */
		SELECT SUM(salEmp) + 500000 as Total_A_Pagar 
		FROM empleado 
		WHERE codDepto ='3000';
        
/* 19. Obtener la lista de los empleados que ganan una comisión superior a su sueldo. */
SELECT nomEmp, salEmp, comisionE
FROM empleado
WHERE comisionE > salEmp;

/* 20. Listar los empleados cuya comisión es menor o igual que el 30% de su sueldo. */
SELECT nomEmp, salEmp, comisionE
FROM empleado
WHERE comisionE <= salEmp*(30/100);

/* 21. Elabore un listado donde para cada fila, figure ‘Nombre’ y ‘Cargo’ antes del valor respectivo para cada empleado */
SELECT CONCAT('Nombre: ', nomEmp) as NombreEmpleado, CONCAT('Cargo: ', cargoE) as CargoEmpleado
FROM empleado;

		/* Opción que crea una columna para 'Nombre' y otra para 'Cargo' */
		SELECT 'Nombre: ' as '', nomEmp, 'Cargo: ' as '', cargoE
		FROM Empleado;
        
/* 22. Hallar el salario y la comisión de aquellos empleados cuyo número de documento de identidad es superior al '19.709.802' */
SELECT   nDIEmp, nomEmp, salEmp, comisionE
FROM empleado
WHERE nDIEmp > '19,709.802';

/* 23. Listar los empleados cuyo salario es menor o igual que el 40% de su comisión */
SELECT nomEmp, salEmp, comisionE
FROM empleado
WHERE salEmp<= comisionE*(40/100);

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

/* 25. Listar el salario, la comisión, el salario total (salario + comisión), documento de identidad del
       empleado y nombre, de aquellos empleados que tienen comisión superior a $1.000.000, ordenar el
       informe por el número del documento de identidad */
SELECT  nDIEmp, nomEmp, salEmp, comisionE, salEmp+comisionE AS SalarioTotal
FROM empleado
WHERE comisionE>1000000
ORDER BY nDIEmp;

/* 26. Obtener un listado similar al anterior, pero de aquellos empleados que NO tienen comisión */
SELECT  nDIEmp, nomEmp, salEmp, comisionE, salEmp+comisionE AS SalarioTotal
FROM empleado
WHERE comisionE=0
ORDER BY nDIEmp;

/* 27. Hallar el nombre de los empleados que tienen un salario superior a $1.000.000, y tienen como jefe al
       empleado con documento de identidad '31.840.269' */
SELECT  nomEmp, salEmp, jefeID
FROM empleado
WHERE salEmp>1000000 AND jefeID='31.840.269';

/* 28. Hallar el conjunto complementario del resultado del ejercicio anterior. */
SELECT  nomEmp, salEmp, jefeID
FROM empleado
WHERE salEmp<=1000000 AND jefeID='31.840.269';

/* 29. Hallar los empleados cuyo nombre no contiene la cadena “MA” */
SELECT nomEmp
FROM empleado
WHERE nomEmp NOT LIKE 'Ma%';

/* 30. Obtener los nombres de los departamentos que no sean “Ventas” ni “Investigación” NI
‘MANTENIMIENTO’, ordenados por ciudad. */
SELECT nombreDpto, ciudad
FROM departamento
WHERE nombreDpto NOT IN('VENTAS' , 'INVESTIGACION' , 'MANTENIMIENTO')
ORDER BY ciudad;

/* 31. Obtener el nombre y el departamento de los empleados con cargo 'Secretaria' o 'Vendedor', que
	   no trabajan en el departamento de “PRODUCCION”, cuyo salario es superior a $1.000.000,
	   ordenados por fecha de incorporación. */
SELECT e.nomEmp, e.cargoE, e.fecIncorporacion, d.nombreDpto
FROM empleado e
INNER JOIN departamento d ON e.codDepto=d.codDepto
WHERE e.cargoE IN('Secretaria', 'Vendedor') 
AND d.nombreDpto NOT LIKE 'PRODUCCION' 
AND e.salEmp>1000000
ORDER BY e.fecIncorporacion;	
       
/* 32. Obtener información de los empleados cuyo nombre tiene exactamente 11 caracteres */
SELECT nomEmp, char_length(nomEmp) AS Caracteres
FROM empleado
WHERE char_length(nomEmp) = 11;

/* 33. Obtener información de los empleados cuyo nombre tiene al menos 11 caracteres */
SELECT nomEmp, char_length(nomEmp) AS Caracteres
FROM empleado
WHERE char_length(nomEmp) >= 11;

/* 34. Listar los datos de los empleados cuyo nombre inicia por la letra 'M', su salario es mayor a $800.000
	   o reciben comisión y trabajan para el departamento de 'VENTAS' */
SELECT e.nomEmp, e.salEmp, e.comisionE, d.nombreDpto
FROM empleado e
INNER JOIN departamento d ON e.codDepto = d.codDepto
WHERE e.nomEmp LIKE 'M%' AND (e.salEmp>800000 OR e.comisionE>0) AND d.nombreDpto = 'VENTAS';      
       
/* 35. Obtener los nombres, salarios y comisiones de los empleados que reciben un salario situado entre la
       mitad de la comisión la propia comisión */
SELECT nomEmp, salEmp, comisionE
FROM empleado
WHERE salEmp>comisionE/2 and salEmp<=comisionE;       
       
/* 36. Suponga que la empresa va a aplicar un reajuste salarial del 7%. Listar los nombres de los empleados, su
	   salario actual y su nuevo salario, indicando para cada uno de ellos si tiene o no comisión */
SELECT nomEmp, salEmp, salEmp*1.07 AS salActual, comisionE
FROM empleado;       
       
/* 37. Obtener la información disponible del empleado cuyo número de documento de identidad sea:
	   '31.178.144', '16.759.060', '1.751.219', '768.782', '737.689', '19.709.802', '31.174.099', '1.130.782' */
SELECT *
FROM empleado
WHERE nDIEmp IN ('31.178.144', '16.759.060', '1.751.219', '768.782', '737.689', '19.709.802', '31.174.099', '1.130.782');       
       
/* 38. Entregar un listado de todos los empleados ordenado por su departamento, y alfabético dentro del departamento. */
SELECT *
FROM empleado 
ORDER BY codDepto, nomEmp;

/* 39. Entregar el salario más alto de la empresa. */
SELECT nomEmp, MAX(salEmp) AS "Salario Máximo"
FROM empleado 
WHERE salEmp IN (SELECT MAX(salEmp) FROM empleado);

/* 40. Entregar el total a pagar por comisiones, y el número de empleados que las reciben. */
SELECT SUM(comisionE), COUNT(nomEmp)
FROM empleado 
WHERE comisionE > 0;

/* 41. Entregar el nombre del último empleado de la lista por orden alfabético. */
SELECT MAX(nomEmp) AS Nombre
FROM empleado;

/* 42. Hallar el salario más alto, el más bajo y la diferencia entre ellos. */
SELECT MAX(salEmp) AS "Salario Máximo", MIN(salEmp) AS "Salario Mínimo", (MAX(salEmp) - MIN(salEmp)) AS Diferencia
FROM empleado;

/* 43. Conocido el resultado anterior, entregar el nombre de los empleados que reciben el salario más alto
	   y más bajo. Cuanto suman estos salarios? */
SELECT DISTINCT (SELECT nomEmp FROM empleado WHERE salEmp IN (SELECT MAX(salEmp) from empleado)) AS "Empleado con mayor salario",
				(SELECT nomEmp FROM empleado WHERE salEmp IN (SELECT MIN(salEmp) from empleado)) AS "Empleado con menor salario",
				(MAX(salEmp) + MIN(salEmp)) AS "Suma de salarios"
FROM empleado;       
       
/* 44. Entregar el número de empleados de sexo femenino y de sexo masculino, por departamento. */
SELECT codDepto, sexEmp, COUNT(nomEmp) AS "Nº Empleados"
FROM empleado
GROUP BY codDepto, sexEmp
ORDER BY codDepto;

/* 45. Hallar el salario promedio por departamento. */
SELECT codDepto, AVG(salEmp) AS "Salario promedio"
FROM empleado
GROUP BY codDepto
ORDER BY codDepto;

/* 46. Hallar el salario promedio por departamento, considerando aquellos empleados cuyo salario supera
	   $900.000, y aquellos con salarios inferiores a $575.000. Entregar el código y el nombre del departamento. */
SELECT d.codDepto, d.nombreDpto, e.promedio
FROM departamento d
INNER JOIN  (SELECT codDepto, AVG(salEmp) AS promedio
			 FROM empleado
			 WHERE salEmp > 900000 AND salEmp > 575000
		 	 GROUP BY codDepto) e
ON e.codDepto = d.codDepto;       
       
/* 47. Entregar la lista de los empleados cuyo salario es mayor o igual que el promedio de la empresa. Ordenarlo por departamento. */
SELECT e.codDepto, e.nomEmp, e.salEmp, em.media
FROM empleado e, (SELECT AVG(salEmp) AS media
FROM empleado) em
WHERE e.salEmp>em.media
ORDER BY e.codDepto;

/* 48. Hallar los departamentos que tienen más de tres (3) empleados. Entregar el número de empleados de esos departamentos. */
SELECT d.codDepto, d.nombreDpto,  COUNT(*) AS Empleados
FROM empleado e
INNER JOIN departamento d ON e.codDepto = d.codDepto 
GROUP BY d.codDepto
HAVING Empleados>3
ORDER BY d.codDepto;

/* 49. Obtener la lista de empleados jefes, que tienen al menos un empleado a su cargo. Ordene el informe inversamente por el nombre. */
SELECT ej.nDIEmp, ej.nomEmp, COUNT(e.jefeID) AS "Numero de Empleados"
FROM empleado e
INNER JOIN empleado ej ON e.jefeID = ej.nDIEmp
GROUP BY ej.nDIEmp
ORDER BY ej.nomEmp DESC;

/* 50. Hallar los departamentos que no tienen empleados */
SELECT e.nomEmp, d.nombreDpto, d.ciudad
FROM empleado e RIGHT JOIN departamento d ON e.codDepto = d.codDepto
WHERE e.codDepto is Null;

		-- Comprobamos los empleados que tiene cada departamento
		SELECT COUNT(e.codDepto) AS NumeroEmpleados,d.nombreDpto
		FROM empleado e 
		RIGHT JOIN departamento d ON e.codDepto = d.codDepto
		GROUP BY d.nombreDpto
		HAVING NumeroEmpleados>=0
		ORDER BY NumeroEmpleados DESC;

		-- Otra opción
		SELECT * 
		FROM departamento d 
		WHERE d.codDepto NOT IN(SELECT codDepto FROM empleado);


/* 51. Entregar un reporte con el numero de cargos en cada departamento y cual es el promedio de salario
	   de cada uno. Indique el nombre del departamento en el resultado. */
SELECT d.codDepto, d.nombreDpto, COUNT(e.cargoE) AS Cargos, IFNULL(AVG(e.salEmp),0) AS "Promedio Salario"
FROM empleado e RIGHT JOIN departamento d ON e.codDepto = d.codDepto
GROUP BY d.codDepto
ORDER BY d.nombreDpto;  
       
/* 52. Entregar el nombre del departamento cuya suma de salarios sea la más alta, indicando el valor de la suma. */
		-- Suponiendo que solo hay un departamentos con la suma más alta
		SELECT d.codDepto,d.nombreDpto, SUM(e.salEmp) AS sumaSalarios
		FROM empleado e INNER JOIN departamento d on e.codDepto = d.codDepto
		GROUP BY d.codDepto
		ORDER BY sumaSalarios DESC
		LIMIT 1;

		-- Suponiendo que puede haber varios departamentos con la suma más alta
		SELECT d.nombreDpto, SUM(e.salEmp)
		FROM departamento d
		INNER JOIN empleado e ON d.codDepto = e.codDepto
		GROUP BY d.codDepto
		HAVING d.codDepto = (SELECT d.codDepto
			FROM departamento d
			INNER JOIN empleado e ON e.codDepto = d.codDepto
			GROUP BY d.codDepto
			ORDER BY SUM(e.salEmp) DESC
			LIMIT 1)
		;

		/* MISMO EJERCICO CON VISTAS*/
		-- Calcular el total de salarios por departamento
		CREATE VIEW SumSalar AS
		 (SELECT codDepto, SUM(salEmp) AS sumS
		 FROM Empleado
		 GROUP BY codDepto);
		-- Hallar la suma de salarios más alta
		CREATE VIEW SumSalar2 AS
		 (SELECT MAX(sumS) sSalD
		 FROM SumSalar);
		 -- Listar el nombre del departamento con suma de salarios sea la más alta
		 SELECT d.nombreDpto, ss.sumS
		 FROM departamento d 
		 JOIN SumSalar ss ON ss.codDepto = d.codDepto
		 WHERE ss.sumS = (SELECT * FROM SumSalar2);

/* 53. Entregar un reporte con el código y nombre de cada jefe, junto al número de empleados que dirige.
	   Puede haber empleados que no tengan supervisores, para esto se indicará solamente el numero de
       ellos dejando los valores restantes en NULL. */
SELECT ej.nDIEmp, ej.nomEmp, COUNT(e.nomEmp) AS Empleados
FROM empleado e 
LEFT JOIN empleado ej ON  e.jefeID = ej.nDIEmp
GROUP BY ej.nDIEmp
ORDER BY Empleados DESC, ej.nDIEmp DESC;