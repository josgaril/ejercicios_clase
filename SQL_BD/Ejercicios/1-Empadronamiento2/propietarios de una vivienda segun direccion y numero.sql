SELECT  p.nombre, p.apellidos, v.calle, v.numero
FROM personas p
JOIN personas_has_viviendas pv ON p.id=pv.persona_id
JOIN viviendas v ON pv.vivienda_id=v.id
WHERE v.calle='Los huertos' AND v.numero=3;