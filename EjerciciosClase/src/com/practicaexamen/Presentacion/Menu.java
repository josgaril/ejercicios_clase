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
				mostrarOpciones();
				opcion = pedirOpcion();
				procesarOpcion(opcion);
			} while (opcion != OPCION_SALIR);
			saludoFinal();
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}

	private static void mostrarOpciones() {

		System.out.println("\tMENU\t");
		System.out.println("----------------");
		System.out.println(OPCION_LISTADO + ". Listado");
		System.out.println(OPCION_AGREGAR + ". Añadir alumno");
		System.out.println(OPCION_MODIFICAR + ". Modificar alumno");
		System.out.println(OPCION_BORRAR + ". Borrar alumno");
		System.out.println(OPCION_BUSCAR + ". Buscar alumno");
		System.out.println(OPCION_GUARDAR_CSV + ". Guardar en CSV");
		System.out.println(OPCION_CARGAR_CSV + ". Cargar CSV");
		System.out.println(OPCION_GUARDAR + ". Guardar");
		System.out.println(OPCION_CARGAR + ". Cargar");
		System.out.println(OPCION_SALIR + ". Salir");
	}

	private static int pedirOpcion() {
		return Biblioteca.leerEntero("Dime la opción: ");
	}

	private static void procesarOpcion(int opcion) {
		switch (opcion) {
		case OPCION_SALIR:
			System.out.println("SALIR");
			break;
		case OPCION_LISTADO:
			System.out.println("LISTADO");
			listadoAlumnos();
			break;
		case OPCION_AGREGAR:
			System.out.println("AÑADIR ALUMNO");
			agregarAlumno();
			break;
		case OPCION_MODIFICAR:
			System.out.println("MODIFICAR ALUMNO");
			modificarAlumno();
			break;
		case OPCION_BORRAR:
			System.out.println("BORRAR ALUMNO");
			borrarAlumno();
			break;
		case OPCION_BUSCAR:
			System.out.println("BUSCAR");
			buscarAlumno();
			break;
		case OPCION_GUARDAR_CSV:
			System.out.println("GUARDAR CSV");
			guardarCSV();
			break;
		case OPCION_CARGAR_CSV:
			System.out.println("CARGAR CSV");
			cargarCSV();
			break;
		case OPCION_GUARDAR:
			System.out.println("GUARDAR");
			guardar();
			break;
		case OPCION_CARGAR:
			System.out.println("CARGAR");
			cargar();
			break;
		default:
			System.out.println("NO IMPLEMENTADO");
		}
	}

	private static void cargar() {
		// TODO Auto-generated method stub

	}

	private static void guardar() {
		// TODO implementar guardar
	}

	private static void cargarCSV() {
		// TODO implementar cargar
	}

	private static void guardarCSV() {
		// TODO implementar guardarCSV
	}

	private static void buscarAlumno() {
		Long id = (long) Biblioteca.leerEntero("Dime el ID a buscar: ");

		AlumnoExamen alumno = dao.obtenerPorId(id);

		if (alumno != null) {
			mostrarAlumno(alumno);
		} else {
			System.out.println("No se ha encontrado el alumno");
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

			System.out.println("Alumno borrado");
		} catch (AccesoDatosException e) {
			System.out.println("ERROR al borrar alumno: " + e.getMessage());
		}
	}

	private static void modificarAlumno() {
		listadoAlumnos();

		// TODO: Hacer con long
		Long id = (long) Biblioteca.leerEntero("Dime el ID a modificar: ");

		if (dao.obtenerPorId(id) == null) {
			System.out.println("ERROR: No se ha encontrado el alumno a modificar");
			return;
		}

		AlumnoExamen alumno = pedirDatosAlumno();

		alumno.setId(id);

		try {
			dao.modificar(alumno);
			System.out.println("Alumno modificado");
		} catch (AccesoDatosException e) {
			System.out.println("ERROR al modificar alumno: " + e.getMessage());
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
				System.out.println("ERROR al pedir datos al alumno para modificar: " + e.getMessage());
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

}
