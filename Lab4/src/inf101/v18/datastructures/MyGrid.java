package inf101.v18.datastructures;

/**
 * 
 * A Grid contains a set of cells in a square 2D matrix.
 *
 */
public class MyGrid<T> implements IGrid<T> {
	private IList<T> cells;
	private int height;
	private int width;

	/**
	 * 
	 * Construct a grid with the given dimensions.
	 * 
	 * @param width
	 * @param height
	 * @param initElement
	 *            What the cells should initially hold (possibly null)
	 */
	public MyGrid(int width, int height, T t) {
		if(width <= 0 || height <= 0)
			throw new IllegalArgumentException();

		this.height = height;
		this.width = width;
		cells = new MyList<T>(height * width);
		for (int i = 0; i < height * width; ++i) {
			cells.add(t);
		}
	}

	
	@Override
	public int getHeight() {
		return height; // 
	}


	@Override
	public int getWidth() {
		return width; // 
	}


	@Override
	public void set(int x, int y, T t) {
		if(x < 0 || x >= width)
			throw new IndexOutOfBoundsException();
		if(y < 0 || y >= height)
			throw new IndexOutOfBoundsException();
		int index = x+(width*y);
		cells.set(index, t);
	}

	
	@Override
	public T get(int x, int y) {
		if(x < 0 || x >= width)
			throw new IndexOutOfBoundsException();
		if(y < 0 || y >= height)
			throw new IndexOutOfBoundsException();
		int index = x + (width*y);
		
		return cells.get(index);
	}

	@Override
	public IGrid<T> copy() {
		MyGrid<T> newGrid = new MyGrid<T>(getWidth(), getHeight(), null);

		for (int x = 0; x < width; x++)
			for(int y = 0; y < height; y++)
				newGrid.set(x,  y,  get(x, y));
		return newGrid;
	}

}
