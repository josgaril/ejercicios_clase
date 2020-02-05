SELECT  p.nombre, p.apellidos, v.calle, v.numero
FROM personas p
JOIN viviendas v ON p.empadronado_en=v.id
WHERE v.calle='Los huertos' AND v.numero=3;