package cs228hw1.stats;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;


public class Tests {
    public static void main(String [] args) {
        ArrayList<Double> data = new ArrayList<Double>();
        
        data.add(15.0);
        data.add(8.5);
        data.add(1907.0);
        data.add(13.3);
        data.add(67954.1);
        data.add(9.63);
       
        System.out.println(new Minimum<Double>(data).GetResult()); // 2.0
        System.out.println(new Maximum<Double>(data).GetResult()); // 16.5
        System.out.println(new Median<Double>(data).GetResult()); // 14,9
        System.out.println(new Average<Double>(data).GetResult()); // 9.06666
        System.out.println(new StdDeviation<Double>(data).GetResult()); // 4.8167
        System.out.println(new Histogram<Double>(data).GetResult());
    	
    	
//    	ArrayList<Double> data = new ArrayList<>();
//    	data.add(3.0);
//    	data.add(3.0);
//    	data.add(2.99);
//    	data.add(4.0);
//    	data.add(8.0);
//    	data.add(9.0);
//    	data.add(15.0);
//		Histogram<Double> y = new Histogram<>(data);
//		
//		y.SetData(data);
//		y.SetNumberBins(3);
//		y.SetMaxRange(15.0);
//		y.SetMinRange(2.99);
//		System.out.println(y.GetResult()); // 4 2 0
    	
//    	ArrayList<Double> data = new ArrayList<>();
//    	data.add(6.0);
//    	data.add(33.0);
//    	data.add(26.0);
//    	data.add(18.0);
//    	data.add(8.0);
//    	data.add(37.0);
//    	data.add(23.0);
//    	data.add(16.0);
//		Histogram<Double> y = new Histogram<>(data);
//		
//		y.SetData(data);
//		y.SetNumberBins(7);
//		y.SetMaxRange(40.0);
//		y.SetMinRange(5.0);
//		System.out.println(y.GetResult()); // 2 0 2 1 1 1 1
		
//		assertEquals(1, y.GetResult().get(0).doubleValue(), EPSILON);
//		assertEquals(1, y.GetResult().get(1).doubleValue(), EPSILON);
    
//    	ArrayList<Double> data = new ArrayList<Double>();
//    	data.add(6.0);
//    	data.add(33.0);
//    	data.add(26.0);
//    	data.add(18.0);
//    	data.add(8.0);
//    	data.add(37.0);
//    	data.add(23.0);
//    	data.add(16.0);
//    	
//    	System.out.println(new Minimum<Double>(data).GetResult());
//    	System.out.println(new Maximum<Double>(data).GetResult());
//    	System.out.println(new Median<Double>(data).GetResult());
//    	System.out.println(new Average<Double>(data).GetResult());
//    	System.out.println(new StdDeviation<Double>(data).GetResult());
//    	System.out.println(new Histogram<Double>(data).GetResult());
    }
    //        
//    	ArrayList<Double> x = new ArrayList<>();
//		x.add(15.5);
//		x.add(19.7);
//		x.add(.01);
//		x.add(999.3);
//		x.add(39.8);
//		x.add(47.876);
//		Maximum<Double> y = new Maximum<Double>(x);
//		y.SetData(x);
//		ArrayList<Double> p = new ArrayList<>();
//		p.add(15.5); 
//		p.add(19.7); 
//		p.add(.01); 
//		p.add(999.3);
//		p.add(39.8); 
//		p.add(47.876);
//		System.out.println(new Maximum<Double>(p).GetResult()); // 999.3
    	
//    	ArrayList<Double> x = new ArrayList<>();
//		x.add(15.5);
//		x.add(19.7);
//		x.add(.01);
//		x.add(999.3);
//		x.add(39.8);
//		x.add(47.876);
//		Median<Double> y = new Median<Double>(x);
//		y.SetData(x);
//		System.out.println(new Median<Double>(x).GetResult()); // 29.75
////		assertEquals(29.75, y.GetResult().get(0).doubleValue(), EPSILON);
//		x.remove(2);
//		x.add(null);
//		y.SetData(x);
//		System.out.println(new Median<Double>(x).GetResult());
////		assertEquals(39.8, y.GetResult().get(0).doubleValue(), EPSILON);
    	
//    	ArrayList<Double> x = new ArrayList<>();
//		x.add(15.5);
//		x.add(19.7);
//		x.add(.01);
//		x.add(999.3);
//		x.add(39.8);
//		x.add(47.876);
//		StdDev<Double> y = new StdDev<Double>(x);
//		y.SetData(x);
//		
//		System.out.println(new StdDev<Double>(x).GetResult()); // 398.29
//		assertEquals(363.598, y.GetResult().get(0).doubleValue(), EPSILON);
    	
    	
//    	ArrayList<Double> x = new ArrayList<>();
//		x.add(3.0);
//		x.add(3.0);
//		x.add(2.99);
//		x.add(4.0);
//		x.add(8.0);
//		x.add(9.0);
//		x.add(15.0);
//		Histogram<Double> y = new Histogram<Double>(x);
//		y.SetData(x);
//		y.SetNumberBins(3);
//		y.SetMaxRange(15.0);
//		y.SetMinRange(2.99);
//		
//		System.out.println(y.GetResult().get(0).doubleValue()); // 4.0
//		System.out.println(y.GetResult().get(1).doubleValue()); // 2.0
//		System.out.println(y.GetResult().get(2).doubleValue()); // 0.0
		
//		assertEquals(4.0, y.GetResult().get(0).doubleValue(), EPSILON);
//		assertEquals(2.0, y.GetResult().get(1).doubleValue(), EPSILON);
//		assertEquals(0.0, y.GetResult().get(2).doubleValue(), EPSILON);
//		y.SetMaxRange(9.0);
//		y.SetMinRange(3);
//		System.out.println(y.GetResult().get(0).doubleValue()); // 3.0
//		System.out.println(y.GetResult().get(1).doubleValue()); // 0.0
//		System.out.println(y.GetResult().get(2).doubleValue()); // 1.0
		
//		assertEquals(3.0, y.GetResult().get(0).doubleValue(), EPSILON);
//		assertEquals(0.0, y.GetResult().get(1).doubleValue(), EPSILON);
//		assertEquals(2.0, y.GetResult().get(2).doubleValue(), EPSILON);
    	
//    	ArrayList<Double> x = new ArrayList<>();
//		x.add(null);
//		x.add(null);
//		x.add(null);
//		x.add(null);
//		Histogram<Double> y = new Histogram<Double>(x);
//		y.SetData(x);
//		y.SetNumberBins(5);
//		
//		System.out.println(y.GetResult().get(0).doubleValue()); // 0.0
//		System.out.println(y.GetResult().get(1).doubleValue()); // 0.0
//		System.out.println(y.GetResult().get(2).doubleValue()); // 0.0
		
//		assertEquals(0, y.GetResult().get(0).doubleValue(), EPSILON);
//		assertEquals(0, y.GetResult().get(1).doubleValue(), EPSILON);
//		assertEquals(0, y.GetResult().get(2).doubleValue(), EPSILON);
//		x.clear();
//		x.add(2.9);
//		x.add(2.8);
//		y.SetData(x);
//		y.SetNumberBins(2);
//		y.SetMaxRange(2.9);
//		y.SetMinRange(2.8);
//		System.out.println(y.GetResult().get(0).doubleValue()); // 1.0
//		System.out.println(y.GetResult().get(1).doubleValue()); // 0.0
		
//		assertEquals(1, y.GetResult().get(0).doubleValue(), EPSILON);
//		assertEquals(1, y.GetResult().get(1).doubleValue(), EPSILON);
	
    }


