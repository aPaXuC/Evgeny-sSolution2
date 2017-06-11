/**
 * 
 */
package model;

import java.util.Calendar;

/**
 * @author Java spring 2017
 *
 */
public class ShiftManager extends HourlyEmployee {
	/** Amount added to the salary in every month */
	protected double extraWage;
	/**
	 * Full constructor
	 * @param id
	 * @param name
	 * @param address
	 * @param birthday
	 * @param employmentDate
	 * @param hourlyWage
	 * @param extraWage
	 */
	protected ShiftManager(String id, String name, Address address,
			Calendar birthday, Calendar employmentDate, double hourlyWage, double extraWage) {
		super(id, name, address, birthday, employmentDate, hourlyWage);
		setExtraWage(extraWage);
	}
	/**
	 * Extra wage added to the monthly salary
	 * @param extraWage
	 */
	protected void setExtraWage(double extraWage) {
		if (extraWage > 0)
			this.extraWage = extraWage;
	}
	/**
	 * @see AbstractEmployee#getSalary(Calendar)
	 */
	protected double getSalary(Calendar cal) {
		//TODO Complete this method
		return super.getSalary(cal) + extraWage;
		
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ShiftManager [extraWage=" + extraWage + ", toString()="
				+ super.toString() + "]";
	}
	
	protected Object clone() {
		return new ShiftManager(getId(), name, address, (Calendar)getBirthday().clone(), (Calendar)getEmploymentDate().clone(), getHourlyWage(), extraWage);
	}
}
