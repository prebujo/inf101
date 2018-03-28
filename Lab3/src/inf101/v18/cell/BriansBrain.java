package inf101.v18.cell;

import java.awt.Color;
import java.util.Random;

import inf101.v18.datastructures.IGrid;
import inf101.v18.datastructures.MyGrid;

public class BriansBrain implements ICellAutomaton{
	IGrid currentGeneration;
	
	public BriansBrain(int width, int height) {
		currentGeneration = new MyGrid(width, height,CellState.DEAD);
	}

	@Override
	public Color getColorInCurrentGeneration(int x, int y) {
		if(currentGeneration.get(x, y) == CellState.ALIVE)
			return Color.black;
		else if (currentGeneration.get(x, y) == CellState.DYING)
			return Color.blue;
		else
			return Color.white;
	}

	@Override
	public void initializeGeneration() {
		Random random = new Random();
		for(int i = 0; i < currentGeneration.getWidth();i++) {
			for(int j = 0; j < currentGeneration.getHeight();j++) {
				if(random.nextBoolean()) {
					currentGeneration.set(i, j, CellState.ALIVE);					
				} else {
					currentGeneration.set(i, j, CellState.DEAD);					
				}
			}
		}		
	}

	@Override
	public void stepAutomaton() {
		IGrid nextGeneration = new MyGrid(currentGeneration.getWidth(), currentGeneration.getHeight(), CellState.DEAD);
		for(int i = 0; i<currentGeneration.getWidth();i++)
			for(int j = 0; j<currentGeneration.getHeight();j++) {
				if(currentGeneration.get(i, j) == CellState.ALIVE)
					nextGeneration.set(i, j, CellState.DYING);
				else if(currentGeneration.get(i, j) == CellState.DEAD){
					int numNeighbours = 0;
					for (int dx = -1; dx <= 1; dx++) {
						for (int dy = -1; dy <= 1; dy++) {
							if (dx == 0 && dy == 0)
								continue; // samme celle, hopp over
							if (j + dy < 0)
								continue; // utenfor brettet
							if (j + dy >= currentGeneration.getHeight())
								continue; // utenfor brettet
							if (i + dx < 0)
								continue; // utenfor brettet
							if (i + dx >= currentGeneration.getWidth())
								continue; // utenfor brettet
							
							// tell levende naboer
							if (currentGeneration.get(i + dx, j + dy) == CellState.ALIVE) {
								numNeighbours++;
							}
						}
					}
					if (numNeighbours == 2)
						nextGeneration.set(i, j, CellState.ALIVE);
				}
				else ;
			}
		currentGeneration = nextGeneration;
	}

	@Override
	public int getHeight() {
		return currentGeneration.getHeight();
	}

	@Override
	public int getWidth() {
		return currentGeneration.getWidth();
	}
	

}
