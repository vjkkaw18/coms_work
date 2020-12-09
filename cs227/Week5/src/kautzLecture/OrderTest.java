package kautzLecture;

public class OrderTest
{
  public static void main(String[] args)
  {
    Order order = new Order();
    
    order.addShirts(15);
    System.out.println(order.getNumShirts());
    System.out.println("Expected 15");

    System.out.println(order.isMNResident());
    System.out.println("Expected false");
    
    order.setResidentStatus(true);
    System.out.println(order.isMNResident());
    System.out.println("Expected true");
    
    System.out.println(order.getTotal());
    System.out.println("Expected 189");
  
//    // try nonresident, no shipping
//    order = new Order();
//    order.addShirts(30);
//    System.out.println(order.getTotal());
//    System.out.println("Expected 300");

  }
}