package estructuraRepetitiva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ER_Ejercicio7_de1hastaN {
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * 7. Escribe un programa Java que pida por teclado el valor de un número N y
		 * muestre por pantalla todos los números desde 1 hasta N. Resuelve este
		 * ejercicio de tres formas distintas: 
		 * 1. Utilizando la estructura for
		 * 2. Utilizando la estructura while 
		 * 3. Utilizando la estructura do .. while
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n1,i;
		System.out.print("Introduzca un número: ");
		n1 = Integer.parseInt(br.readLine());
		System.out.println("Números del 1 al " + n1 + " utilizando For");
		for(i=1;i<=n1;i++)
			System.out.println(i);
		System.out.println("");
		System.out.print("Introduzca un número: ");
		n1 = Integer.parseInt(br.readLine());
		System.out.println("Números del 1 al " + n1 + " utilizando While");
		i=1;
		while(i<=n1) {
			System.out.println(i);
			i++;
		}
		System.out.println("");
		System.out.print("Introduzca un número: ");
		n1 = Integer.parseInt(br.readLine());
		System.out.println("Números del 1 al " + n1 + " utilizando Do While");			
		i=1;
		do{
			System.out.println(i);
			i++;
		}while (i<=n1);	
	}
	
}
