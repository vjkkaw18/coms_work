
package hw2;

import api.Defaults;
import api.Outcome;

import static api.Outcome.*;

/**
 * Model of a simplified/modified Cricket game that simulates the sport Cricket.
 * @author vaka99
 */
public class CricketGame {

	/**
	 * the given bowls per over in a Cricket game
	 */
	private int bowlsPerOver;
	
	/**
	 * the given overs per innings in a Cricket game
	 */
	private int oversPerInnings;
	
	/**
	 * the given total Innings in a Cricket game to determine when to end the game
	 */
	private int totalInnings;
	
	/**
	 * the given total number of players to determine when to switch sides
	 */
	private int numPlayers;
	
	/**
	 * the current total score for side 0
	 */
	private int totalScore0 = 0; 
	
	/**
	 * the current total score for side 1
	 */
	private int totalScore1 = 0; 

	/**
	 * the current number of bowls
	 */
	private int numBowls = 0;
	
	/**
	 * the current number of overs 
	 */
	private int numOvers = 0;
	
	/** 
	 * the current number of innings 
	 */
	private int numInnings = 0;
	
	/**
	 * the current number of players out 
	 */
	private int numPlayersOut = 0;

	/**
	 * Indicates whether the game is in play or not.
	 * First sets the state of the game to not in play. 
	 */
	private boolean inPlay = false;
	
	/**
	 * Indicates whether the player/s is/are currently running. 
	 * First sets the state of the player to not running. 
	 */
	private boolean currentlyRunning = false; 


	/**
	 * Constructs a CricketGame using the given public default values 
	 */
	public CricketGame()
	{
		bowlsPerOver = Defaults.DEFAULT_BOWLS_PER_OVER;
		oversPerInnings = Defaults.DEFAULT_OVERS_PER_INNINGS;
		totalInnings = Defaults.DEFAULT_NUM_INNINGS;
		numPlayers = Defaults.DEFAULT_NUM_PLAYERS;
	}

	/**
	 * Constructs a CricketGame with the given configuration parameters
	 * @param givenBowlsPerOver
	 * the given bowls per over 
	 * @param givenOversPerInnings
	 * the given overs per innings 
	 * @param givenTotalInnings
	 * the given total number of innings 
	 * @param givenNumPlayers
	 * the given total number of players
	 */
	public CricketGame(int givenBowlsPerOver, int givenOversPerInnings, int givenTotalInnings, int givenNumPlayers) 
	{
		bowlsPerOver = givenBowlsPerOver;
		oversPerInnings = givenOversPerInnings;

		totalInnings = givenTotalInnings;
		if (totalInnings % 2 != 0)
		{
			totalInnings = totalInnings + 1;
		}
		numPlayers = givenNumPlayers;
	}

	/**
	 * Returns the score for one of the two sides. 
	 * @param battingSide
	 * If true, returns the score for the side currently at bat.
	 * Otherwise, returns the score for the other side
	 * @return
	 * the score for one of the two sides 
	 */
	public int getScore(boolean battingSide)
	{
		int teamScore = 0;
		if (battingSide == true)
		{
			if (whichSideIsBatting() == 0)
			{
				teamScore = totalScore0;
			}
			else 
			{
				teamScore = totalScore1;
			}
		}
		else if (battingSide == false)
		{
			if (whichSideIsBatting() == 0)
			{
				teamScore = totalScore1;
			}
			else 
			{
				teamScore = totalScore0;
			}
		}
		return teamScore;
	}

	/**
	 * Returns the number of times the bowler has bowled so far during the current over
	 * excluding wides and no-balls. 
	 * @return
	 * number of bowls so far in the current over 
	 */
	public int getBowlCount()
	{
		return numBowls;
	}

	/**
	 * Returns the number of completed overs for the current innings 
	 * @return
	 * number of overs for the current innings
	 */
	public int getOverCount()
	{
		return numOvers;
	}

