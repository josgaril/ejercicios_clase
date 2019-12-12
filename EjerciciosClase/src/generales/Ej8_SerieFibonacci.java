package generales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej8_SerieFibonacci {

	public static void main(String[] args) throws NumberFormatException, IOException {

		/*
		 * 8. La serie de fibonacci la forman una serie de n�meros tales que: 
		 * El primer t�rmino de la serie es el n�mero 
		 * 1 El segundo t�rmino de la serie es el n�mero 1 
		 * Los siguientes t�rminos de la serie de fibonacci se obtienen de la suma de los 
		 * dos anteriores: 
		 * 1, 1, 2, 3, 5, 8, 13, ..... 
		 * Vamos a escribir el programa java que muestra los N primeros n�meros de la serie. 
		 * El valor de N se lee por teclado.
		 */

		int num, fibo1, fibo2, acum = 0, i;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do{
			System.out.print("Introduzca un n�mero positivo para ver su serie de Fibonacci: ");
			num = Integer.parseInt(br.readLine());
		}while(num<=0);
		fibo1 = 1;
		fibo2 = 1;
		for (i = 1; i <= num; i++) {
			if (num == 1 || num == 2) {
				acum = 1;
			} else {
			
				fibo1 = fibo2;
				fibo2 = acum;
				acum = fibo1 + fibo2;
			}
			System.out.print(acum + " ");
		}


	}

}
