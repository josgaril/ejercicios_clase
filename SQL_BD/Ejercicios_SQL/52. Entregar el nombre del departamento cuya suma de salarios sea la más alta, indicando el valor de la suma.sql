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