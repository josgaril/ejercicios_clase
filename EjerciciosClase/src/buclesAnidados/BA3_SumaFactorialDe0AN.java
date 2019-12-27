package buclesAnidados;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BA3_SumaFactorialDe0AN {

	public static void main(String[] args) throws NumberFormatException, IOException {

		/*
		 * 3. Leer por teclado un número entero N no negativo y mostrar la suma de los
		 * factoriales de todos los números desde 0 hasta N.
		 */

		int numero, i, j;
		double factorial, suma=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduzca un numero para calcular la suma de los factoriales de 0 hasta N");
		do {
			System.out.print("Introduzca un umero entero no negativo(N): ");
			numero = Integer.parseInt(br.readLine());
		} while (numero < 0);

		for (i = 0; i <= numero; i++) {
			factorial = 1;
			for (j = 1; j <= i; j++) {
				factorial = factorial * j;				
			}
			
			System.out.println("Factorial de " + i + "=" + factorial);
			
			suma=suma+factorial;
		}
		System.out.println("La suma de los factoriales desde 0 hasta " + numero + " es: " + suma);
		System.out.println("Fin del programa");
	}

}
