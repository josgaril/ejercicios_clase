package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej1_Media10Numeros {

	public static void main(String[] args) throws NumberFormatException, IOException {

		/*
		 * 1. Programa Java que lea por teclado 10 números enteros y los guarde en un
		 * array. A continuación calcula y muestra por separado la media de los valores
		 * positivos y la de los valores negativos.
		 */
		int i;
		double sumapos = 0, sumaneg = 0, contpos = 0, contneg = 0, mediapos = 0, medianeg = 0;
		int[] numeros = new int[10];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Ingroduce 10 numeros enteros.");
		for (i = 0; i <= 9; i++) {
			System.out.print("Número " + (i + 1) + " -> ");
			numeros[i] = Integer.parseInt(br.readLine());

		}

		for (i = 0; i <= 9; i++) {
			if (numeros[i] < 0) {
				++contneg;
				sumaneg += numeros[i];
			} else {
				++contpos;
				sumapos += numeros[i];
			}
		}
		if (contpos != 0) {
			System.out.println("La media de los valores positivos es: " + sumapos / contpos);
		} else {
			System.out.println("No se han introducido numeros positivos. ");
		}
		if (contneg != 0) {
			System.out.println("La media de los valores negatibos es: " + sumaneg / contneg);
		} else {
			System.out.println("No se han introducido numeros negativos.");
		}
	}
}
