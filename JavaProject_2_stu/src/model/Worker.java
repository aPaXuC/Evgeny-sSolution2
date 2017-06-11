/**
 * 
 */
package model;

import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Java spring 2017
 *
 */
public class Worker extends HourlyEmployee {
	/** Set of work station that the worker can operate */
	private HashSet<WorkStation> stations;
	/**
	 * Full constructor
	 * @param id Employee id
	 * @param name Employee name
	 * @param address Address
	 * @param birthday Date of birth
	 * @param employmentDate Date of employment
	 * @param hourlyWage Hourly wage
	 */
	protected Worker(String id, String name, Address address,
			Calendar birthday, Calendar employmentDate, double hourlyWage) {
		super(id, name, address, birthday, employmentDate, hourlyWage);
		stations = new HashSet<WorkStation>();
	}
	/**
	 * @return Get the set of work stations
	 */
	protected Set<WorkStation> getWorkStations() {
		//TODO Complete this method
		return Collections.unmodifiableSet(this.stations);
	}
	/**
	 * Add work station to this worker 
	 * @param ws Work Station to add
	 * @return True if added successfully
	 */
	protected boolean addWorkStation(WorkStation ws) {
		//TODO Complete this method
		return stations.add(ws);
	}
	/**
	 * Remove work station from the set
	 * @param ws Work station to remove
	 * @return True if removed successfully
	 */
	protected boolean removeWorkStation(WorkStation ws) {
		//TODO Complete this method
		return stations.remove(ws);
	}
	/**
	 * A worker can be added to a shift only if the shift has work station that the worker can operate
	 */
	@Override
	protected boolean addShift(Shift shift) {
		//TODO Complete this method
		for (Slot s : shift.getSlots().values())
			for (WorkStation ws : s.plan.type.getWorkStations())
				if (stations.contains(ws))
					return super.addShift(shift);
		return false;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Worker [stations=" + stations + ", toString()="
				+ super.toString() + "]";
	}
	
	protected Object clone() {
		return new Worker(getId(), name, (Address)address.clone(), (Calendar)getBirthday().clone(), (Calendar)getEmploymentDate().clone(), getHourlyWage());
	}
}
