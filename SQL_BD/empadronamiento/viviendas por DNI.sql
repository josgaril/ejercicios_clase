SELECT p.dni, v.calle, v.numero 
FROM personas p
JOIN situacion s ON p.id = s.persona_id
JOIN viviendas v ON s.vivienda_id = v.id
WHERE p.dni='71256985D';