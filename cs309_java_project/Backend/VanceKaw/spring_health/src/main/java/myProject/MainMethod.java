//package myProject;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class MainMethod {
//	@Autowired 
//	private LoginDB loginDB;
//
//	public void main(String[] args)
//	{
//		Login login1 = new Login("Vance", "Kaw", "vaka99@iastate.edu", "hello.WORLD.99", "ADMIN");
//		Login login2 = new Login("Daniel", "King", "djking@iastate.edu", "hello.WORLD.98", "MANAGER");
//		loginDB.save(Arrays.asList(login1, login2));
//		
//		List<Login> results = loginDB.findByUserType("ADMIN");
//		System.out.println(results.size()); // should be 1
//				
//	}
//
//}
