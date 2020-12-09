package GuangSongLecture;

public class CalculatorTest {

	public static void main(String[] args) 
	{
		Calculator calculate = new Calculator(5, 5);
		
		System.out.println(calculate.add());
		System.out.println(calculate.subtract());
		System.out.println(calculate.multiply());
		System.out.println(calculate.divide());
		
		

	}

}
