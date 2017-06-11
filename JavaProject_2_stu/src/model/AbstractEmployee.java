/**
 * 
 */
package model;

import java.util.Calendar;

import utils.Constants;

/**
 * @author Java spring 2017
 *
 */
public abstract class AbstractEmployee implements Comparable<AbstractEmployee> {
	/** Employee ID */
	private String id;
	/** Employee name */
	protected String name;
	/** Employee address */
	protected Address address;
	/** When the employee was born */
	private Calendar birthday;
	/** When the employee started working */
	private Calendar employmentDate;
	/**
	 * Full constructor
	 * @param id Employee id
	 * @param name full name
	 * @param address Employee address
	 * @param birthday Date of birth
	 * @param employmentDate Date of employment
	 */
	protected AbstractEmployee(String id, String name, Address address,
			Calendar birthday, Calendar employmentDate) {
		setId(id);
		this.name = name;
		this.address = address;
		setBirthday(birthday);
		setEmploymentDate(employmentDate);
	}
	/**
	 * @return id
	 */
	protected String getId() {
		return id;
	}
	/**
	 * Set the id, must have 9 digits
	 * @param id
	 */
	private void setId(String id) {
		if (id.length() == Constants.ID_DIGITS && Constants.isNumeric(id))
			this.id = id;
	}
	/**
	 * Gets the Employee's salary for a given month
	 * @param cal
	 * @return Salary
	 */
	protected abstract double getSalary(Calendar cal);
	/**
	 * @return birthday
	 */
	protected Calendar getBirthday() {
		return birthday;
	}
	/**
	 * An employee can be born only in the past
	 * @param birthday the birthday to set
	 */
	private void setBirthday(Calendar birthday) {
		if (Calendar.getInstance().after(birthday))
			this.birthday = birthday;
	}
	/**
	 * Gets the employment date
	 * @return Employment date
	 */
	protected Calendar getEmploymentDate() {
		return employmentDate;
	}
	/**
	 * An employee can start working only after he was born
	 * @param employmentDate the employmentDate to set
	 */
	private void setEmploymentDate(Calendar employmentDate) {
		if (employmentDate.after(birthday))
			this.employmentDate = employmentDate;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof AbstractEmployee)
			if (((AbstractEmployee)obj).id.equals(this.id))
				return true;
		return false;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AbstractEmployee [id=" + id + ", name=" + name + ", address="
				+ address + ", birthday=" + birthday.getTime().toString() + ", employmentDate="
				+ employmentDate.getTime().toString() + "]";
	}
	
	@Override
	public int compareTo(AbstractEmployee arg0) {
		int x = getClass().getSimpleName().compareTo(arg0.getClass().getSimpleName());
		if (x == 0)
			x = id.compareTo(arg0.getId());
		return x;
	}
	
	protected abstract Object clone();
}
