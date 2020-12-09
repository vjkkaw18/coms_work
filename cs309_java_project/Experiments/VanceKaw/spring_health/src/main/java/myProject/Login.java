package myProject;

import javax.persistence.*;

@Entity
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
	
	public Integer getId() { return id; }
	
	public String getEmail() { return email; }
	public String getfirstName() { return firstName; }
	public String getlastName() { return lastName; }
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	
	
}