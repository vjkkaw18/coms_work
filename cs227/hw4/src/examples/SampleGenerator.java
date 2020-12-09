package examples;
import java.awt.Color;

import api.Generator;
import api.Icon;
import api.Piece;
import api.Position;
import hw4.IPiece;

/**
 * Very simple implementation of the Generator interface generates
 * only red icons and only instance of SamplePiece.
 */
public class SampleGenerator implements Generator
{
  @Override
  public Piece getNext(int width)
  {
    // start off in the middle of the grid, one row above the top
    return new SamplePiece(new Position(-1, width / 2));
  }

  @Override
  public Icon randomIcon()
  {
    return new Icon(Color.RED);
  }
  
}
