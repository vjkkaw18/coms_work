package hw2;

import hw2.CricketGame;

public class SimpleGameTest
{

  public static void main(String[] args)
  {
    // try out the createString method
    CricketGame g = new CricketGame(2, 3, 4, 6);
    System.out.println(createString(g));
  }

  /**
   * Creates a string summarizing the current game state.
   * @param g
   * @return
   */
  public static String createString(CricketGame g)
  {
    int side0Score = g.getScore(g.whichSideIsBatting() == 0);
    int side1Score = g.getScore(g.whichSideIsBatting() == 1);

    StringBuilder sb = new StringBuilder();
    sb.append("Innings: ");
    sb.append(g.getCompletedInnings());
    sb.append(" Overs: ");
    sb.append(g.getOverCount());
    sb.append(" Bowls: ");
    sb.append(g.getBowlCount());
    sb.append(" Outs: ");
    sb.append(g.getOuts());
    sb.append(" Side0: ");
    sb.append(side0Score);
    sb.append(" Side1: ");
    sb.append(side1Score);
    if (g.isInPlay())
    {
      sb.append(" (in play)");
    }
    if (g.isRunning())
    {
      sb.append(" (running)");
    }
    if (g.isGameEnded())
    {
      sb.append(" (ended)");
    }   
    return sb.toString();
  }
  
}