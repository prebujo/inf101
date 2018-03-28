package inf101.v18.main;

import java.util.Random;

import inf101.v18.util.IGenerator;
import inf101.v18.util.generators.IntGenerator;
import inf101.v18.util.generators.StringGenerator;

public class GenerateMain {
	public static void main(String args[]) {
		Random r = new Random();
		for(int i = 0; i<10;i++) {
		IGenerator<String> strGen = new StringGenerator(5,15);
		System.out.println("Tilfeldig streng: " + strGen.generate(r));
		}
		
		IGenerator<String> strGen = new StringGenerator(5,15);
		System.out.println("5 like tilfeldige strenger: " + strGen.generateEquals(r,5));
		
		long sum = 0;
		for(int i = 0; i<1000000;i++) {
			
			IGenerator<Integer> intGen = new IntGenerator(0, 1000);
			
			sum = sum + intGen.generate(r);
			
		}
		System.out.println(sum/1000000); 
	}

}
