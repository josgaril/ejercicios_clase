package buclesAnidados;

public class BA4_QuitarLetrasAUnaFrase {
	
	public static void main(String[] args) {
	
		/*
		 * 4. Programa que muestre en lineas separadas lo siguiente:
		 * ZYWXVUTSRQPONMLKJIHGFEDCBA, YWXVUTSRQPONMLKJIHGFEDCBA,
		 * WXVUTSRQPONMLKJIHGFEDCBA, ...., DCBA, CBA, BA, A.
		 */
		char x,y;
		for (x='Z';x>='A';x--) {

			for(y=x; y>='A';y--){
				System.out.print(y);
			}
			System.out.println();
				
				//System.out.print(cadena.charAt(i));
		}
		System.out.println("Fin del progama");

	}
	
		
	
}
