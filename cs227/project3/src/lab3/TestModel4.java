package lab3;

public class TestModel4
{
  public static void main(String[] args)
  {
    RabbitModel3 model = new RabbitModel3();
    
    // Check that the initial population is 0
    System.out.println(model.getPopulation());
    System.out.println("Expected 500");
    
    // A year goes by...
    model.simulateYear();
    
    System.out.println(model.getPopulation());
    System.out.println("Expected 250");
    
    // Start over
    model.reset();
    System.out.println(model.getPopulation());
    System.out.println("Expected 500");
  }
  
}
