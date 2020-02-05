SELECT a.nombre Alojamiento, ac.nombre Actividad, ac.descripcion 
FROM alojamientos a
JOIN alojamientos_has_actividades aa ON a.id=aa.alojamiento_id
JOIN actividades ac ON aa.actividad_id = ac.id
WHERE a.nombre = "La Huerta"
ORDER BY ac.nombre;