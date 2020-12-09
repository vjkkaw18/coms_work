//package myProject;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = App.class)
//public class LoginDBIntegrationTest {
//	
//	@Autowired 
//	private LoginDB loginDB;
//	
////	@Before
////	public void setUp()
////	{
////		Login login1 = new Login("Vance", "Kaw", "vaka99@iastate.edu", "hello.WORLD.99", "ADMIN");
////		Login login2 = new Login("Daniel", "King", "djking@iastate.edu", "hello.WORLD.98", "MANAGER");
//////		loginDB.save(Arrays.asList(login1, login2));
////		loginDB.save(login1);
////		loginDB.save(login2);
////	}
//	
//	@Test
//	public void testFindByUserType()
//	{
////		Login login = new Login("Vance", "Kaw", "vaka99@iastate.edu", "hello.WORLD.1", "ADMIN");
//		List<Login> results = loginDB.findByUserType("ADMIN");
//		assertEquals(1, results.size());
//		
//		assertEquals("Vance", results.get(0).firstName);
//		assertEquals("Kaw", results.get(0).lastName);
//		assertEquals("vaka99@iastate.edu", results.get(0).email);
//		assertEquals("hello.WORLD.1", results.get(0).password);
//		assertEquals("ADMIN", results.get(0).userType);
//		
//////		assertEquals("Daniel", results.get(1).firstName);
////		assertEquals("Jing", results.get(1).lastName);
////		assertEquals("djjing@iastate.edu", results.get(1).email);
////		assertEquals("hello.WORLD.5", results.get(1).password);
////		assertEquals("ADMIN", results.get(1).userType);
//	}
//	
//	@Test
//	public void testFindByFirstName()
//	{
//		List<Login> results = loginDB.findByFirstName("Daniel");
//		assertEquals(2, results.size());
//	}
//	
//	@Test
//	public void testFindByEmail()
//	{
//		List<Login> results = loginDB.findByEmail("vaka99@iastate.edu");
//		assertEquals("Vance", results.get(0).firstName);
//		assertEquals("Kaw", results.get(0).lastName);
//		assertEquals("vaka99@iastate.edu", results.get(0).email);
//		assertEquals("hello.WORLD.1", results.get(0).password);
//		assertEquals("ADMIN", results.get(0).userType);
//	}
//	
//	@Test
//	public void testFindByLastName()
//	{
//		List<Login> results = loginDB.findByLastName("Kaw");
//		assertEquals(1, results.size());
//		assertEquals("Vance", results.get(0).firstName);
//		assertEquals("Kaw", results.get(0).lastName);
//		assertEquals("vaka99@iastate.edu", results.get(0).email);
//		assertEquals("hello.WORLD.1", results.get(0).password);
//		assertEquals("ADMIN", results.get(0).userType);
//	}
//	
//	
//}
