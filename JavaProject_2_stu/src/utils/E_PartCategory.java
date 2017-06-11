/**
 * Categories for part types
 */
package utils;

/**
 * @author Java spring 2017
 *
 */
public enum E_PartCategory {
	INTERIOR("Interior"),
	EXTERIOR("Exterior"),
	MECHANICS("Mechanics"),
	ELECTRICITY("Electricity"),
	HYDRAULICS("Hydraulics");
	/** Text of the category */ 
	private String text;
	/**
	 * Constructor
	 * @param text The text to set
	 */
	E_PartCategory(String text) {
		this.text = text;
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	public String toString() {
		return text;
	}
}
