/* 1.	Listado de todos los proveedores ordenados alfabéticamente.*/
SELECT *
FROM proveedores
ORDER BY nombre;

/* 2.   Listado de todos productos organizados por categorías.*/
SELECT id_producto, descripcion, precio, id_categoria, id_proveedor
FROM productos
ORDER BY id_categoria, descripcion;

/* 3.	Las ventas del último mes, mostrando: cliente, producto, categoría y cantidad */

SELECT c.nombre AS Cliente, prod.descripcion AS Producto, cat.descripcion AS Categoría, v.cantidad, f.fecha
FROM ventas v
INNER JOIN facturas f ON v.id_factura = f.id_factura
INNER JOIN clientes c ON c.id_cliente = f.id_factura
INNER JOIN productos prod ON v.id_producto = prod.id_producto
INNER JOIN categorias cat ON cat.id_categoria = prod.id_categoria
-- ACABAR LO DE LA FECHA DEL ULTIMO MES UTILIZANDO MAX(f.fecha)
;

/* 4.	Listado de los 5 productos más vendidos */
SELECT p.id_producto, p.descripcion, SUM(v.cantidad) AS CantidadVendida
FROM productos p
INNER JOIN ventas v ON p.id_producto=v.id_producto
GROUP BY p.descripcion
ORDER BY CantidadVendida DESC
LIMIT 5;

/* 5.	Listado de los 5 clientes que más dinero han gastado */
SELECT cl.nombre AS Cliente, SUM(d.total) AS TOTAL
FROM clientes cl 
INNER JOIN (SELECT c.nombre, f.id_factura, p.id_producto, v.cantidad,  p.precio, p.precio*cantidad AS total
			FROM clientes c
			INNER JOIN facturas f ON c.id_cliente = f.id_cliente
			INNER JOIN ventas v ON f.id_factura = v.id_factura
			INNER JOIN productos p ON v.id_producto = p.id_producto
			ORDER BY c.nombre) d ON cl.nombre=d.nombre
GROUP BY cl.nombre
ORDER BY TOTAL DESC
LIMIT 1;
