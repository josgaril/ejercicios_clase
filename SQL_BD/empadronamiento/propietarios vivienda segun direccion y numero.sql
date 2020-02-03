SELECT p.dni, p.nombre, p.apellidos, pr.propietario, v.calle, v.numero 
FROM personas p
JOIN propiedades pr ON p.id=pr.persona_id
JOIN viviendas v ON pr.vivienda_id=v.id
HAVING v.calle='Mayor' AND v.numero=134 AND pr.propietario=1
ORDER BY p.dni; 