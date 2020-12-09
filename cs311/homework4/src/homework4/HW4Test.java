package homework4;

public class HW4Test {
	public static void main(String[] args) throws Exception {
		
		RobotPath rp = new RobotPath();
//		rPath.readInput("Grid.txt");
//		System.out.println("\n planShortest:\n");
//		rPath.planShortest();
//		rPath.output();
//		System.out.println("\n quickPlan:\n");
//		rPath.quickPlan();
//		rPath.output();
		
		rp.readInput("Grid.txt");
		rp.planShortest();
		rp.output();
		System.out.println();
		rp.quickPlan();
		rp.output();
		System.out.println();
		
		rp.readInput("Grid2.txt");
		rp.planShortest();
		rp.output();
		System.out.println();
		
		rp.readInput("Grid3.txt");
		rp.planShortest();
		rp.output();
		System.out.println();
		
		rp.readInput("Grid_NoPath.txt");
		rp.planShortest();
		rp.output();
		System.out.println();
		
		rp.readInput("Grid.txt");
		rp.planShortest();
		rp.quickPlan();
		rp.output();
		System.out.println();
		
		rp.readInput("Grid2.txt");
		rp.planShortest();
		rp.quickPlan();
		rp.output();
		System.out.println();
		
		rp.readInput("Grid3.txt");
		rp.planShortest();
		rp.quickPlan();
		rp.output();
		System.out.println();
		
		rp.readInput("Grid_NoPath.txt");
		rp.planShortest();
		rp.quickPlan();
		rp.output();
		System.out.println();
	}
}
		
		// EXPECTED OUTPUT 
		/*
		planShortest

	    0    0    0    *    0    0    0    0    0    0
	    s    w    S    *    0    0    0    0    0    0
	    s    *    *    0    0    0    0    0    0    0
	   se   se   se   se   se   se    e    s    0    0
	   se   se   se   se   se    s    *    s    0    0
	   se   se   se   se   se    s    *    s    0    0
	   se   se   se   se   se    s    *    s    0    0
	   se   se   se   se   se    s    *    s    0    0
	    e    e    e    e    e    e    e    D    0    0
	    0    0    0    0    0    0    0    0    0    0

	 quickPlan

	    0    0    0    *    0    0    0    0    0    0
	    s    w    S    *    0    0    0    0    0    0
	    s    *    *    0    0    0    0    0    0    0
	    e    e    e    s    0    0    0    0    0    0
	    0    0    0    e    s    0    *    0    0    0
	    0    0    0    0    e    s    *    0    0    0
	    0    0    0    0    0    s    *    0    0    0
	    0    0    0    0    0    s    *    0    0    0
	    0    0    0    0    0    e    e    D    0    0
	    0    0    0    0    0    0    0    0    0    0
	    
	    */
