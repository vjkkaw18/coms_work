package lab3;

public class TestModel2
{
  public static void main(String[] args)
  {
    RabbitModel2 model = new RabbitModel2();
    
    // Check that the initial population is 0
    System.out.println(model.getPopulation());
    System.out.println("Expected 0");
    
    // A year goes by...
    model.simulateYear();
    model.simulateYear();
    model.simulateYear();
    model.simulateYear();
    model.simulateYear();
    
    System.out.println(model.getPopulation());
    System.out.println("Expected 0");
    
    // Start over
    model.reset();
    System.out.println(model.getPopulation());
    System.out.println("Expected 0");
  }
  
}
