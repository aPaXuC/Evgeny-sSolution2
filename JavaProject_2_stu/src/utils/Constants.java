/**
 * Constants for the entire project
 */
package utils;

/**
 * @author Java spring 2017
 *
 */
public class Constants {
	/** Number of characters in a vehicle identification number */
	public static final int NUM_OF_VIN_CHARACTERS = 17;
	/** Array of characters that cannot be in a VIN */
	public static final char[] FORBIDDEN_VIN_CHARACTERS = {'I', 'O', 'Q'};
	/** Number of digits in id */
	public static final int ID_DIGITS = 9;
	/** Shift length in hours */
	public static final int SHIFT_LENGTH = 8;
	/** Slot length in hours */
	public static final int SLOT_LENGTH = 1;
	/**
	 * Checks if a string can be parsed to an integer
	 * @param s String to check
	 * @return True if string is integer
	 */
	public static boolean isNumeric(String s) {
		try {
			@SuppressWarnings("unused")
			int x = Integer.parseInt(s);
		}
		catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}
