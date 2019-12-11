package estructuraRepetitiva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ER_Ejercicio10_ParesEntre2Numeros {

	public static void main(String[] args) throws NumberFormatException, IOException {

		/*
		 * 10. Programa que pida que se introduzcan dos números enteros A y B por
		 * teclado y muestre los números pares que hay entre A y B. A debe ser menor que
		 * B. Si no es así se mostrará un mensaje indicándolo y se vuelven a introducir.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A, B,i;
		do{
			System.out.println("Introduzca dos números enteros");
			System.out.print("Numero 1 -> ");
			A=Integer.parseInt(br.readLine());
			System.out.print("Número 2 -> ");
			B=Integer.parseInt(br.readLine());
			if (A>B) {
				System.out.println("El primer número tiene que ser menor que el segundo");
			}
		}while(A>B);
		System.out.println("Los numeros pares comprendidos entre " + A + " y " + B + " son: ");
	for (i=A;i<=B;i++)
		if(i%2==0) {
			System.out.println(i);
		}
	}

}
