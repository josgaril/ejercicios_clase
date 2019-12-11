package estructuraRepetitiva;

public class ER_Ejercicio1_2_3_4_5_6 {

	public static void main(String[] args) {

		/*
		 * 1. Ejemplo de uso de while: Programa Java que muestre los números del 1 al
		 * 100 utilizando la instrucción while.
		 */
		System.out.println("Números del 1 al 100 con while");
		int i1 = 1;
		while (i1 <= 100) {
			System.out.println(i1);
			i1++;
		}
		System.out.println("");

		/*
		 * 2. Ejemplo de uso de do-while. Programa Java que muestre los números del 1 al
		 * 100 utilizando la instrucción do..while.
		 */
		System.out.println("Números del 1 al 100 con do while");
		int i2 = 1;
		do {
			System.out.println(i2);
			i2++;
		} while (i2 <= 100);
		System.out.println("");

		/*
		 * 3. Ejemplo de uso de for. Programa Java que muestre los números del 1 al 100
		 * utilizando la instrucción for.
		 */
		System.out.println("Números del 1 al 100 con for");
		int i3;
		for (i3 = 1; i3 <= 100; i3++) {
			System.out.println(i3);
		}
		System.out.println("");

		/*
		 * 4. Ejemplo de uso de while. Programa Java que muestre los números del 100 al
		 * 1 utilizando la instrucción while.
		 */
		System.out.println("Números del 100 al 1 con while");
		int i4 = 100;
		while (i4 >= 1) {
			System.out.println(i4--);
		}
		System.out.println("");

		/*
		 * 5. Ejemplo de uso de do-while. Programa Java que muestre los números del 100
		 * al 1 utilizando la instrucción do..while.
		 */
		System.out.println("Números del 100 al 1 con do while");
		int i5 = 100;
		do {
			System.out.println(i5--);
		} while (i5 >= 1);
		System.out.println("");

		/*
		 * 6. Ejemplo de for. Programa Java que muestre los números del 100 al 1
		 * utilizando la instrucción for.
		 */
		System.out.println("Números del 100 al 1 con do for");
		int i6;
		for (i6 = 100; i6 >= 1; i6--) {
			System.out.println(i6);
		}
		System.out.println("");
	}

}
