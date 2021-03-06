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
			System.out.println("El car�cter es un d�gito");
		else
			System.out.println("No es un d�gito");
		System.out.println("");
		
		/*
		 * La otra soluci�n es directa y consiste en comprobar si el car�cter que se ha
		 * le�do por teclado es mayor o igual que el car�cter 0 y menor o igual que el
		 * car�cter 9
		 */
		String numero1;
		char n1;
		System.out.println("Introduzca un car�cter para saber sin es un d�gito num�rico ");
		System.out.print("Numero: ");
		numero1= br.readLine();
		n1= numero1.charAt(0);
		if(n1>='0' && n1<='9')
			System.out.println("El car�cter es un d�gito");
		else
			System.out.println("No es un d�gito");
		System.out.println("");
			
		/*
		 * 7. Programa que lea dos n�meros por teclado y muestre el resultado de la
		 * divisi�n del primer n�mero por el segundo. Se debe comprobar que el divisor
		 * no puede ser cero.
		 */
		double num1, num2;
		System.out.println("Introduzca dos n�meros para realizar su divisi�n");
		System.out.print("N�mero 1-> ");
		num1 = Double.parseDouble(br.readLine());
		System.out.print("Numero 2-> ");
		num2 = Integer.parseInt(br.readLine());
		if (num2==0)
			System.out.println("El divisor no puede ser cero");
		else
			System.out.println(num1 + " / " + num2 + " = " + (num1/num2));
		System.out.println("");
		
		
	}

}
