package generales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej12_CifradoCesar {

	public static void main(String[] args) throws IOException {

		/*
		 * 12. Programa para codificar o decodificar un texto utilizando el método de
		 * cifrado de César. Supondremos que el texto solo contiene letras mayúsculas o
		 * minúsculas. La letras serán las correspondientes al alfabeto inglés (26
		 * caracteres, excluimos la ñ y Ñ). En este método de cifrado cada letra del
		 * texto se sustituye por otra letra que se encuentra N posiciones adelante en
		 * el alfabeto. Se considera que el alfabeto es circular, es decir, la letra
		 * siguiente a la ‘z’ es la ‘a’.
		 * 
		 * Para descifrar un texto se realiza la operación contraria. Se calcula la
		 * letra que está N posiciones por detrás en el alfabeto. Como el alfabeto es
		 * circular, la letra anterior a la ‘a’ es la ‘z’.
		 * 
		 * El programa pedirá por teclado un texto, a continuación el valor de N y si
		 * queremos codificar o decodificar el texto. Finalmente se mostrará el texto
		 * resultante.
		 * 
		 */

		int num, i;
		String texto, cadena, codificado = "", resultado;
		char letra, opcion;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.print("Introduce un texto: ");
			texto = br.readLine();
		} while (texto.isEmpty());

		do {
			System.out.print("Introduce el valor de N: ");
			num = Integer.parseInt(br.readLine());
		} while (num < 1);

		do {
			System.out.print("Elija codificar(C) o decodificar(D)-> ");
			cadena = br.readLine();
			opcion = cadena.charAt(0);
			if (opcion == 'C') {
				resultado = cifradoCesar(texto, num);
			}
			if (opcion == 'D') {
				descifradoCesar(texto, num);
			}
		} while (opcion != 'C' && opcion != 'D');

	}

	private static void descifradoCesar(String texto, int num) {
		/*
		 * System.out.println("descifrar"); String resultado; return
		 * resultado.tostring();
		 */
		// return acabar!!!();
	}

	private static String cifradoCesar(String texto, int num) {
		System.out.println("Se procede a cifrar el texto.");
		int i;
		String cifrado = "";
		char letra;
		for (i = 1; i <= texto.length(); i++) {
			letra = texto.charAt(i);
			System.out.println("Letra " + letra);
			cifrado += (letra + num);
		}
		return cifrado;

	}

}
