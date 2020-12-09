package hw4;

import java.util.Random;

import api.Generator;
import api.Icon;
import api.Piece;
import api.Position;

/**
 * Generator for Piece objects in BlockAddiction. Icons are 
 * always selected uniformly at random, and the Piece types
 * are generated with the following probabilities:
 * <ul>
 * <li>LPiece - 10%
 * <li>DiagonalPiece - 25%
 * <li>CornerPiece - 15%
 * <li>SnakePiece - 10%
 * <li>IPiece - 40%
 * </ul>
 * The initial position of each piece is based on its
 * vertical size as well as the width of the grid (given
 * as an argument to getNext).  The initial column is always
 * width/2 - 1.  The initial row is:
 *  * <ul>
 * <li>LPiece - row = -2
 * <li>DiagonalPiece - row = -1
 * <li>CornerPiece - row = -1
 * <li>SnakePiece - row = -1
 * <li>IPiece - row = -2
 * </ul>
 * 
 */

/**
 * Generator for Piece objects.
 * Every shape has its own probability to be generated. 
 * @author vaka99
 *
 */
public class BasicGenerator implements Generator 
{
  private Random rand;

  /**
   * Constructs a BasicGenerator that will use the given
   * Random object as its source of randomness.
   * @param givenRandom
   *   instance of Random to use
   */
  public BasicGenerator(Random givenRandom)
  {
    rand = givenRandom;
  }

  /**
   * Generates a random number and within the given probablilty/range, determines
   * the type of piece to use/supply. 
   * Returns the randomized icon for each corresponding piece. 
   */
  @Override
  public Piece getNext(int width)
  {
    int col = width / 2 - 1;
    
    int randomNum = rand.nextInt(100) + 1;
    
    if (randomNum <= 10)
    {
    	Icon [] icon = {randomIcon(),randomIcon(),randomIcon(),randomIcon()};
    	 return new LPiece(new Position(-2, col), icon);
    }
    
    else if (randomNum > 10 && randomNum <= 20)
    {
    	Icon [] icon = {randomIcon(),randomIcon(),randomIcon(),randomIcon()};
    	return new SnakePiece(new Position(-1, col), icon);
    }
    
    else if (randomNum > 20 && randomNum <= 35)
    {
    	Icon [] icon = {randomIcon(),randomIcon(),randomIcon()};
    	return new CornerPiece(new Position(-1, col), icon);
    }
    
    else if (randomNum > 35 && randomNum <= 60)
    {
    	Icon [] icon = {randomIcon(),randomIcon()};
    	return new DiagonalPiece(new Position(-1, col), icon);
    }
    
    else
    {
    	Icon [] icon = {randomIcon(),randomIcon(),randomIcon()};
    	return new IPiece(new Position(-2, col), icon);
    }
  }

  /**
   * Generates a  color for every icon by randomizing the colors.
   */
  @Override
  public Icon randomIcon()
  {
    return new Icon(Icon.COLORS[rand.nextInt(Icon.COLORS.length)]);
  }

}
