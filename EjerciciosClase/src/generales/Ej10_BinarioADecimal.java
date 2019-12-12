package generales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej10_BinarioADecimal {

	public static void main(String[] args) throws NumberFormatException, IOException {

		/*
		 * 10. CONVERTIR UN N�MERO DE BINARIO A DECIMAL EN JAVA. El programa para pasar
		 * un n�mero expresado en binario a decimal se basa en la forma tradicional de
		 * hacerlo. Los d�gitos del n�mero binario ocupan una posici�n que se numera de
		 * derecha a izquierda empezando por cero. La posici�n del d�gito m�s a la
		 * derecha es la 0. Para pasar el n�mero a decimal se multiplica cada d�gito
		 * binario por 2 elevado a la posici�n que ocupa. La suma de todos los productos
		 * es el equivalente en decimal.
		 */
		long  num, decimal, digito, aux;
		int exponente;
		boolean esBinario;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	
		   do {
				System.out.print("Introduzca un numero binario para pasarlo a decimal-> ");
				num = Integer.parseInt(br.readLine());
		  		  esBinario = true;
		          aux = num;
		          while (aux != 0) {
		                     digito = aux % 10; 
		                     if (digito != 0 && digito != 1) { 
		                          esBinario = false; 
		                     }
		                     aux = aux / 10; 
		           }
		      } while (!esBinario); 
		
		exponente=0;
		decimal=0;
		while(num!=0) {
			digito = num%10;
			decimal= decimal + digito * (int) Math.pow(2, exponente);
			exponente++;
			num=num/10;
		}
		System.out.println("Decimal: " + decimal);
	}

}
