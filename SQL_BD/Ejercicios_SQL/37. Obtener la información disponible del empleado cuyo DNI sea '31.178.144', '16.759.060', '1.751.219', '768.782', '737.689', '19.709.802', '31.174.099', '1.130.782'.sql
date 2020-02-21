-- 37. Obtener la información disponible del empleado cuyo número de documento de identidad sea:
--     '31.178.144', '16.759.060', '1.751.219', '768.782', '737.689', '19.709.802', '31.174.099', '1.130.782'

SELECT nomEmp, salEmp, salEmp*1.07 AS salActual, comisionE
FROM empleado;

