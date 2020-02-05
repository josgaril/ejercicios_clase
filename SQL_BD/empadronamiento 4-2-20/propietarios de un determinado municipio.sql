SELECT DISTINCT p.nombre, p.apellidos, s.propietario, m.nombre
FROM personas p
JOIN situacion s ON p.id=s.persona_id
JOIN viviendas v ON s.vivienda_id=v.id
JOIN municipios m ON v.municipio_id=m.id
WHERE s.propietario=1 AND m.nombre="Valles de Palenzuela"
ORDER BY p.nombre; 