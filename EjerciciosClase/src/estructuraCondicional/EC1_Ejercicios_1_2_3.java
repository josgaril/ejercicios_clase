package estructuraCondicional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class EC1_Ejercicios_1_2_3 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		/*
		 * // 1. Programa Java que lea un número entero por teclado y calcule si es par
		 * o impar.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Introduzca un número para saber si es par o impar: ");
		int num = Integer.parseInt(br.readLine());
		if (num % 2 == 0)
			System.out.println(num + " es par");
		else
			System.out.println(num + " es impar");
		System.out.println("");

		/*
		 * 2. Programa que lea un número entero y muestre si el número es múltiplo de
		 * 10.
		 */
		System.out.print("Introduzca un número para saber si es múltiplo de 10: ");
		int num2 = Integer.parseInt(br.readLine());
		if (num2 % 10 == 0)
			System.out.println(num2 + " es múltiplo de 10");
		else
			System.out.println(num2 + " no es múltiplo de 10");
		System.out.println("");

		/*
		 * 3. Programa que lea un carácter por teclado y compruebe si es una letra
		 * mayúscula
		 */
		System.out.print("Introduzca una letra para comprobar si es mayúscula: ");
		String caracter = br.readLine();
		char letrita = caracter.charAt(0);
		if (Character.isUpperCase(letrita))
			System.out.println("La letra " + letrita + " es mayúscula");
		else
			System.out.println("La letra " + letrita + " es minúscula");
		System.out.println("");

		// Con Scanner
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca una letra para comprobar si es mayúscula: ");
		char letraa = sc.nextLine().charAt(0);
		if (Character.isUpperCase(letraa))
			System.out.println("La letra " + letraa + " es mayúscula");
		else
			System.out.println("La letra " + letraa + " es minúscula");
		System.out.println("");
	}

}
