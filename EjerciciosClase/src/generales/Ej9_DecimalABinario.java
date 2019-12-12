package generales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej9_DecimalABinario {

	public static void main(String[] args) throws NumberFormatException, IOException {

		/*
		 * 9. En esta entrada vamos a escribir el programa java para convertir un
		 * n�mero de decimal a binario. Para escribir el programa nos vamos a basar en
		 * la forma cl�sica de pasar de decimal a binario, o sea, dividir el n�mero
		 * entre 2 y quedarnos con el resto de la divisi�n. Esta cifra, que ser� un cero
		 * o un uno, es el d�gito de menos peso (m�s a la derecha) del n�mero binario. A
		 * continuaci�n volvemos a dividir el cociente que hemos obtenido entre 2 y nos
		 * quedamos con el resto de la divisi�n. Esta cifra ser� la segunda por la
		 * derecha del n�mero binario. Esta operaci�n se repite hasta que obtengamos un
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
