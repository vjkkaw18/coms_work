package myProject;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest(LoginController.class)
public class ServiceUnitTesting {
	
	@TestConfiguration 
	static class LoginConfiguration
	{
		@Bean
		public LoginService lService()
		{
			return new LoginService();
		}
		
		@Bean
		LoginDB getRepo()
		{
			return mock(LoginDB.class);
		}
		
	}
	
	@Autowired
	private LoginService ls;
	
	@Autowired
	private LoginDB repo;
	
	@Test
	public void testLogin() throws Exception
	{
		//set up for MOCK methods for the REPO
		List<Login> l = new ArrayList<Login>();
		Login login = new Login("Hello", "World", "123@email.com", "helloWorld999", "PATIENT");
		
		// mock the findAll method
		when(repo.findAll()).thenReturn(l);
		
		// mock the save() method to save argument to the list
		when(repo.save((Login)any(Login.class)))
						.thenAnswer(x -> {
								Login r = (Login) x.getArguments()[0];
								l.add(r);
								return null;
		});
		
		repo.save(login);
//		when(repo.findAll()).thenReturn(l);

		assertEquals("Hello", l.get(0).firstName);
		assertEquals("World", l.get(0).lastName);
		assertEquals("123@email.com", l.get(0).email);
		assertEquals("helloWorld999", l.get(0).password);
		assertEquals("PATIENT", l.get(0).userType);
		assertEquals(1, l.size());

	}
	
	@Test
	public void testLoginByFirstName() throws Exception
	{
		//set up for MOCK methods for the REPO
		List<Login> l = new ArrayList<Login>();
		Login login = new Login("Hello", "World", "123@email.com", "helloWorld999", "PATIENT");
		Login login2 = new Login("Vance", "Kaw", "vaka99@iastate.edu", "wrong.SHOT.1", "ADMIN");
		
		// mock the findAll method
//		when(repo.findAll()).thenReturn(l);
		
		// mock the save() method to save argument to the list
		when(repo.save((Login)any(Login.class)))
						.thenAnswer(x -> {
								Login r = (Login) x.getArguments()[0];
								l.add(r);
								return null;
		});		

		repo.save(login);

		assertEquals("Hello", ls.getLoginByFirstName("Hello").get(0).firstName);
		assertEquals("World", ls.getLoginByFirstName("Hello").get(0).lastName);
		assertEquals("123@email.com", ls.getLoginByFirstName("Hello").get(0).email);
		assertEquals("helloWorld999", ls.getLoginByFirstName("Hello").get(0).password);
		assertEquals("PATIENT", ls.getLoginByFirstName("Hello").get(0).userType);
	}
	
	@Test
	public void testLoginByEmail() throws Exception
	{
		//set up for MOCK methods for the REPO
		List<Login> l = new ArrayList<Login>();
		Login login = new Login("Hello", "World", "123@email.com", "helloWorld999", "PATIENT");
		Login login2 = new Login("Vance", "Kaw", "vaka99@iastate.edu", "wrong.SHOT.1", "ADMIN");
		
		// mock the findAll method   
//		when(repo.findAll()).thenReturn(l);
		
		// mock the save() method to save argument to the list
		when(repo.save((Login)any(Login.class)))
						.thenAnswer(x -> {
								Login r = (Login) x.getArguments()[0];
								l.add(r);
								return null;
		});		

		repo.save(login);

		assertEquals("Hello", ls.getLoginByEmail("123@email.com").get(0).firstName);
		assertEquals("World", ls.getLoginByEmail("123@email.com").get(0).lastName);
		assertEquals("123@email.com", ls.getLoginByEmail("123@email.com").get(0).email);
		assertEquals("helloWorld999", ls.getLoginByEmail("123@email.com").get(0).password);
		assertEquals("PATIENT", ls.getLoginByEmail("123@email.com").get(0).userType);
	}
	
