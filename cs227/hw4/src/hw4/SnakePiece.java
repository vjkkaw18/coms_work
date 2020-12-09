package hw4;

import api.Cell;
import api.Icon;
import api.Position;

/**
 * Extends AbstractPiece for implementations Piece interface for an SnakePiece
 * @author vancekaw
 *
 */
public class SnakePiece extends AbstractPiece {

	/**
	 * An array of cells to keep track of the initial positions.
	 */
	private Cell[] cells;

	/**
	 * An array of list used to know the sequence of the direction of the cell. 
	 */
	private static final Position[] sequence = 
		{
				new Position(0,0),
				new Position(0,1),
				new Position(0,2),
				new Position(1,2),
				new Position(1,1),
				new Position(1,0),
				new Position(2,0),
				new Position(2,1),
				new Position(2,2),
				new Position(1,2),
				new Position(1,1),
				new Position(1,0),
		};

	/**
	 * An instance variable named count to keep track of the position of the first icon. 
	 */
	private int count = 0;

	
	/**
	 * Constructs an SnakePiece with the given position and an array of icons
	 * @param givenPosition
	 * the given position of the cell
	 * @param icons
	 * given array of icons for the cell
	 * @throws IllegalArgumentException
	 * throws an illegal argument exception if the given array is not the correct length
	 */
	public SnakePiece(Position givenPosition, Icon[] icons) throws IllegalArgumentException
	{
		super(givenPosition, icons);

		cells = new Cell[4];

		cells[0] = new Cell(icons[0], new Position(0,0));
		cells[1] = new Cell(icons[1], new Position(1,0));
		cells[2] = new Cell(icons[2], new Position(1,1));
		cells[3] = new Cell(icons[3], new Position(1,2));
	
		setCells(cells);
	}
	
	/**
	 * Overrides the AbstractPiece method and does its own transform method for the SnakePiece. 
	 * This method performs a kind of rotation through 12 different states. 
	 * After calling twelve times, the cells are back in the initial positions. 
	 */
	@Override
	public void transform()
	{
		setCells(cells);
		cells = getCells();
		count++;
		
		cells[3].setPosition(new Position(cells[2].getRow(), cells[2].getCol()));
		cells[2].setPosition(new Position(cells[1].getRow(), cells[1].getCol()));
		cells[1].setPosition(new Position(cells[0].getRow(), cells[0].getCol()));
		
		if (count >= 12)
		{
			count = 0;
			cells[0].setPosition(sequence[count]);
		}
		else
		{
			cells[0].setPosition(sequence[count]);
		}
	}
}