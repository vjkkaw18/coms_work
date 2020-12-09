package myProject;

//Import Java libraries
import java.util.List;
import java.util.ArrayList;

//import junit/spring tests
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.springframework.http.MediaType;

//import mockito related
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;


@RunWith(SpringRunner.class)
@WebMvcTest(LoginController.class)
public class TestingControllerUnit {


//	@TestConfiguration
//	static class StringContextConfiguration {
//
//		@Bean
//		public LoginService lService() {
//			return new LoginService();
//		}
//
//		@Bean LoginDB getRepo() {
//			return mock(LoginDB.class);
//		}
//	}

	@MockBean
	private LoginService service;
	
	@Autowired
	private MockMvc controller;

	@Autowired // note that this repo is also needed in
	private LoginDB repo;

	/*
	 * There are three steps here:
	 *   1 - set up mock database methods
	 *   2 - set up mock service methods
	 *   3 - call and test the results of the controller
	 */
	@Test
	public void testLoginController() throws Exception {

//		Login login = new Login("Hello", "World", "123@email.com", "helloWorld999", "PATIENT");
//		// Set up MOCK methods for the REPO
//		List<Login> l = Arrays.asList(login);
//		repo.save(l);
//
//		controller.perform(get("/logins")
//			      .contentType(MediaType.APPLICATION_JSON))
//			      .andExpect(status().isOk())
//			      .andExpect(jsonPath("$[0].name", is(login.firstName)));
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
		
		controller.perform(get("/logins").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].data", is(repo.findByFirstName("Hello").get(0).firstName)));

		
	}


//	@Test
//	public void testCapitalizeEndpoint() throws Exception {
//
//		// Set up MOCK methods for the REPO
//		List<Login> l = new ArrayList<Login>();
//
//		// mock the findAll method
//		when(repo.findAll()).thenReturn(l);
//
//		when(repo.save((Login)any(Login.class)))
//		.thenAnswer(x -> {
//			Login r = (Login) x.getArguments()[0];
//			l.add(r);
//			return null;
//		});
//
//
//
//		// CALL THE CONTROLLER DIRECTLY (instead of using postman) AND TEST THE RESULTS
//		// we sent hello. we expect back a list with first object having "olleh" in it
//		controller.perform(post("/capitalize").contentType(MediaType.APPLICATION_JSON).content("hello"))
//		.andExpect(status().isOk())
//		.andExpect(jsonPath("$[0].data", is("HELLO")));
//	}

}
