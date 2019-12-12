package generales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej4_TablaMultiplicar {

	public static void main(String[] args) throws NumberFormatException, IOException {

		/* 4. Mostrar la tabla de multiplicar de un número. */
		int num,i;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Introduzca un número para ver su tabla de multiplicar: ");
		num = Integer.parseInt(br.readLine());
		System.out.println("Tabla del " + num);
		System.out.println("----------");
		for(i=1;i<=10;i++) {
			System.out.println(num + " * " + i + " = " + (num*i));
		}

	}

}
