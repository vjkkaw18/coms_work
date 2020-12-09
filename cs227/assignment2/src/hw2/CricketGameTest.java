package hw2;

import api.Outcome;

public class CricketGameTest {

	public static void main(String[] args) {
		
		CricketGame g = new CricketGame(2, 3, 4, 6);
		g.bowl(Outcome.WIDE);
		g.bowl(Outcome.WIDE);
		System.out.println(g.getScore(true)); // expected 2
		
		g = new CricketGame(2, 3, 4, 6);
		g.bowl(Outcome.BOUNDARY_SIX);
		System.out.println(g.getScore(true)); // expected 6
		System.out.println(g.getBowlCount()); // expected 1
		
		g = new CricketGame(2, 3, 4, 6);
		g.bowl(Outcome.BOUNDARY_SIX);
		g.bowl(Outcome.BOUNDARY_SIX);
		g.bowl(Outcome.BOUNDARY_SIX);
		g.bowl(Outcome.BOUNDARY_SIX);
		g.bowl(Outcome.BOUNDARY_SIX);
		
		System.out.println(g.getBowlCount()); // expected 1
		System.out.println(g.getOverCount()); // expected 2
		
		g = new CricketGame(2, 3, 4, 6);
		g.bowl(Outcome.WICKET);
		g.bowl(Outcome.WICKET);
		g.bowl(Outcome.WICKET);
		System.out.println(g.getScore(true)); // expected 0
		System.out.println(g.getOuts()); // expected 3
		
		g = new CricketGame(2, 3, 4, 6);
		g.bowl(Outcome.BOUNDARY_SIX);
		g.bowl(Outcome.BOUNDARY_SIX);
		g.bowl(Outcome.BOUNDARY_SIX);
		g.bowl(Outcome.BOUNDARY_SIX);
		g.bowl(Outcome.BOUNDARY_SIX);
		g.bowl(Outcome.BOUNDARY_SIX);
	
		System.out.println(g.getBowlCount()); // expected 0 
		System.out.println(g.getOverCount()); // expected 0
		System.out.println(g.getCompletedInnings()); // expected 1
		System.out.println(g.getScore(true)); // expected 0
		System.out.println(g.getScore(false)); // expected: 36
		
		g = new CricketGame(2, 3, 4, 6);
		g.bowl(Outcome.HIT);
		System.out.println(g.isInPlay()); // expected true
		g.safe();
		System.out.println(g.isInPlay()); // expected false 
		
		g = new CricketGame(2, 3, 4, 6);
		g.bowl(Outcome.WICKET);
		g.bowl(Outcome.WICKET);
		g.bowl(Outcome.WICKET);
		g.bowl(Outcome.WICKET);
		g.bowl(Outcome.WICKET);
		
		System.out.println(g.getCompletedInnings()); // expected 1
		
		
		g = new CricketGame(2, 3, 100, 4);
		g.bowl(Outcome.WICKET);
		g.bowl(Outcome.WICKET); 
		g.bowl(Outcome.WICKET);
		g.bowl(Outcome.WICKET); 
		g.bowl(Outcome.WICKET);
		
		g.bowl(Outcome.WICKET); 
		g.bowl(Outcome.WICKET);
		g.bowl(Outcome.WICKET);
		g.bowl(Outcome.WICKET);
		g.bowl(Outcome.WICKET); 
		
		g.bowl(Outcome.WICKET); 
		g.bowl(Outcome.WICKET); 
		g.bowl(Outcome.WICKET);
		g.bowl(Outcome.WICKET); 
		g.bowl(Outcome.WICKET);
		
		g.bowl(Outcome.WICKET); 
		g.bowl(Outcome.WICKET);
		g.bowl(Outcome.WICKET); 
		g.bowl(Outcome.WICKET);
		g.bowl(Outcome.WICKET); 
		
		g.bowl(Outcome.WICKET); 
		g.bowl(Outcome.WICKET); 
		g.bowl(Outcome.WICKET);
		

		System.out.println(g.getBowlCount()); // expected 0
		System.out.println(g.getOverCount()); // expected 1
		System.out.println(g.getCompletedInnings()); // expected 7
	
		
		g = new CricketGame(2, 3, 4, 6);
		g.bowl(Outcome.HIT);
		g.tryRun();
		g.safe();
		System.out.println(g.getScore(true)); // expected 1
		
		g = new CricketGame(2, 3, 4, 6);
		g.bowl(Outcome.HIT);
		g.tryRun();
		g.runOut();
		System.out.println(g.getScore(true)); // expected 0
		
		g = new CricketGame(2, 1, 4, 6);
		g.bowl(Outcome.BOUNDARY_SIX);
		g.bowl(Outcome.BOUNDARY_SIX);
		g.bowl(Outcome.BOUNDARY_SIX);
		g.bowl(Outcome.BOUNDARY_SIX);
		g.bowl(Outcome.BOUNDARY_SIX);
		g.bowl(Outcome.BOUNDARY_SIX);
		g.bowl(Outcome.BOUNDARY_SIX);
		g.bowl(Outcome.BOUNDARY_SIX);
		
		System.out.println(g.getScore(true)); // expected 24
		
		g = new CricketGame(2, 3, 4, 6);
		g.bowl(Outcome.WICKET);
		g.bowl(Outcome.WICKET);
		g.bowl(Outcome.WICKET);
		g.bowl(Outcome.WICKET);
		g.bowl(Outcome.WICKET);
		
		g.bowl(Outcome.WICKET);
		g.bowl(Outcome.WICKET);
		g.bowl(Outcome.WICKET);
		g.bowl(Outcome.WICKET);
		

		System.out.println(g.getCompletedInnings()); // expected 1
		
		
		g = new CricketGame(2, 3, 4, 6);
		g.bowl(Outcome.HIT);
		g.tryRun();
		g.runOut();
		System.out.println(g.getScore(true)); // expected 0
		
		
		g = new CricketGame(2, 3, 4, 6);
		g.bowl(Outcome.HIT);
		g.tryRun();
		g.tryRun();
		g.runOut();
		System.out.println(g.getScore(true)); // expected 1
		
		g = new CricketGame(2, 3, 4, 6);
		g.bowl(Outcome.WIDE);
		g.bowl(Outcome.BOUNDARY_FOUR);
		g.bowl(Outcome.HIT);
		g.tryRun();
		g.tryRun();
		g.runOut();
		g.bowl(Outcome.CAUGHT_FLY);
		g.bowl(Outcome.HIT);
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.safe();
		g.bowl(Outcome.LBW);
		g.bowl(Outcome.WICKET);
		
		System.out.println(g.getScore(false)); // expected 10
		
		
		g = new CricketGame(2, 3, 4, 6);
		g.bowl(Outcome.HIT); // 1 bowl
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.safe();
		
		g.bowl(Outcome.HIT); // 1 bowl
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.tryRun();
		
		g.runOut(); // 1 playerOut
		
		g.bowl(Outcome.HIT); // 1 bowl
		g.runOut(); // 1 player Out
		g.bowl(Outcome.BOUNDARY_FOUR); //1 bowl
		g.bowl(Outcome.WICKET); // 1 bowl
		g.bowl(Outcome.HIT); //1 bowl
		g.tryRun();
		g.tryRun();
		g.safe();
		
		System.out.println(g.getCompletedInnings()); // expected 3
		
		////////////////////////////////////////////////////////////
		
		g = new CricketGame(2, 3, 4, 6);
		g.bowl(Outcome.WIDE);
		g.bowl(Outcome.BOUNDARY_FOUR);
		g.bowl(Outcome.HIT);
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.runOut();
		g.bowl(Outcome.CAUGHT_FLY);
		g.bowl(Outcome.HIT);
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.safe();
		g.bowl(Outcome.LBW);
		g.bowl(Outcome.WICKET);
		System.out.println("expected 1: " + g.getCompletedInnings()); // expected 1
		System.out.println("expected 0: " + g.getOverCount()); // expected 0
		System.out.println("expected 0: " + g.getBowlCount()); // expected 0
		System.out.println("expected 0: " + g.getOuts()); // expected 0
		System.out.println(" ");

		g.bowl(Outcome.BOUNDARY_FOUR);
		g.bowl(Outcome.BOUNDARY_SIX);
		g.bowl(Outcome.NO_BALL);
		g.bowl(Outcome.NO_BALL);
		g.bowl(Outcome.NO_BALL);
		g.bowl(Outcome.NO_BALL);
		g.bowl(Outcome.NO_BALL);
		g.bowl(Outcome.NO_BALL);
		g.bowl(Outcome.HIT);
		g.tryRun();
		g.runOut();
		g.bowl(Outcome.CAUGHT_FLY);
		g.bowl(Outcome.CAUGHT_FLY);
		g.bowl(Outcome.LBW);
		System.out.println("expected 2: " + g.getCompletedInnings()); // expected 2
		System.out.println("expected 0: " + g.getOverCount()); // expected 0
		System.out.println("expected 0: " + g.getBowlCount()); // expected 0
		System.out.println("expected 0: " + g.getOuts()); // expected 0
		
		System.out.println("expected 10: " + g.getScore(true)); // expected 10
		System.out.println("expected 16: " + g.getScore(false)); // expected 16
		
		System.out.println(" ");
		

		g.bowl(Outcome.HIT); // 1 bowl
		g.tryRun();
		g.tryRun();
		g.safe();
		g.bowl(Outcome.HIT); // 1 bowl
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.tryRun();
		g.runOut();
		g.bowl(Outcome.HIT); // 1 bowl
		g.tryRun();
		g.runOut();
		g.bowl(Outcome.BOUNDARY_FOUR); // 1 bowl
		g.bowl(Outcome.WICKET); // 1 bowl
		g.bowl(Outcome.HIT); // 1 bowl
		g.tryRun();
		g.safe();
		System.out.println("expected 3: " + g.getCompletedInnings()); // expected 3
		System.out.println("expected 0: " + g.getOverCount()); // expected 0
		System.out.println("expected 0: " + g.getBowlCount()); // expected 0
		System.out.println("expected 0: " + g.getOuts()); // expected 0
		System.out.println("expected 36: " + g.getScore(false)); // expected 36
		System.out.println("expected 16: " + g.getScore(true)); // expected 16
		System.out.println(" ");

		g.bowl(Outcome.CAUGHT_FLY);
		g.bowl(Outcome.HIT);
		g.tryRun();
		g.tryRun(); // 17
		g.safe(); // 18
		g.bowl(Outcome.WIDE); // 19
		g.bowl(Outcome.HIT); 
		g.tryRun();
		g.tryRun(); // 20
		g.tryRun(); // 21
		g.runOut(); 
		g.bowl(Outcome.BOUNDARY_SIX); // 27
		g.bowl(Outcome.HIT);
		g.tryRun();
		g.tryRun();// 28
		g.tryRun(); // 29
		g.tryRun(); // 30
		g.tryRun(); //31
		g.tryRun();  // 32
		g.tryRun(); // 33
		g.tryRun(); // 34
		g.tryRun(); //35
		g.tryRun(); //36
		g.safe(); //38
		System.out.println("expected 3: " + g.getCompletedInnings()); // expected 3
		System.out.println("expected 2: " + g.getOverCount()); // expected 2
		System.out.println("expected 1: " + g.getBowlCount()); // expected 1
		System.out.println("expected 2: " + g.getOuts()); // expected 2
		System.out.println("expected 36: " + g.getScore(false)); // expected 36
		System.out.println("expected 38: " + g.getScore(true)); // output was 37
		System.out.println(" ");
		
		
	}

}
