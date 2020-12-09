package myProject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // JPA annotation to make this object ready for storage in a JPA-based data store
@Table(name = "login_information")
class Login {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@Column
	String firstName;
	
	@Column
	String lastName;
	
	@Column
	String email;
	
	@Column
	String password;
	
	@Column 
	String userType;
	
//	@OneToMany(mappedBy = "login")
//	@JsonIgnore
//	List<HospitalList> hospitalLists;
	
	public Login() {}
	
	public Login(String firstName, String lastName, String email, String password, String userType)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.userType = userType;
//		this.hospitalLists = new ArrayList<>();
	}
	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Integer getId() 
	{ 
		return id; 
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getEmail() 
	{ 
		return email; 
	}
	
	public String getPassword() 
	{ 
		return password; 
	}
	
	public void setID(Integer id)
	{
		this.id = id;
	}
	
	public void setPassword(String password) 
	{ 
		this.password = password; 
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
	
//	public List<HospitalList> getHospitalLists()
//	{
//		return hospitalLists;
//	}
//	
//	public void setHospitalLists(List<HospitalList> hospitalLists)
//	{
//		this.hospitalLists = hospitalLists;
//	}
	
}