package application;

public class Person {
	
	private String firstName;
	private String lastName;
	private String phone;
	private String city;
	private String postalCode;
	private String email;
	
	public Person(String firstName, String lastName, String phone, String city, String postalCode, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.city =city;
		this.postalCode = postalCode;
		this.email = email;
	}

	// getters 
	public String getFirstName() {return firstName;}
	public String getLastName() {return lastName;}
	public String getPhone() {return phone;}
	public String getCity() {return city;}
	public String getPostalCode() {return postalCode;}
	public String getEmail() {return email;}
	
	// setters
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
}
