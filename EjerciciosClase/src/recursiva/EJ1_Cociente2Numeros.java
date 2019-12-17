package recursiva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EJ1_Cociente2Numeros {

	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * Programa Java que calcule el cociente de dos números enteros de forma
		 * recursiva.
		 * 
		 * La solución recursiva del problema se plantea de la siguiente forma:
		 * 
		 * Caso Base: Si el dividendo es menor que el divisor el cociente es cero.
		 * 
		 * Si no, se restan el dividendo y el divisor. Al resultado se le vuelve a
		 * restar el divisor. Esta resta se repite mientras se pueda realizar, o sea,
		 * mientras el resultado sea mayor o igual que el divisor. El número de veces
		 * que se ha hecho la resta es el cociente.
		 * 
		 * Con un ejemplo lo veremos más claro. Por ejemplo, para dividir 10 entre 3
		 * haríamos:
		 * 
		 * 10 - 3 = 7 7 - 3 = 4 4 - 3 = 1
		 * 
		 * No se puede seguir restando ya que el último valor obtenido (1) es menor que
		 * el divisor. Como se han realizado 3 restas el cociente es 3.
		 */
		int dividendo, divisor, cociente = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduzca dos numeros para obtener su cociente");
		System.out.print("Dividendo: ");
		dividendo = Integer.parseInt(br.readLine());
		do {
			System.out.print("Divisor: ");
			divisor = Integer.parseInt(br.readLine());
		} while (dividendo<=0);
		if (dividendo < divisor) {
			cociente = 0;
		} else {
			do {
				cociente++;
				dividendo = dividendo - divisor;
			} while (dividendo >= divisor);
		}
		System.out.println("El cociente es: " + cociente);
	}
}
