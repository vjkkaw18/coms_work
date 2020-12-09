package example;

public class PhoneContact extends Contact 
{
   private String phoneNumber;

   public PhoneContact(String givenFirstName,
                       String givenLastName,
                       String givenPhoneNumber) 
   {
      super(givenFirstName, givenLastName);
      phoneNumber = givenPhoneNumber;
   }

   public void notify(String alertMessage) 
   {
      // electronically dial phoneNumber ...
      System.out.println(alertMessage);
      System.out.println("To repeat this message, press 1.");
      System.out.println("To hear it in Spanish, press 1 also.");
   }
}
 

