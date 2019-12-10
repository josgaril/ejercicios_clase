package datosPantalla1;

public class BasicoJava2 {

	public static void main(String[] args) {
		int i=1, j=1, k=1, x;
		System.out.println("x = " + ((j>=0 && k>1) ? ++j : k+1));
		System.out.println("x = " + ((j>1 || k>=1) ? j+3 : k+1));
		System.out.println("x = " + ((j>=1 && i<=1) ? 10 : 20));
		System.out.println("x = " + ((i+j>2 || k<1) ? 2 : 4));
		System.out.println("x = " + ((3/2>i) ? j+5 : k));
		System.out.println("x = " + ((3%2>i) ? j++ : ++k));
		System.out.println("x = " + ((i+10<=j+10 || k==0) ? -1 : -2));
		System.out.println("x = " + ((i==0 || j==1 || k==2) ? 0 : 5));
		System.out.println("x = " + ((i==0 || j==1 && k==2) ? 0 : 5));
		System.out.println("x = " + ((i!=0 || j==1 && k==2) ? 0 : 5));
		
		
		
		
	}

}
