/**
 * This class represent a warehouse
 * Each warehouse can store parts and vehicles
 * A warehouse has a maximum amount of vehicles that can be stored
 * A warehouse might not be able to store parts
 */
package model;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Java spring 2017
 *
 */
public class Warehouse implements Cloneable{
	/** Key: Warehouse number */
	protected int warehouseNumber;
	/** Warehouse location */
	protected Address location;
	/** List of vehicles stored in this warehouse */
	private HashSet<Vehicle> vehicles;
	/** List of part types stored in this warehouse */
	private HashMap<PartType, Integer> parts;
	/** Number of parts that can be stored here */
	private int maxPartsStored;
	/** Maximum number of vehicles that can be stored here */
	private int maxVehiclesStored;
	/**
	 * Full constructor
	 * @param warehouseNumber Warehouse number
	 * @param location Warehouse location
	 * @param maxPartsStored Maximum number of parts stored
	 * @param maxVehiclesStored Maximum number of vehicles stored
	 */
	protected Warehouse(int warehouseNumber, Address location, int maxPartsStored,
			int maxVehiclesStored) {
		this.warehouseNumber = warehouseNumber;
		this.location = location;
		vehicles = new HashSet<Vehicle>();
		parts = new HashMap<PartType, Integer>();
		setMaxPartsStored(maxPartsStored);
		setMaxVehiclesStored(maxVehiclesStored);
	}
	/**
	 * Gets the number of parts that can be stored here
	 * @return Number of parts
	 */
	protected int getMaxPartsStored() {
		return maxPartsStored;
	}
	/**
	 * Set the maximum amount of parts stored
	 * Maximum can't be less than current number of parts
	 * @param maxPartsStored
	 */
	protected void setMaxPartsStored(int maxPartsStored) {
		if (maxPartsStored < getCurrentNumberOfParts())
			return;
		this.maxPartsStored = maxPartsStored;
	}
	/**
	 * Get how many vehicles can be stored here
	 * @return Maximum Vehicles stored
	 */
	protected int getMaxVehiclesStored() {
		return maxVehiclesStored;
	}
	/**
	 * Set maximum amount of vehicles stored
	 * Maximum can't be less than current number of vehicles
	 * @param maxVehiclesStored
	 */
	protected void setMaxVehiclesStored(int maxVehiclesStored) {
		if (maxVehiclesStored < vehicles.size())
			return;
		this.maxVehiclesStored = maxVehiclesStored;
	}
	/**
	 * Get the list of vehicles in this warehouse
	 * @return The list
	 */
	protected Set<Vehicle> getVehicles() {
		//TODO Complete this method
		return Collections.unmodifiableSet(this.vehicles);
	}
	/**
	 * Add a vehicle to the warehouse
	 * No duplicated allowed
	 * Make sure not to exceed the maximum
	 * @param vehicle The vehicle to add
	 * @return True if added successfully
	 */
	protected boolean addVehicle(Vehicle vehicle) {
		//TODO Complete this method
		if (maxVehiclesStored == 0)
			return false;
		if (vehicles.size() == maxVehiclesStored)
			return false;
		return vehicles.add(vehicle);
	}
	/**
	 * Remove a vehicle from the warehouse
	 * @param vehicle The vehicle to be removed
	 * @return True if removed successfully
	 */
	protected boolean removeVehicle(Vehicle vehicle) {
		//TODO Complete this method
		return vehicles.remove(vehicle);
	}
	/**
	 * Get a map of part types in this warehouse
	 * @return The map
	 */
	protected Map<PartType, Integer> getParts() {
		//TODO Complete this method
		return Collections.unmodifiableMap(this.parts);
	}
	/**
	 * Adds part types to the warehouse
	 * Only if there is enough store space
	 * @param partType Part type to add
	 * @param amount Amount to add
	 * @return True if parts was added successfully
	 */
	protected boolean addPartType(PartType partType, int amount) {
		//TODO Complete this method
		if (maxPartsStored == 0)
			return false;
		if (amount <= 0)
			return false;
		if (getCurrentNumberOfParts() + amount > maxPartsStored)
			return false;
		if (parts.containsKey(partType))
			parts.put(partType, parts.get(partType) + amount);
		else parts.put(partType, amount);
		return true;
	}
	/**
	 * Remove parts from warehouse
	 * Cannot have less than 1 part
	 * If amount reaches 0, remove the parts from the map
	 * @param partType Part type to remove
	 * @param amount The amount to remove
	 * @return True if removed successfully
	 */
	protected boolean removePartType(PartType partType, int amount) {
		//TODO Complete this method
		if (amount <= 0)
			return false;
		if (!parts.containsKey(partType))
			return false;
		if (parts.get(partType) < amount)
			return false;
		if (parts.get(partType) == amount)
			parts.remove(partType);
		else parts.put(partType, parts.get(partType) - amount);
		return true;
	}
	/**
	 * Get how many parts are currently stored in the warehouse
	 * @return Number of current parts
	 */
	protected int getCurrentNumberOfParts() {
		//TODO Complete this method
		int sum = 0;
		for (Integer i : parts.values())
			sum+=i;
		return sum;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + warehouseNumber;
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Warehouse)
			if (((Warehouse)obj).warehouseNumber == this.warehouseNumber)
				return true;
		return false;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Warehouse [warehouseNumber=" + warehouseNumber + ", location="
				+ location + ", maxPartsStored=" + maxPartsStored
				+ ", maxVehiclesStored=" + maxVehiclesStored
				+ ", currentNumberofParts=" + getCurrentNumberOfParts() + "]";
	}
	
	protected Object clone() {
		return new Warehouse(warehouseNumber, (Address) location.clone(), maxPartsStored, maxVehiclesStored);
	}
}
