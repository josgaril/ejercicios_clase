package estructuraRepetitiva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EI1_deNhasta1_Ejercicio8 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		/*
		 * Programa que pida que se introduzca por teclado el valor de un número entero
		 * N y muestre los números desde N hasta 1 ambos incluidos. Se debe resolver
		 * este ejercicio de tres formas distintas: utilizando la estructura repetitiva
		 * while, utilizando la estructura repetitiva do .. while y utilizando la
		 * estructura repetitiva for.
		 */		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n1,i;
		System.out.print("Introduzca un número: ");
		n1 = Integer.parseInt(br.readLine());
		System.out.println("Numeros del " + n1 + " al 1 utilizando While");
		while(n1>=1) {
			System.out.println(n1--);
		}
		System.out.println("");
		System.out.print("Introduzca un número: ");
		n1 = Integer.parseInt(br.readLine());
		System.out.println("Numeros del " + n1 + " al 1 utilizando Do While");
		do {
			System.out.println(n1--);
		}while(n1>=1);
		System.out.println("");
		System.out.print("Introduzca un número: ");
		n1 = Integer.parseInt(br.readLine());
		System.out.println("Numeros del " + n1 + " al 1 utilizando For");
		for (i=n1;i>=1;i--) {
			System.out.println(i);
		}
	}
	

}
