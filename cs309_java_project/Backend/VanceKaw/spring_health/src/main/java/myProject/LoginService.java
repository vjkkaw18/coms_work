package myProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {
	@Autowired
	public LoginDB repository;
	
//	public List<Login> getLoginByUserType(String userType)
//	{
//		return repository.findByUserType(userType);
//	}
	
	public Login getLoginById(Integer id)
	{
		return repository.findById(id);
	}
	
	public Login validatingLogin(Login login)
	{
		return repository.findByEmailAndPassword(login.getEmail(), login.getPassword());
	}
	
	public List<Login> getLoginByFirstName(String firstName)
	{
//		return repository.findByFirstName(firstName);
		return repository.findAll();
	}

	public List<Login> getLoginByEmail(String email)
	{
//		return repository.findByEmail(email);
		return repository.findAll();
	}
	
	public List<Login> getLoginByLastName(String lastName)
	{
//		return repository.findByLastName(lastName);
		return repository.findAll();
	}
	
//	public List<Login> getLoginByPassword(String password)
//	{
////		return repository.findByPassword(password);
//		return repository.findAll();
//	}
	
	public List<Login> getLoginByPassword(String password)
	{
//		return repository.findByPassword(password);
		return repository.findAll();
	}
	
	public List<Login> getLoginByUserType(String userType)
	{
//		return repository.findByUserType(userType);
		return repository.findAll();
	}
	
}