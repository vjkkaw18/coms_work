package kautzLecture;

public class GasTankTest {

	public static void main(String[] args) {
		GasTank g = new GasTank(10);
		System.out.println(g.getCapacity());
		System.out.println("Expected 10" );
		
		System.out.println(g.getContents());
		System.out.println("Expected 0");
		
		g.fill();
		System.out.println(g.getContents());
		System.out.println("Expected: 10");
		
		
		
		

	}

}
