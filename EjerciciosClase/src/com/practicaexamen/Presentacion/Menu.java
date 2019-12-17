package com.practicaexamen.Presentacion;

import java.text.SimpleDateFormat;

import com.practicaexamen.accesodatos.AccesoDatosException;
import com.practicaexamen.accesodatos.AlumnoArrayList;
import com.practicaexamen.accesodatos.Dao;
import com.practicaexamen.entidades.AlumnoExamen;
import com.practicaexamen.entidades.EntidadesException;
import com.practicaexamen.utilidades.Biblioteca;

public class Menu {

	private static final Dao<AlumnoExamen> dao = AlumnoArrayList.getInstancia();

	private static final SimpleDateFormat FECHA_CORTA = new SimpleDateFormat("dd-MM-yyyy");

	private static final int OPCION_SALIR = 0;
	private static final int OPCION_LISTADO = 1;
	private static final int OPCION_AGREGAR = 2;
	private static final int OPCION_MODIFICAR = 3;
	private static final int OPCION_BORRAR = 4;
	private static final int OPCION_BUSCAR = 5;
	private static final int OPCION_GUARDAR_CSV = 6;
	private static final int OPCION_CARGAR_CSV = 7;
	private static final int OPCION_GUARDAR = 8;
	private static final int OPCION_CARGAR = 9;

	public static void main(String[] args) {
		try {
			int opcion = 0;

			do {
				// BORRAR CONSOLA DE MSDOS (Sólo funciona en el MSDOS, no en Eclipse)
				// new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				mostrarOpciones();
				opcion = pedirOpcion();
				procesarOpcion(opcion);
			} while (opcion != OPCION_SALIR);

			saludoFinal();
		} catch (Exception e) {
			mostrar("ERROR: " + e.getMessage());
			return;
		}
	}

	private static void mostrarOpciones() {
		mostrar("\n\tMENU");
		mostrar("------------------");
		mostrar(OPCION_LISTADO + ". Listado");
		mostrar(OPCION_AGREGAR + ". Añadir alumno");
		mostrar(OPCION_MODIFICAR + ". Modificar alumno");
		mostrar(OPCION_BORRAR + ". Borrar alumno");
		mostrar(OPCION_BUSCAR + ". Buscar alumno");
		mostrar(OPCION_GUARDAR_CSV + ". Guardar en CSV");
		mostrar(OPCION_CARGAR_CSV + ". Cargar CSV");
		mostrar(OPCION_GUARDAR + ". Guardar");
		mostrar(OPCION_CARGAR + ". Cargar");
		mostrar(OPCION_SALIR + ". Salir");
	}

	private static int pedirOpcion() {
		return Biblioteca.leerEntero("Dime la opción: ");
	}

	private static void procesarOpcion(int opcion) {
		switch (opcion) {
		case OPCION_SALIR:
			mostrar("SALIR");
			break;
		case OPCION_LISTADO:
			mostrar("LISTADO");
			listadoAlumnos();
			break;
		case OPCION_AGREGAR:
			mostrar("AÑADIR ALUMNO");
			agregarAlumno();
			break;
		case OPCION_MODIFICAR:
			mostrar("MODIFICAR ALUMNO");
			modificarAlumno();
			break;
		case OPCION_BORRAR:
			mostrar("BORRAR ALUMNO");
			borrarAlumno();
			break;
		case OPCION_BUSCAR:
			mostrar("BUSCAR");
			buscarAlumno();
			break;
		case OPCION_GUARDAR_CSV:
			mostrar("GUARDAR CSV");
			guardarCSV();
			break;
		case OPCION_CARGAR_CSV:
			mostrar("CARGAR CSV");
			cargarCSV();
			break;
		case OPCION_GUARDAR:
			mostrar("GUARDAR");
			guardar();
			break;
		case OPCION_CARGAR:
			mostrar("CARGAR");
			cargar();
			break;
		default:
			mostrar("NO IMPLEMENTADO");
		}
	}

	private static void cargar() {
		//
	}

	private static void guardar() {
		//
	}

	private static void gestionErrores(Exception e) {
		//
	}

	private static void cargarCSV() {
		//
	}

	private static void guardarCSV() {
		//
	}

