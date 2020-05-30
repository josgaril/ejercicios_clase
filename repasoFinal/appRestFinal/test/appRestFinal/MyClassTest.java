package appRestFinal;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class MyClassTest {


	  @Test
	  public void testMultiply() {
	    MyClass tester = new MyClass();
	    assertEquals("10 x 5 must be 50", 50, tester.multiply(10, 5));
	  }

}