	@Test
	public void testLoginByLastName() throws Exception
	{
		//set up for MOCK methods for the REPO
		List<Login> l = new ArrayList<Login>();
		Login login = new Login("Hello", "World", "123@email.com", "helloWorld999", "PATIENT");
		Login login2 = new Login("Vance", "Kaw", "vaka99@iastate.edu", "wrong.SHOT.1", "ADMIN");
		
		// mock the findAll method   
		when(repo.findAll()).thenReturn(l);
		
		// mock the save() method to save argument to the list
		when(repo.save((Login)any(Login.class)))
						.thenAnswer(x -> {
								Login r = (Login) x.getArguments()[0];
								l.add(r);
								return null;
		});		

		repo.save(login);
		repo.save(login2);

		assertEquals("Hello", ls.getLoginByLastName("World").get(0).firstName);
		assertEquals("World", ls.getLoginByLastName("World").get(0).lastName);
		assertEquals("123@email.com", ls.getLoginByLastName("World").get(0).email);
		assertEquals("helloWorld999", ls.getLoginByLastName("World").get(0).password);
		assertEquals("PATIENT", ls.getLoginByLastName("World").get(0).userType);
		
		assertEquals("Vance", ls.getLoginByLastName("Kaw").get(1).firstName);
		assertEquals("Kaw", ls.getLoginByLastName("Kaw").get(1).lastName);
		assertEquals("vaka99@iastate.edu", ls.getLoginByLastName("Kaw").get(1).email);
		assertEquals("wrong.SHOT.1", ls.getLoginByLastName("Kaw").get(1).password);
		assertEquals("ADMIN", ls.getLoginByLastName("Kaw").get(1).userType);
	}
	
	@Test
	public void testLoginByPassword() throws Exception
	{
		//set up for MOCK methods for the REPO
		List<Login> l = new ArrayList<Login>();
		Login login = new Login("Hello", "World", "123@email.com", "helloWorld999", "PATIENT");
		Login login2 = new Login("Vance", "Kaw", "vaka99@iastate.edu", "wrong.SHOT.1", "ADMIN");
		
		// mock the findAll method   
		when(repo.findAll()).thenReturn(l);
		
		// mock the save() method to save argument to the list
		when(repo.save((Login)any(Login.class)))
						.thenAnswer(x -> {
								Login r = (Login) x.getArguments()[0];
								l.add(r);
								return null;
		});		

		repo.save(login);
		repo.save(login2);

		assertEquals("Hello", ls.getLoginByPassword("helloWorld999").get(0).firstName);
		assertEquals("World", ls.getLoginByPassword("helloWorld999").get(0).lastName);
		assertEquals("123@email.com", ls.getLoginByPassword("helloWorld999").get(0).email);
		assertEquals("helloWorld999", ls.getLoginByPassword("helloWorld999").get(0).password);
		assertEquals("PATIENT", ls.getLoginByPassword("helloWorld999").get(0).userType);
		
		assertEquals("Vance", ls.getLoginByPassword("wrong.SHOT.1").get(1).firstName);
		assertEquals("Kaw", ls.getLoginByPassword("wrong.SHOT.1").get(1).lastName);
		assertEquals("vaka99@iastate.edu", ls.getLoginByPassword("wrong.SHOT.1").get(1).email);
		assertEquals("wrong.SHOT.1", ls.getLoginByPassword("wrong.SHOT.1").get(1).password);
		assertEquals("ADMIN", ls.getLoginByPassword("wrong.SHOT.1").get(1).userType);
	}
	
	@Test
	public void testLoginByUserType() throws Exception
	{
		//set up for MOCK methods for the REPO
		List<Login> l = new ArrayList<Login>();
		Login login = new Login("Hello", "World", "123@email.com", "helloWorld999", "PATIENT");
		Login login2 = new Login("Vance", "Kaw", "vaka99@iastate.edu", "wrong.SHOT.1", "ADMIN");
		
		// mock the findAll method   
		when(repo.findAll()).thenReturn(l);
		
		// mock the save() method to save argument to the list
		when(repo.save((Login)any(Login.class)))
						.thenAnswer(x -> {
								Login r = (Login) x.getArguments()[0];
								l.add(r);
								return null;
		});		

		repo.save(login);
		repo.save(login2);

		assertEquals("Hello", ls.getLoginByUserType("PATIENT").get(0).firstName);
		assertEquals("World", ls.getLoginByUserType("PATIENT").get(0).lastName);
		assertEquals("123@email.com", ls.getLoginByUserType("PATIENT").get(0).email);
		assertEquals("helloWorld999", ls.getLoginByUserType("PATIENT").get(0).password);
		assertEquals("PATIENT", ls.getLoginByUserType("PATIENT").get(0).userType);
		
		assertEquals("Vance", ls.getLoginByUserType("ADMIN").get(1).firstName);
		assertEquals("Kaw", ls.getLoginByUserType("ADMIN").get(1).lastName);
		assertEquals("vaka99@iastate.edu", ls.getLoginByUserType("ADMIN").get(1).email);
		assertEquals("wrong.SHOT.1", ls.getLoginByUserType("ADMIN").get(1).password);
		assertEquals("ADMIN", ls.getLoginByUserType("ADMIN").get(1).userType);
	}
	
	
	
	
}


