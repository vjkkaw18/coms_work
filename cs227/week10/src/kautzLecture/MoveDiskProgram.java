package kautzLecture;

public class MoveDiskProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void move(int n, String src, String dist, String extra)
	{
		if (n == 1)
		{
			System.out.println("move disk from" + src + "to" + dist);
		}
		
		else 
		{
			move(n - 1, src, extra, dist);
			move(1, src, dist, extra);
			move(n - 1, extra, dist, src);	
		}
	}
}
