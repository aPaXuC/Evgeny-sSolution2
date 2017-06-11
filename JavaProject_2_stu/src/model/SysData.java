/**
 * This class contains the database of the company
 */
package model;

import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import utils.E_PartCategory;
import utils.E_VehicleType;

/**
 * @author Java spring 2017
 *
 */
public class SysData {
	/** SysData Singleton instance */
	private static SysData instance;
	/** Manufacturers list */
	private HashMap<String, Manufacturer> manufacturers;
	/** Orders list */
	private HashMap<Integer, Order<?,?>> orders;
	/** Part types list */
	private HashMap<Integer, PartType> parts;
	/** Production plans list */
	private HashMap<Integer, ProductionPlan> productionPlans;
	/** Production plan types list */
	private HashMap<Integer, ProductionPlanType> productionPlanTypes;
	/** Vehicle models list */
	private HashMap<String, VehicleModel> models;
	/** Vehicles list */
	private HashMap<String, Vehicle> vehicles;
	/** Warehouses list */
	private HashMap<Integer, Warehouse> warehouses;
	/** Work stations list */
	private HashMap<Integer, WorkStation> workStations;
	/** Shift list */
	private HashMap<Calendar, Shift> shifts;
	/** Employees list */
	private HashMap<String, AbstractEmployee> employees;
	/**
	 * SysData constructor
	 */
	private SysData() {
		manufacturers = new HashMap<String, Manufacturer>();
		orders = new HashMap<Integer, Order<?,?>>();
		parts = new HashMap<Integer, PartType>();
		productionPlans = new HashMap<Integer, ProductionPlan>();
		productionPlanTypes = new HashMap<Integer, ProductionPlanType>();
		models = new HashMap<String, VehicleModel>();
		vehicles = new HashMap<String, Vehicle>();
		warehouses = new HashMap<Integer, Warehouse>();
		workStations = new HashMap<Integer, WorkStation>();
		shifts = new HashMap<Calendar, Shift>();
		employees = new HashMap<String, AbstractEmployee>();
	}
	/**
	 * Get the SysData instance
	 * @return Instance of the SysData
	 */
	protected static SysData getInstance() {
		if (instance == null)
			instance = new SysData();
		return instance;
	}
	/**
	 * @return the manufacturers
	 */
	protected Map<String, Manufacturer> getManufacturers() {
		//TODO Complete this method
		return Collections.unmodifiableMap(this.manufacturers);
	}
	/**
	 * @return the orders
	 */
	protected Map<Integer, Order<?, ?>> getOrders() {
		//TODO Complete this method
		return Collections.unmodifiableMap(this.orders);
	}
	/**
	 * @return the parts
	 */
	protected Map<Integer, PartType> getParts() {
		//TODO Complete this method
		return Collections.unmodifiableMap(this.parts);
	}
	/**
	 * @return the productionPlans
	 */
	protected Map<Integer, ProductionPlan> getProductionPlans() {
		//TODO Complete this method
		return Collections.unmodifiableMap(this.productionPlans);
	}
	/**
	 * @return the productionPlanTypes
	 */
	protected Map<Integer, ProductionPlanType> getProductionPlanTypes() {
		//TODO Complete this method
		return Collections.unmodifiableMap(this.productionPlanTypes);
	}
	/**
	 * @return the models
	 */
	protected Map<String, VehicleModel> getModels() {
		//TODO Complete this method
		return Collections.unmodifiableMap(this.models);
	}
	/**
	 * @return the vehicles
	 */
	protected Map<String, Vehicle> getVehicles() {
		//TODO Complete this method
		return Collections.unmodifiableMap(this.vehicles);
	}
	/**
	 * @return the warehouses
	 */
	protected Map<Integer, Warehouse> getWarehouses() {
		//TODO Complete this method
		return Collections.unmodifiableMap(this.warehouses);
	}
	/**
	 * @return the workStations
	 */
	protected Map<Integer, WorkStation> getWorkStations() {
		//TODO Complete this method
		return Collections.unmodifiableMap(this.workStations);
	}
	/**
	 * @return the shifts
	 */
	protected Map<Calendar, Shift> getShifts() {
		//TODO Complete this method
		return Collections.unmodifiableMap(this.shifts);
	}
	/**
	 * @return the employees
	 */
	protected Map<String, AbstractEmployee> getEmployees() {
		//TODO Complete this method
		return Collections.unmodifiableMap(this.employees);
	}

