/**
 * 
 */
package model;

import java.util.Calendar;

/**
 * @author Java spring 2017
 *
 */
public class Guard extends AbstractEmployee {
	/** Salary per month */
	protected double monthlySalary;
	/** The warehouse where this employee works */
	protected Warehouse warehouse;
	/**
	 * Full constructor
	 * @param id
	 * @param name
	 * @param address
	 * @param birthday
	 * @param employmentDate
	 * @param monthlySalary Salary per month
	 * @param warehouse Where he works
	 */
	protected Guard(String id, String name, Address address,
			Calendar birthday, Calendar employmentDate, double monthlySalary, Warehouse warehouse) {
		super(id, name, address, birthday, employmentDate);
		this.warehouse = warehouse;
		setMonthlySalary(monthlySalary);
	}
	/**
	 * Set the monthly salary of the employee
	 * @param monthlySalary
	 */
	protected void setMonthlySalary(double monthlySalary) {
		if (monthlySalary > 0)
			this.monthlySalary = monthlySalary;
	}
	@Override
	protected double getSalary(Calendar cal) {
		return monthlySalary;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Guard [monthlySalary=" + monthlySalary + ", warehouse="
				+ warehouse + ", toString()=" + super.toString() + "]";
	}
	
	protected Object clone() {
		return new Guard(getId(), name, (Address)address.clone(), (Calendar)getBirthday().clone(), (Calendar)getEmploymentDate().clone(), monthlySalary, (Warehouse)warehouse.clone());
	}
}
