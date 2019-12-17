package arrayList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class Ej2_otro_arraylist {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		/*
		 * 2. Programa que lea una serie de valores numéricos enteros desde el teclado y
		 * los guarde en un ArrayList de tipo Integer. La lectura de números termina
		 * cuando se introduzca el valor -99
		 */		
		
		ArrayList<Integer> array = leerValores();
		double suma = calcularSuma(array);
		double media = suma / array.size();
		mostrarResultados(array, suma, media);
	}

	public static ArrayList<Integer> leerValores() throws NumberFormatException, IOException {
		ArrayList<Integer> valores = new ArrayList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n;
		System.out.print("Introduce entero. -99 para acabar: ");
		n = Integer.parseInt(br.readLine());
		while (n != -99) {
			valores.add(n);
			System.out.print("Introduce entero. -99 para acabar: ");
			n = Integer.parseInt(br.readLine());
		}
		return valores;
	}

	public static double calcularSuma(ArrayList<Integer> valores) {
		double suma = 0;
		Iterator it = valores.iterator();
		while (it.hasNext()) {
			suma = suma + (Integer) it.next();
			// next() devuelve un dato de tipo Object. Hay que convertirlo a Integer
		}
		return suma;
	}

	public static void mostrarResultados(ArrayList<Integer> valores, double suma, double media) {
		int cont = 0;
		System.out.println("Valores introducidos: ");
		System.out.println(valores);
		System.out.println("Suma: " + suma);
		System.out.printf("Media: %.2f %n", media);
		for (Integer i : valores) {
			if (i > media) {
				cont++;
			}
		}
		System.out.println(cont + " valores superiores a la media");
	}

}
