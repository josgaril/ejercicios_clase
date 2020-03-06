<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>
----EN EL EXAMEN ENTRA APIREST
----MIRAR JAX-RS

Para que te lleve a administracion/trabajadores por ejemplo, tienes que guardar la direccion a la que ibas ç
en el filtro, se guarda en una variable de sesion y luego en el loginController le mandamos a esa variable

POR HACER:
------------------------------------------------------------------------------------------
EJERCICIO PRIMERO DE LIBRO, en la biblioteca no tiene que ir la validacion del formato, tiene que ir 
en el programa principal cuando se añade un libro
EL NUMERO DE LETRAS DEL NOMBRE DEL LIBRO..
CONTROLAR CUANDO METES S/N AL AGREGAR EL LIBRO.
- Validaciones de libro CMS cuando metes un "". Probar tooooodas las validaciones
------------------------------------------------------------------------------------------
·Comprobar en salon de masajes(ambas), que los metodos hacer el return dentro del try
-Insomnia
· Corregir lo de la fecha, para que formatee y en vez de T ponga un espacio
· Mirar que te devuelva el id tambien al devolver el objeto creado
-- Configurar bien el acceso Login, que busque los datos en el PathConfiguration en vez de meterlo a mano.
-- Controlar las excepciones cuando se repite un cliente o trabajador con el mismo DNI(que es unico...)--
HACER LOGIN CON BD, Creando BD de usuarios con email y contraseña.
CONTROLAR     BIEN    LA    SESION    NORMAL  CUANDO    SE    MODIFICA  ,   SE    HACE    MAL
- cuando se borra algun elemento, cuadro preguntando si estas seguro de borrarlo
- EN CLASE TRABAJADORES CAMBIAR EL REGEX DE NOMBRE Y APELLIDOS. DEJA METER PUNTOS (.), 
	COMPROBAR MAS. EN CLIENTES POSIBLEMENTE TMB PASE...
- VALIDACIONES EN LA CLASE SESION NORMAL, no la de objetos. AL AGREGAR Y MODIFICAR
- REVISAR TODOS LOS COMENTARIOS DEL PROYETO; QUITANDO LOS QUE NO VALEN
- REVISAR LOS MENSAJES CUANDO HAY ERRORES O AVISOS DE INFORMACION, QUE NO SALGAN DE OTRA CLASE
- Fabrica Dao y FabricaDaoProperties
- Pool de conexiones
- Test de clientes
- SesionDao para cita periodica semanal
- Crear mas procedimientos

- Poner enzima del menu una imagen de "Empresa de masajes SAMAJA", en plan logo y asi...
- Poner en el menu de administracion desplegable con las opciones
- Listado de trabajadores con su foto aleatoria generada
- Listado de clientes con su foto aleatoria generada
- Hacer que cuando un cliente le de a contratar un servicio le obligue a loguearse como cliente 
  (password 112233) y pueda contratarlo despues.
  Tendré que hacer otro filtro de login diferente solo para que el cliente acceda a adminservcicios. 
  Lo suyo sería que cada cliente tenga su propio usuario..
  Modificar foto del cliente cuando se loguea
- Mejora en las cards de los listados.
- Configurar bien las columnas de todas las tablas. 
- Quitar los enlaces superiores de listado de trabajadores, clientes y sesiones?

EJERCICIO casa, salonCasa, cocinaCasa
https://www.aprenderaprogramar.com/index.php?option=com_content&view=article&id=511:clases-que-utilizan-objetos-relacion-de-uso-entre-clases-java-concepto-de-diagrama-de-clases-cu00641b&catid=68&Itemid=188

Hecho pero no funciona si lo dejo activado, asique.. volver a mirar:
- COMPROBAR LOS REGEX DE DNI, NOMBRE, APELLIDOS...

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>
