package com.ipartek.formacion.uf2216.presentacion;

import java.util.Scanner;
import java.util.TreeMap;

import com.ipartek.formacion.uf2216.entidades.Libro;

public class PresentacionConsola {

	private final static TreeMap<Long, Libro> libros = new TreeMap<>();
	private final static Scanner scanner = new Scanner(System.in);
	private static long ultimoId = 1L;
	
	public static void main(String[] args) {
		boolean esNuevoRegistro;
					
		do {
			Libro libro = pedirLibro();
			
			mostrarLibro(libro);

			guardarLibro(libro);
			
			listadoLibros();
			
			//Preguntar si el usuario quiere introducir un nuevo registro
			System.out.print("�Desea introducir un nuevo registro? (S/n) ");
			esNuevoRegistro = !scanner.nextLine().equalsIgnoreCase("n");
		} while (esNuevoRegistro);
		
		System.out.println("Saliendo de la aplicaci�n. Gracias por usar esta aplicaci�n");
		
		scanner.close();
	}

	private static Libro pedirLibro() {
		//Pedir datos de libro
		String titulo, isbn;
		int numeroPaginas = -1;
		boolean formato = false;
		
		titulo = pedirTitulo();
		isbn = pedirIsbn();
		numeroPaginas = pedirNumeroPaginas(numeroPaginas);
		formato = pedirFormato(formato);
		
		//Creaci�n de libro en base a los datos introducidos
		Libro libro = new Libro(ultimoId, titulo, isbn, numeroPaginas, formato);
		
		return libro;
	}

	private static void guardarLibro(Libro libro) {
		System.out.print("�Quieres guardar este libro? (S/n) ");
		
		//Si me dicen que s�, guardo el libro
		if(!scanner.nextLine().equalsIgnoreCase("n")) {
			//A�adir el libro a la colecci�n de libros
			libros.put(ultimoId++, libro);
		}
	}

	private static void listadoLibros() {
		System.out.println("LISTADO DE LIBROS");
		
		System.out.println(
				"Id\tISBN\t\tN�mero de p�ginas\tFormato\tT�tulo");
		for (Libro libroExtraido : libros.values()) {
			System.out.println(
					libroExtraido.getId() +
					"\t" + libroExtraido.getIsbn() +
					"\t" + libroExtraido.getNumeroPaginas() +
					"\t\t\t" + (libroExtraido.isFormato() ? "Digital" : "Papel") +
					"\t" + libroExtraido.getTitulo());
		}
	}

	private static void mostrarLibro(Libro libro) {
		System.out.println(
				"Id: " + libro.getId() + 
				"\nT�tulo: " + libro.getTitulo() + 
				"\nISBN: " + libro.getIsbn() + 
				"\nN�mero de p�ginas: " + libro.getNumeroPaginas() +
				"\nFormato: " + (libro.isFormato() ? "Digital" : "Papel"));
	}

	private static boolean pedirFormato(boolean formato) {
		boolean esFormatoCorrecto;
		String stringFormato;
		do {
			//Introducci�n de formato
			System.out.print("Formato (digital o papel): ");
			stringFormato = scanner.nextLine().trim();
			
			if(stringFormato.equalsIgnoreCase("digital") || stringFormato.equalsIgnoreCase("papel")) {
				esFormatoCorrecto = true;
				formato = stringFormato.equalsIgnoreCase("digital");
			} else {
				esFormatoCorrecto = false;
				System.out.println("El formato debe ser digital o papel");
			}
		} while (!esFormatoCorrecto);
		return formato;
	}

	private static int pedirNumeroPaginas(int numeroPaginas) {
		boolean esNumeroPaginasCorrecto;
		do {
			//Introducci�n de n�mero de p�ginas
			System.out.print("N�mero de p�ginas: ");
			
			try {
				numeroPaginas = scanner.nextInt();
				
				if(numeroPaginas >= 1) {
					esNumeroPaginasCorrecto = true;
				} else {
					esNumeroPaginasCorrecto = false;
					System.out.println("El n�mero de p�ginas debe ser m�nimo 1");
				}
			} catch (Exception e) {
				System.out.println("Debes introducir un n�mero (s�lo d�gitos)");
				esNumeroPaginasCorrecto = false;
			} finally {
				//Consumir el enter si ha ido bien, o el texto si ha habido una excepci�n
				scanner.nextLine();
			}
		} while (!esNumeroPaginasCorrecto);
		return numeroPaginas;
	}

	private static String pedirIsbn() {
		boolean esIsbnCorrecto;
		String isbn;
		do {
			//Introducci�n de ISBN
			System.out.print("ISBN: ");
			isbn = scanner.nextLine();
			
			if(isbn.matches("\\d{10}")) {
				esIsbnCorrecto = true;
			} else {
				esIsbnCorrecto = false;
				System.out.println("El ISBN debe ser un n�mero de longitud 10");
			}
		} while (!esIsbnCorrecto);
		return isbn;
	}

	private static String pedirTitulo() {
		boolean esTituloCorrecto;
		String titulo;
		do {
			//Introducci�n de t�tulo
			System.out.print("T�tulo: ");
			titulo = scanner.nextLine().trim();
			
			//Validaci�n del t�tulo
			if (titulo.length() > 3 && titulo.length() <= 150) {
				esTituloCorrecto = true;
				
			} else {
				esTituloCorrecto = false;
				System.out.println("El t�tulo debe tener un tama�o m�nimo de 3 letras y m�ximo de 150");
			}
		} while (!esTituloCorrecto);
		return titulo;
	}

}
