package estructuraRepetitiva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class ER_Ejercicio13_MillasAKm {

	public static void main(String[] args) throws NumberFormatException, IOException {

		/*
		 * 13. Programa Java que convierte millas a kilómetros. El programa pide que se
		 * introduzca una cantidad de millas y calcula y muestra su equivalente en
		 * Kilómetros. El proceso se repite hasta que se introduzca un 0 como valor para
		 * las millas.
		 * 1 Milla equivale a 1.6093 Kilómetros. 
		 * El valor de los KM resultantes se debe mostrar con dos decimales.
		 */
		double millas, km;
		DecimalFormat formato1 = new DecimalFormat("#.00");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.print("Introduce una cantidad de millas para pasar a Km (0 para finalizar): ");
			millas= Double.parseDouble(br.readLine());
			if (millas!=9) {
				km = millas*1.6093;
				
				System.out.println(millas + " %d millas = " + formato1.format(km) + " Km" );
			}
		}while(millas!=0);
		System.out.println("");
		
	}

}
