package myProject;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity // JPA annotation to make this object ready for storage in a JPA-based data store
@Table(name = "hospital_information")
class HospitalList {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer fid;
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	String state;
	
	
	@Column
	Integer beds, id, zip, ICU_beds, ECG_machine, ventilator, COVID_testing, ECG_wait, 
	TOTAL_beds, TOTAL_ICU_beds, TOTAL_ECG_machine, TOTAL_ventilator;
	
	
	@Column
	String address, city, country, county, name, status, telephone, type, website;
	
	@Column
	Double latitude, longitude;
	
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@ManyToOne
//	@JoinColumn(name = "login_id", nullable = false)
//	Login login;
	
	@OneToMany(mappedBy = "hospitalList")
	List<HospitalInventory> hospitalInventory;
	
	public HospitalList() {}
	
	public HospitalList(String name, String state)
	{
		super();
		this.name = name;
		this.state = state;
	}
	
	public HospitalList(Integer id, String name, String address, String city, String state, Integer zip, 
		    String telephone, String type, String status, String county, String country, Double latitude, Double longitude, String website, Integer beds, 
		    Integer TOTAL_beds, Integer TOTAL_ICU_beds, Integer TOTAL_ECG_machine, Integer TOTAL_ventilator,
		    Integer ICU_beds, Integer ECG_machine, Integer ventilator, Integer COVID_testing, Integer ECG_wait) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.telephone = telephone;
		this.type = type;
		this.status = status;
//		this.population = population;
		this.county = county;
		this.country = country;
		this.latitude = latitude;
		this.longitude = longitude;
//		this.sourcedate = sourcedate;
		this.website = website;
		this.beds = beds;
//		this.login = login;
		this.hospitalInventory = new ArrayList<>();
		this.ICU_beds = ICU_beds;
		this.ECG_machine = ECG_machine;
		this.ventilator = ventilator; 
		this.COVID_testing = COVID_testing;
		this.ECG_wait = ECG_wait;
		this.TOTAL_beds = TOTAL_beds;
		this.TOTAL_ECG_machine = TOTAL_ECG_machine;
		this.TOTAL_ICU_beds = TOTAL_ICU_beds;
		this.TOTAL_ventilator = TOTAL_ventilator;
		
	}

	public Integer getTOTAL_beds() {
		return TOTAL_beds;
	}

	public void setTOTAL_beds(Integer tOTAL_beds) {
		TOTAL_beds = tOTAL_beds;
	}

	public Integer getTOTAL_ICU_beds() {
		return TOTAL_ICU_beds;
	}

	public void setTOTAL_ICU_beds(Integer tOTAL_ICU_beds) {
		TOTAL_ICU_beds = tOTAL_ICU_beds;
	}

	public Integer getTOTAL_ECG_machine() {
		return TOTAL_ECG_machine;
	}

	public void setTOTAL_ECG_machine(Integer tOTAL_ECG_machine) {
		TOTAL_ECG_machine = tOTAL_ECG_machine;
	}

	public Integer getTOTAL_ventilator() {
		return TOTAL_ventilator;
	}

	public void setTOTAL_ventilator(Integer tOTAL_ventilator) {
		TOTAL_ventilator = tOTAL_ventilator;
	}

	public Integer getICU_beds() {
		return ICU_beds;
	}

	public void setICU_beds(Integer iCU_beds) {
		ICU_beds = iCU_beds;
	}

	public Integer getECG_machine() {
		return ECG_machine;
	}

	public void setECG_machine(Integer eCG_machine) {
		ECG_machine = eCG_machine;
	}

	public Integer getVentilator() {
		return ventilator;
	}

	public void setVentilator(Integer ventilator) {
		this.ventilator = ventilator;
	}

	public Integer getCOVID_testing() {
		return COVID_testing;
	}

	public void setCOVID_testing(Integer cOVID_testing) {
		COVID_testing = cOVID_testing;
	}

	public Integer getECG_wait() {
		return ECG_wait;
	}

	public void setECG_wait(Integer eCG_wait) {
		ECG_wait = eCG_wait;
	}

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

	public Integer getBeds() {
		return beds;
	}

	public void setBeds(Integer beds) {
		this.beds = beds;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}	
	
//	public Login getLogin()
//	{
//		return login;
//	}
//	
//	public void setLogin(Login login)
//	{
//		this.login = login;
//	}
	
	public List<HospitalInventory> getHospitalInventory()
	{
		return hospitalInventory;
	}
	
	public void setHospitalInventories(List<HospitalInventory> hospitalInventory)
	{
		this.hospitalInventory = hospitalInventory;
	}
	
		
}