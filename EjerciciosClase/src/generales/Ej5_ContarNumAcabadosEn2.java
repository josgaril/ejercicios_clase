package generales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej5_ContarNumAcabadosEn2 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		/*
		 * 5.Programa que lea una serie de números por teclado hasta que se lea un
		 * número negativo. El programa indicará cuántos números acabados en 2 se han
		 * leído.
		 */
		int num, cont=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.print("Introduce un número (negativo para salir): ");
			num = Integer.parseInt(br.readLine());
			if(num%10==2) {
				cont++;	
			}
		} while (num >= 0);
		System.out.println("Se han introducido " + cont + " números que acaban en 2");
	}

}
