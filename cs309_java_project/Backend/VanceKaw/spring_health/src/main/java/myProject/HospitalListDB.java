package myProject;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HospitalListDB extends JpaRepository<HospitalList, Integer> {
	HospitalList findByName(String name);
	List<HospitalList> findByState(String state);
	List<HospitalList> findByCounty(String county);
	HospitalList findById(int fid);
	
}
