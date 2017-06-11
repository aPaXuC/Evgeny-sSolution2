/**
 * Represents an address
 */
package model;

/**
 * @author Java spring 2017
 *
 */
public class Address {
	/** Country name */
	protected String country;
	/** City name */
	protected String city;
	/** Street name */
	protected String street;
	/** House number */
	private int houseNumber;
	/** ZIP code */
	protected String zipCode;
	/**
	 * Address constructor
	 * @param country Country name
	 * @param city City name
	 * @param street Street name
	 * @param houseNumber House number
	 * @param zipCode ZIP code
	 */
	protected Address(String country, String city, String street, int houseNumber,
			String zipCode) {
		this.country = country;
		this.city = city;
		this.street = street;
		setHouseNumber(houseNumber);
		this.zipCode = zipCode;
	}
	/**
	 * @return the houseNumber
	 */
	protected int getHouseNumber() {
		return houseNumber;
	}
	/**
	 * Sets the house number, cannot be negative or 0 
	 * @param houseNumber The houseNumber to set
	 */
	public void setHouseNumber(int houseNumber) {
		if (houseNumber > 0)
			this.houseNumber = houseNumber;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Address [country=" + country + ", city=" + city + ", street="
				+ street + ", houseNumber=" + houseNumber + ", zipCode="
				+ zipCode + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() {
		return new Address(country, city, street, houseNumber, zipCode);
	}
}
