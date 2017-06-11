/**
 * A manufacturer that the company can contact (with an order) to produce vehicles and parts
 * A manufacturer has a list of models it can produce, any vehicle ordered must be with a model from the list
 * A manufacturer can produce parts from specific categories, any parts order must be of parts with their category on the list
 */
package model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import utils.E_PartCategory;

/**
 * @author Java spring 2017
 *
 */
public class Manufacturer implements Cloneable{
	/** Key: Manufacturer name */
	protected String name;
	/** Manufacturer address */
	protected Address address;
	/** Percentage added to any order as a profit */
	protected double profitPercentage;
	/** List of models the manufacturer can produce */
	private HashSet<VehicleModel> producedModels;
	/** List of part categories the manufacturer can produce and number of parts */ 
	private HashSet<E_PartCategory> producedPartTypes;	// replace **** by HashSet - XXX check about number of parts
	/**
	 * Full constructor
	 * @param name Manufacturer name
	 * @param address Manufacturer address
	 * @param profitPercentage Profit percentage
	 */
	protected Manufacturer(String name, Address address, double profitPercentage) {
		this.name = name;
		this.address = address;
		this.profitPercentage = profitPercentage;
		producedModels = new HashSet<VehicleModel>();
		producedPartTypes = new HashSet<>();
	}
	/**
	 * @return Unmodifiable set of vehicle models this manufacturer can produce
	 */
	protected Set<VehicleModel> getProducedModels() {
		//TODO Complete this method
		return Collections.unmodifiableSet(this.producedModels);
	}
	/**
	 * Adds a model to the list only if it's not in there
	 * @param modelToAdd The model to add
	 */
	protected boolean addProducedModel(VehicleModel modelToAdd) {
		//TODO Complete this method
		return producedModels.add(modelToAdd);
	}
	/**
	 * Removes a model from the list
	 * @param modelToRemove Model to remove
	 * @return True if successful
	 */
	protected boolean removeProducedModel(VehicleModel modelToRemove) {
		//TODO Complete this method
		return producedModels.remove(modelToRemove);
	}
	/**
	 * @return Part categories that the manufacturer can produce
	 */
	protected Set<E_PartCategory> getProducedPartTypes() {
		//TODO Complete this method
		return Collections.unmodifiableSet(this.producedPartTypes);
	}
	/**
	 * Adds a part category
	 * @param producedPartType The part category to add
	 */
	protected boolean addProducedPartType(E_PartCategory producedPartType) {
		//TODO Complete this method
		return producedPartTypes.add(producedPartType);
	}
	/**
	 * Removes a part category from the list
	 * @param producedPartType Part category to remove
	 * @return True if removed successfully
	 */
	protected boolean removeProducedPartType(E_PartCategory producedPartType) {
		//TODO Complete this method
		return producedPartTypes.remove(producedPartType);
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Manufacturer)
			if (((Manufacturer)obj).name.equals(this.name))
				return true;
		return false;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Manufacturer [name=" + name + ", address=" + address
				+ ", profitPercentage=" + profitPercentage + "]";
	}
	
	protected Object clone() {
		return new Manufacturer(name, (Address)address.clone(), profitPercentage);
	}
}
