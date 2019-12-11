package estructuraRepetitiva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EI1_NumerosEntre2Numeros_Ejercicio9 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		/*
		 * 9. Programa que pida que se introduzcan dos números enteros por teclado y
		 * muestre los números desde el menor hasta el mayor de los números
		 * introducidos. Los dos números introducidos deben ser distintos. Si son
		 * iguales se mostrará un mensaje indicándolo y se vuelven a introducir.
		 */		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numero1, numero2, menor, mayor,i;
			do {
			System.out.println("Introduzca dos numeros enteros distintos");
			System.out.print("Numero 1-> ");
			numero1= Integer.parseInt(br.readLine());
			System.out.print("Numero 2-> ");
			numero2= Integer.parseInt(br.readLine());
			if (numero1==numero2) {
				System.out.println("Los dos numeros deben ser distintos");
			System.out.println("");
			}
		}while (numero1==numero2);
		if (numero1>numero2) {
			mayor=numero1;
			menor=numero2;
		}
		else {
			mayor=numero2;
			menor=numero1;
		}
		System.out.println("Numeros desde el " + menor + " hasta el " + mayor + ":");
		for(i=menor;i<=mayor;i++) {
			System.out.println(i);
		}
	}

}
