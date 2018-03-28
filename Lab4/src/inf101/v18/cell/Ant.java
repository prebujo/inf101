package inf101.v18.cell;

public class Ant {
	
	protected int x, y;
	protected Direction dir;
	
	public Ant(int x, int y, Direction dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
	public void turnLeft() {
		switch(dir) {
		case NORTH: 	this.dir = Direction.WEST;
					  	this.x -= 1;
					  	break;
		case EAST: 		this.dir = Direction.NORTH;
						this.y += 1;
						break;
		case SOUTH: 	this.dir = Direction.EAST;
						this.x += 1;
						break;
		case WEST:		this.dir = Direction.SOUTH;
						this.y -= 1;
						break;					
		}		
	}

	
	public void turnRight() {
		switch(dir) {
		case NORTH: 	this.dir = Direction.EAST;
					  	this.x += 1;
					  	break;
		case EAST: 		this.dir = Direction.SOUTH;
						this.y -= 1;
						break;
		case SOUTH: 	this.dir = Direction.WEST;
						this.x -= 1;
						break;
		case WEST:		this.dir = Direction.NORTH;
						this.y += 1;
						break;					
		}	
	}
	
	public int getX() { return x; }
	public void setX(int x) { this.x = x; }
	
	public int getY() { return y; }
	public void setY(int y) { this.y = y; }
	
	public Ant copy() {
		return new Ant(x, y, dir);
	}

}
