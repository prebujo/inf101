package inf101.v18.labyrinth;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import inf101.v18.datastructures.IGrid;

public class LabyrinthTest {
	private ILabyrinth labyrinth;

	private IGrid<LabyrinthTile> testGrid() {
		return LabyrinthHelper.loadGrid(//
				new char[][] { //
				{ '*', '*', '*', '*' }, //
				{ '*', ' ', ' ', '*' }, //
				{ '*', ' ', '*', '*' }, //
				{ '*', 's', '*', '*' }, //
				{ '*', '*', '*', '*' }, });
	}

	@Before
	public void setup() {
		labyrinth = new Labyrinth(testGrid());
	}

	@Test
	public void badMoveTestS() {
		assertFalse(labyrinth.playerCanGo(Direction.SOUTH));

		try {
			labyrinth.movePlayer(Direction.SOUTH);
			fail("Moving south should fail");
		} catch (MovePlayerException e) {
			assertTrue(true);
		}
	}

	@Test
	public void badMoveTestW() {
		assertFalse(labyrinth.playerCanGo(Direction.WEST));

		try {
			labyrinth.movePlayer(Direction.WEST);
			fail("Moving west should fail");
		} catch (MovePlayerException e) {
			assertTrue(true);
		}
	}

	@Test
	public void badMoveTestE() {
		assertFalse(labyrinth.playerCanGo(Direction.EAST));

		try {
			labyrinth.movePlayer(Direction.EAST);
			fail("Moving east should fail");
		} catch (MovePlayerException e) {
			assertTrue(true);
		}
	}

	@Test
	public void goodMoveTestN() throws MovePlayerException {
		assertTrue(labyrinth.playerCanGo(Direction.NORTH));
		labyrinth.movePlayer(Direction.NORTH);
		assertEquals(LabyrinthTile.PLAYER, labyrinth.getCell(1, 2));
	}

	@Test
	public void goodMoveTestNNE() throws MovePlayerException {
		labyrinth.movePlayer(Direction.NORTH);
		labyrinth.movePlayer(Direction.NORTH);
		labyrinth.movePlayer(Direction.EAST);
		assertEquals(LabyrinthTile.PLAYER, labyrinth.getCell(2, 3));
	}

	@Test
	public void badGrid1() {
		try {
			new Labyrinth(LabyrinthHelper.loadGrid(new char[][] { //
					{ '*', '*', '*', '*' }, //
					{ '*', ' ', 's', '*' }, //
					{ '*', ' ', '*', '*' }, //
					{ '*', 's', '*', '*' }, //
					{ '*', '*', '*', '*' }, }));
			fail("Should throw exception if board has more than one player");
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	@Test
	public void gridGet() {
		assertEquals(LabyrinthTile.WALL, labyrinth.getCell(0, 0));
		assertEquals(LabyrinthTile.WALL, labyrinth.getCell(2, 1));
		assertEquals(LabyrinthTile.WALL, labyrinth.getCell(3, 4));
		assertEquals(LabyrinthTile.PLAYER, labyrinth.getCell(1,1));
		assertEquals(LabyrinthTile.OPEN, labyrinth.getCell(1,2));
	}
	
	@Test
	public void badGrid2() {
		try {
			new Labyrinth(LabyrinthHelper.loadGrid(new char[][] { //
					{ '*', '*', '*', '*' }, //
					{ '*', ' ', ' ', '*' }, //
					{ '*', ' ', '*', '*' }, //
					{ '*', ' ', '*', '*' }, //
					{ '*', '*', '*', '*' }, }));
			fail("Should throw exception if board has more than one player");
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
}
