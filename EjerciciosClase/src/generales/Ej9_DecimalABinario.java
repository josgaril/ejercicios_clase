package generales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej9_DecimalABinario {

	public static void main(String[] args) throws NumberFormatException, IOException {

		/*
		 * 9. En esta entrada vamos a escribir el programa java para convertir un
		 * número de decimal a binario. Para escribir el programa nos vamos a basar en
		 * la forma clásica de pasar de decimal a binario, o sea, dividir el número
		 * entre 2 y quedarnos con el resto de la división. Esta cifra, que será un cero
		 * o un uno, es el dígito de menos peso (más a la derecha) del número binario. A
		 * continuación volvemos a dividir el cociente que hemos obtenido entre 2 y nos
		 * quedamos con el resto de la división. Esta cifra será la segunda por la
		 * derecha del número binario. Esta operación se repite hasta que obtengamos un
		 * cero como cociente.
		 */
		int num, digito, exp;
		double binario;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		do {
			System.out.print("Introduzca un numero decimal para pasarlo a binario-> ");
			num = Integer.parseInt(br.readLine());
		} while (num < 0);
		exp = 0;
		binario = 0;
		while (num != 0) {
			digito = num % 2;
			binario = binario + digito * Math.pow(10, exp);
			exp++;
			num = num / 2;
		}
		System.out.printf("Binario: %.0f %n", binario);
	}

}
