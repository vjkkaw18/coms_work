package lab2;

/**
 * Model of an atom for use in quality control simulation
 * @author vaka99
 * The code below calculates several stuff. 
 */

public class Atom 
{
	/**
	 * number of protons in the element 
	 */
	private int protons; 
	
	/**
	 * number of neutrons in the element
	 */
	private int neutrons;
	
	/**
	 * number of electrons in the element 
	 */
	private int electrons;
	
	/**
	 * Constructs an Atom with the given protons, neutrons, and electrons
	 * @param givenProtons
	 * the number of protons in the element 
	 * @param givenNeutrons
	 * the number of neutrons in the element 
	 * @param givenElectrons
	 * the number of eleectons in the element 
	 */
	public Atom(int givenProtons, int givenNeutrons, int givenElectrons) 
	{
		protons = givenProtons; 
		neutrons = givenNeutrons;
		electrons = givenElectrons;	
	}
	
	/**
	 * Returns the calculated Atomic Mass of the element 
	 * @return
	 * atomic mass of the element 
	 */
	 public int getAtomicMass() 
	 {
		 int mass = protons + neutrons;
		 return mass;
	 }
	
	 /**
	  * Returns the calculated Atomic Charge of the element
	  * @return
	  * atomic charge of the element 
	  */
	 public int getAtomicCharge() 
	 {
		 int charge = protons - electrons; 
		 return charge;
		 
	 }
	 
	 /**
	  * Subtracts the number of protons and number of electrons by 2
	  */
	 public void decay() 
	 {
		 protons = protons - 2;
		 neutrons = neutrons -2;
	 }
	 	
	
}
	

