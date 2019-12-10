package estructuraSecuencial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class EntradaSalidaDatos1 {

	public static void main(String[] args) throws IOException {
		//Programa Java que lea dos n�meros enteros por teclado y los muestre por pantalla.
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Introduzca el primer n�mero: ");
		String numero1 = br.readLine();
		System.out.print("Introduzca el segundo n�mero: ");
		String numero2 = br.readLine();
		System.out.println("Primer n�mero: " + numero1);
		System.out.println("Segundo numero: " + numero2);
		System.out.println("");
		
		//  Programa Java que lea un nombre y muestre por pantalla:
		//  �Buenos dias nombre_introducido�
		System.out.print("Introduzca su nombre: ");
		String nombre= br.readLine();
		System.out.println("Buenos d�as " + nombre);
		System.out.println("");
		
		//programa Java que lee un n�mero entero por teclado y obtiene y muestra por pantalla el doble y el triple de ese n�mero
		
		  System.out.print("Introduzca un n�mero para calcular su doble y su triple: ");
		  int numero = Integer.parseInt(br.readLine());
		  System.out.println("El doble de " + numero  + " es: " + (2*numero)); 
		  System.out.println("El triple de " + numero  + " es: " + (3*numero));
		  System.out.println("");
		 
		
		//otra forma
		  Scanner sc = new Scanner(System.in);
	        int numero3;
	        System.out.print("Introduce un n�mero entero:");
	        numero3 = sc.nextInt();
	        System.out.println("N�mero introducido: " + numero3);
	        System.out.println("Doble de " + numero3 + " -> "+ 2*numero3);
	        System.out.println("Triple de " + numero3 + " -> "+ 3*numero3);
	}

}
