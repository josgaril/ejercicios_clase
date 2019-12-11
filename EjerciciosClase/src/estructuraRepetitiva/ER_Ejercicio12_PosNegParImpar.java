package estructuraRepetitiva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ER_Ejercicio12_PosNegParImpar {

	public static void main(String[] args) throws NumberFormatException, IOException {

		/*
		 * 12. Programa que lea n�meros enteros por teclado y para cada n�mero
		 * introducido indique si es positivo o negativo y si es par o impar. Se deben
		 * realizar tres versiones del programa: 
		 * 1. En la primera versi�n se utilizar� un bucle while. La lectura de n�meros 
		 * finalizar� cuando se introduzca un cero. 
		 * 2. En la segunda versi�n se utilizar� un bucle do .. while. La lectura
		 * de n�meros en esta versi�n tambi�n finaliza cuando se introduzca un cero.
		 * 3. En la tercera versi�n tambi�n se utilizar� un bucle do .. while pero en
		 * este caso la lectura de n�meros finaliza cuando se responda �N� � �n� a la
		 * pregunta �Desea introducir m�s n�meros? (S/N):�
		 */
		int numero;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Programa para leer n�meros enteros y saber si son positivos o negativos y pares o impares");
		System.out.println("Utilizamos bucle While");
		System.out.print("Introduzca un n�mero(0 para acabar): ");
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
			System.out.print("Introduzca un n�mero(0 para acabar): ");
			numero=Integer.parseInt(br.readLine());
		}
		System.out.println("Fin del programa con While");
		System.out.println("");
		
		System.out.println("Utilizamos bucle DO While");
		do {
			System.out.print("Introduzca un n�mero(0 para acabar): ");
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
			System.out.print("Introduzca un n�mero: ");
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
				System.out.print("�Desea introducir m�s n�meros?(S/N)");
				cadena= br.readLine();
				respuesta= cadena.charAt(0);
			}
		}while(respuesta!='N' || respuesta!='n');
		System.out.println("Fin del programa con Do While");
	}
}
