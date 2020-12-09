package hw4;

import java.util.ArrayList;
import java.util.List;

import api.AbstractGame;
import api.Game;
import api.Generator;
import api.Position;

/**
 * A subclass of AbstractGame that implements the game as described. 
 * This class finds a pattern or a shape that it can collapse or determine the 
 * positions to collapse. 
 * @author vancekaw
 *
 */
public class BlockAddiction extends AbstractGame{

	/**
	 * Constructs a BlockAddiction constuctor that implements the game. 
	 * @param height
	 * given height of the grid of the game
	 * @param width
	 * given width of the grid of the game
	 * @param gen
	 * given a genrator that randomizes icons. 
	 */
	
	
	public BlockAddiction(int height, int width, Generator gen)
	{
		super(height, width, gen);
	}
	
	/**
	 * Constructs a BlockAddiction constuctor that implements the game. 
	 * @param height
	 * given height of the grid of the game
	 * @param width
	 * given width of the grid of the game
	 * @param gen
	 * given a genrator that randomizes icons. 
	 * @param preFillRows
	 * pre fill rows in a checkboard pattern using random icons obtained from the generator. 
	 * Placing an icon if both row and col are both even or odd. 
	 */
	public BlockAddiction(int height, int width, Generator gen, int preFillRows)
	{
		super(height, width, gen);
		
		if (preFillRows > 0)
		{
			for (int row = height - preFillRows; row < height; row++)
			{
				for (int col = 0; col < width; col++)
				{
					if ((row % 2 == 0 && col % 2 == 0) || row % 2 != 0 && col % 2 != 0)
					{
						setBlock(row, col, gen.randomIcon());
					}
				}
			}
		}
	}
		
		
	

	/**
	 * A collapsible set is defined to be any set of three or more adjacent icons 
	 * with the same color. A collapsible set is when a cell has two or more 
	 * neighbors that match its color. 
	 * If the element is non-null and has two or more neighbors that match, 
	 * then it is added to the list and in addition to this, we also add
	 * all its matching neighbors to the list. 
	 * A new array is created to remove the duplicates. 
	 */
	public List<Position> determinePositionsToCollapse()
	{
		List<Position> positions = new ArrayList<>();
		List<Position> newPositions = new ArrayList<>();
		
		
		for (int row = 1; row < getHeight()-1; ++row)
		{
			for (int col = 1; col < getWidth()-1; ++col)
			{
				if(getIcon(row, col) != null && getIcon(row, col).matches(getIcon(row, col+1)) && getIcon(row, col).matches(getIcon(row+1, col)))
				{
					positions.add(new Position(row, col+1));
					positions.add(new Position(row, col));
					positions.add(new Position(row+1, col));
				}
				
				else if(getIcon(row, col) != null  && getIcon(row,col).matches(getIcon(row, col+1)) && getIcon(row, col).matches(getIcon(row+1, col+1)))
				{
					positions.add(new Position(row, col));
					positions.add(new Position(row, col+1));
					positions.add(new Position(row+1, col+1));
				}
				
				else if(getIcon(row, col) != null && getIcon(row,col).matches(getIcon(row+1, col)) && getIcon(row, col).matches(getIcon(row+1, col+1)))
				{
					positions.add(new Position(row, col));
					positions.add(new Position(row+1, col));
					positions.add(new Position(row+1, col+1));
				}
				
				else if(getIcon(row, col) != null && getIcon(row, col).matches(getIcon(row-1, col)) && getIcon(row, col).matches(getIcon(row, col-1)))
				{
					positions.add(new Position(row-1, col));
					positions.add(new Position(row, col));
					positions.add(new Position(row, col-1));
				}
				
				else if(getIcon(row, col) != null && getIcon(row,col).matches(getIcon(row, col+1)) && getIcon(row, col).matches(getIcon(row, col-1)))
				{
					positions.add(new Position(row, col));
					positions.add(new Position(row, col+1));
					positions.add(new Position(row, col-1));
				}
				
				else if(getIcon(row, col) != null && getIcon(row,col).matches(getIcon(row+1, col)) && getIcon(row, col).matches(getIcon(row-1, col)))
				{
					positions.add(new Position(row, col));
					positions.add(new Position(row+1, col));
					positions.add(new Position(row-1, col));
				}
			}
			
			
			for (int i = 0; i < positions.size(); i++)
			{
				for(int j = 1; j < positions.size(); j++)
				{
					if (positions.get(i) != positions.get(j))
					{
						newPositions.add(positions.get(i));
					}
				}
			}
		}
		return newPositions; 
	}

}
