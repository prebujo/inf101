package inf101.v18.datastructures;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import inf101.v18.cell.CellState;

public class GridTest {
	Random random = new Random();

	@Test
	public void constructTest1() {
		IGrid<CellState> grid = new MyGrid<CellState>(11, 17, CellState.DEAD);
		
		assertEquals(grid.getHeight(), 17);
		assertEquals(grid.getWidth(), 11);
	}
	/**
	 * Tests that trying to access outside of the dimensions of the grid throws
	 * an IndexOutOfBoundsException.
	 */
	
	@Test
	public void outOfBoundsTest2(){
		IGrid<CellState> grid = new MyGrid<CellState>(10,10,CellState.ALIVE);
		try {
			grid.get(11, 5);
			fail("Should throw exception");
		} catch(IndexOutOfBoundsException e) {
			;
		}
		try {
			grid.get(5, 11);
			fail("Should throw exception");
		} catch(IndexOutOfBoundsException e) {
			;
		}		
	}
	
	
	@Test
	public void nullstateTest() {
		IGrid<CellState> grid = new MyGrid<CellState>(100,100,CellState.DYING);
		for(int i = 0; i<100;i++)
			for(int j = 0; j<100;j++)
				assertEquals(CellState.DYING, grid.get(i, j));		
	}
	@Test
	public void nullConstructTest() {
		try {
		IGrid<CellState> grid = new MyGrid<CellState>(0,0,CellState.DEAD);
		fail("Should throw exception");	
		} catch (IllegalArgumentException e ) {
			;
		}
	}
	@Test
	public void outOfBoundsTest() {
		IGrid<CellState> grid = new MyGrid<CellState>(10, 10, CellState.DEAD);

		try {
			grid.set(11, 0, CellState.DEAD);
			fail("Should throw exception");
		} catch (IndexOutOfBoundsException e) {
			;
		}
		try {
			grid.set(0, 11, CellState.DEAD);
			fail("Should throw exception");
		} catch (IndexOutOfBoundsException e) {
			;
		}
	}

	@Test
	public void setGetTest1() {
		IGrid<CellState> grid = new MyGrid<CellState>(100, 100, CellState.DEAD);

		for (int x = 0; x < 100; x++)
			for (int y = 0; y < 100; y++) {
				CellState cs = CellState.random(random);
				grid.set(x, y, cs);
				assertEquals(cs, grid.get(x, y));
			}
	}

	@Test
	public void setGetTest2() {
		IGrid<CellState> grid = new MyGrid<CellState>(100, 100, CellState.DEAD);

		for (int x = 0; x < 100; x++) {
			for (int y = 0; y < 100; y++) {
				grid.set(x, y, CellState.random(random));
			}
		}

		for (int x = 0; x < 100; x++)
			for (int y = 0; y < 100; y++) {
				CellState cs = CellState.random(random);
				grid.set(x, y, cs);
				assertEquals(cs, grid.get(x, y));
			}
	}

	@Test
	public void copyTest() {
		IGrid<CellState> grid = new MyGrid<CellState>(100, 100, CellState.DEAD);

		for (int x = 0; x < 100; x++) {
			for (int y = 0; y < 100; y++) {
				CellState cs = CellState.random(random);
				grid.set(x, y, cs);
			}
		}

		IGrid<CellState> newGrid = grid.copy();
		for (int x = 0; x < 100; x++) {
			for (int y = 0; y < 100; y++) {
				assertEquals(grid.get(x, y), newGrid.get(x, y));
			}
		}
	}
}
