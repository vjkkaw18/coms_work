package myProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalListService {
	@Autowired
	private HospitalListDB repository;
	
	public List<HospitalList> getHospitalByState(String state)
	{
		return repository.findByState(state);
	}
	
	public HospitalList getHospitalById(int fid)
	{
		return repository.findById(fid);
	}
}
