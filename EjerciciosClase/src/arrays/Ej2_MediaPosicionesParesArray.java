package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej2_MediaPosicionesParesArray {

	public static void main(String[] args) throws NumberFormatException, IOException {

		/*
		 * 2. 2. Programa Java que lea 10 números enteros por teclado y los guarde en un
		 * array. Calcula y muestra la media de los números que estén en las posiciones
		 * pares del array.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i,suma=0;
		int[] numeros = new int[10];
		System.out.println("Introduce 10 numeros enteros.");
		for (i = 0; i <= 9; i++) {
			System.out.print("Número " + (i + 1) + " -> ");
			numeros[i] = Integer.parseInt(br.readLine());
		}
	

	for (i = 0; i <= 9; i++) {
		if (i %2 == 0) {
			suma=suma+numeros[i];
		}
	}
		System.out.println("La media los valores de posiciones pares del array es: " + suma/5);
	}
}
