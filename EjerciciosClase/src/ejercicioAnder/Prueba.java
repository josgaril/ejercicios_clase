package ejercicioAnder;

public class Prueba {

	public static void main(String[] args) {

		// hacer un array con los datos 3 0 1 8 7 2 5 4 6 9 y ordenar
		// crear en una clase a la que pasamos el array con los elementos y el orden, si queremos ascendente o descendente
		
		
		int[] bailarines = { 3, 0, 1, 8, 7, 2, 5, 4, 6, 9 };
		int i, j, aux;
		System.out.println("Mostramos el array desordenado:");
		for (i = 0; i <= 9; i++) {
			System.out.println(bailarines[i]);
		}
		
		//llamada a la clase de los bailarines
		
		
		System.out.println("Procedemos a ordenar el array");
//		for (i = 0; i <= 9; i++)
//			for (j = 0; j < 9; j++) {
//				if (bailarines[j] > bailarines[j+1]) {
//					aux = bailarines[j];
//					bailarines[j] = bailarines[j+1];
//					bailarines[j+1] = aux;
//				}
//			}

			
		System.out.println("Mostramos el array ordenado:");
		for (i = 0; i <= 9; i++) {
			System.out.println(bailarines[i]);
		}
	}
}
