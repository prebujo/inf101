package inf101.v18.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import inf101.v18.datastructures.IGrid;
import inf101.v18.util.IGenerator;
import inf101.v18.util.generators.IntGenerator;
import inf101.v18.util.generators.MyGridGenerator;
import inf101.v18.util.generators.StringGenerator;

import java.util.Random;


public class MyGridTest {
	private static final int N = 1000000;

	private IGenerator<String> strGen = new StringGenerator();
	private IGenerator<IGrid<String>> gridGen = new MyGridGenerator<String>(strGen);
	private IGenerator<Integer> intGen = new IntGenerator(1, 100);

	@BeforeAll
	public static void setUp() throws Exception {
	}

	@AfterAll
	public static void tearDown() throws Exception {
	}

	/**
	 * Test that get gives back the same value after set.
	 */
	@Test
	public void setGetTest() {
		IGrid<String> grid = gridGen.generate();

		IGenerator<Integer> wGen = new IntGenerator(0, grid.getWidth());
		IGenerator<Integer> hGen = new IntGenerator(0, grid.getHeight());

		for (int i = 0; i < N; i++) {
			int x = wGen.generate();
			int y = hGen.generate();
			String s = strGen.generate();
			
			setGetProperty(grid, x, y, s);
		}
	}

	/**
	 * get(x,y) is val after set(x, y, val)
	 */
	private <T> void setGetProperty(IGrid<T> grid, int x, int y, T val) {
		// TODO: fyll inn
		fail("TODO");
	}

	/**
	 * A set on (x1,y1) doesn't affect a get on a different (x2,y2)
	 */
	private <T> void setGetIndependentProperty(IGrid<T> grid, int x1,
			int y1, int x2, int y2, T val) {
		if (x1 != x2 && y1 != y2) {
			T s = grid.get(x2, y2);
			grid.set(x1, y1, val);
			assertEquals(s, grid.get(x2, y2));
		}
	}


}
