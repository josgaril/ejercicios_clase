package generales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej11_ConvertirANumerosRomanos {

	public static void main(String[] args) throws NumberFormatException, IOException {

		/*
		 * 11. Programa Java para convertir un n�mero entero a n�meros romanos. El
		 * programa pide un n�mero entre 1 y 3999 y calcula su equivalente en n�meros
		 * romanos. Se utiliza un m�todo llamado convertirANumerosRomanos que recibe el
		 * n�mero N a convertir de tipo int y devuelve un String con el equivalente en
		 * n�meros romanos. Para convertirlo se obtiene por separado cada cifra del
		 * n�mero y se muestran las combinaciones de letras del n�mero romano
		 * equivalentes a cada cifra del n�mero original. Este m�todo no utiliza arrays
		 * de modo que este programa se puede resolver sin haber estudiado a�n los
		 * arrays.
		 */
		int num;
		String resultado;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.print("Introduzca un numero entero para pasarlo a romano (entre 1 y 3999) -> ");
			num = Integer.parseInt(br.readLine());
		} while (num < 1 || num > 3999);
		resultado = convertirANumerosRomanos(num);
		System.out.println(num + " en n�meros romanos es-> " + resultado);
	}

	private static String convertirANumerosRomanos(int num) {
		String numRomano = "";
		int i, unidades, decenas, centenas, miles;
		miles = num / 1000;
		centenas = (num / 100) % 10;
		decenas = (num / 10) % 10;
		unidades = num % 10;

		for (i = 1; i <= miles; i++) {
			numRomano += "M";
		}

		
			if (centenas == 9) {
				numRomano += "CM";
			} else if (centenas >= 5) {
				numRomano += "D";
				for (i = 6; i <= centenas; i++) {
					numRomano += 'C';
				}
			} else if (centenas == 4) {
				numRomano += "CD";
			} else {
				for (i = 1; i <= centenas; i++) {
					numRomano += 'C';
				}
			}


	
			if (decenas == 9) {
				numRomano += "XC";
			} else if (decenas >= 5) {
				numRomano += "L";
				for (i = 6; i <= decenas; i++) {
					numRomano += "X";
				}
			} else if (decenas == 4) {
				numRomano += "XL";
			} else {
				for (i = 1; i <= decenas; i++) {
					numRomano += "X";
				}
			}



			if (unidades == 9) {
				numRomano += "IX";
			} else if (unidades >= 5) {
				numRomano += "V";
				for (i = 6; i <= unidades; i++) {
					numRomano += "I";
				}
			} else if (unidades == 4) {
				numRomano += "IV";
			} else {
				for (i = 1; i <= unidades; i++) {
					numRomano += "I";
				}
			}

		return numRomano;
	}
}
