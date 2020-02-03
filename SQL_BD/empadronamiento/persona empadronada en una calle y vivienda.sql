SELECT p.dni, p.nombre, p.apellidos, s.empadronado, v.calle, v.numero 
FROM personas p
JOIN situacion s ON p.id=s.persona_id
JOIN viviendas v ON s.vivienda_id=v.id
HAVING v.calle='Los huertos' AND v.numero=3 AND s.empadronado=1
ORDER BY p.dni; 