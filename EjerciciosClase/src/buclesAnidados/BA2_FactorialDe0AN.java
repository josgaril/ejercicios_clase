package buclesAnidados;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BA2_FactorialDe0AN {

	public static void main(String[] args) throws NumberFormatException, IOException {

		/*
		 * 2. Leer un número N y calcular el factorial de los números desde 0 hasta N.
		 */

		int numero, i, j;
		double factorial = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Factorial de numeros desde 0 hasta N");
		do {
			System.out.print("Introduzca un numero(N) mayor que 0: ");
			numero = Integer.parseInt(br.readLine());
		} while (numero < 0);

		for (i = 0; i <= numero; i++) {
			factorial = 1;
			for (j = 1; j <= i; j++) {
				factorial = factorial * j;
			}
			System.out.printf("%2d! = %.0f %n", i,factorial);
		}
		
		System.out.println("Fin del programa");
	}
}
