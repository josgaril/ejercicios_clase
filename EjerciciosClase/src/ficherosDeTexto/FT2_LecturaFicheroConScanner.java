package ficherosDeTexto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FT2_LecturaFicheroConScanner {

	public static void main(String[] args) {

		/*
		 * Programa que lee línea a línea el contenido del fichero datos.txt utilizando
		 * la clase Scanner. Se utiliza el método hasNext() de Scanner para saber si
		 * quedan más datos que leer en el fichero. Este método devuelve false si se ha
		 * llegado al final del fichero y true en caso contrario.
		 */

		String texto;
		File f = new File("C:\\ficheros eclipse\\LeerYEscribir1.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(f);
			while (sc.hasNext()) {//mientras no se alcance el final del fichero
				texto = sc.nextLine();
				System.out.println(texto);
			}
		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el archivo");
			System.out.println(e.getLocalizedMessage());
		} finally {
			try {
				if (sc != null) {
					sc.close();
				}
			} catch (NullPointerException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
