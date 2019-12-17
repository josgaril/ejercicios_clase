package com.practicaexamen.Presentacion;

import com.practicaexamen.entidades.EntidadesException;

public class Menu {

	private static final int OPCION_SALIR = 0;

	public static void main(String[] args) {

		try {
			int opcion = 0;
			do {
				mostrarOpciones();
				opcion = pedirOpcion();
				procesarOpcion();
			} while (opcion != OPCION_SALIR);
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}
	
	private static void mostrarOpciones() {

		System.out.println("\tMenú\t");
		System.out.println("1- Listado");
		System.out.println();

	}
	private static void procesarOpcion() {
		// TODO Auto-generated method stub

	}

	private static int pedirOpcion() {
		// TODO Auto-generated method stub
		return 0;
	}



}
