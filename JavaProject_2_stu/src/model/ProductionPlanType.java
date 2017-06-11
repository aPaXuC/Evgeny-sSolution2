/**
 * Class that represents a production plan type
 */
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Java spring 2017
 *
 */
public class ProductionPlanType implements Comparable<ProductionPlanType>, Cloneable {
	/** Key: Production plan type serial number */
	protected int serialNumber;
	/** Number of time slots needed per vehicle */
	protected int numberOfSlots;
	/** List of workstations needed for this production plan type */
	private ArrayList<WorkStation> workStations;
	/**
	 * Full constructor
	 * @param serialNumber Production plan type serial number
	 * @param numberOfSlots Number of slots
	 */
	protected ProductionPlanType(int serialNumber, int numberOfSlots) {
		this.serialNumber = serialNumber;
		this.numberOfSlots = numberOfSlots;
		workStations = new ArrayList<WorkStation>();
	}
	/**
	 * Gets an unmodifiable list of the workstations
	 * @return WorkStations list
	 */
	protected List<WorkStation> getWorkStations() {
		//TODO Complete this method
		return Collections.unmodifiableList(this.workStations);
	}
	/**
	 * Add a workstation to a position in the list
	 * If position is negative, do nothing.
	 * If position is higher than the number of workstations, put it in the end of the list
	 * @param ws WorkStation to add
	 * @param pos position where it should be added
	 * @return True if added successfully
	 */
	protected boolean addWorkStation(WorkStation ws, int pos) {
		//TODO Complete this method
		if (pos < 0)
			return false;
		if (pos > workStations.size())
			return workStations.add(ws);
		workStations.add(pos, ws);
		return true;
	}
	/**
	 * Removes the workstation
	 * @param ws WorkStation to remove
	 * @return True if removed successfully
	 */
	protected boolean removeWorkStation(WorkStation ws) {
		//TODO Complete this method
		return workStations.remove(ws);
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
		if (obj instanceof ProductionPlanType)
			if (((ProductionPlanType)obj).serialNumber == this.serialNumber)
				return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProductionPlanType [serialNumber=" + serialNumber
				+ ", numberOfSlots="
				+ numberOfSlots + "]";
	}
	@Override
	public int compareTo(ProductionPlanType arg0) {
		//TODO Complete this method
		return ((Integer)serialNumber).compareTo(arg0.serialNumber);	//XXX check by which value have to be sorted
	}
	
	protected Object clone() {
		return new ProductionPlanType(serialNumber, numberOfSlots);
	}
}
