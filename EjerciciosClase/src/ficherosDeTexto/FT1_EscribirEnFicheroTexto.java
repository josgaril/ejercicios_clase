package ficherosDeTexto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FT1_EscribirEnFicheroTexto {

	public static void main(String[] args) throws IOException {

		/*
		 * 1. Programa Java que lee texto por teclado y lo escribe en un fichero de
		 * texto llamado datos.txt. El proceso consiste en leer una línea de texto por
		 * teclado y escribirla en el fichero. Este proceso se repite hasta que se
		 * introduce por teclado la cadena FIN. La cadena FIN que indica el final de
		 * lectura no se debe escribir en el fichero.
		 */

		String texto;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = null;
		FileWriter fw = null;
		try {
		    fw= new FileWriter("C:\\ficheros eclipse\\LeerYEscribir.txt", true);
			pw = new PrintWriter(fw);
			System.out.println("Introduzca texto. Para acabar introduce la cadena FIN: ");
			texto = br.readLine();			
			while (!texto.equalsIgnoreCase("FIN")) {
				pw.println(texto);
				texto = br.readLine();
			}
			pw.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pw.close();
			fw.close();
		}
		System.out.println("Escritura realizada");

		// usando try-with-resources
		try (FileWriter fw1= new FileWriter("C:\\ficheros eclipse\\LeerYEscribir1.txt", true);
			PrintWriter pw1 = new PrintWriter(fw1)) {
			System.out.println("Introducimos texto. Para acabar introduce la cadena FIN:");
			texto = br.readLine();			
			while (!texto.equalsIgnoreCase("FIN")) {
				pw1.println(texto);
				texto = br.readLine();
			}
		}  catch (IOException ex) {
            System.out.println(ex.getMessage());
		}
		System.out.println("Escritura realizada");
	}

}
