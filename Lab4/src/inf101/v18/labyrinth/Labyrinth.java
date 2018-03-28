package inf101.v18.labyrinth;

import java.awt.Color;

import inf101.v18.datastructures.IGrid;

public class Labyrinth implements ILabyrinth{
	
	protected IGrid<LabyrinthTile> newTiles;
	
	protected int playerX;
	protected int playerY;
	
	public Labyrinth(IGrid<LabyrinthTile> tiles) {
		checkLab(tiles);
		this.newTiles = tiles.copy();		
	}

	private void checkLab(IGrid<LabyrinthTile> tiles){
		// TODO Auto-generated method stub
		boolean hasPlayer = false;
		for(int i = 0; i < tiles.getWidth(); i++)
			for(int j = 0; j < tiles.getHeight(); j++) {
				if(tiles.get(i, j) == LabyrinthTile.PLAYER) {
					if(hasPlayer)
						throw new IllegalArgumentException();
					else {
						hasPlayer = true;
						playerX = i;
						playerY = j;
					}
				}
				else if (tiles.get(i, j) == null)
					throw new IllegalArgumentException();						
			}
		if(!hasPlayer)
			throw new IllegalArgumentException();
	}
	
	public LabyrinthTile getCell(int x, int y) {
		return newTiles.get(x, y);
	}
	
	public Color getColor(int x, int y) {
		return newTiles.get(x, y).getColor();		
	}
	
	public int getHeight() {
		return newTiles.getHeight();
		
	}
	
	public int getWidth() {
		return newTiles.getWidth();
		
	}
	
	public boolean isPlaying(){
		return true;
	}
	
	public void movePlayer(Direction dir) throws MovePlayerException {
		//checking if direction is valid
		if(!playerCanGo(dir))
			throw new MovePlayerException(null);
		
		//setting previous position to open
		newTiles.set(playerX, playerY, LabyrinthTile.OPEN);
		
		//moving player in direction..
		switch (dir) {
		case NORTH:	newTiles.set(playerX, playerY+1, LabyrinthTile.PLAYER);
					playerY += 1;
					break;
		case EAST: 	newTiles.set(playerX+1, playerY, LabyrinthTile.PLAYER);
					playerX += 1;
					break;
		case SOUTH: newTiles.set(playerX, playerY-1, LabyrinthTile.PLAYER);
					playerY -= 1;
					break;
		case WEST: 	newTiles.set(playerX-1, playerY, LabyrinthTile.PLAYER);
					playerX -= 1;
					break;					
		}	
			
		
	}
	public boolean playerCanGo(Direction d) {
		switch (d) {
		case NORTH:	return isValidPosition(playerX, playerY+1);
		case EAST: 	return isValidPosition(playerX+1, playerY);
		case SOUTH: return isValidPosition(playerX, playerY-1);			
		case WEST: 	return isValidPosition(playerX-1, playerY);
		default: 	return false;						
		}		
	}
	
	public int getPlayerGold() {
		return 0;
		
	}
	
	public int getPlayerHitPoints() {
		return 0;
		
	}
	
	public boolean isValidPosition(int x, int y){
		if(x >= newTiles.getWidth() || x < 0)
			return false;
		else if (y >= newTiles.getHeight() || y < 0)
			return false;
		else if (newTiles.get(x, y) == LabyrinthTile.WALL)
			return false;
		else
			return true;
	}
	

}
