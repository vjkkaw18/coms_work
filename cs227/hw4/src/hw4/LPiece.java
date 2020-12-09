package hw4;

import api.Cell;
import api.Icon;
import api.Position;


/**
 * Extends AbstractPiece for implementations of Piece interface for an LPiece
 * @author vancekaw
 */
public class LPiece extends AbstractPiece {

	/**
	 * An array of cells to keep track of the initial positions.
	 */
	private Cell[] cells;


	/**
	 * Constructs an LPiece with the given position and an array of icons
	 * @param givenPosition
	 * the given position of the cell
	 * @param icons
	 * given array of icons for the cell
	 * @throws IllegalArgumentException
	 * throws an illegal argument exception if the given array is not the correct length
	 */
	public LPiece(Position givenPosition, Icon[] icons) throws IllegalArgumentException
	{
		super(givenPosition, icons);
		
		cells = new Cell[icons.length];
		
		cells[0] = new Cell(icons[0], new Position(0,0));
		cells[1] = new Cell(icons[1], new Position(0,1));
		cells[2] = new Cell(icons[2], new Position(1,1));
		cells[3] = new Cell(icons[3], new Position(2,1));
		
		setCells(cells);
	}
	
}