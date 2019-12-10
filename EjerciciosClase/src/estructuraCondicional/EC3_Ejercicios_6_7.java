package estructuraCondicional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EC3_Ejercicios_6_7 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * 6. Programa java que lea un car�cter por teclado y compruebe si es un d�gito
		 * num�rico (cifra entre 0 y 9).
		 * 
		 * Vamos a escribir dos soluciones a este ejercicio.
		 * La primera consiste en comprobar si el car�cter es un d�gito mediante el
		 * m�todo isDigit de la clase Character. Este m�todo devuelve true si el
		 * car�cter que se le pasa como par�metro es una cifra entre 0 y 9
		 */
		String numero;
		char n;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduzca un car�cter para saber sin es un d�gito num�rico ");
		System.out.print("Numero: ");
		numero = (br.readLine());
		n = (numero.charAt(0));
		if (Character.isDigit(n))
			System.out.println("El car�cter es un numero entre 0 y 9");
		else
			System.out.println("No es un d�gito entre 0 y 9");
		System.out.println("");
		/*
		 * La otra soluci�n es directa y consiste en comprobar si el car�cter que se ha
		 * le�do por teclado es mayor o igual que el car�cter 0 y menor o igual que el
		 * car�cter 9
		 */
	}

}
