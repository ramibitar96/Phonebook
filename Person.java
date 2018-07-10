package claim2;

public class Person {
	private String firstName;
	private String lastName;
	private String middleName;
	private String phoneNumber;
	private Address address;
	
	public Person() {
		
	}
	
	public Person(String firstName, String middleName, String lastName, String phoneNumber, String street, String city, String state, String zip) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = new Address(street, city, state, zip);
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getMiddleName() {
		return this.middleName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getFullName() {
		if (this.middleName.equals(""))
			return this.firstName + " " + this.lastName;
		else
			return this.firstName + " " + this.middleName + " " + this.lastName;
	}
	
	public String fullSortName() {
		if (this.middleName.equals(""))
			return this.lastName + " " + this.firstName;
		else
			return this.lastName + " " + this.firstName + " " + this.middleName;
	}
	
	public String getNumber() {
		return this.phoneNumber;
	}
	
	public Address getAddress() {
		return this.address;
	}
	
	public void setAddress(String street, String city, String state, String zip) {
		this.address.setAddress(street, city, state, zip);
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
