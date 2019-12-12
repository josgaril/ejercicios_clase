package generales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej1_IntercambiarVariables {

	public static void main(String[] args) throws IOException {
		
		/*
		 * 1. Programa para intercambiar el valor de dos variables. Los valores
		 * iniciales se leen por teclado.
		 */
		int A,B,AUX;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Intercambio de valores con varaiable auxiliar");
		System.out.print("Introduce el valor de A: ");
		A=Integer.parseInt(br.readLine());
		System.out.print("Introduce el valor de B: ");
		B= Integer.parseInt(br.readLine());
		System.out.println("Valores iniciales");
		System.out.println("A-> " + A);
		System.out.println("B-> " + B);
		AUX=A;
		A=B;
		B=AUX;
		System.out.println("Valores intercambiados:");
		System.out.println("A-> " + A);
		System.out.println("B-> " + B);
		System.out.println("");
		
		//Sin utilizar variable auxiliar
		System.out.println("Intercambio de valores sin variable auxiliar");
		System.out.print("Introduce el valor de A: ");
		A=Integer.parseInt(br.readLine());
		System.out.print("Introduce el valor de B: ");
		B= Integer.parseInt(br.readLine());
		System.out.println("Valores iniciales");
		System.out.println("A-> " + A);
		System.out.println("B-> " + B);
		A=A+B;
		B=A-B;
		A=A-B;
		System.out.println("Valores intercambiados:");
		System.out.println("A-> " + A);
		System.out.println("B-> " + B);
	}

}
