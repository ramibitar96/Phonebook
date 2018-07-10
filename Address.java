package claim2;

public class Address {
	private String street;
	private String zip;
	private String city;
	private String state;
	
	public Address() {

	}
	
	public Address(String street, String city, String state, String zip) {
		this.street = street;
		this.state = state;
		this.zip = zip;
		this.city = city;
	}
	
	public String getStreet() {
		return this.street;
	}
	
	public String getState() {
		return this.state;
	}
	
	public String getZip() {
		return this.zip;
	}
	
	public String getAddress() {
		return street + " " + city + ", " + state + " " + zip;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public void setAddress(String street, String city, String state, String zip) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCity() {
		return this.city;
	}
}
