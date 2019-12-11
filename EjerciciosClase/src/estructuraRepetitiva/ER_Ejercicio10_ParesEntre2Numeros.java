package estructuraRepetitiva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ER_Ejercicio10_ParesEntre2Numeros {

	public static void main(String[] args) throws NumberFormatException, IOException {

		/*
		 * 10. Programa que pida que se introduzcan dos n�meros enteros A y B por
		 * teclado y muestre los n�meros pares que hay entre A y B. A debe ser menor que
		 * B. Si no es as� se mostrar� un mensaje indic�ndolo y se vuelven a introducir.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A, B,i;
		do{
			System.out.println("Introduzca dos n�meros enteros");
			System.out.print("Numero 1 -> ");
			A=Integer.parseInt(br.readLine());
			System.out.print("N�mero 2 -> ");
			B=Integer.parseInt(br.readLine());
			if (A>B) {
				System.out.println("El primer n�mero tiene que ser menor que el segundo");
			}
		}while(A>B);
		System.out.println("Los numeros pares comprendidos entre " + A + " y " + B + " son: ");
	for (i=A;i<=B;i++)
		if(i%2==0) {
			System.out.println(i);
		}
	}

}
