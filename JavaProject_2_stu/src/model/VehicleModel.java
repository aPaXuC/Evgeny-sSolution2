/**
 * This class represents a model of a vehicle
 */
package model;

import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import utils.E_VehicleType;

/**
 * @author Java spring 2017
 *
 */
public class VehicleModel  implements Comparable<VehicleModel>, Cloneable {
	/** Production plan type of this model */
	protected ProductionPlanType productionPlanType;
	/** Key: Model name */
	protected String modelName;
	/** Vehicle type */
	protected E_VehicleType vehicleType;
	/** Horse power */
	private int hp;
	/** Top speed in KPH */
	private int topSpeed;
	/** Number of seats */
	private int numOfSeats;
	/** Does this model has an automatic gear box? */
	protected boolean isAutomatic;
	/** Cost of producing one vehicle of this model */
	private double productionCost;
	/** When did this model entered production? */
	private Calendar enteredProduction;
	/** List of parts needed to build this model */
	private HashMap<PartType, Integer> requiredParts;
	/**
	 * Full constructor
	 * @param productionPlanType Production plan type of this model
	 * @param modelName Model name
	 * @param vehicleType Vehicle type
	 * @param hp Horse power
	 * @param topSpeed Top speed
	 * @param numOfSeats Number of seats
	 * @param isAutomatic Is it automatic?
	 * @param productionCost Price of production
	 * @param enteredProduction Date when model entered production
	 */
	protected VehicleModel(ProductionPlanType productionPlanType, String modelName,
			E_VehicleType vehicleType, int hp, int topSpeed, int numOfSeats,
			boolean isAutomatic, double productionCost, Calendar enteredProduction) {
		this.modelName = modelName;
		this.productionPlanType = productionPlanType;
		this.vehicleType = vehicleType;
		setHp(hp);
		setTopSpeed(topSpeed);
		setNumOfSeats(numOfSeats);
		this.isAutomatic = isAutomatic;
		setProductionCost(productionCost);
		this.enteredProduction = enteredProduction;
		requiredParts = new HashMap<PartType, Integer>();
	}
	/**
	 * Set top speed, cannot be 0 or lower
	 * @param topSpeed the topSpeed to set
	 */
	private void setTopSpeed(int topSpeed) {
		if (topSpeed > 0)
			this.topSpeed = topSpeed;
	}
	/**
	 * Set the number of seats, must be more than 0
	 * @param numOfSeats The number of seats to set
	 */
	private void setNumOfSeats(int numOfSeats) {
		if (numOfSeats > 0)
			this.numOfSeats = numOfSeats;
	}
	/**
	 * Get price of producing one vehicle of this model
	 * @return The price
	 */
	protected double getProductionCost() {
		return productionCost;
	}
	/**
	 * Set the price of producing one vehicle
	 * No need to check parts
	 * @param productionCost The price to set
	 */
	private void setProductionCost(double productionCost) {
		if (productionCost > 0)
			this.productionCost = productionCost;
	}
	/**
	 * Set the horse power, cannot be 0 or negative
	 * @param hp The horse power to set
	 */
	private void setHp(int hp) {
		if (hp > 0)
			this.hp = hp;
	}
	/**
	 * Get an unmodifiable list of parts
	 * @return List of parts
	 */
	protected Map<PartType, Integer> getRequiredParts() {
		//TODO Complete this method
		return Collections.unmodifiableMap(this.requiredParts);
	}
	/**
	 * Add a part type to this model
	 * If a part already exists, add the amount to the current amount
	 * @param part The part type to add
	 * @param amount Amount to add
	 * @return True if added successfully
	 */
	protected boolean addPartType(PartType part, int amount) {
		//TODO Complete this method
		if (amount <= 0)
			return false;
		if (requiredParts.containsKey(part))
			requiredParts.put(part, requiredParts.get(part) + amount);
		else requiredParts.put(part, amount);
		return true;
	}
	/**
	 * Remove the amount of parts from this model
	 * Cannot have less than 0 parts
	 * If number of parts reaches 0, remove the part from the map
	 * @param part Part type to remove
	 * @param amount Amount to remove
	 * @return True if removed successfully
	 */
	protected boolean removePartType(PartType part, int amount) {
		//TODO Complete this method
		if (amount <= 0)
			return false;
		if (!requiredParts.containsKey(part))
			return false;
		if (requiredParts.get(part) < amount)
			return false;
		if (requiredParts.get(part) == amount)
			requiredParts.remove(part);
		else requiredParts.put(part, requiredParts.get(part) - amount);
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof VehicleModel)
			if (((VehicleModel)obj).modelName.equals(this.modelName))
				return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "VehicleModel [productionPlanType=" + productionPlanType
				+ ", modelName=" + modelName + ", vehicleType=" + vehicleType
				+ ", hp=" + hp + ", topSpeed=" + topSpeed + ", numOfSeats="
				+ numOfSeats + ", isAutomatic=" + isAutomatic
				+ ", productionCost=" + productionCost + ", enteredProduction="
				+ enteredProduction.getTime().toString() + "]";
	}
	@Override
	public int compareTo(VehicleModel arg0) {
		//TODO Complete this method
		return modelName.compareTo(arg0.modelName);				//XXX check by which value we have to compare
	}

	protected Object clone() {
		return new VehicleModel((ProductionPlanType)productionPlanType.clone(), modelName, vehicleType, hp, topSpeed, numOfSeats, isAutomatic, productionCost, (Calendar)enteredProduction.clone());
	}
}
