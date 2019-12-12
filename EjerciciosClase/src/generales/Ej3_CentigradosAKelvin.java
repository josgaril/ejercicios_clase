package generales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej3_CentigradosAKelvin {

	public static void main(String[] args) throws NumberFormatException, IOException {

		/*
		 * 3. Programa Java que lee una temperatura expresada en grados centígrados y la
		 * convierte a grados kelvin.		
		 * El proceso de leer grados centígrados se debe repetir mientras que se
		 * responda ‘S’ a la pregunta: Repetir proceso? (S/N).		 
		 * Para hacer la conversión de grados Centígrados a grados Kelvin hay que
		 * utilizar la fórmula:   ºK = ºC + 273
		 */
		double gCentig, gKelvin;
		String cadena;
		char respuesta;
		do{
			BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Introduzca los grados centrígados para pasar a grados kelvin: ");
		gCentig = Double.parseDouble(br.readLine());
		gKelvin= gCentig + 273;
		System.out.println(gCentig + "º centígrados = " + gKelvin + "º Kelvin");
		System.out.print("¿Repetir proceso? (S/N) ");
		cadena = br.readLine();
		respuesta = cadena.charAt(0);
		}while(respuesta=='S' || respuesta=='s');
		System.out.println("Fin del programa");
	}

}