	/**
	 * Returns the number of players out in the current innings.
	 * @return
	 * number of players currently out 
	 */
	public int getOuts()
	{
		return numPlayersOut;
	}
	
	/**
	 * Returns true if the game has ended (not running and game is not in play).
	 * Game ended determined by the number of innings and the totalScore for side 1 and side 0.
	 * false, otherwise
	 * @return
	 * true if the game has ended, false otherwise 
	 */
	public boolean isGameEnded()
	{
		boolean gameState = false;

		if (currentlyRunning == false) 
		{
			if (isInPlay() == false) {

				if (numInnings == totalInnings)
				{
					gameState = true;
				}
				if (totalInnings - numInnings == 0)
				{
					gameState = true;
				}
				else if (totalInnings - numInnings == 1)
				{
					if (totalScore1 > totalScore0)
					{
						gameState = true;
					}
				}
			}
		}
		return gameState;
	}

	/**
	 * Returns 0 if side 0 is batting or 1 if side is batting 
	 * @return
	 * 0 if side 0 is batting or 1 if side 1 is batting 
	 */
	public int whichSideIsBatting()
	{
		int currentSide = 0;

		if (numInnings == 0)
		{
			currentSide = 0;
		}
		else if (numInnings % 2 == 0)
		{
			currentSide = 0;
		}
		else if (numInnings % 2 != 0)
		{
			currentSide = 1;
		}
		return currentSide;
	}

	/**
	 * Returns the number of innings that have been completed 
	 * @return
	 * the number of completed innings 
	 */
	public int getCompletedInnings()
	{
		return numInnings;
	}

	/**
	 * Returns true if the ball is currently in play. 
	 * The ball is in play directly following a call to bowl(HIT).
	 * And is taken out of play by a subsequent call to safe or runOut 
	 * @return
	 * true if the ball is currently in play, false otherwise 
	 */
	public boolean isInPlay()
	{
		boolean currentState = true;
		if (inPlay == true)
		{
			currentState = true;
		}
		else 
		{
			currentState = false;
		}
		return currentState;		
	}

	/**
	 * Returns true if batsmen are currently running. 
	 * Batsmen are running directly following a call to tryRun 
	 * and will remain in a running state until a subsequent call to safe or runOut
	 * @return
	 * true if batsmen are running, false otherwise
	 */
	public boolean isRunning()
	{
		return currentlyRunning;
	}

	/**
	 * Bowls the ball and updates the game state depending on the given outcome. 
	 * After this method with Outcome.HIT is called, the ball will be in play 
	 * and thus isInPlay method returns true
	 * Calls method whichSideIsBatting to determine which side is currently batting.
	 * Then adds the corresponding score based on the current side batting.
	 * Also, increments the number of bowls, overs, innings, and number of players out.
	 * @param outcome
	 * outcome of this bowl
	 */
	public void bowl(Outcome outcome)
	{	
		int currentScore = 0;

		if (numInnings >= totalInnings)
		{
			totalScore0 = totalScore0 + 0;
			totalScore1 = totalScore1 + 0;
		}

		else if (outcome == Outcome.WIDE)
		{
			currentScore = currentScore + 1;
		}

		else if (outcome == Outcome.NO_BALL)
		{
			currentScore = currentScore + 1;
		}

		else if (outcome == Outcome.BOUNDARY_SIX)
		{
			if (inPlay == true)
			{
				currentScore = currentScore + 0;
				numBowls = numBowls + 1;
			}
			else 
			{
				currentScore = currentScore + 6;
				numBowls = numBowls + 1;
			}
			inPlay = false;
		}

		else if (outcome == Outcome.BOUNDARY_FOUR)
		{
			currentScore = currentScore + 4;
			numBowls = numBowls + 1;

			inPlay = false;
		}

		else if (outcome == Outcome.WICKET)
		{
			numBowls = numBowls + 1;
			if (inPlay == false)
			{
				numPlayersOut = numPlayersOut + 1;
			}
		}

		else if (outcome == Outcome.HIT)
		{
			numBowls = numBowls + 1;
			inPlay = true;

			if (numBowls == bowlsPerOver)
			{
				numOvers = numOvers + 1;
				numBowls = 0;
			}
		}

		else if (outcome == Outcome.LBW)
		{

			if (inPlay == false)
			{
				numPlayersOut = numPlayersOut + 1;
			}
			numBowls = numBowls + 1;


		}

		else if (outcome == Outcome.CAUGHT_FLY)
		{
			if (inPlay == false)
			{
				numPlayersOut = numPlayersOut + 1;
			}
			numBowls = numBowls + 1;
		}

		if (whichSideIsBatting() == 0)
		{
			totalScore0 = totalScore0 + currentScore;
		}

		else 
		{
			totalScore1 = totalScore1 + currentScore;
		}

		if (isInPlay() == false)
		{
			if (numBowls >= bowlsPerOver)
			{
				numOvers = numOvers + 1;
				numBowls = 0;
			}

			if (numOvers == oversPerInnings || numPlayersOut == numPlayers - 1)
			{
				numInnings = numInnings + 1;
				numPlayersOut = 0;
				numOvers = 0;
				numBowls = 0;
			}
		}
	}