	private static void buscarAlumno() {
		Long id = (long) Biblioteca.leerEntero("Dime el ID a buscar: ");

		AlumnoExamen alumno = dao.obtenerPorId(id);

		if (alumno != null) {
			mostrarAlumno(alumno);
		} else {
			mostrar("No se ha encontrado el alumno");
		}
	}

	private static void mostrarAlumno(AlumnoExamen alumno) {
		System.out.println("                 ID: " + alumno.getId());
		System.out.println("             Nombre: " + alumno.getNombre());
		System.out.println("          Apellidos: " + alumno.getApellidos());
		System.out.println("                DNI: " + alumno.getDni());
		System.out.println("Fecha de nacimiento: " + FECHA_CORTA.format(alumno.getFechaNacimiento()));
	}

	private static void borrarAlumno() {
		listadoAlumnos();

		// TODO: Hacer con long
		Long id = (long) Biblioteca.leerEntero("Dime el ID a borrar: ");

		try {
			dao.borrar(id);

			mostrar("Alumno borrado");
		} catch (AccesoDatosException e) {
			mostrar("ERROR: " + e.getMessage());
		}
	}

	private static void modificarAlumno() {
		listadoAlumnos();

		// TODO: Hacer con long
		Long id = (long) Biblioteca.leerEntero("Dime el ID a modificar: ");

		if (dao.obtenerPorId(id) == null) {
			mostrar("ERROR: No se ha encontrado el alumno a modificar");
			return;
		}

		AlumnoExamen alumno = pedirDatosAlumno();

		alumno.setId(id);

		try {
			dao.modificar(alumno);
			mostrar("Alumno modificado");
		} catch (AccesoDatosException e) {
			mostrar("ERROR: " + e.getMessage());
		}
	}

	private static void agregarAlumno() {
		AlumnoExamen alumno = pedirDatosAlumno();

		dao.agregar(alumno);
	}

	private static AlumnoExamen pedirDatosAlumno() {
		AlumnoExamen alumno = new AlumnoExamen();

		final int NOMBRE = 0;
		final int APELLIDOS = 1;
		final int DNI = 2;
		final int FECHA = 3;

		int campo = 0;

		while (campo <= FECHA) {
			try {
				switch (campo) {
				case NOMBRE:
					alumno.setNombre(Biblioteca.leerLinea("Nombre: "));
					break;
				case APELLIDOS:
					alumno.setApellidos(Biblioteca.leerLinea("Apellidos: "));
					break;
				case DNI:
					alumno.setDni(Biblioteca.leerLinea("DNI: "));
					break;
				case FECHA:
					alumno.setFechaNacimiento(Biblioteca.leerDate("Fecha de nacimiento: "));
					break;
				default:
					throw new PresentacionException("CAMPO NO DEFINIDO");
				}

				campo++;

			} catch (EntidadesException e) {
				mostrar("ERROR: " + e.getMessage());
			}
		}
		return alumno;
	}

	private static void listadoAlumnos() {
		// TODO: Usar columnas de tamaño fijo
		mostrarCabeceraListado();
		for (AlumnoExamen alumno : dao.obtenerTodos()) {
			mostrarAlumnoFila(alumno);
		}
	}

	private static void mostrarCabeceraListado() {
		System.out.print("ID");
		System.out.print('\t');
		System.out.print("NOMBRE");
		System.out.print('\t');
		System.out.print("APELLIDOS");
		System.out.print('\t');
		System.out.print("DNI");
		System.out.print("\t\t");
		System.out.print("FECHA DE NACIMIENTO");
		System.out.println();
	}

	private static void mostrarAlumnoFila(AlumnoExamen alumno) {
		System.out.print(alumno.getId());
		System.out.print('\t');
		System.out.print(alumno.getNombre());
		System.out.print('\t');
		System.out.print(alumno.getApellidos());
		System.out.print('\t');
		System.out.print(alumno.getDni());
		System.out.print('\t');
		System.out.print(FECHA_CORTA.format(alumno.getFechaNacimiento()));
		System.out.println();
	}

	private static void saludoFinal() {
		System.out.println("Gracias por usar nuestro programa");
	}

	private static void mostrar(Object o) {
		System.out.println(o);
	}

}
