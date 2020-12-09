package finalReview;

import java.awt.Shape;
import java.util.ArrayList;


public class picture extends Circle {
	
	private ArrayList<Shape> arrOfShape;
	
	public picture()
	{
		arrOfShape = new ArrayList<>();
	}
	
	public void add(Shape s)
	{
		this.arrOfShape.add(s);
	}
	
	public double findTotalArea()
	{
		if (arrOfShape.size() == 0)
		{
			return 0;
		}
		
		
		double total = 0;
		
//		for (Shape s : arrOfShape)
//		{
//			total += s.getArea();
//		}
		
		for (int i = 0; i < arrOfShape.size(); i++)
		{
			total += arrOfShape.get(i).getArea();
		}
		
		return total;
	}
}
