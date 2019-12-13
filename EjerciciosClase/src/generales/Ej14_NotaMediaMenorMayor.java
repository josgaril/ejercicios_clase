package generales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej14_NotaMediaMenorMayor {

	public static void main(String[] args) throws NumberFormatException, IOException {

		/*
		 * 14. Calcular la nota media, nota mayor y nota menor de una serie de alumnos
		 * Programa Java que pida por teclado la nota obtenida por cada alumno en un
		 * examen y calcule y muestre la nota media de la clase, la nota mayor y la nota
		 * menor.
		 */ 
		
		double nota,acum=0, menor, mayor, media,alumnos;
		int i;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do{
			System.out.print("¿Cuantos alumnos hay en la clase?");
			alumnos= Double.parseDouble(br.readLine());
		}while(alumnos<1);
	
		System.out.println("Introduzca las notas obtenidas por los alumnos");
		System.out.print("Nota alumno 1 ->");
		nota= Double.parseDouble(br.readLine());
		menor=nota;
		mayor=nota;
		acum+=nota;
		for (i=2;i<=alumnos;i++) {
			System.out.print("Nota alumno " + i + " ->");
			nota= Double.parseDouble(br.readLine());
			acum+=nota;
			if(nota<menor){
				menor=nota;
			}
			if(nota>mayor) {
				mayor=nota;
			}
		}
		
		System.out.println("La nota mas alta de la clase es: " + mayor);
		System.out.println("La nota mas baja de la clase es: " + menor);
		System.out.printf("La nota media de la clase es: %.2f %n", acum/alumnos);
		System.out.println("La nota media de la clase es: " + (acum/alumnos));
	}
	
	

}
