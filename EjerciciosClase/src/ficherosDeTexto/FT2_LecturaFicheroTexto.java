package ficherosDeTexto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FT2_LecturaFicheroTexto {

	public static void main(String[] args){

		/*
		 * 2. Programa Java que lee el contenido del fichero datos.txt creado en el
		 * ejemplo anterior y lo muestra por pantalla. El proceso consiste en leer una
		 * línea del fichero y mostrarla por pantalla. El proceso se repite hasta que se
		 * llegue al final del fichero y no hayan más líneas que leer. Cuando esto
		 * ocurre el método readLine() devuelve null.
		 */
		String texto;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("C:\\ficheros eclipse\\LeerYEscribir11.txt");
			br = new BufferedReader(fr);
			texto = br.readLine();
			do {
				System.out.println(texto);
				texto = br.readLine();
			} while (texto != null);
		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el archivo");//e.getMessage())
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
}
