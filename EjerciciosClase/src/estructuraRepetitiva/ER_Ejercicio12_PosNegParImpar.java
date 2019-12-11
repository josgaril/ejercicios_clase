package estructuraRepetitiva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ER_Ejercicio12_PosNegParImpar {

	public static void main(String[] args) throws NumberFormatException, IOException {

		/*
		 * 12. Programa que lea números enteros por teclado y para cada número
		 * introducido indique si es positivo o negativo y si es par o impar. Se deben
		 * realizar tres versiones del programa: 
		 * 1. En la primera versión se utilizará un bucle while. La lectura de números 
		 * finalizará cuando se introduzca un cero. 
		 * 2. En la segunda versión se utilizará un bucle do .. while. La lectura
		 * de números en esta versión también finaliza cuando se introduzca un cero.
		 * 3. En la tercera versión también se utilizará un bucle do .. while pero en
		 * este caso la lectura de números finaliza cuando se responda ‘N’ ó ‘n’ a la
		 * pregunta “Desea introducir más números? (S/N):”
		 */
		int numero;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Programa para leer números enteros y saber si son positivos o negativos y pares o impares");
		System.out.println("Utilizamos bucle While");
		System.out.print("Introduzca un número(0 para acabar): ");
		numero=Integer.parseInt(br.readLine());
		while (numero !=0) {
			System.out.print("El numero " + numero + " es: ");
			if (numero>0) {
				System.out.print(" positivo");
					}else {
				System.out.print(" negativo ");
			}
			if (numero%2==0) {
				System.out.println(" y par");
			}else {
				System.out.println(" e impar");
			}
			System.out.print("Introduzca un número(0 para acabar): ");
			numero=Integer.parseInt(br.readLine());
		}
		System.out.println("Fin del programa con While");
		System.out.println("");
		
		System.out.println("Utilizamos bucle DO While");
		do {
			System.out.print("Introduzca un número(0 para acabar): ");
			numero=Integer.parseInt(br.readLine());
			if (numero!=0) {
				System.out.print("El numero " + numero + " es: ");
				if (numero>0) {
				System.out.print(" positivo");
					}else {
				System.out.print(" negativo ");
				}
				if (numero%2==0) {
					System.out.println(" y par");
				}else {
					System.out.println(" e impar");
				}
			}
		}while(numero!=0);
		System.out.println("Fin del programa con Do While");
		System.out.println("");

		System.out.println("Utilizamos bucle DO While");
		String cadena;
		char respuesta='n';
		
		do {
			System.out.print("Introduzca un número: ");
			numero=Integer.parseInt(br.readLine());
			if (numero!=0) {
				System.out.print("El numero " + numero + " es: ");
				if (numero>0) {
				System.out.print(" positivo");
					}else {
				System.out.print(" negativo ");
				}
				if (numero%2==0) {
					System.out.println(" y par");
				}else {
					System.out.println(" e impar");
				}
				System.out.print("¿Desea introducir más números?(S/N)");
				cadena= br.readLine();
				respuesta= cadena.charAt(0);
			}
		}while(respuesta!='N' || respuesta!='n');
		System.out.println("Fin del programa con Do While");
	}
}
