SELECT DISTINCT a.nombre AS Alojamiento, t.nombre AS Tipo_Habitacion, ac.nombre AS Actividad
FROM alojamientos a 
JOIN habitaciones h ON h.alojamiento_id=a.id
JOIN tipos t ON h.tipo_id = t.id
JOIN alojamientos_has_actividades aa ON a.id=aa.alojamiento_id
JOIN actividades ac ON aa.actividad_id=ac.id
WHERE ac.nombre = "Senderismo" AND t.nombre="Doble"
ORDER BY a.nombre;

