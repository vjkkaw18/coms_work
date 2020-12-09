package example;

public class EmergencyTester {
	   public static void main(String[] args) {
	      EmergencyDatabase db = new EmergencyDatabase();
	      db.addContact(new EmailContact("Bill", "Dollar", "xxx@iastate.edu"));
	      db.addContact(new PhoneContact("Don", "Kees", "(515) 555-5555"));
	      db.alertEverybody("A giraffe is loose near the campanile!");
	   }
	}
