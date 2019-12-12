package generales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej5_ContarNumAcabadosEn2 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		/*
		 * 5.Programa que lea una serie de n�meros por teclado hasta que se lea un
		 * n�mero negativo. El programa indicar� cu�ntos n�meros acabados en 2 se han
		 * le�do.
		 */
		int num, cont=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.print("Introduce un n�mero (negativo para salir): ");
			num = Integer.parseInt(br.readLine());
			if(num%10==2) {
				cont++;	
			}
		} while (num >= 0);
		System.out.println("Se han introducido " + cont + " n�meros que acaban en 2");
	}

}