	/**
	 * Starts the batsmen running from one end of the pitch to the other.
	 * After this method is called, isRunning method returns true 
	 * If batsmen are already running, then a run is added to the score for the batting side.
	 * Additionally, method does not do anything once game is over or ball is not in play.
	 */
	public void tryRun()
	{
		if (isGameEnded() == false)
		{
			if (isInPlay() == true)
			{
				if (isRunning() == true)
				{
					if (whichSideIsBatting() == 0)
					{
						totalScore0 = totalScore0 + 1;
					}
					else 
					{
						totalScore1 = totalScore1 + 1;
					}
				}
				currentlyRunning = true;
			}
		}
	}

	/**
	 * Transitions from ball in play to ball not in play, without an out.
	 * If batsmen were running, that run is successfully completed and a run is added to the score.
	 * After this method is called, isRunning() returns false and isInPlay() returns false too. 
	 * Method does nothing if game is already over or ball is not in play. 
	 * Also increments/adds the number of innings by one when one of the conditions are met.
	 * Sets the currentlyRunning and inPlay variables to false at the end of the method.
	 */
	public void safe()
	{
		if (isGameEnded() == false)
		{

			if (isRunning() == true && isInPlay() == true)
			{
				if (whichSideIsBatting() == 0)
				{
					totalScore0 = totalScore0 + 1;
				}
				else 
				{
					totalScore1 = totalScore1 + 1;
				}

				if (numOvers == oversPerInnings || numPlayersOut == numPlayers - 1)
				{
					numInnings = numInnings + 1;
					numOvers = 0;
					numPlayersOut = 0;
				}
			}
			inPlay = false;
			currentlyRunning = false;
		}
	}

	/**
	 * Runs the batsmen out
	 * Does not count as a run 
	 * After this method is called, isRunning() returns false and isInPlay() returns false too. 
	 * Does nothing if game is already over or if batsmen are not running.
	 * Also increments/adds the number of innings by one when one of the conditions are met.
	 * Sets the currentlyRunning and inPlay variables to false at the end of the method.
	 */
	public void runOut()
	{
		if (isGameEnded() == false)
		{
			if (isInPlay() == true && isRunning() == true)
			{
				numPlayersOut = numPlayersOut + 1;

				if (numOvers == oversPerInnings || numPlayersOut == numPlayers - 1)
				{
					numInnings = numInnings + 1;
					numOvers = 0;
					numPlayersOut = 0;
				}
				currentlyRunning = false;
				inPlay = false;
			}
		}
	}
}
