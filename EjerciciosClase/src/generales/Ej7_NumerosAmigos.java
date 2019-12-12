package generales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej7_NumerosAmigos {

	public static void main(String[] args) throws NumberFormatException, IOException {

		/*
		 * 7. COMPROBAR SI DOS N�MEROS SON AMIGOS. Dos n�meros enteros positivos A y B
		 * son n�meros amigos si la suma de los divisores propios de A es igual a B y la
		 * suma de los divisores propios de B es igual a A. Los divisores propios de un
		 * n�mero incluyen la unidad pero no el propio n�mero.
		 */
		int num1, num2, acum = 0, i;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduzca dos n�meros para saber si son amigos");
		System.out.print("N�mero 1-> ");
		num1 = Integer.parseInt(br.readLine());
		System.out.print("N�mero 2-> ");
		num2 = Integer.parseInt(br.readLine());
		for (i = 1; i < num1; i++) {
			if (num1 % i == 0) {
				acum += i;
			}
		}
		if (acum == num2) {
			acum=0;
			for (i = 1; i < num2; i++) {
				if (num2 % i == 0) {
					acum += i;
				}
			}
			if (acum == num1) {
				System.out.println("Los n�meros " + num1 + " y " + num2 + " son amigos");
			}else {
				System.out.println("Los n�meros " + num1 + " y " + num2 + " no son amigos");
			}
		}else {
			System.out.println("Los n�meros " + num1 + " y " + num2 + " no son amigos");
		}
	}

}
