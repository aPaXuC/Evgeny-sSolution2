/**
 * This class represents a vehicle
 * Each vehicle can be either produced by this company or by a manufacturer
 * If it is produced locally, it needs a production plan
 * If it is produced by a manufacturer, it needs an order
 */
package model;

import utils.Constants;

/**
 * @author Java spring 2017
 *
 */
public class Vehicle implements Cloneable{
	/** Key: Vehicle identification number (Chassis number) */
	private String vin;
	/** Vehicle model */
	protected VehicleModel model;
	/** Production plan of this vehicle */
	protected ProductionPlan productionPlan;
	/** Order of this vehicle */
	protected Order<?, ?> order;
	/**
	 * Full constructor #1
	 * Used when the vehicle is produced locally
	 * @param vin Vehicle identification number
	 * @param model Vehicle model
	 * @param productionPlan Vehicle production plan
	 */
	protected Vehicle(String vin, VehicleModel model, ProductionPlan productionPlan) {
		setVin(vin);
		this.model = model;
		this.productionPlan = productionPlan;
	}
	/**
	 * Full constructor #2
	 * @param vin Vehicle identification number
	 * @param model Vehicle model
	 * @param order Vehicle order
	 */
	protected Vehicle(String vin, VehicleModel model, Order<?, ?> order) {
		setVin(vin);
		this.model = model;
		this.order = order;
	}
	/**
	 * Set VIN
	 * VIN has a fixed number of characters
	 * There is a list of illegal characters that cannot be in a VIN 
	 * @param vin The VIN to set
	 */
	private void setVin(String vin) {
		if (vin.length() != Constants.NUM_OF_VIN_CHARACTERS) return;
		for (char ch : Constants.FORBIDDEN_VIN_CHARACTERS) {
			if (vin.indexOf(ch) != -1)
				return;
		}
		this.vin = vin;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vin == null) ? 0 : vin.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vehicle)
			if (((Vehicle)obj).vin.equals(this.vin))
				return true;
		return false;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Vehicle [vin=" + vin + ", model=" + model + ","
				+ (productionPlan != null ? "productionPlan=" + productionPlan + ", " : "") 
				+ (order != null ? "order=" + order : "") + "]";
	}
	
	protected Object clone() {
		if (productionPlan == null)
			return new Vehicle(vin, (VehicleModel)model.clone(), (Order<?, ?>)order.clone());
		return new Vehicle(vin, (VehicleModel)model.clone(), (ProductionPlan)productionPlan.clone());
	}
}
