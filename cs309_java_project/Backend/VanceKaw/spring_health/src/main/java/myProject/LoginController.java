package myProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	public final LoginDB repository;
	
	public LoginService loginService;
	
	@Autowired
	public LoginController(LoginDB repository)
	{
		this.repository = repository;
	}

	// getting/READING data from database server 
	@GetMapping("/logins/{id}")
	Login getLogin(@PathVariable int id) {
		return repository.findOne(id);
	}
	
	@RequestMapping("/logins")
	List<Login> hello() {
		return repository.findAll();
	}
	
	// used for posting or pushing NEW data to server database
	@PostMapping("/logins")
	Login newLogin(@RequestBody Login newLogin) {
		
		return repository.save(newLogin);
	}
	
	//validating user login information
	@PostMapping(value = "/", produces = "application/json")
    public @ResponseBody Login validateUser(@RequestBody Login login){
        return loginService.validatingLogin(login);
    }


	// UPDATING specific data by ID already stored in server database
	@PutMapping("/login/{id}")
	Login updateLogin(@RequestBody Login login, @PathVariable Integer id) {
		Login newLogin = loginService.getLoginById(id);
		
		//Setting login information 
		newLogin.setFirstName(login.getFirstName());
		newLogin.setLastName(login.getLastName());
		newLogin.setEmail(login.getEmail());
		newLogin.setPassword(login.getPassword());
		newLogin.setUserType(login.getUserType());

		repository.save(newLogin);
		return newLogin;
	}

	// DELETING data from table by ID
	@DeleteMapping("/logins/{id}")
	String deleteLogin(@PathVariable Integer id) {
		repository.delete(id);
		return "deleted " + id;
	} 

	
	
}


