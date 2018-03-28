package inf101.v18.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import inf101.v18.util.IGenerator;
import inf101.v18.util.generators.StringGenerator;


public class StringTest {
	private final IGenerator<String> strGen = new StringGenerator();
	private final int N = 100000;
	@Test
	public void stringTest1() {
		assertEquals("foo", "FOO".toLowerCase());
	}
	
	@Test
	public void transitiveProperty(String s1, String s2, String s3) {
		  if(s1.equals(s2) && s2.equals(s3))
		    assertEquals(s1, s3); // transitivitet
	}
	
	@Test
	public void transitiveTest(int N) {
		
	}
	
	@Test
	public void stringTest2() {
		for(int i = 0; i < N; i++) {
			String s = strGen.generate();
			
			assertEquals(s + s, s.concat(s));
		}
			
	}
}

