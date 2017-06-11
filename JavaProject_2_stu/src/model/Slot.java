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
public class Slot implements Comparable<Slot>, Cloneable {
	/** Key: When the slot starts */
	protected Calendar startingTime;
	/** The shift it belongs to */
	protected Shift shift;
	/** The production plan that belongs to the slot */
	protected ProductionPlan plan;
	/**
	 * Full constructor
	 * @param startingTime
	 * @param shift
	 * @param plan
	 */
	protected Slot(Calendar startingTime, Shift shift, ProductionPlan plan) {
		this.startingTime = startingTime;
		this.shift = shift;
		this.plan = plan;
	}
	/**
	 * When the slot ends
	 * @return End of slot
	 */
	protected Calendar endTime() {
		Calendar end = (Calendar)startingTime.clone();
		end.add(Calendar.HOUR_OF_DAY, Constants.SLOT_LENGTH);
		return end;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((startingTime == null) ? 0 : startingTime.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Slot)
			if (((Slot)obj).startingTime.equals(startingTime))
				return true;
		return false;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Slot [startingTime=" + startingTime.getTime().toString() + ", shift=" + shift
				+ ", plan=" + plan + "]";
	}
	@Override
	public int compareTo(Slot o) {
		return startingTime.compareTo(o.startingTime);
	}
	
	protected Object clone() {
		return new Slot((Calendar)startingTime.clone(), (Shift)shift.clone(), (ProductionPlan)plan.clone());
	}
}
