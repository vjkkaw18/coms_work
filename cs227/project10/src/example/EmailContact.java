package example;

public class EmailContact extends Contact 
{
   private String emailAddress;

   public EmailContact(String givenFirstName,
                       String givenLastName,
                       String givenEmailAddress) 
   {
      // first, we call the superclass constructor to initialize the
      // "inherited" instance variables
      super(givenFirstName, givenLastName);
	 
      // then, initialize everything that is special for EmailContact
      emailAddress = givenEmailAddress;
   }

   // override the notify() method 
   @Override
   public void notify(String alertMessage) 
   {
      // simulate sending an email to the address
      System.out.println("Esteemed " + getName() + ",");
      System.out.println(alertMessage);
   }
}