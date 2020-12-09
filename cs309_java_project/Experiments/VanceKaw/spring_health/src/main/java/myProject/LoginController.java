package myProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

	@Autowired
	LoginDB db;

	@GetMapping("/logins/{id}")
	Login getLogin(@PathVariable Integer id) {
		return db.findOne(id);
	}
	@RequestMapping("/logins")
	List<Login> hello() {
		return db.findAll();
	}

	@PostMapping("/login")
	Login createLogin(@RequestBody Login p) {
		db.save(p);
		return p;
	}


	@PutMapping("/login/{id}")
	Login updateLogin(@RequestBody Login p, @PathVariable Integer id) {
		Login old_p = db.findOne(id);
		old_p.setPassword(p.password);
		db.save(old_p);
		return old_p;
	}

	@DeleteMapping("/Login/{id}")
	String deleteLogin(@PathVariable Integer id) {
		db.delete(id);
		return "deleted " + id;
	}

}
