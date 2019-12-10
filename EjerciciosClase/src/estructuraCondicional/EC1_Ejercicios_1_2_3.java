package estructuraCondicional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class EC1_Ejercicios_1_2_3 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		/*
		 * // 1. Programa Java que lea un n�mero entero por teclado y calcule si es par
		 * o impar.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Introduzca un n�mero para saber si es par o impar: ");
		int num = Integer.parseInt(br.readLine());
		if (num % 2 == 0)
			System.out.println(num + " es par");
		else
			System.out.println(num + " es impar");
		System.out.println("");

		/*
		 * 2. Programa que lea un n�mero entero y muestre si el n�mero es m�ltiplo de
		 * 10.
		 */
		System.out.print("Introduzca un n�mero para saber si es m�ltiplo de 10: ");
		int num2 = Integer.parseInt(br.readLine());
		if (num2 % 10 == 0)
			System.out.println(num2 + " es m�ltiplo de 10");
		else
			System.out.println(num2 + " no es m�ltiplo de 10");
		System.out.println("");

		/*
		 * 3. Programa que lea un car�cter por teclado y compruebe si es una letra
		 * may�scula
		 */
		System.out.print("Introduzca una letra para comprobar si es may�scula: ");
		String caracter = br.readLine();
		char letrita = caracter.charAt(0);
		if (Character.isUpperCase(letrita))
			System.out.println("La letra " + letrita + " es may�scula");
		else
			System.out.println("La letra " + letrita + " es min�scula");
		System.out.println("");

		// Con Scanner
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca una letra para comprobar si es may�scula: ");
		char letraa = sc.nextLine().charAt(0);
		if (Character.isUpperCase(letraa))
			System.out.println("La letra " + letraa + " es may�scula");
		else
			System.out.println("La letra " + letraa + " es min�scula");
		System.out.println("");
	}

}
