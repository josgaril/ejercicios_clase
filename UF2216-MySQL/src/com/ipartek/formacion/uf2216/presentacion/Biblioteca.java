package com.ipartek.formacion.uf2216.presentacion;

import java.util.Scanner;

public class Biblioteca {

	private static Scanner sc = new Scanner(System.in);

	public static int leerEntero(String mensaje) {

		int i = 0;
		boolean correcto = true;
		do {
			System.out.println(mensaje);

			try {
				correcto = true;
				i = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				correcto = false;
				System.out.println("El dato introducido no es un número entero");
			}

		} while (!correcto);
		return i;
	}

}
