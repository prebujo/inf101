package inf101.v18.cell;

import java.awt.Color;

import inf101.v18.datastructures.IGrid;
import inf101.v18.datastructures.MyGrid;

public class LangtonsAnt implements ICellAutomaton {
	
	/**
	 * The maximum length of any valid rule. Should not exceed 256, 
	 * otherwise not all colors will be distinct.
	 */
	public static final int MAX_RULE_LENGTH = 32;
	
	/**
	 * Stores the rule, in the following sense: Upon reading a state whose value is i, 
	 * char[i] indicates whether to turn left ('L') or right ('R')
	 */
	protected char[] rule;
	
	protected IGrid<CellState> currentGeneration;
	
	protected Ant ant;
	
	/**
	 * The state the ant saw upon moving to the field it is placed on 
	 * currently. Determines the next move (using the given rule).
	 */
	protected CellState seenState;
	
	public LangtonsAnt(int width, int height, String rule) throws Exception {
		this.currentGeneration = new MyGrid<CellState>(width, height, null);
		checkRule(rule);
		this.rule = rule.toCharArray();
	}
	
	/**
	 * Checks the rule for validity.
	 * A string is not a rule its length exceeds the maximum length ({@link #MAX_RULE_LENGTH}) 
	 * or if it contains characters other than 'L' and 'R'.
	 * 
	 * @param rule
	 * @throws Exception 
	 */
	private void checkRule(String rule) throws Exception {
		// TODO check if the length of the rule is within MAX_RULE_LENGTH and
		// 	throw an exception otherwise.
		if (rule.length() > MAX_RULE_LENGTH)
			throw new Exception();		
		// TODO check if the string rule only consists of the characters 
		// 'L' and 'R' and throw an exception otherwise.
		for (int i = 0; i<rule.length(); i++) {
			if(rule.charAt(i) != 'L' && rule.charAt(i) != 'R')
				throw new Exception();
		}
	}

	@Override
	public Color getColorInCurrentGeneration(int x, int y) {
		// This method returns different shades of the same color.
		// The scaling depends on the length of the given rule.
		CellState state = currentGeneration.get(x, y);
		if (state == CellState.ANT) return Color.yellow;
		int val = (int) (state.getValue()*256/rule.length);
		return new Color(255, 255-val, 255-val);
	}

	@Override
	public void initializeGeneration() {
		// TODO Set all fields to be in state 0.	
		CellState nullState = new CellState(0);
		for(int i = 0; i < currentGeneration.getHeight(); i++)
			for(int j = 0; j < currentGeneration.getWidth(); j++) {
				currentGeneration.set(i, j, nullState);
			}
		
		// TODO Initialize the ant and place it in the middle of the grid.
		ant = new Ant(currentGeneration.getHeight()/2, currentGeneration.getWidth()/2, Direction.NORTH);
		// TODO Initialize the seenState field (to state 0).
		seenState = nullState;
	}

	@Override
	public void stepAutomaton() {
		
		// Retrieve the color of the cell the ant is on using the seenState field.
		int color = seenState.getValue();
		
		// Initialize the next position of the any by copying the ant field.
		// Make sure that all operations concerning the *next* position of the
		// ant in the grid are performed on this object.
		Ant nextAnt = ant.copy();
		
		if (rule[color] == 'L') {
			// TODO turn left
			nextAnt.turnLeft();
		}
		if (rule[color] == 'R') {
			// TODO turn right
			nextAnt.turnRight();
		}
		// TODO Check whether the new coordinates are within the grid, otherwise 
		// 	reset them in some way of your choosing. (Note that this will greatly
		//  influence the patterns being drawn by the ant.)
		if (nextAnt.x < 0){
			nextAnt.x = 1;
			nextAnt.dir = Direction.EAST;
		}
		else if (nextAnt.y < 0) {
			nextAnt.y = 1;
			nextAnt.dir = Direction.NORTH;
		}
		else if (nextAnt.x > currentGeneration.getWidth() ) {
			nextAnt.x = currentGeneration.getWidth() - 1;
			nextAnt.dir = Direction.WEST;			
		}
		else if (nextAnt.y > currentGeneration.getHeight()) {
			nextAnt.y = currentGeneration.getHeight() - 1;
			nextAnt.dir = Direction.SOUTH;
		}
		
		// TODO Update the state of the filed the ant is leaving.
		int newColor = (color + 1) % rule.length;
		CellState newState = new CellState(newColor);
		currentGeneration.set(ant.x, ant.y, newState);
		// TODO Update the seenState field, i.e. the state the ant is reading in 
		//	the field it is moving to.
		seenState = currentGeneration.get(nextAnt.x, nextAnt.y);
		
		// TODO Move the ant to the new position in the grid.
		currentGeneration.set(nextAnt.x, nextAnt.y, CellState.ANT);
		
		// TODO Update the ant field variable.
		ant = nextAnt;
		
	}

	@Override
	public int getHeight() {
		return this.currentGeneration.getHeight();
	}

	@Override
	public int getWidth() {
		return this.currentGeneration.getWidth();
	}

}
