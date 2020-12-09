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
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HospitalListController {

	private final HospitalListDB repository;
	
	@Autowired 
	private HospitalListService hospitalListService;
	
//	@Autowired
//	HospitalDB db;
	@Autowired
	public HospitalListController(HospitalListDB repository)
	{
		this.repository = repository;
	}

	// getting/READING data from database server 
	@GetMapping("/hospitallist/{fid}")
	public HospitalList getHospital(@PathVariable Integer fid) {
		return repository.findOne(fid);
	}
	
	@GetMapping(path = "/hospitallists/{state}")
	public List<HospitalList> getHospitalByState(@PathVariable String state)
	{
		return hospitalListService.getHospitalByState(state);
//		return repository.findByState(state);
	}
	
	@RequestMapping("/hospitallists")
	List<HospitalList> hello() {
		return repository.findAll();
	}

	
	// used for posting or pushing NEW data to server database
	@PostMapping("/hospitallist")
	HospitalList newHospital(@RequestBody HospitalList h) {
		repository.save(h);
		return h;
	}

//	 UPDATING specific data by ID already stored in server database
	@PutMapping("/hospitallist/{fid}")
	HospitalList updateHospital(@RequestBody HospitalList hospital, @PathVariable Integer fid) {
		HospitalList newHospital = repository.findOne(fid);
		newHospital.setBeds(hospital.getBeds());
		newHospital.setCOVID_testing(hospital.getCOVID_testing());
		newHospital.setECG_machine(hospital.getECG_machine());
		newHospital.setICU_beds(hospital.getICU_beds());
		newHospital.setVentilator(hospital.getVentilator());
		newHospital.setTOTAL_beds(hospital.getTOTAL_beds());
		newHospital.setTOTAL_ECG_machine(hospital.getTOTAL_ECG_machine());
		newHospital.setTOTAL_ICU_beds(hospital.getTOTAL_ICU_beds());
		newHospital.setTOTAL_ventilator(hospital.getVentilator());
		
//		newHospital.setAddress(hospital.getAddress());
//		newHospital.setCity(hospital.getCity());
//		newHospital.setCountry(hospital.getCountry());
//		newHospital.setCounty(hospital.getCounty());
//		newHospital.setECG_wait(hospital.getECG_wait());
//		newHospital.setId(hospital.getId());
//		newHospital.setLatitude(hospital.getLatitude());
//		newHospital.setLongitude(hospital.getLongitude());
//		newHospital.setName(hospital.getName());
//		newHospital.setState(hospital.getState());
//		newHospital.setStatus(hospital.getStatus());
//		newHospital.setTelephone(hospital.getTelephone());
//		newHospital.setType(hospital.getType());
//		newHospital.setWebsite(hospital.getWebsite());
//		newHospital.setZip(hospital.getZip());
		
		repository.save(newHospital);
		return newHospital;
	}
	

	// DELETING data from table by ID
	@DeleteMapping("/hospitallist/{fid}")
	String deleteHospital(@PathVariable Integer fid) {
		repository.delete(fid);
		return "deleted " + fid;
	} 

}


