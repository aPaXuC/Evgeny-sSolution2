/**
 * Queries need for this project
 */
package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.Map.Entry;

/**
 * @author Java spring 2017
 *
 */
public class Queries {
	/** SysData instance */
	private static SysData data = SysData.getInstance();
	/**
	 * List of all the warehouses located in the same country as this manufacturer
	 * @param manufacturerName Manufacturer name
	 * @return The list
	 */
	protected static LinkedList<Warehouse> getAllWarehousesInManufacturerCountry(String manufacturerName) {
		//TODO Complete this method
		LinkedList<Warehouse> result = new LinkedList<>();
		Manufacturer m = data.getManufacturers().get(manufacturerName);
		if (m == null)
			return result;
		for (Warehouse w : data.getWarehouses().values())
			if (w.location.country.equals(m.address.country))
				result.add(w);
		return result;
	}
	/**
	 * Find a vehicle of a requested model in a city
	 * Needs to find a warehouse in this city, and a vehicle from the model
	 * Retrieve any vehicle with these parameters, even if there is more than one
	 * It doesn't matter which vehicle is retrieved, as long as it is OK
	 * @param country Country name
	 * @param city City name
	 * @param model Model name
	 * @return The first vehicle found, null if no vehicle was found
	 */
	protected static Vehicle findVehicleInCity(String country, String city, String model) {
		//TODO Complete this method
		for (Warehouse w : data.getWarehouses().values())
			if (w.location.country.equals(country) && w.location.city.equals(city))
				for (Vehicle v : w.getVehicles())
					if (v.model.modelName.equals(model))
						return v;
		return null;
	}
	/**
	 * Get the most profitable manufacturer
	 * Total all orders from this manufacturer minus all orders to him
	 * @return Most profitable manufacturer
	 */
	protected static Manufacturer getMostProfitableManufacturer() {
		//TODO Complete this method
		double bestProfit = 0;
		Manufacturer bestManu = null;
		for (Manufacturer m : data.getManufacturers().values()) {
			double profit = 0;
			for (Order<?, ?> ord : data.getOrders().values()) {
				if (ord.orderedFrom.equals(m))
					profit+=ord.getPrice();
				if (ord.orderedTo.equals(m))
					profit-=ord.getPrice();
			}
			if (profit > bestProfit) {
				bestProfit = profit;
				bestManu = m;
			}
		}
		return bestManu;
	}
	/**
	 * Find which parts are not in stock for a production plan
	 * Find parts needed for vehicle in this plan that cannot be found in any warehouse
	 * For each part type, calculate the amount missing
	 * @param plan Production plan name
	 * @return List of parts not in stock
	 */
	protected static HashMap<PartType, Integer> getMissingPartsForProductionPlan(int plan) {
		//TODO Complete this method
		HashMap<PartType, Integer> result = new HashMap<>();
		ProductionPlan pp = data.getProductionPlans().get(plan);
		if (pp == null)
			return result;
		for (Vehicle v : pp.getVehicles())
			for (Entry<PartType, Integer> entry : v.model.getRequiredParts().entrySet())
				if (result.containsKey(entry.getKey()))
					result.put(entry.getKey(), result.get(entry.getKey()) + entry.getValue());
				else result.put(entry.getKey(), entry.getValue());
		for (Warehouse w : data.getWarehouses().values())
			if (w.getMaxPartsStored() > 0)
				for (Entry<PartType, Integer> entry : w.getParts().entrySet())
					if (result.containsKey(entry.getKey())) {
						if (result.get(entry.getKey()) == entry.getValue())
							result.remove(entry.getKey());
						else result.put(entry.getKey(), result.get(entry.getKey()) - entry.getValue());
					}
		return result;
	}
	/**
	 * Get the last date a vehicle from this model is expected to be produced
	 * Vehicles are expected in production plans and orders from a manufacturer
	 * @param model Model name
	 * @return Calendar of the last time a vehicle will be produced
	 */
	protected static Calendar getLastFutureProductionOfModel(String model) {
		//TODO Complete this method
		Calendar last = Calendar.getInstance();
		last.set(1990, 1, 1);
		for (ProductionPlan pp : data.getProductionPlans().values())
			for (Vehicle v : pp.getVehicles())
				if (v.model.modelName.equals(model) && pp.getEndDate().after(last))
					last = pp.getEndDate();
		for (Order<?, ?> ord : data.getOrders().values())
			if (ord.orderedFrom instanceof Manufacturer)
				for (Vehicle v : ord.getVehicles())
					if (v.model.modelName.equals(model) && ord.dueDate.after(last))
						last = ord.dueDate;
		return last;
	}
	/**
	 * Find the shift during this time 
	 * @param time The time given
	 * @return The shift, null if there is no shift in this time
	 */
	protected static Shift findShiftByTime(Calendar time) {
		//TODO Complete this method
		for (Shift s : data.getShifts().values()) {
			if (s.startingTime.compareTo(time) <= 0 && s.endTime().compareTo(time) > 0)
				return s;
		}
		return null;
	}
	/**
	 * Order all shift by the number of production plan types
	 * @return Set of shifts
	 */
	protected static TreeSet<Shift> getAllShiftsOrderedByNumberOfProductionPlanTypes() {
		//TODO Complete this method
		TreeSet<Shift> result = new TreeSet<>(new Comparator<Shift>() {

			@Override
			public int compare(Shift arg0, Shift arg1) {
				// TODO Auto-generated method stub
				return ((Integer)arg0.countProductionPlanType()).compareTo(arg1.countProductionPlanType());
			}
		});
		result.addAll(data.getShifts().values());
		return result;
	}
	/**
	 * Get the K models with the smallest amount of vehicles in the system
	 * @param k
	 * @return List of K models
	 */
	protected static ArrayList<VehicleModel> getKModelsWithLeastVehicles(int k) {
		//TODO Complete this method
		ArrayList<VehicleModel> result = new ArrayList<>(data.getModels().values());
		result.sort(new Comparator<VehicleModel>() {

			@Override
			public int compare(VehicleModel o1, VehicleModel o2) {
				// TODO Auto-generated method stub
				int ao1 = 0;
				int ao2 = 0;
				for (Vehicle v : data.getVehicles().values()){
					if (v.model.equals(o1))
						ao1++;
					if (v.model.equals(o2))
						ao2++;
				}
				return ((Integer)ao1).compareTo(ao2);
			}
		});
		ArrayList<VehicleModel> res = new ArrayList<>();
		for (int i = 0; i < k; i++)
			res.add(result.get(i));
		return res;
	}
	/**
	 * Get all orders, for each orders count the amount of parts.
	 * Remember: each part has an amount
	 * @return Map of orders
	 */
	protected static HashMap<Order<? ,?>, Integer> getNumberOfPartsForEachOrder() {
		//TODO Complete this method
		HashMap<Order<? ,?>, Integer> result = new HashMap<>();
		for (Order<?, ?> ord : data.getOrders().values()) {
			int sum = 0;
			for (Integer i : ord.getParts().values())
				sum += i;
			result.put(ord, sum);
		}
		return result;
	}
	/**
	 * Get all the employees ordered by type (class simple name) and then by id
	 * Note: this is employees natural order
	 * @return Set of employees
	 */
	protected static TreeSet<AbstractEmployee> getAllEmployeesOrderedByTypeAndById() {
		//TODO Complete this method
		return new TreeSet<AbstractEmployee>(data.getEmployees().values());
	}
	/**
	 * Get all employees ordered by salary in given month
	 * Order can be minimum to maximum or in reverse
	 * @param month Month for salary calculations
	 * @param dir Direction of order. True for max to min, false for min to max
	 * @return Set of employees
	 */
	protected static TreeSet<AbstractEmployee> getAllEmployeesOrderedBySalaryInMonth(Calendar month, boolean dir) {
		//TODO Complete this method
		TreeSet<AbstractEmployee> result = new TreeSet<>(new EmployeeComparator(month, dir));
		result.addAll(data.getEmployees().values());
		return result;
	}
	/**
	 * Get all production plan types ordered by number of slots
	 * @return Set of production plan types
	 */
	protected static TreeSet<ProductionPlanType> getProductionPlanTypesOrderedByNumberOfSlots() {
		//TODO Complete this method
		TreeSet<ProductionPlanType> result = new TreeSet<>(new Comparator<ProductionPlanType>() {

			@Override
			public int compare(ProductionPlanType o1, ProductionPlanType o2) {
				// TODO Auto-generated method stub
				return ((Integer)o1.numberOfSlots).compareTo(o2.numberOfSlots);
			}
		});
		result.addAll(data.getProductionPlanTypes().values());
		return result;
	}
	/**
	 * Get all hourly employees
	 * For each employee get all shifts
	 * For each shift get all slots 
	 * @return Map of employees, value is map of shift and collection of slots
	 */
	protected static HashMap<HourlyEmployee, HashMap<Shift, Collection<Slot>>> getAllHourlyEmployeesWithShiftsAndSlots() {
		//TODO Complete this method
		HashMap<HourlyEmployee, HashMap<Shift, Collection<Slot>>> result = new HashMap<>();
		for (AbstractEmployee ae : data.getEmployees().values())
			if (ae instanceof HourlyEmployee) {
				HashMap<Shift, Collection<Slot>> res = new HashMap<>();
				for (Shift s : ((HourlyEmployee) ae).getShifts())
					res.put(s, s.getSlots().values());
				result.put((HourlyEmployee) ae, res);
			}
		return result;
	}
	/**
     * Get part types' quantity from all orders, return only part types that exist in an order (quantity > 0).
     * Remember: each part has an amount
     * @return Map of PartTypes
     */
    protected static HashMap<PartType, Integer> getPartsQuantityInAllOrders() {
    	//TODO Complete this method
    	HashMap<PartType, Integer> result = new HashMap<>();
    	for (Order<?, ?> ord : data.getOrders().values())
    		for (Entry<PartType, Integer> entry : ord.getParts().entrySet()) {
    			if (result.containsKey(entry.getKey()))
    				result.put(entry.getKey(), result.get(entry.getKey()) + entry.getValue());
    			else result.put(entry.getKey(), entry.getValue());
    		}
    	return result;
    }
}
