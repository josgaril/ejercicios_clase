SELECT p.dni, p.nombre, p.apellidos, s.propietario, v.calle, v.numero 
FROM personas p
JOIN situacion s ON p.id=s.persona_id
JOIN viviendas v ON s.vivienda_id=v.id
WHERE v.calle='Mayor' AND v.numero=134 AND s.propietario=1
ORDER BY p.dni; 