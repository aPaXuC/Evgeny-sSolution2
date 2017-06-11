/**
 * 
 */
package model;

import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

import utils.Constants;

/**
 * @author Java spring 2017
 *
 */
public class Shift implements Comparable<Shift>, Cloneable {
	/** Key: When the shift starts */
	protected Calendar startingTime;
	/** The shift manager for this shift */
	protected ShiftManager shiftManager;
	/** Working slots in this shift */
	private TreeMap<Calendar, Slot> slots;
	/**
	 * Constructor
	 * @param startingTime
	 * @param manager
	 */
	protected Shift(Calendar startingTime, ShiftManager manager) {
		this.startingTime = startingTime;
		shiftManager = manager;
		slots = new TreeMap<Calendar, Slot>();
	}
	/**
	 * Get the set of slots
	 * @return Set of slots
	 */
	protected Map<Calendar, Slot> getSlots() {
		//TODO Complete this method
		return Collections.unmodifiableMap(this.slots);
	}
	/**
	 * A slot must start and end within the shift time
	 * @param s Slot to add
	 * @return True if added successfully
	 */
	protected boolean addSlot(Slot s) {
		//TODO Complete this method
		if (s.startingTime.before(startingTime))
			return false;
		if (s.endTime().after(endTime()))
			return false;
		if (slots.containsKey(s.startingTime))
			return false;
		if (slots.size() == Constants.SHIFT_LENGTH/Constants.SLOT_LENGTH)	//XXX each shift can have only 8 slots
			return false;
		slots.put(s.startingTime, s);
		return true;
	}
	/**
	 * Remove the slot
	 * @param s Slot to remove
	 * @return True of removed successfully
	 */
	protected boolean removeSlot(Slot s) {
		//TODO Complete this method
		Slot answ = slots.remove(s.startingTime);
		if (answ == null)
			return false;
		return true;
	}
	/**
	 * Calculate when the shift ends
	 * @see Constants#SHIFT_LENGTH
	 * @return When the shift ends
	 */
	protected Calendar endTime() {
		Calendar end = (Calendar)startingTime.clone();
		end.add(Calendar.HOUR_OF_DAY, Constants.SHIFT_LENGTH);
		return end;
	}
	/**
	 * @return The number of different production plan types in this shift
	 */
	protected int countProductionPlanType() {
		//TODO Complete this method
		HashSet<ProductionPlanType> result = new HashSet<>();
		for (Slot s : slots.values())
			result.add(s.plan.type);
		return result.size();
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
		if (obj instanceof Shift)
			if (((Shift)obj).startingTime.equals(this.startingTime))
				return true;
		return false;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Shift [startingTime=" + startingTime.getTime().toString() + ", shiftManager="
				+ shiftManager + "]";
	}
	/**
	 * Compare by starting time
	 */
	@Override
	public int compareTo(Shift o) {
		//TODO Complete this method
		return startingTime.compareTo(o.startingTime);
	}
	
	protected Object clone() {
		return new Shift((Calendar)startingTime.clone(), (ShiftManager)shiftManager.clone());
	}
}