	/**
	 * Adds manufacturer to the system only if it doesn't exist yet
	 * @param name Manufacturer name
	 * @param country Address country
	 * @param city Address city
	 * @param street Address street
	 * @param houseNumber Address house number
	 * @param zipCode Address ZIP code
	 * @param profitPercentage Manufacturer percentage of order price added as income
	 * @return True if added successfully
	 */
	protected boolean addManufacturer(String name, String country, String city, String street,
			int houseNumber, String zipCode, double profitPercentage) {
		if (manufacturers.containsKey(name)) return false;
		Address address = new Address(country, city, street, houseNumber, zipCode);
		Manufacturer manufacturer = new Manufacturer(name, address, profitPercentage);
		manufacturers.put(name, manufacturer);
		return true;
	}
	/**
	 * Adds warehouse to the system only if it doesn't exists yet
	 * @param warehouseNumber Warehouse serial number
	 * @param country Address country
	 * @param city Address city
	 * @param street Address street
	 * @param houseNumber Address house number
	 * @param zipCode Address ZIP code
	 * @param maxPartsStored Maximum number of parts stored in this warehouse
	 * @param maxVehiclesStored Maximum number of vehicles stored in this warehouse
	 * @return True if added successfully
	 */
	protected boolean addWarehouse(int warehouseNumber, String country, String city, String street,
			int houseNumber, String zipCode, int maxPartsStored, int maxVehiclesStored) {
		//TODO Complete this method
		if (warehouses.containsKey(warehouseNumber))
			return false;
		Address address = new Address(country, city, street, houseNumber, zipCode);
		Warehouse wh = new Warehouse(warehouseNumber, address, maxPartsStored, maxVehiclesStored);
		warehouses.put(warehouseNumber, wh);
		return true;
	}
	/**
	 * Adds production plan type to the system only if it doesn't exists yet
	 * @param serialNumber Production plan type serial number
	 * @param numberOfSlots Number of slots
	 * @return True if added successfully
	 */
	protected boolean addProductionPlanType(int serialNumber, int numberOfSlots) {
		//TODO Complete this method
		if (productionPlanTypes.containsKey(serialNumber))
			return false;
		ProductionPlanType ppt = new ProductionPlanType(serialNumber, numberOfSlots);
		ProductionPlanType ans = productionPlanTypes.put(serialNumber, ppt);
		if (ans != null)
			return false;
		return true;
	}
	/**
	 * Adds production plan to the system only if it doesn't exists yet
	 * Don't forget to retrieve the Production plan type 
	 * @param serialNumber Production plan serial number
	 * @param typeSerialNumber Production plan type serial number, this production plan will be of this type
	 * @return True if added successfully
	 */
	protected boolean addProductionPlan(int serialNumber, int typeSerialNumber) {
		//TODO Complete this method
		if (productionPlans.containsKey(serialNumber))
			return false;
		ProductionPlanType ppt = productionPlanTypes.get(typeSerialNumber);
		if (ppt == null)
			return false;
		ProductionPlan pp = new ProductionPlan(serialNumber, ppt);
		productionPlans.put(serialNumber, pp);
		return true;
	}
	/**
	 * Adds Vehicle model to the system only if it doesn't exists yet
	 * Don't forget to retrieve the production plan type of this model
	 * @param productionPlanTypeSerial Serial number of the production plan needed to build this vehicle
	 * @param modelName Name of this model
	 * @param vehicleType Type of this model
	 * @param hp Model Horse power
	 * @param topSpeed Model top speed in KPH
	 * @param numOfSeats Number of seats in this model
	 * @param isAutomatic True if this model has an automatic gear box
	 * @param productionCost Cost of producing one vehicle
	 * @param enteredProduction When did this model entered production?
	 * @return True if added successfully
	 * @see E_VehicleType
	 */
	protected boolean addVehicleModel(int productionPlanTypeSerial, String modelName,
			E_VehicleType vehicleType, int hp, int topSpeed, int numOfSeats,
			boolean isAutomatic, double productionCost, Calendar enteredProduction) {
		//TODO Complete this method
		if (models.containsKey(modelName))
			return false;
		ProductionPlanType ppt = productionPlanTypes.get(productionPlanTypeSerial);
		if (ppt == null)
			return false;
		VehicleModel vm = new VehicleModel(ppt, modelName, vehicleType, hp, topSpeed, numOfSeats, isAutomatic, productionCost, enteredProduction);
		models.put(modelName, vm);
		return true;
	}
	/**
	 * Adds part type to the system only if it doesn't exists yet
	 * @param partNumber Part type serial number
	 * @param partName Name of the part
	 * @param category Category of the part
	 * @param productionCost Cost to produce this part
	 * @return True if added successfully
	 * @see E_PartCategory
	 */
	protected boolean addPartType(int partNumber, String partName, E_PartCategory category, double productionCost) {
		//TODO Complete this method
		if (parts.containsKey(partNumber))
			return false;
		PartType pt = new PartType(partNumber, partName, category, productionCost);
		parts.put(partNumber, pt);
		return true;
	}
	/**
	 * Adds order to the system only if it doesn't exists yet
	 * Don't forget to retrieve the manufacturer
	 * @param orderNumber Order number
	 * @param orderedFrom Ordering side
	 * @param orderedTo Receiving side
	 * @param dueDate When the order needs to be delivered
	 * @return True if added successfully
	 */
	protected boolean addOrder(int orderNumber, String orderedFrom, String orderedTo, Calendar dueDate) {
		//TODO Complete this method
		if (orders.containsKey(orderNumber))
			return false;
		if (manufacturers.containsKey(orderedFrom) && employees.containsKey(orderedTo)) {
			Manufacturer m = manufacturers.get(orderedFrom);
			AbstractEmployee ae = employees.get(orderedTo);
			Order<Manufacturer, AbstractEmployee> ord = new Order<Manufacturer, AbstractEmployee>(orderNumber, m, ae, dueDate);
			orders.put(orderNumber, ord);
			return true;
		}
		if (employees.containsKey(orderedFrom) && manufacturers.containsKey(orderedTo)) {
			AbstractEmployee ae = employees.get(orderedFrom);
			Manufacturer m = manufacturers.get(orderedTo);
			Order<AbstractEmployee, Manufacturer> ord = new Order<AbstractEmployee, Manufacturer>(orderNumber, ae, m, dueDate);
			orders.put(orderNumber, ord);
			return true;
		}
		return false;
	}
	/**
	 * Adds a vehicle to the system only if it doesn't exists yet
	 * Don't forget to retrieve the production plan
	 * This method is used for adding a new vehicle.
	 * A new vehicle can be added in 2 ways:
	 * - Producing it locally (production plan is needed, order will be -1)
	 * - Ordering it from a manufacturer (Order is needed, production plan will be -1)
	 * @param vin Vehicle identification number (Chassis number)
	 * @param modelName Name of vehicle model
	 * @param productionPlanSerial Serial number of production plan (-1 if in order)
	 * @param orderNumber Order number (-1 if in production plan)
	 * @return True if added successfully
	 */
	protected boolean addVehicle(String vin, String modelName, int productionPlanSerial, int orderNumber) {
		if (vehicles.containsKey(vin)) return false;
		VehicleModel model = models.get(modelName);
		if (model == null) return false;
		ProductionPlan pp = productionPlans.get(productionPlanSerial);
		Order<?, ?> o = orders.get(orderNumber);
		if (pp != null && o == null) {
			Vehicle v = new Vehicle(vin, model, pp);
			if (!pp.addVehicle(v)) return false;
			vehicles.put(vin, v);
			return true;
		}
		if (o != null && pp == null) {
			Vehicle v = new Vehicle(vin, model, o);
			if (!o.addVehicle(v)) return false;
			vehicles.put(vin, v);
			return true;
		}
		return false;
	}
	/**
	 * Adds a work station to the system
	 * @param stationNumber Work station number
	 * @param cat Part category of the work station
	 * @return True if added successfully
	 */
	protected boolean addWorkStation(int stationNumber, E_PartCategory cat) {
		//TODO Complete this method
		if (workStations.containsKey(stationNumber))
			return false;
		WorkStation ws = new WorkStation(stationNumber, cat);
		workStations.put(stationNumber, ws);
		return true;
	}
	/**
	 * Adds a new guard to the system
	 * @param id Guard id
	 * @param name Guard name
	 * @param country Country
	 * @param city City
	 * @param street Street name
	 * @param houseNumber House number
	 * @param zipCode Zip code
	 * @param birthday Date of birth
	 * @param employmentDate Employment date
	 * @param monthlySalary Monthly salary
	 * @param warehouseNumber Warehouse where he is working
	 * @return True if added successfully
	 */
	protected boolean addGuard(String id, String name, String country, String city, String street,
			int houseNumber, String zipCode, Calendar birthday, Calendar employmentDate,
			double monthlySalary, int warehouseNumber) {
		//TODO Complete this method
		if (employees.containsKey(id))
			return false;
		Address address = new Address(country, city, street, warehouseNumber, zipCode);
		Warehouse w = warehouses.get(warehouseNumber);
		if (w == null)
			return false;
		Guard g = new Guard(id, name, address, birthday, employmentDate, monthlySalary, w);
		employees.put(id, g);
		return true;
	}
	/**
	 * Adds a new shift manager
	 * @param id Shift manager id
	 * @param name Shift manager name
	 * @param country Country
	 * @param city City
	 * @param street Street name
	 * @param houseNumber House number
	 * @param zipCode Zip code
	 * @param birthday Date of birth
	 * @param employmentDate Employment date
	 * @param hourlyWage Wage per hour
	 * @param extraWage Extra wage added every month
	 * @return True if added successfully
	 */
	protected boolean addShiftManager(String id, String name, String country, String city, String street,
			int houseNumber, String zipCode, Calendar birthday, Calendar employmentDate,
			double hourlyWage, double extraWage) {
		if (employees.containsKey(id)) return false;
		Address address = new Address(country, city, street, houseNumber, zipCode);
		ShiftManager sm = new ShiftManager(id, name, address, birthday, employmentDate, hourlyWage, extraWage);
		employees.put(id, sm);
		return true;
	}
	/**
	 * Adds a new worker
	 * @param id Worker id
	 * @param name Worker name
	 * @param country Country
	 * @param city City
	 * @param street Street name
	 * @param houseNumber House number
	 * @param zipCode Zip code
	 * @param birthday Date of birth
	 * @param employmentDate Employment date
	 * @param hourlyWage Wage per hour
	 * @return True if added successfully
	 */
	protected boolean addWorker(String id, String name, String country, String city, String street,
			int houseNumber, String zipCode, Calendar birthday, Calendar employmentDate,
			double hourlyWage) {
		//TODO Complete this method
		if (employees.containsKey(id))
			return false;
		Address address = new Address(country, city, street, houseNumber, zipCode);
		Worker w = new Worker(id, name, address, birthday, employmentDate, hourlyWage);
		employees.put(id, w);
		return true;
	}
	/**
	 * Adds shift to the system
	 * @param startingTime Starting time
	 * @param ShiftManagerId Manager for this shift
	 * @return True if added successfully
	 */
	protected boolean addShift(Calendar startingTime, String ShiftManagerId) {
		//TODO Complete this method
		if (shifts.containsKey(startingTime))
			return false;
		AbstractEmployee sm = employees.get(ShiftManagerId);
		if (sm == null)
			return false;
		if (!(sm instanceof ShiftManager))
			return false;
		Shift s = new Shift(startingTime, (ShiftManager) sm);
		if (((ShiftManager) sm).addShift(s)) {
			shifts.put(startingTime, s);
			return true;
		}
		return false;
	}
	/**
	 * Add a slot
	 * You need to determine the shift according to the slot time
	 * @param startingTime
	 * @param productionPlanSerial
	 * @return True if added successfully
	 */
	protected boolean addSlot(Calendar startingTime, int productionPlanSerial) {
		//TODO Complete this method
		ProductionPlan pp = productionPlans.get(productionPlanSerial);
		if (pp == null)
			return false;
		if (pp.getSlots().containsKey(startingTime))
			return false;
		Shift sh = Queries.findShiftByTime(startingTime);
		if (sh == null)
			return false;
		if (sh.getSlots().containsKey(startingTime))
			return false;
		Slot sl = new Slot(startingTime, sh, pp);
		boolean flag = false;
		if (pp.addSlot(sl)) {
			flag = true;
			if (!sh.addSlot(sl)) {
				pp.removeSlot(sl);
				return false;
			}
		}
		return flag;
	}
	/**
	 * Remove a manufacturer from the system
	 * If this manufacturer has orders or there are part types that can be made by this manufacturer - don't remove it
	 * @param manufacturerName Manufacturer to remove
	 * @return True if removed successfully
	 */
	protected boolean removeManufacturer(String manufacturerName) {
		//TODO Complete this method
		Manufacturer m = manufacturers.get(manufacturerName);
		if (m == null)
			return false;
		for (Order<?, ?> ord : orders.values())
			if (ord.orderedFrom.equals(m) || ord.orderedTo.equals(m))
				return false;
		for (PartType pt : parts.values())
			if (pt.getManufacturers().contains(m))
				return false;
		manufacturers.remove(manufacturerName);
		return true;
	}
	/**
	 * Remove a warehouse from the system
	 * Only if it is empty and there are no guards
	 * @param warehouseNumber
	 * @return True if removed successfully
	 */
	protected boolean removeWarehouse(int warehouseNumber) {
		Warehouse w = warehouses.get(warehouseNumber);
		if (w == null) return false;
		for (AbstractEmployee e : employees.values())
			if (e instanceof Guard)
				if (((Guard)e).warehouse.equals(w)) return false;
		if (w.getParts().isEmpty() && w.getVehicles().isEmpty()) {
			warehouses.remove(warehouseNumber);
			return true;
		}
		return false;
	}
	/**
	 * Remove a production plan type
	 * Only if there are no Work stations, production plans and models
	 * @param serialNumber Serial number of the production plan type
	 * @return True if removed successfully
	 */
	protected boolean removeProductionPlanType(int serialNumber) {
		//TODO Complete this method
		ProductionPlanType ppt = productionPlanTypes.get(serialNumber);
		if (ppt == null)
			return false;
		if (ppt.getWorkStations().size() > 0)
			return false;
		for (ProductionPlan pp : productionPlans.values())
			if (pp.type.equals(ppt))
				return false;
		for (VehicleModel vm : models.values())
			if (vm.productionPlanType.equals(ppt))
				return false;
		productionPlanTypes.remove(serialNumber);
		return true;
	}
	/**
	 * Remove production plan
	 * Only if it has no vehicles and no slots
	 * @param serialNumber production plan serial number
	 * @return True if removed successfully
	 */
	protected boolean removeProductionPlan(int serialNumber) {
		//TODO Complete this method
		ProductionPlan pp = productionPlans.get(serialNumber);
		if (pp == null)
			return false;
		if (pp.getSlots().isEmpty() && pp.getVehicles().isEmpty()) {	//XXX is it good?
			productionPlans.remove(serialNumber);
			return true;
		}
		return false;
	}
	/**
	 * Remove a model
	 * Only if there are no vehicle of this model and no manufacturer can produce it
	 * @param name Name of the model
	 * @return True if removed successfully
	 */
	protected boolean removeVehicleModel(String name) {
		//TODO Complete this method
		VehicleModel vm = models.get(name);
		if (vm == null)
			return false;
		for (Vehicle v : vehicles.values())
			if (v.model.equals(vm))
				return false;
		for (Manufacturer m : manufacturers.values())
			if (m.getProducedModels().contains(vm))
				return false;
		models.remove(name);		//XXX remove(vm) -> WRONG
		return true;
	}
	/**
	 * Remove part type
	 * Only if it is not in any model, order and warehouse
	 * @param partNumber
	 * @return True if removed successfully
	 */
	protected boolean removePartType(int partNumber) {
		//TODO Complete this method
		PartType pt = parts.get(partNumber);
		if (pt == null)
			return false;
		for (VehicleModel vm : models.values())
			if (vm.getRequiredParts().containsKey(pt))
				return false;
		for (Order<?, ?> ord : orders.values())
			if (ord.getParts().containsKey(pt))
				return false;
		for (Warehouse w : warehouses.values())
			if (w.getParts().containsKey(pt))
				return false;
		parts.remove(partNumber);
		return true;
	}
	/**
	 * REmove order
	 * Only if it has no vehicle and no parts
	 * @param orderNumber
	 * @return True if removed successfully
	 */
	protected boolean removeOrder(int orderNumber) {
		Order<? ,?> o = orders.get(orderNumber);
		if (o == null) return false;
		if (o.getVehicles().isEmpty() && o.getParts().isEmpty()) {
			orders.remove(orderNumber);
			return true;
		}
		return false;
	}
	/**
	 * Remove a vehicle
	 * Only if it is not in any warehouse;
	 * You must also remove it from it's order or production plan
	 * @param vin
	 * @return True if removed successfully
	 */
	protected boolean removeVehicle(String vin) {
		//TODO Complete this method
		Vehicle v = vehicles.get(vin);
		if (v == null)
			return false;
		for (Warehouse w : warehouses.values())
			if (w.getVehicles().contains(v))
				return false;
		if (v.order == null)
			v.productionPlan.removeVehicle(v);
		if (v.productionPlan == null)
			v.order.removeVehicle(v);
		vehicles.remove(vin);
		return true;
	}
	/**
	 * Remove work station
	 * Only if no workers can work on it and it is not in any production plan type
	 * @param stationNumber
	 * @return True if removed successfully
	 */
	protected boolean removeWorkStation(int stationNumber) {
		//TODO Complete this method
		WorkStation ws = workStations.get(stationNumber);
		if (ws == null)
			return false;
		for (AbstractEmployee ae : employees.values())
			if (ae instanceof Worker && ((Worker) ae).getWorkStations().contains(ws))
				return false;
		for (ProductionPlanType ppt : productionPlanTypes.values())
			if (ppt.getWorkStations().contains(ws))
				return false;
		workStations.remove(stationNumber);		//XXX remove(ws) -> WRONG
		return true;
	}
	/**
	 * Remove an employee
	 * Needs to work for any sub-class
	 * If he has shifts (HourlyEmployee), don't remove it
	 * @param id
	 * @return True if removed successfully
	 */
	protected boolean removeEmployee(String id) {
		AbstractEmployee emp = employees.get(id);
		if (emp == null) return false;
		if (emp instanceof HourlyEmployee)
			if (!((HourlyEmployee)emp).getShifts().isEmpty())
				return false;
		employees.remove(id);
		return true;
	}
	/**
	 * Remove shift
	 * If a worker is working in this shift, don't remove it
	 * When removing a shift, don't forget to remove it from the shift manager, and remove all slots from production plans
	 * @param startingTime
	 * @return True if removed successfully
	 */
	protected boolean removeShift(Calendar startingTime) {
		//TODO Complete this method
		Shift sh = shifts.get(startingTime);
		if (sh == null)
			return false;
		for (AbstractEmployee ae : employees.values())
			if (ae instanceof Worker && ((Worker) ae).getShifts().contains(sh))
				return false;
		sh.shiftManager.removeShift(sh);
		for (Slot sl : sh.getSlots().values())
			sl.plan.removeSlot(sl);
		shifts.remove(startingTime);
		return true;
	}
}
