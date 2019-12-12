package generales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej2_NumeroCifras {

	public static void main(String[] args) throws NumberFormatException, IOException {

		/*
		 * 2. Programa Java que pide un número entero por teclado y calcula y muestra el
		 * número de cifras que tiene.
		 */
		int num, cont;
		String cadena;
		char respuesta;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.print("Introduce un número: ");
			num = Integer.parseInt(br.readLine());
			cont=0;
			while (num != 0) {
				num = num / 10;
				cont++;
			}
			System.out.println("El numero tiene " + cont + " cifras");
			System.out.print("¿Desea introducir otro número?(S/N): ");
			cadena = br.readLine();
			respuesta = cadena.charAt(0);
		} while (respuesta != 'N' && respuesta != 'n');
		System.out.println("Fin del programa");
	}
}
