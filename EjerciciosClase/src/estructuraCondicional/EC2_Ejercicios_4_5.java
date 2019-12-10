package estructuraCondicional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EC2_Ejercicios_4_5 {

	public static void main(String[] args) throws IOException {
		/*
		 * 4. Programa que lea dos caracteres y compruebe si son iguales.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduzca dos caracteres para comprobar si son iguales");
		System.out.print("Primer carácter: ");
		String letraA = br.readLine();
		char A= letraA.charAt(0);
		System.out.print("Segundo carácter: ");
		String letraB= br.readLine();
		char B= letraB.charAt(0);
		if (A==B)
			 System.out.println("Son iguales");
		else
			System.out.println("Son distintos");
		System.out.println("");
		
		//Otra forma de hacerlo
		if (letraA.equals(letraB))
			System.out.println("Los dos caracteres son iguales");
		else
			System.out.println("Los dos caracteres son distintos");
		System.out.println();
		
		/*
		 * 5. Programa java que lea dos caracteres por teclado y compruebe si los dos
		 * son letras minúsculas
		 */	
		char A1, B1;
		String letra1,letra2;
		System.out.println("Introduzca dos caracteres para comprobar si son minúsculas. ");
		System.out.print("Primera carácter: ");
		letra1 = br.readLine();
		A1=letra1.charAt(0);
		System.out.print("Segundo carácter: ");
		letra2 = br.readLine();
		B1 = letra2.charAt(0);
		if (Character.isLowerCase(A1)) {
			if (Character.isLowerCase(B1))
					System.out.println("Las dos letras son minúsculas");
			else
				System.out.println("La letra " + A1 + " es minúscula pero la letra " + B1 + " no lo es");
		}
		else {
			if (Character.isLowerCase(B1))
				System.out.println("La letra " + B1 + " es minúscula pero la letra " + A1 + " no lo es");
			else
				System.out.println("Ninguna de las dos letras son minúsculas");
		}
		System.out.println("");
	
	}
}
