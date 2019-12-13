package estructuraSecuencial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ES2_Ejercicios_Ej_4_5_6_7 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * 4- Programa que lea una cantidad de grados centígrados y la pase a grados
		 *  Fahrenheit.
		 */	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Introduzca el número de grados: ");
		double gradosC = Double.parseDouble(br.readLine());
		double gradosF = 32 + (9 * gradosC / 5);
		System.out.println(gradosC + " grados centígrados equivale a: " + gradosF);
		System.out.println("");

		// Con Scanner
		Scanner sc = new Scanner(System.in);
		double gradosC1, gradosF1;
		System.out.println("Introduce grados Centígrados:");
		gradosC1 = sc.nextDouble();
		gradosF1 = 32 + (9 * gradosC1 / 5);
		System.out.println(gradosC1 + " ºC = " + gradosF1 + " ºF");
		sc.close();
		System.out.println("");

		/*
		 *  5- Programa que lee por teclado el valor del radio de una circunferencia y
		 *  calcula y muestra por pantalla la longitud y el área de la circunferencia
		 */	
		System.out.print("Introducza el radio de la circunferencia:");
		double radio = Double.parseDouble(br.readLine());
		double longCirc = 2 * Math.PI * radio;
		double areaCirc = Math.PI * Math.pow(radio, 2);
		System.out.println(("La longitud de la circunferencia es: ") + longCirc);
		System.out.println(("El área de la circunferencia es: ") + areaCirc);
		System.out.println("");

		// Con Scanner
		Scanner sc0 = new Scanner(System.in);
		double radio1, longitud, area;
		System.out.println("Introduce radio de la circunferencia:");
		radio1 = sc0.nextDouble();
		longitud = 2 * Math.PI * radio1;
		area = Math.PI * Math.pow(radio1, 2);
		System.out.println("Longitud de la circunferencia -> " + longitud);
		System.out.println("Area de la circunferencia -> " + area);
		sc0.close();
		System.out.println("");

		/*
		 * 6- Programa que pase una velocidad en Km/h a m/s. La velocidad se lee por
		 *  teclado.
		 */	
		System.out.print("Introduzca la velocidad en Km/h a la que circula el vehículo: ");
		double veloc = Double.parseDouble(br.readLine());
		System.out.println("El vehículo circula a: " + veloc + " Km/h");
		System.out.println("Lo equivalente a: " + veloc * 1000 / 3600 + " m/s");
		System.out.println("");

		// Con Scanner
		Scanner sc1 = new Scanner(System.in);
		double velocidad;
		System.out.print("Introduzca velocidad en Km/h: ");
		velocidad = sc1.nextDouble();
		System.out.println(velocidad + " Km/h -> " + velocidad * 1000 / 3600 + " m/s");
		sc1.close();
		System.out.println("");

		/*
		 * 7- Programa lea la longitud de los catetos de un triángulo rectángulo y //
		 * calcule la longitud de la hipotenusa según el teorema de Pitágoras
		 */		
		System.out.print("Longitud del primer cateto: ");
		double cateto1 = Double.parseDouble(br.readLine());
		System.out.print("Longitud del segundo cateto: ");
		double cateto2 = Double.parseDouble(br.readLine());
		System.out.println("La hipotenusa es: " + Math.sqrt(Math.pow(cateto1, 2) + Math.pow(cateto2, 2)));
		System.out.println();

		// Con Scanner
		Scanner sc3 = new Scanner(System.in);
		double cateto3, cateto4;
		System.out.print("Introduzca longitud del primer cateto: ");
		cateto3 = sc3.nextDouble();
		System.out.print("Introduzca longitud del segundo cateto: ");
		cateto4 = sc3.nextDouble();
		System.out.println("Hipotenusa -> " + Math.sqrt(Math.pow(cateto3, 2) + Math.pow(cateto4, 2)));
		sc3.close();
		System.out.println("");
	}

}
