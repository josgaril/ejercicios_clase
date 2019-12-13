package generales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej13_NumeroCapicua {

	public static void main(String[] args) throws NumberFormatException, IOException {

		/*
		 * 13. COMPROBAR SI UN N�MERO ES CAPIC�A EN JAVA Un n�mero es capic�a si se
		 * puede leer igual de derecha a izquierda que de izquierda a derecha. Ejemplos
		 * de n�meros capic�as: 121, 3003, 1234321, 33, 445544, etc. Vamos a escribir un
		 * programa Java que pida por teclado un n�mero entero N de m�s de una cifra y
		 * verifique si es capic�a.
		 */
		int num, aux, inverso = 0,cifra;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.print("Introduce un nunmero entero de m�s de una cifra: ");
			num = Integer.parseInt(br.readLine());
		} while (num < 10);

		//Invertimos el numero
		aux = num;
		while(aux!=0) {
			cifra=aux%10;
			inverso= inverso*10+cifra;
			aux= aux/10;
		}
		if (num == inverso) {
			System.out.println("El n�mero " + num + " si es capicua");
		} else {
			System.out.println("El n�mero " + num + " no es capicua");
		}

	}

}
