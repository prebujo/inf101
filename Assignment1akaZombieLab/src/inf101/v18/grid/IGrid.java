package inf101.v18.grid;

import java.util.function.Function;
import java.util.stream.Stream;

public interface IGrid<T> extends Iterable<T> {

	/**
	 * Make a copy
	 *
	 * @return A fresh copy of the grid, with the same elements
	 */
	IGrid<T> copy();

	/**
	 * Create a parallel {@link Stream} with all the elements in this grid.
	 * 
	 * @return A stream
	 * @see {@link java.util.Collection#parallelStream()}
	 */
	Stream<T> elementParallelStream();

	/**
	 * Create a {@link Stream} with all the elements in this grid.
	 * 
	 * @return A stream
	 */
	Stream<T> elementStream();

	/**
	 * Initialise the contents of all cells using an initialiser function.
	 * 
	 * The function will be called with the (x,y) position of an element, and is
	 * expected to return the element to place at that position. For example:
	 * 
	 * <pre>
	 * // fill all cells with the position as a string (e.g., "(2,2)")
	 * grid.setAll((x, y) -> String.format("(%d,%d)", x, y));
	 * </pre>
	 * 
	 * @param initialiser
	 *            The initialiser function
	 */
	void fill(Function<ILocation, T> initialiser);

	/**
	 * Set the contents of all cells to <code>element</code>
	 * 
	 * For example:
	 * 
	 * <pre>
	 * // clear the grid
	 * grid.setAll(null);
	 * </pre>
	 * 
	 * @param initialiser
	 */
	void fill(T element);

	/**
	 * Get the contents of the cell in the given x,y location.
	 *
	 * y must be greater than or equal to 0 and less than getHeight(). x must be
	 * greater than or equal to 0 and less than getWidth().
	 *
	 * @param pos
	 *            The (x,y) position of the grid cell to get the contents of.
	 * @throws IndexOutOfBoundsException
	 *             if !isValid(pos)
	 */
	T get(ILocation pos);

	/**
	 * Get the contents of the cell in the given x,y location.
	 *
	 * y must be greater than or equal to 0 and less than getHeight(). x must be
	 * greater than or equal to 0 and less than getWidth().
	 *
	 * @param x
	 *            The column of the cell to get the contents of.
	 * @param y
	 *            The row of the cell to get contents of.
	 * @throws IndexOutOfBoundsException
	 *             if !isValid(x,y)
	 */
	T get(int x, int y);

	IArea getArea();

	/** @return The height of the grid. */
	int getHeight();

	/**
	 * Get the contents of the cell in the given x,y location.
	 *
	 * y must be greater than or equal to 0 and less than getHeight(). x must be
	 * greater than or equal to 0 and less than getWidth().
	 *
	 * @param pos
	 *            The (x,y) position of the grid cell to get the contents of.
	 * @param defaultResult
	 *            A default value to be substituted if the (x,y) is out of bounds or
	 *            contents == null.
	 */
	T getOrDefault(ILocation pos, T defaultResult);

	/**
	 * Get the contents of the cell in the given x,y location.
	 *
	 * y must be greater than or equal to 0 and less than getHeight(). x must be
	 * greater than or equal to 0 and less than getWidth().
	 *
	 * @param x
	 *            The column of the cell to get the contents of.
	 * @param y
	 *            The row of the cell to get contents of.
	 * @param defaultResult
	 *            A default value to be substituted if the (x,y) is out of bounds or
	 *            contents == null.
	 */
	T getOrDefault(int x, int y, T defaultResult);

	/** @return The width of the grid. */
	int getWidth();

	/**
	 * Check if coordinates are valid.
	 * 
	 * Valid coordinates are 0 <= pos.getX() < getWidth(), 0 <= pos.getY() <
	 * getHeight().
	 * 
	 * @param pos
	 *            A position
	 * @return true if the position is within the grid
	 */
	boolean isValid(ILocation pos);

	/**
	 * Check if coordinates are valid.
	 * 
	 * Valid coordinates are 0 <= x < getWidth(), 0 <= y < getHeight().
	 * 
	 * @param x
	 *            an x coordinate
	 * @param y
	 *            an y coordinate
	 * @return true if the (x,y) position is within the grid
	 */
	boolean isValid(int x, int y);

	/**
	 * Create a parallel {@link Stream} with all the locations in this grid.
	 * <p>
	 * All locations obtained through the stream are guaranteed to be valid
	 * according to {@link #isValid(ILocation)}.
	 * 
	 * @return A stream
	 * @see {@link java.util.Collection#parallelStream()}
	 */
	Stream<ILocation> locationParallelStream();

	/**
	 * Iterate over all grid locations
	 * <p>
	 * See also {@link #iterator()} – using the grid directly in a for-loop will
	 * iterate over the elements.
	 * <p>
	 * All locations obtained through the iterator are guaranteed to be valid
	 * according to {@link #isValid(ILocation)}.
	 * 
	 * @return An iterable for iterating over all the locations in the grid
	 */
	Iterable<ILocation> locations();

	/**
	 * Create a {@link Stream} with all the locations in this grid.
	 * <p>
	 * All locations obtained through the stream are guaranteed to be valid
	 * according to {@link #isValid(ILocation)}.
	 * 
	 * @return A stream
	 */
	Stream<ILocation> locationStream();

	/**
	 * Set the contents of the cell in the given x,y location.
	 *
	 * y must be greater than or equal to 0 and less than getHeight(). x must be
	 * greater than or equal to 0 and less than getWidth().
	 *
	 * @param pos
	 *            The (x,y) position of the grid cell to get the contents of.
	 * @param element
	 *            The contents the cell is to have.
	 * @throws IndexOutOfBoundsException
	 *             if !isValid(pos)
	 */
	void set(ILocation pos, T element);

	/**
	 * Set the contents of the cell in the given x,y location.
	 *
	 * y must be greater than or equal to 0 and less than getHeight(). x must be
	 * greater than or equal to 0 and less than getWidth().
	 *
	 * @param pos
	 *            The (x,y) position of the grid cell to get the contents of.
	 * @param element
	 *            The contents the cell is to have.
	 * @throws IndexOutOfBoundsException
	 *             if !isValid(x,y)
	 */
	void set(int x, int y, T element);

}