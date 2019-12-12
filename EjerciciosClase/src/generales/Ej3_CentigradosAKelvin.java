package generales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej3_CentigradosAKelvin {

	public static void main(String[] args) throws NumberFormatException, IOException {

		/*
		 * 3. Programa Java que lee una temperatura expresada en grados cent�grados y la
		 * convierte a grados kelvin.		
		 * El proceso de leer grados cent�grados se debe repetir mientras que se
		 * responda �S� a la pregunta: Repetir proceso? (S/N).		 
		 * Para hacer la conversi�n de grados Cent�grados a grados Kelvin hay que
		 * utilizar la f�rmula:   �K = �C + 273
		 */
		double gCentig, gKelvin;
		String cadena;
		char respuesta;
		do{
			BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Introduzca los grados centr�gados para pasar a grados kelvin: ");
		gCentig = Double.parseDouble(br.readLine());
		gKelvin= gCentig + 273;
		System.out.println(gCentig + "� cent�grados = " + gKelvin + "� Kelvin");
		System.out.print("�Repetir proceso? (S/N) ");
		cadena = br.readLine();
		respuesta = cadena.charAt(0);
		}while(respuesta=='S' || respuesta=='s');
		System.out.println("Fin del programa");
	}

}
