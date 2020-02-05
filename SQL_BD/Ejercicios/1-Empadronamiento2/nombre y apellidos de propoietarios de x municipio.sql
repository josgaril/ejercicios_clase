SELECT DISTINCT p.nombre, p.apellidos, m.nombre municipio
FROM personas p
JOIN personas_has_viviendas pv ON p.id=pv.persona_id
JOIN viviendas v ON pv.vivienda_id=v.id
JOIN municipios m ON v.municipio_id=m.id
WHERE m.nombre='Valles de Palenzuela'
;