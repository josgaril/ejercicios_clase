package ficherosDeTexto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FT2_LecturaFicheroTextoPorCaracteres {

	public static void main(String[] args) {

		/*
		 * 2. Mostrar por pantalla el contenido del fichero de texto datos.txt pero en este
		 * caso lo vamos a leer carácter a carcater. El proceso consiste en leer un
		 * carácter del fichero y mostrarlo por pantalla. Este proceso se repite hasta
		 * que no queden más caracteres que leer en el fichero, es decir, hasta que se
		 * alcance el finall del fichero. En este caso el método read() devuelve -1.
		 */

		int texto;
		int i;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("C:\\ficheros eclipse\\LeerYEscribir.txt");
			br = new BufferedReader(fr);
			texto = br.read();
			while (texto != -1) {
				System.out.println((char) texto);
				texto = br.read();
			}
		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el archivo indicado");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
