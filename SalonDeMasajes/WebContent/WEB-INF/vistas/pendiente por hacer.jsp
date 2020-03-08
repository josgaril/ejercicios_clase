<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>
----EN EL EXAMEN ENTRA APIREST
----MIRAR JAX-RS

Para que te lleve a administracion/trabajadores por ejemplo, tienes que guardar la direccion a la que ibas ç
en el filtro, se guarda en una variable de sesion y luego en el loginController le mandamos a esa variable

POR HACER:
------------------------------------------------------------------------------------------
EJERCICIO PRIMERO DE LIBRO:
- Hacer metodo guardar y metodo cargar
------------------------------------------------------------------------------------------
· Validaciones en todos los REST de JAX_RS
·Comprobar en salon de masajes(ambas), que los metodos hacer el return dentro del try, meter 
	los PreparedStatement y ResultSet con trycatch, no solo el connection. 
	YA CORREGIDO EN SALON DE MASAJES. COPIAR Y PEGAR TODAS DE NUEVO O MODIFICAR EN EXISTENTES...
	TENER EN CUENTA QUE LAS DE JAX-RS tienen conifgurado lo jsonProperties en los setters de 
	clientes,trabajadores y servicios. y jsonFormat para la fecha en el setter
	
-Insomnia
· ApiREST.En clientes y trabajadores, Si meto un id que no existe lo coge como que no es el mismo que el de la url
· REST. Corregir lo de la fecha, para que formatee y en vez de T ponga un espacio
· Mirar que te devuelva el id tambien al devolver el objeto creado

-- Configurar bien el acceso Login, que busque los datos en el PathConfiguration en vez de meterlo a mano.
HACER LOGIN CON BD, Creando BD de usuarios con email y contraseña.
CONTROLAR     BIEN    LA    SESION    NORMAL  CUANDO    SE    MODIFICA  ,   SE    HACE    MAL
- cuando se borra algun elemento, cuadro preguntando si estas seguro de borrarlo

- Fabrica Dao y FabricaDaoProperties
- Pool de conexiones
- Test de clientes
- SesionDao para cita periodica semanal
- Crear mas procedimientos

- Poner enzima del menu una imagen de "Empresa de masajes SAMAJA", en plan logo y asi...
- Poner en el menu de administracion desplegable con las opciones
- Listado de trabajadores con su foto aleatoria generada
- Listado de clientes con su foto aleatoria generada

  Tendré que hacer otro filtro de login diferente solo para que el cliente acceda a adminservcicios. 
  Lo suyo sería que cada cliente tenga su propio usuario..
- Mejora en las cards de los listados.
- Configurar bien las columnas de todas las tablas. 
- Quitar los enlaces superiores de listado de trabajadores, clientes y sesiones?

EJERCICIO casa, salonCasa, cocinaCasa
https://www.aprenderaprogramar.com/index.php?option=com_content&view=article&id=511:clases-que-utilizan-objetos-relacion-de-uso-entre-clases-java-concepto-de-diagrama-de-clases-cu00641b&catid=68&Itemid=188

Hecho pero no funciona si lo dejo activado, asique.. volver a mirar:
- COMPROBAR LOS REGEX DE DNI, NOMBRE, APELLIDOS...

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>
