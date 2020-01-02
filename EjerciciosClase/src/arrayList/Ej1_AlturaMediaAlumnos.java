package arrayList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ej1_AlturaMediaAlumnos {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * 1. Calcular la altura media de los alumnos de una clase
		 * 
		 * Programa Java que pida por teclado las alturas de N alumnos de una clase y
		 * las guarde en un ArrayList de tipo Double. A continuaci�n el programa
		 * calcular� la altura media de todos los alumnos, cuantos alumnos hay m�s altos
		 * que la media y cuantos m�s bajos.
		 * 
		 * Para resolverlo vamos a utilizar 4 m�todos adem�s del m�todo main:
		 * 
		 * M�todo numeroAlumnos(): este m�todo pide por teclado el n�mero de alumnos de
		 * la clase y devuelve dicho n�mero al programa principal.
		 * 
		 * M�todo leerAlturas(): pide por teclado las alturas de los N alumnos y las
		 * almacena en el ArrayList. Este m�todo recibe como par�metros el ArrayList
		 * inicialmente vac�o y el n�mero de alumnos a leer.
		 * 
		 * M�todo calcularMedias(): calcula y devuelve la media de los alumnos de la
		 * clase. Este m�todo recibe como par�metro el ArrayList con las alturas de
		 * todos los alumnos.
		 * 
		 * M�todo mostrarResultados(): muestra por pantalla todas las alturas y calcula
		 * y muestra el n�mero de alumnos con altura superior e inferior a la media.
		 * Recibe como par�metros el ArrayList con las alturas de todos los alumnos y la
		 * media calculada anteriormente.
		 */

		int num;
		double media;
		num = numeroAlumnos();
		ArrayList<Double> altura = new ArrayList<Double>();
		leerAlturas(altura, num);
		media = calcularMedias(altura);
		mostrarResultados(altura, media);
	}

	private static void mostrarResultados(ArrayList<Double> altura, double media) {
		int superior=0, inferior=0;
		System.out.println("Se muestran todas las alturas");
		System.out.println(altura);
		for (double d : altura) {
			if (d > media) {
				superior++;
			} else {
				inferior++;
			}
		}
		System.out.printf("La media es: %.2f %n", media);
		System.out.println("Hay " + superior + " alumnos con altura superior que la media");
		System.out.println("Hay " + inferior + " alumnos con altura inferior que la media");

	}

	private static double calcularMedias(ArrayList<Double> altura) {
		double sumaaltura = 0;
		for (Double d : altura) {
			sumaaltura += d;
		}
		return sumaaltura / altura.size();
	}

	private static void leerAlturas(ArrayList<Double> altura, int num) throws NumberFormatException, IOException {

		int i;
		double alto;
		System.out.println("Introduzca las alturas de los alumnos");
		for (i = 1; i <= num; i++) {
			do {
				System.out.print("Alumno " + i + " altura: -> ");
				alto = Double.parseDouble(br.readLine());
			} while (alto <= 0);
			altura.add(alto);
		}
	}

	private static int numeroAlumnos() throws NumberFormatException, IOException {
		System.out.print("Introduzca el n�mero de alumnos:");
		int num = Integer.parseInt(br.readLine());
		return num;
	}

}
