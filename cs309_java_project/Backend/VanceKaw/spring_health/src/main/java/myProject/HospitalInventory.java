package myProject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity // JPA annotation to make this object ready for storage in a JPA-based data store
@Table(name = "hospital_inventory")
class HospitalInventory {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@Column
	String covidTesting;
	
	@Column
	Integer icuBeds;
	
	@Column
	Integer totalBeds;
	
	@Column
	Integer ventilators;
	
	@Column 
	Integer staffAvailable;
	
	@Column 
	Integer defibrillators;
	
	@ManyToOne
	@JoinColumn(name = "hospitallist_id", nullable = false)
	HospitalList hospitalList;
	
	public HospitalInventory() {}
	
	public HospitalInventory(String covidTesting, Integer icuBeds, Integer totalBeds, Integer ventilators, Integer staffAvailable, 
			Integer defibrillators, HospitalList hospitalList)
	{
		super();
		this.covidTesting = covidTesting;
		this.icuBeds = icuBeds;
		this.totalBeds = totalBeds;
		this.ventilators = ventilators;
		this.staffAvailable = staffAvailable;
		this.defibrillators = defibrillators;
		this.hospitalList = hospitalList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCovidTesting() {
		return covidTesting;
	}

	public void setCovidTesting(String covidTesting) {
		this.covidTesting = covidTesting;
	}

	public Integer getIcuBeds() {
		return icuBeds;
	}

	public void setIcuBeds(Integer icuBeds) {
		this.icuBeds = icuBeds;
	}

	public Integer getTotalBeds() {
		return totalBeds;
	}

	public void setTotalBeds(Integer totalBeds) {
		this.totalBeds = totalBeds;
	}

	public Integer getVentilators() {
		return ventilators;
	}

	public void setVentilators(Integer ventilators) {
		this.ventilators = ventilators;
	}

	public Integer getStaffAvailable() {
		return staffAvailable;
	}

	public void setStaffAvailable(Integer staffAvailable) {
		this.staffAvailable = staffAvailable;
	}

	public Integer getDefibrillators() {
		return defibrillators;
	}

	public void setDefibrillators(Integer defibrillators) {
		this.defibrillators = defibrillators;
	}
	
	public HospitalList getHospitalList()
	{
		return hospitalList;
	}
	
	public void setHospitalList(HospitalList hospitalList)
	{
		this.hospitalList = hospitalList;
	}
	
	
	
}