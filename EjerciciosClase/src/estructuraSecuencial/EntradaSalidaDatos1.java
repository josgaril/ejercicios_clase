package estructuraSecuencial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class EntradaSalidaDatos1 {

	public static void main(String[] args) throws IOException {
		//Programa Java que lea dos números enteros por teclado y los muestre por pantalla.
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Introduzca el primer número: ");
		String numero1 = br.readLine();
		System.out.print("Introduzca el segundo número: ");
		String numero2 = br.readLine();
		System.out.println("Primer número: " + numero1);
		System.out.println("Segundo numero: " + numero2);
		System.out.println("");
		
		//  Programa Java que lea un nombre y muestre por pantalla:
		//  “Buenos dias nombre_introducido”
		System.out.print("Introduzca su nombre: ");
		String nombre= br.readLine();
		System.out.println("Buenos días " + nombre);
		System.out.println("");
		
		//programa Java que lee un número entero por teclado y obtiene y muestra por pantalla el doble y el triple de ese número
		
		  System.out.print("Introduzca un número para calcular su doble y su triple: ");
		  int numero = Integer.parseInt(br.readLine());
		  System.out.println("El doble de " + numero  + " es: " + (2*numero)); 
		  System.out.println("El triple de " + numero  + " es: " + (3*numero));
		  System.out.println("");
		 
		
		//otra forma
		  Scanner sc = new Scanner(System.in);
	        int numero3;
	        System.out.print("Introduce un número entero:");
	        numero3 = sc.nextInt();
	        System.out.println("Número introducido: " + numero3);
	        System.out.println("Doble de " + numero3 + " -> "+ 2*numero3);
	        System.out.println("Triple de " + numero3 + " -> "+ 3*numero3);
	}

}
