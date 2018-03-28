package inf101.v18.cell;

import java.util.Random;

/**
 * 
 * The State of a cell
 */
public enum CellState {
	ALIVE,
	DYING,
	DEAD;
	
	public static CellState random(Random rand){
		return CellState.values()[rand.nextInt(3)];
	}
}

//this is a comment to make a change