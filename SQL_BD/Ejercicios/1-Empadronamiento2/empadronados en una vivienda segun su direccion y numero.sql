SELECT  p.nombre, p.apellidos, v.calle, v.numero, m.nombre municipio
FROM personas p
JOIN viviendas v ON p.empadronado_en=v.id
JOIN municipios m ON v.municipio_id= m.id
WHERE v.calle='Los huertos' AND v.numero=3;