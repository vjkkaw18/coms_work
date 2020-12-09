package hw4;

import api.Cell;
import api.Icon;
import api.Piece;
import api.Position;

/**
 * A partial implementation of the Piece interface. A superclass called AbstractPiece
 * that implements most of the methods contained in the five concrete classes. 
 * @author vancekaw
 */
public abstract class AbstractPiece implements Piece {
	
	private Position position;
	private Cell[] cells;
	private Icon[] icon;
	
	/**
	 * Constructs a protected AbstractPiece with the initial positions and array 
	 * of icons. 
	 * @param givenPosition
	 * the initial position of the icon which includes the row and column
	 * @param icons
	 * The given array of icons 
	 */
	protected AbstractPiece(Position givenPosition, Icon[] icons)
	{
		position = givenPosition;
		icon = icons;
		
		cells = new Cell[icons.length];
	}

	public Position getPosition()
	{
		return position;
	}
	
	public void setCells(Cell[] givenCells)
	{
		cells = new Cell[givenCells.length];
		
		for (int i = 0; i < cells.length; i++)
		{
			cells[i] = new Cell(givenCells[i]);
		}
	}
	

	public Cell[] getCells()
	{
		Cell[] copy = new Cell[cells.length];
		for (int i = 0; i < cells.length; i++)
		{
			copy[i] = new Cell(cells[i]);
		}

		return copy;
	}
	

	public Cell[] getCellsAbsolute()
	{
		Cell[] ret = new Cell[cells.length];

		for (int i = 0; i < cells.length; i++)
		{
			int row = cells[i].getRow() + position.row();
			int col = cells[i].getCol() + position.col();
			Icon b = cells[i].getIcon();
			ret[i] = new Cell(b, new Position(row, col));
		}
		return ret;
	}
	

	public void shiftDown()
	{
		position = new Position(position.row() + 1, position.col());
	}
	

	public void shiftLeft()
	{
		position = new Position(position.row(), position.col() - 1);
	}
	

	public void shiftRight()
	{
		position = new Position(position.row(), position.col() + 1);
	}
	

	public void transform()
	{	
		if (cells[0].getCol() == 0)
		{
			cells[0].setCol(+2);
		}
		
		else 
		{
			cells[0].setCol(0);
		}
		setCells(cells);
	}
	
	public void cycle()
	{
		Icon[] tempIcon = new Icon[icon.length];
		tempIcon[0] = icon[icon.length - 1];

		for (int i = 1; i < tempIcon.length; i++)
		{
			tempIcon[i] = icon[i-1];
		}

		for (int j = 0; j < tempIcon.length; j++)
		{
			icon[j] = tempIcon[j];
			int row = cells[j].getRow(); 
			int col = cells[j].getCol();
			cells[j] = new Cell(icon[j], new Position(row,col));
		}
	}

	public Piece clone()
	{
		try 
		{
			AbstractPiece l = (AbstractPiece) super.clone();

			l.cells = new Cell[cells.length];

			for (int i = 0; i < cells.length; i++)
			{
				l.cells[i] = new Cell(cells[i]);
			}
			return l;
		}
		catch (CloneNotSupportedException e)
		{
			return null;
		}
	}
	
	
}