package estructuraRepetitiva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EI1_MultiplosDeNDesde1aM_Ejercicio11 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		/*
		 * 11. Programa que lea dos n�meros enteros positivos N y M y muestre los
		 * m�ltiplos de N que hay desde 1 hasta M. Por ejemplo si N = 4 y M = 500 el
		 * programa mostrar� los m�ltiplos de 4 desde 1 hasta 500. El valor de N deber�
		 * ser menor que el valor de M. Si no se introducen valores v�lidos para N o M
		 * se mostrar� el mensaje correspondiente y se vuelven a pedir.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N, M, i;
		do {
			System.out.print("Introduzca un n�mero positivo: ");
			M = Integer.parseInt(br.readLine());
			if (M<=0) {
				System.out.println("Debe introducir un n�nmero positivo");
			}
		} while (M <= 0);
		do {
			System.out.print("�Qu� m�ltiplos quiere ver?");
			N = Integer.parseInt(br.readLine());
			if (M < N) {
				System.out.println("El m�ltiplo tiene que ser menor que el n�mero introducido");
			}
		} while (M < N);
		System.out.println("Se muestras los m�ltiplos de " + N + " desde 1 hasta " + M + " :");
		for (i = 1; i <= M; i++) {
			if ((i % N) == 0) {
				System.out.println(i + " es m�ltiplo de " + N);
			}
		}

	}

}
