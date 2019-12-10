package datosPantalla1;

public class Basicos4 {

	public static void main(String[] args) {
	int A=1, B=2, C=3, D=4, AUX;
	System.out.println("Valores iniciales");
	System.out.println("A = " + A);
	System.out.println("B = " + B);
	System.out.println("C = " + C);
	System.out.println("D = " + D);
	AUX=B; 
	B=C;
	C=A;
	A=D;
	D=AUX;
	System.out.println("Valores finales");
	System.out.println("B toma el valor de C -> B = " + B);
	System.out.println("C toma el valor de A -> C = " + C);
	System.out.println("A toma el valor de D -> A = " + A);
	System.out.println("D toma el valor de B -> D = " + D);
	
	}

}
