package estructuraSecuencial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ES4_Ejercicios_Ej_11_12_13 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * 11- Programa que lea un número entero N de 5 cifras y muestre sus cifras
		 * igual que en el ejemplo. Por ejemplo para un número N = 12345 La salida debe
		 * ser: 
		 * 1
		 * 12 
		 * 123 
		 * 1234 
		 * 12345
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Introduzca un número de 5 cifras: ");
		int num = Integer.parseInt(br.readLine());
		System.out.println(num / 10000);
		System.out.println(num / 1000);
		System.out.println(num / 100);
		System.out.println(num / 10);
		System.out.println(num);
		System.out.println("");

		// Con Scan
		Scanner sc11 = new Scanner(System.in);
		System.out.print("Introduzca un número de 5 cifras: ");
		int numero11 = sc11.nextInt();
		System.out.println(numero11 / 10000);
		System.out.println(numero11 / 1000);
		System.out.println(numero11 / 100);
		System.out.println(numero11 / 10);
		System.out.println(numero11);
		System.out.println();

		/*
		 * 12- Programa Java que lea un número entero N de 5 cifras y muestre sus cifras
		 * igual que en el ejemplo.Por ejemplo para un número N = 12345 La salida debe
		 * ser: 
		 * 5 
		 * 45 
		 * 345 
		 * 2345 
		 * 12345
		 */
		System.out.print("Introduzca un número de 5 cifras: ");
		int num12 = Integer.parseInt(br.readLine());
		System.out.println(num12 % 10);
		System.out.println(num12 % 100);
		System.out.println(num12 % 1000);
		System.out.println(num % 10000);
		System.out.println(num);
		System.out.println("");

		//Con Scan
		Scanner sc12 = new Scanner(System.in);
		System.out.print("Introduzca un número de 5 cifras: ");
		int numero12 = sc12.nextInt();
		System.out.println(numero12 % 10);
		System.out.println(numero12 % 100);
		System.out.println(numero12 % 1000);
		System.out.println(numero12 % 10000);
		System.out.println(numero12);
		System.out.println("");
		System.out.println("");

		/*
		 * 13- Programa que pida por teclado la fecha de nacimiento de una persona (dia,
		 * mes, año) y calcule su número de la suerte. El número de la suerte se calcula
		 * sumando el día, mes y año de la fecha de nacimiento y a continuación sumando
		 * las cifras obtenidas en la suma.
		 */
		System.out.println("Introduzca su fecha de nacimiento:");
		System.out.print("Día: ");
		int dia = Integer.parseInt(br.readLine());
		System.out.print("Mes: ");
		int mes = Integer.parseInt(br.readLine());
		System.out.print("Año: ");
		int anho = Integer.parseInt(br.readLine());
		int suma= dia + mes + anho;
		int cifra1,cifra2,cifra3,cifra4;
		cifra1= suma/1000;
		cifra2=(suma/100)%10;
		cifra3=(suma/10)%10;
		cifra4=suma%10;
		System.out.println("Su número de la suerte es: " + (cifra1+ cifra2+ cifra3+ cifra4));	
		System.out.println("");
		
		//Con Scann
		Scanner sc13 = new Scanner(System.in);
		System.out.println("Introduzca su fecha de nacimiento:");
		System.out.print("Día: ");
		int dia13 = sc13.nextInt();
		System.out.print("Mes: ");
		int mes13=sc13.nextInt();
		System.out.print("Año: ");
		int anho13 = sc13.nextInt();
		int suma13= dia13 + mes13 + anho13;
		int cifra_1,cifra_2,cifra_3,cifra_4;
		cifra_1= suma13/1000;
		cifra_2=(suma13/100)%10;
		cifra_3=(suma13/10)%10;
		cifra_4=suma13%10;
		System.out.println("Su número de la suerte es: " + (cifra_1+ cifra_2+ cifra_3+ cifra_4));	
		System.out.println("");
	}

}
