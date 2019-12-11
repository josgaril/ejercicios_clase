package estructuraCondicional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ECMayorde3_Ejercicio8 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		/*8. El programa lee por teclado tres números enteros y calcula y muestra el mayor de los tres.*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num1, num2, num3;
		System.out.println("Introduce 3 números enteros para saber cual es el mayor");
		System.out.print("Numero 1-> ");
		num1 = Integer.parseInt(br.readLine());
		System.out.print("Numero 2-> ");
		num2 = Integer.parseInt(br.readLine());
		System.out.print("Numero 3-> ");
		num3 = Integer.parseInt(br.readLine());
		if (num1>num2) {
			if (num1>num3) {
				System.out.println("El mayor es: " + num1);
			}
			else {
				System.out.println("El mayor es: " + num3);
			}
		}
		else {
			if(num2>num3) {
				System.out.println("El mayor es: " + num2);
			}
			else {
				System.out.println("El mayor es: " + num3);
			}
		}
	}

}
