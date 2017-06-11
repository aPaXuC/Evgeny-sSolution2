/**
 * Types of vehicles
 */
package utils;

/**
 * @author Java spring 2017
 *
 */
public enum E_VehicleType {
	MINI("Mini car"),
	COMPACT("Compact car"),
	MID("Mid-size car"),
	FULL("Full-size car"),
	LUX("Luxury car"),
	SPORT("Sports car"),
	SUPER("Super car"),
	VAN("Van"),
	PICKUP("Pickup truck"),
	SUV("SUV");
	/** Text of the vehicle type */
	public String text;
	/**
	 * Constructor
	 * @param text The text to set
	 */
	E_VehicleType(String text) {
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
