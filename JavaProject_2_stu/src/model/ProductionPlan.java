/**
 * This class represents a production plan
 */
package model;

import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Java spring 2017
 *
 */
public class ProductionPlan implements Cloneable{
	/** Key: Production plan serial number */
	protected int serialNumber;
	/** The type of this production plan */
	protected ProductionPlanType type;
	/** List of vehicles produced in this production plan */
	private HashSet<Vehicle> vehicles;
	/** Set of slots when the production plan is allocated */
	private TreeMap<Calendar, Slot> slots;
	/**
	 * Full constructor
	 * @param serialNumber Plan serial number
	 * @param type Type of this plan
	 */
	protected ProductionPlan(int serialNumber, ProductionPlanType type) {
		this.serialNumber = serialNumber;
		this.type = type;
		vehicles = new HashSet<Vehicle>();
		slots = new TreeMap<Calendar, Slot>();
	}
	/**
	 * Gets when the production plan will start
	 * @return Date of first slot
	 */
	protected Calendar getStartDate() {
		//TODO Complete this method
		return slots.firstKey();
	}
	/**
	 * Calculate when this order will end
	 * @return date of last slot
	 */
	protected Calendar getEndDate() {
		//TODO Complete this method
		return slots.lastKey();
	}
	/**
	 * Gets an unmodifiable set of vehicles
	 * @return The vehicles set
	 */
	protected Set<Vehicle> getVehicles() {
		//TODO Complete this method
		return Collections.unmodifiableSet(this.vehicles);
	}
	/**
	 * Adds a vehicle to this production plan
	 * Cannot have duplicates
	 * Only vehicle with the correct production plan type can be added
	 * @param vehicle the vehicles to add
	 * @return True if added successfully
	 */
	protected boolean addVehicle(Vehicle vehicle) {
		//TODO Complete this method
		if (!vehicle.model.productionPlanType.equals(type))
			return false;
		return vehicles.add(vehicle);
	}
	/**
	 * Removes a vehicle from the vehicles set
	 * @param vehicle The vehicle to remove
	 * @return True if removed successfully
	 */
	protected boolean removeVehicle(Vehicle vehicle) {
		//TODO Complete this method
		return vehicles.remove(vehicle);
	}
	/**
	 * Gets an unmodifiable set of slots
	 * @return The slots set
	 */
	protected Map<Calendar, Slot> getSlots() {
		//TODO Complete this method
		return Collections.unmodifiableMap(this.slots);
	}
	/**
	 * Adds a slot to this production plan
	 * Make sure it is needed
	 * @param slot Slot to add
	 * @return True if added successfully
	 */
	protected boolean addSlot(Slot slot) {
		//TODO Complete this method
		if (isGood())
			return false;
		if (slots.containsKey(slot.startingTime))
			return false;
		slots.put(slot.startingTime, slot);
		return true;
	}
	/**
	 * Removes a slot from the slots set
	 * @param slot Slot to remove
	 * @return True if removed successfully
	 */
	protected boolean removeSlot(Slot slot) {
		//TODO Complete this method
		Slot answ = slots.remove(slot.startingTime);
		if (answ == null)
			return false;
		return true;
		
	}
	/**
	 * Check if there are enough slots for this production plan
	 * Production plan type has the amount of slots needed per vehicle
	 * @return True if 'Good'
	 */
	protected boolean isGood() {
		return ((type.numberOfSlots * vehicles.size()) <= (slots.size()));
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + serialNumber;
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ProductionPlan)
			if (((ProductionPlan)obj).serialNumber == this.serialNumber)
				return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProductionPlan [serialNumber=" + serialNumber + ", type="
				+ type + "]";
	}
	
	protected Object clone() {
		return new ProductionPlan(serialNumber, (ProductionPlanType)type.clone());
	}
}
