package estructuraSecuencial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class EntradaSalidaDatos3_Ej_8_9_10 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * 8 Programa que tome como dato de entrada un número que corresponde a la //
		 * longitud del radio una esfera y nos calcula y escribe el volumen de la esfera
		 * que se corresponden con dicho radio.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(("Introduzca el radio de la esfera: "));
		double radioEsfera = Double.parseDouble(br.readLine());
		System.out.println("El volúmen de la esfera es: " + (4.0 / 3) * Math.PI * Math.pow(radioEsfera, 3));
		System.out.println("");

		// Con Scanner
		Scanner sc8 = new Scanner(System.in);
		double radio, volumen;
		System.out.print("Introduzca radio de la esfera: ");
		radio = sc8.nextDouble();
		System.out.println("Volumen de la esfera de radio " + radio + " = " + (4.0 / 3) * Math.PI * Math.pow(radio, 3));
		System.out.println("");

		/*
		 * 9- Programa Java que calcule el área de un triángulo en función de las
		 * longitudes de sus lados (a, b, c) Area = RaizCuadrada(p*(p-a)*(p-b)*(p-c))
		 * donde p = (a+b+c)/2 Para calcular la raíz cuadrada se utiliza el método
		 * Math.sqrt()
		 */
		System.out.println("Introduzca la longitud de los lados del triángulo:");
		System.out.print("A--> ");
		double A = Double.parseDouble(br.readLine());
		System.out.print("B-> ");
		double B = Double.parseDouble(br.readLine());
		System.out.print("C-> ");
		double C = Double.parseDouble(br.readLine());
		double p = (A + B + C) / 2;
		System.out.println("El área del triángulo es: " + Math.sqrt(p * (p - A) * (p - B) * (p - C)));
		System.out.println("");

		// Con scanner
		Scanner sc9 = new Scanner(System.in);
		System.out.print("A-> ");
		double A1 = sc9.nextDouble();
		System.out.print("B-> ");
		double B1 = sc9.nextDouble();
		System.out.print("C-> ");
		double C1 = sc9.nextDouble();
		double p9 = (A + B + C) / 2;
		System.out.print("El área del triángulo es: " + Math.sqrt(p9 * (p9 - A1) * (p9 - B1) * (p9 - C1)));
		System.out.println("");

		/*
		 * 10- Programa Java que lea un número entero de 3 cifras y muestre por separado
		 * las cifras del número
		 */
		System.out.print("Introduzca un numero entero para mostrar sus cifras separadas: ");
		int NUM = Integer.parseInt(br.readLine());
		System.out.println("Primera cifra: " + NUM/100);
		System.out.println("Segunda cifra: " + (NUM/10)%10);
		System.out.println("Tercera cifra: " + NUM%10);
		System.out.println("");
		
		//COn Scann
		System.out.print("Introduzca un numero entero para mostrar sus cifras separadas: ");
		Scanner sc10 = new Scanner(System.in);
		int NUM10 = sc10.nextInt();
		System.out.println("Primera cifra: " + NUM10/100);
		System.out.println("Segunda cifra: " + (NUM10/10)%10);
		System.out.println("Tercera cifra: " + NUM10%10);
		System.out.println("");
		
		
		
	}

}
