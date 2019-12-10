package estructuraSecuencial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class EntradaSalidaDatos1_Ej_1_2_3 {

	public static void main(String[] args) throws IOException {
		/*
		 * 1- Programa Java que lea dos números enteros por teclado y los muestre por //
		 * pantalla.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Introduzca el primer número: ");
		String numero1 = br.readLine();
		System.out.print("Introduzca el segundo número: ");
		String numero2 = br.readLine();
		System.out.println("Primer número: " + numero1);
		System.out.println("Segundo numero: " + numero2);
		System.out.println("");

		// Con Scanner
		int n1, n2;
		Scanner sc = new Scanner(System.in);
		// leer el primer número
		System.out.println("Introduce un número entero: ");
		n1 = sc.nextInt(); // lee un entero por teclado
		// leer el segundo número
		System.out.println("Introduce otro número entero: ");
		n2 = sc.nextInt(); // lee un entero por teclado
		// mostrar resultado
		System.out.println("Ha introducido los números: " + n1 + " y " + n2);
		System.out.println("");

		/*
		 *  2- Programa Java que lea un nombre y muestre por pantalla: “Buenos dias //
		 * nombre_introducido”
		 */		
		System.out.print("Introduzca su nombre: ");
		String nombre = br.readLine();
		System.out.println("Buenos días " + nombre);
		System.out.println("");

		// Con Scanner
		Scanner sc1 = new Scanner(System.in);
		String cadena;
		System.out.println("Introduce un nombre: ");
		cadena = sc1.nextLine();
		System.out.println("Buenos Días " + cadena);
		System.out.println("");

		/*
		 * 3- Programa Java que lee un número entero por teclado y obtiene y muestra por
		 * pantalla el doble y el triple de ese número
		 */
		System.out.print("Introduzca un número para calcular su doble y su triple: ");
		int numero = Integer.parseInt(br.readLine());
		System.out.println("El doble de " + numero + " es: " + (2 * numero));
		System.out.println("El triple de " + numero + " es: " + (3 * numero));
		System.out.println("");

		// Con Scanner
		Scanner sc2 = new Scanner(System.in);
		int numero3;
		System.out.print("Introduce un número entero:");
		numero3 = sc2.nextInt();
		System.out.println("Número introducido: " + numero3);
		System.out.println("Doble de " + numero3 + " -> " + 2 * numero3);
		System.out.println("Triple de " + numero3 + " -> " + 3 * numero3);
	}

}
