package estructuraCondicional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EC4_Ejercicios9_10 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * 9.Programa que lea por teclado tres números enteros H, M, S correspondientes
		 * a hora, minutos y segundos respectivamente, y comprueba si la hora que
		 * indican es una hora válida.
		 * 
		 * Supondremos que se leemos una hora en modo 24 Horas, es decir, el valor
		 * válido para las horas será mayor o igual que cero y menor que 24.
		 * 
		 * El valor válido para los minutos y segundos estará comprendido entre 0 y 59
		 * ambos incluidos
		 */
		int h, m, s;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Introduzca la hora: ");
		h = Integer.parseInt(br.readLine());
		System.out.print("Introduzca los minutos: ");
		m = Integer.parseInt(br.readLine());
		System.out.print("Introduzca los segundos: ");
		s = Integer.parseInt(br.readLine());
		if ((h>=0 && h<=23) && (m>=0 && m<=59) && (s>=0 && s<=59)) {
			System.out.println("La hora es correcta");
		}
		else {
			System.out.println("La hora es incorrecta");
		}
		System.out.println("");	
	
		/*
		 * 10. Programa que lea una variable entera mes y compruebe si el valor
		 * corresponde a un mes de 30 días, de 31 o de 28. Supondremos que febrero tiene
		 * 28 días. Se mostrará además el nombre del mes. Se debe comprobar que el valor
		 * introducido esté comprendido entre 1 y 12.
		 */
		int mes;
		System.out.println("Introduce un mes para comprobar los días que tiene: ");
		mes = Integer.parseInt(br.readLine());
		if (mes>=1 && mes<=12) {
			switch (mes){
			case 1: 
				System.out.println("ENERO");
				break;
			case 2:
				System.out.println("FEBRERO");
				break;
			case 3:
				System.out.println("MARZO");
				break;
			case 4: 
				System.out.println("ABRIL");
				break;
			case 5:
				System.out.println("MAYO");
				break;
			case 6: 
				System.out.println("JUNIO");
				break;
			case 7:
				System.out.println("JULIO");
				break;
			case 8:
				System.out.println("AGOSTO");
				break;
			case 9: 
				System.out.println("SEPTIEMBRE");
				break;
			case 10:
				System.out.println("OCTUBRE");
				break;
			case 11:
				System.out.println("NOVIEMBRE");
				break;
			case 12:
				System.out.println("DICIEMBRE");
				break;
			}
			if (mes==4 || mes==6 || mes==9 || mes==11)
				System.out.println("Tiene 30 días");
			else if (mes==2)
				System.out.println("Tiene 28 días");
				else 	
				System.out.println("Tiene 31 días");
		}
		else {
			System.out.println("Ha introducido un mes incorrecto");
		}
		
	}
}
