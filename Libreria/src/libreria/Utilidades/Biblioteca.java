package libreria.Utilidades;

import java.util.Scanner;

public class Biblioteca {

	private static Scanner s = new Scanner(System.in);

	public static int leerEntero(String mensaje) {

		int i = 0;
		boolean correcto = true;

		do {
			System.out.print(mensaje);
			try {
				correcto = true;
				i = Integer.parseInt(s.nextLine());
			} catch (NumberFormatException e) {
				correcto = false;
				System.out.println("El dato introducido no es un n�mero entero");
			}
		} while (!correcto);

		return i;
	}

	public static String leerLinea(String mensaje) {
		System.out.print(mensaje);
		return s.nextLine();
	}

	/*
	 * public static boolean formatoValido(String formato) { boolean valor = true;
	 * if (formato.equals("Digital") || formato.equals("Papel") ||
	 * formato.equals("digital") || formato.equals("papel")) { valor = true; } else
	 * {
	 * 
	 * valor = false; } return valor; }
	 */
}
