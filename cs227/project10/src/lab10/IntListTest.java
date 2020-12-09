package lab10;

public class IntListTest {

	   public static void main(String[] args) {
	      
//	      IntList list = new IntList();
	      IntListSorted list = new IntListSorted();
	      
//	      
	      list.add(5);
	      list.add(4);
	      list.add(3);
//	      
//	      list.add(0);
//	      list.add(1);
//	      list.add(3);
//	      list.add(10);
	      
	      System.out.println(list);
	      System.out.println("Size: " + list.size());
	      System.out.println("Min: " + list.getMinimum());
	      System.out.println("Max: " + list.getMaximum());
	      
	      System.out.println("Median is: " + list.getMedian());
	   }
	}
