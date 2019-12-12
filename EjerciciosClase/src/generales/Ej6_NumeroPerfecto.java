package generales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej6_NumeroPerfecto {

	public static void main(String[] args) throws NumberFormatException, IOException {

		/*
		 * 6. Comprobar si un número es perfecto. El programa pide por teclado un número
		 * y muestra si es perfecto o no. mediante un bucle for sumaremos los divisores
		 * del número. Al final si esta suma es igual al número mostraremos el mensaje
		 * correspondiente.
		 */

		int num, acum = 0, i;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Introduce un número: ");
		num = Integer.parseInt(br.readLine());
		for (i = 1; i < num; i++) {
			if (num % i == 0) {
				acum += i;
			}
		}
		if (acum == num) {
			System.out.println("El número es perfecto");
		} else {
			System.out.println("El número no es perfecto");
		}

		/*
		 * Utilizando el algoritmo anterior vamos a escribir ahora el programa Java que
		 * muestre los números perfectos entre 1 y 1000
		 */
		System.out.println("Se muestran los numeros perfectos entre 1 y 1000");
		int j;

		for (i = 1; i <= 1000; i++) {
			acum = 0;
			for (j = 1; j < i; j++) {
				if (i % j == 0) {
					acum += j;
				}
			}
			if (acum == i) {
				System.out.println("El número " + i + " es perfecto");
			}
		}
		System.out.println("Fin del programa");
	}
}