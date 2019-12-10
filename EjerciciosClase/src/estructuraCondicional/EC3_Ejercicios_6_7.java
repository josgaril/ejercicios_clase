package estructuraCondicional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EC3_Ejercicios_6_7 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * 6. Programa java que lea un carácter por teclado y compruebe si es un dígito
		 * numérico (cifra entre 0 y 9).
		 * 
		 * Vamos a escribir dos soluciones a este ejercicio.
		 * La primera consiste en comprobar si el carácter es un dígito mediante el
		 * método isDigit de la clase Character. Este método devuelve true si el
		 * carácter que se le pasa como parámetro es una cifra entre 0 y 9
		 */
		String numero;
		char n;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduzca un carácter para saber sin es un dígito numérico ");
		System.out.print("Numero: ");
		numero = (br.readLine());
		n = (numero.charAt(0));
		if (Character.isDigit(n))
			System.out.println("El carácter es un numero entre 0 y 9");
		else
			System.out.println("No es un dígito entre 0 y 9");
		System.out.println("");
		/*
		 * La otra solución es directa y consiste en comprobar si el carácter que se ha
		 * leído por teclado es mayor o igual que el carácter 0 y menor o igual que el
		 * carácter 9
		 */
	}

}
