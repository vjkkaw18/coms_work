package myProject;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LoginDB extends JpaRepository<Login, Integer> {
		List<Login> findByFirstName(String firstName);
		List<Login> findByLastName(String lastName);
		List<Login> findByEmail(String email);
		List<Login> findByUserType(String userType);
		Login findByEmailAndPassword(String email, String password);
		Login findById(int id);
		List<Login> findByPassword(String password);

}