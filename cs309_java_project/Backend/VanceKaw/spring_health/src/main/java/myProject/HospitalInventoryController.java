package myProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HospitalInventoryController {

	private final HospitalInventoryDB repository;
	
//	@Autowired
//	HospitalDB db;
	@Autowired
	public HospitalInventoryController(HospitalInventoryDB repository)
	{
		this.repository = repository;
	}

	// getting/READING data from database server 
	@GetMapping("/hospitalinventory/{fid}")
	HospitalInventory getHospital(@PathVariable Integer fid) {
		return repository.findOne(fid);
	}
	
	@RequestMapping("/hospitalinventory")
	List<HospitalInventory> hello() {
		return repository.findAll();
	}
	
//	@GetMapping("/Hospitals")
//	List<Hospital> all()
//	{
//		return repository.findAll();
//	}

	
	// used for posting or pushing NEW data to server database
	@PostMapping("/hospitalinventory")
	HospitalInventory newHospital(@RequestBody HospitalInventory h) {
//		repository.save(newHospital);
//		return p;
		repository.save(h);
		return h;
	}

	// UPDATING specific data by ID already stored in server database
//	@PutMapping("/hospital/{id}")
//	Hospital updateHospital(@RequestBody Hospital newHospital, @PathVariable Integer id) {
//		Hospital old_p = repository.findOne(id);
//		
//		//Setting Hospital information 
//		old_p.setHospitalName(newHospital.hospitalName);
//
//		repository.save(old_p);
//		return old_p;
////		return repository.save(old_p);
//	}
	

	// DELETING data from table by ID
	@DeleteMapping("/hospitalinventory/{fid}")
	String deleteHospital(@PathVariable Integer fid) {
		repository.delete(fid);
		return "deleted " + fid;
	} 

}


