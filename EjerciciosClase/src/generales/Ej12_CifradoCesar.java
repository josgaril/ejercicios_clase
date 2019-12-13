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

		int num;
		String texto, cadena;
		char opcion;
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
		} while (Character.toUpperCase(opcion) != 'C' && Character.toUpperCase(opcion) != 'D');
			if (Character.toUpperCase(opcion) == 'C') {
				System.out.println("El texto cifrado es: " + cifradoCesar(texto, num));
			}
			if (Character.toUpperCase(opcion) == 'D') {
				System.out.println("El texto descifrado es: " + descifradoCesar(texto, num));
			}
		

	}

	private static String descifradoCesar(String texto, int num) {
		System.out.println("Se procede a descifrar el texto.");
		StringBuilder cifrado = new StringBuilder();
		int i;
		for (i = 0; i < texto.length(); i++) {
			for (i = 0; i < texto.length(); i++) {
				if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
					if ((texto.charAt(i) + num) > 'z') {
						cifrado.append((char) (texto.charAt(i) - num + 26));
					} else {
						cifrado.append((char) (texto.charAt(i) - num));
					}
				} else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
					if ((texto.charAt(i) + num) > 'Z') {
						cifrado.append((char) (texto.charAt(i) - num + 26));
					} else {
						cifrado.append((char) (texto.charAt(i) - num));
					}
				}
			}
		}
		return cifrado.toString();
	}

	private static String cifradoCesar(String texto, int num) {
		System.out.println("Se procede a cifrar el texto.");
		StringBuilder cifrado = new StringBuilder();
		int i;
		for (i = 0; i < texto.length(); i++) {
			for (i = 0; i < texto.length(); i++) {
				if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
					if ((texto.charAt(i) + num) > 'z') {
						cifrado.append((char) (texto.charAt(i) + num - 26));
					} else {
						cifrado.append((char) (texto.charAt(i) + num));
					}
				} else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
					if ((texto.charAt(i) + num) > 'Z') {
						cifrado.append((char) (texto.charAt(i) + num - 26));
					} else {
						cifrado.append((char) (texto.charAt(i) + num));
					}
				}
			}
		}
		return cifrado.toString();
	}
}
