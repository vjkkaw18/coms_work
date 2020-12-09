package kautzLecture;

public class GroupQuiz2 {
	public static void main(String[] args)
	{
		int currentYear = 0;
		double currentValue = 100;

		while (currentValue >= 100 * 0.5)
		{
			currentYear++;
			currentValue = currentValue * 0.8;

			System.out.println(currentValue);
		}
	}

}
