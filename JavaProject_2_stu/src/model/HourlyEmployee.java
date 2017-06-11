/**
 * 
 */
package model;

import java.util.Calendar;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import utils.Constants;

/**
 * @author Java spring 2017
 *
 */
public abstract class HourlyEmployee extends AbstractEmployee {
	/** Wage per hour */
	private double hourlyWage;
	/** Set of shifts the employee is working in */
	private TreeSet<Shift> shifts;
	/**
	 * Full constructor
	 * @param id
	 * @param name
	 * @param address
	 * @param birthday
	 * @param employmentDate
	 */
	protected HourlyEmployee(String id, String name, Address address,
			Calendar birthday, Calendar employmentDate, double hourlyWage) {
		super(id, name, address, birthday, employmentDate);
		setHourlyWage(hourlyWage);
		shifts = new TreeSet<Shift>();
	}
	/**
	 * @return the hourlyWage
	 */
	protected double getHourlyWage() {
		return hourlyWage;
	}
	/**
	 * @param hourlyWage the hourlyWage to set
	 */
	private void setHourlyWage(double hourlyWage) {
		if (hourlyWage > 0)
			this.hourlyWage = hourlyWage;
	}
	/**
	 * @return the shifts
	 */
	protected Set<Shift> getShifts() {
		//TODO Complete this method
		return Collections.unmodifiableSet(this.shifts);
	}
	/**
	 * Add shift to this worker
	 * Can only work after he got employed
	 * @param shift Shift to add
	 * @return True if added successfully
	 */
	protected boolean addShift(Shift shift) {
		//TODO Complete this method
		if (shift.startingTime.before(getEmploymentDate()))
			return false;
		return shifts.add(shift);
	}
	/**
	 * Remove the shift
	 * @param s Shift to remove 
	 * @return True if removed successfully
	 */
	protected boolean removeShift(Shift s) {
		//TODO Complete this method
		return shifts.remove(s);
	}
	/**
	 * @see AbstractEmployee#getSalary(Calendar)
	 */
	protected double getSalary(Calendar cal) {
		//TODO Complete this method
		double salary = 0;
		for (Shift s : shifts)
			if (s.startingTime.get(Calendar.YEAR) == cal.get(Calendar.YEAR) && s.startingTime.get(Calendar.MONTH) == cal.get(Calendar.MONTH))
				salary+=hourlyWage*Constants.SHIFT_LENGTH;
		return salary;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HourlyEmployee [hourlyWage=" + hourlyWage + ", toString()="
				+ super.toString() + "]";
	}
}
