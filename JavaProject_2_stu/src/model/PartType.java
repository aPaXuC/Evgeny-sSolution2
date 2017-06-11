/**
 * This class represents a part type
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
public class PartType implements Cloneable{
	/** Key: Part number */
	protected int partNumber;
	/** Part name */
	protected String partName;
	/** Part category */
	protected E_PartCategory category;
	/** Cost of production of one part */
	private double productionCost;
	/** List of manufacturers that can produce this part */
	private HashSet<Manufacturer> manufacturers;
	/**
	 * Full constructor
	 * @param partNumber Part number
	 * @param partName Part name
	 * @param category PArt category
	 * @param productionCost Production cost
	 */
	protected PartType(int partNumber, String partName, E_PartCategory category, double productionCost) {
		this.partNumber = partNumber;
		this.partName = partName;
		this.category = category;
		setProductionCost(productionCost);
		this.manufacturers = new HashSet<Manufacturer>();
	}
	/**
	 * @return The Production cost
	 */
	protected double getProductionCost() {
		return productionCost;
	}

	/**
	 * Sets production cost, cannot be negative or 0
	 * @param productionCost The production cost to set
	 */
	protected void setProductionCost(double productionCost) {
		if (productionCost > 0)
			this.productionCost = productionCost;
	}

	/**
	 * List of manufacturers that can produce this part
	 * @return The manufacturers
	 */
	protected Set<Manufacturer> getManufacturers() {
		//TODO Complete this method
		return Collections.unmodifiableSet(this.manufacturers);
	}

	/**
	 * The manufacturer to add
	 * No duplicates allowed
	 * Can be added only if the manufacturer can produce this category
	 * @param manufacturer the manufacturer to add
	 * @return True if added successfully
	 */
	protected boolean addManufacturer(Manufacturer manufacturer) {
		//TODO Complete this method
		if (!manufacturer.getProducedPartTypes().contains(category))
			return false;
		return manufacturers.add(manufacturer);
	}
	/**
	 * Removes a manufacturer from the list
	 * @param manufacturer The manufacturer to be removed
	 * @return True if removed successfully
	 */
	protected boolean removeManufacturer(Manufacturer manufacturer) {
		//TODO Complete this method
		return manufacturers.remove(manufacturer);
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + partNumber;
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PartType)
			if (((PartType)obj).partNumber == this.partNumber)
				return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PartType [partNumber=" + partNumber + ", partName=" + partName
				+ ", category=" + category + ", productionCost="
				+ productionCost + "]";
	}
	
	protected Object clone() {
		return new PartType(partNumber, partName, category, productionCost);
	}
}
