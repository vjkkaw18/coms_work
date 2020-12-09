package myProject;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HospitalInventoryDB extends JpaRepository<HospitalInventory, Integer> {

	HospitalInventory findById(int fid);
	
}
