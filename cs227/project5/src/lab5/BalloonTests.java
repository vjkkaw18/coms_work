package lab5;

import org.junit.Test;
import static org.junit.Assert.*;

import balloon4.Balloon;

public class BalloonTests {
	@Test 
	public void testInital()
	{
		Balloon balloon = new Balloon(0);
		assertEquals(0, balloon.getRadius());
	}
	
	@Test 
	public void testIsPopped()
	{
		Balloon balloon = new Balloon(0);
		assertEquals(false, balloon.isPopped());
	}
	
	@Test
	public void blowMulitple()
	{
		Balloon balloon = new Balloon(9);
		balloon.blow(5);
		balloon.blow(1);
		balloon.blow(1);
		balloon.blow(1);
		assertEquals(8, balloon.getRadius());
	}
	
	@Test 
	public void deflateAndPopped()
	{
		Balloon balloon = new Balloon(8);
		balloon.deflate();
		balloon.blow(5);
		assertEquals(false, balloon.isPopped());
	}
	
	@Test
	public void testAfterBlow1()
	{
		Balloon balloon = new Balloon(3);
		balloon.blow(5);
		assertEquals(0, balloon.getRadius()); 
	}
	
	@Test
	public void testBlowingPopped()
	{
		Balloon balloon = new Balloon(10);
		balloon.pop();
		balloon.blow(1);
		assertEquals(0, balloon.getRadius()); // b1: something wrong with pop 
	}
	
	@Test
	public void doubleBlow()
	{
		Balloon balloon = new Balloon(0);
		balloon.blow(5);
		balloon.pop();
		assertEquals(0, balloon.getRadius());
	}
	
	@Test 
	public void deflatePopped()
	{
		Balloon balloon = new Balloon(5);
		balloon.deflate();
		assertEquals(false, balloon.isPopped());
		
	}
	
}
