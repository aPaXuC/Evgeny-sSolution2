/**
 * Heart of the model module.
 * Gives access to the model functions
 * All model access is done through here.
 */
package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import utils.E_PartCategory;
import utils.E_VehicleType;

/**
 * @author Java spring 2017
 *
 */
public class ModelLogic {
	/** Singleton instance */
	private static ModelLogic instance;
	/** Instance of the system data */
	private SysData data;
	/**
	 * Model constructor
	 */
	private ModelLogic() {
		data = SysData.getInstance();
	}
	/**
	 * Singleton access method
	 * @return Singleton instance
	 */
	public static ModelLogic getInstance() {
		if (instance == null)
			instance = new ModelLogic();
		return instance;
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
	public boolean addManufacturer(String name, String country, String city, String street,
			int houseNumber, String zipCode, double profitPercentage) {
		//TODO Complete this method
		return data.addManufacturer(name, country, city, street, houseNumber, zipCode, profitPercentage);
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
	public boolean addWarehouse(int warehouseNumber, String country, String city, String street,
			int houseNumber, String zipCode, int maxPartsStored, int maxVehiclesStored) {
		//TODO Complete this method
		return data.addWarehouse(warehouseNumber, country, city, street, houseNumber, zipCode, maxPartsStored, maxVehiclesStored);
	}
	/**
	 * Adds production plan type to the system only if it doesn't exists yet
	 * @param serialNumber Production plan type serial number
	 * @param numberOfSlots Number of slots needed for this type
	 * @return True if added successfully
	 */
	public boolean addProductionPlanType(int serialNumber, int numberOfSlots) {
		//TODO Complete this method
		return data.addProductionPlanType(serialNumber, numberOfSlots);
	}
	/**
	 * Adds production plan to the system only if it doesn't exists yet
	 * Don't forget to retrieve the Production plan type 
	 * @param serialNumber Production plan serial number
	 * @param typeSerialNumber Production plan type serial number, this production plan will be of this type
	 * @return True if added successfully
	 */
	public boolean addProductionPlan(int serialNumber, int typeSerialNumber) {
		//TODO Complete this method
		return data.addProductionPlan(serialNumber, typeSerialNumber);
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
	public boolean addVehicleModel(int productionPlanTypeSerial, String modelName,
			E_VehicleType vehicleType, int hp, int topSpeed, int numOfSeats,
			boolean isAutomatic, double productionCost, Calendar enteredProduction) {
		//TODO Complete this method
		return data.addVehicleModel(productionPlanTypeSerial, modelName, vehicleType, hp, topSpeed, numOfSeats, isAutomatic, productionCost, enteredProduction);
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
	public boolean addPartType(int partNumber, String partName, E_PartCategory category, double productionCost) {
		//TODO Complete this method
		return data.addPartType(partNumber, partName, category, productionCost);
	}
	/**
	 * Adds order to the system only if it doesn't exists yet
	 * Don't forget to retrieve the manufacturer
	 * @param orderNumber Order number
	 * @param orderedFrom Generic ordering side
	 * @param orderedTo Generic receiving side
	 * @param dueDate When the order needs to be delivered
	 * @return True if added successfully
	 */
	public boolean addOrder(int orderNumber, String orderedFrom, String orderedTo, Calendar dueDate) {
		//TODO Complete this method
		return data.addOrder(orderNumber, orderedFrom, orderedTo, dueDate);
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
	public boolean addVehicle(String vin, String modelName, int productionPlanSerial, int orderNumber) {
		//TODO Complete this method
		return data.addVehicle(vin, modelName, productionPlanSerial, orderNumber);
	}
	/**
	 * Adds a work station to the system
	 * @param stationNumber Work station number
	 * @param cat Part category of the work station
	 * @return True if added successfully
	 */
	public boolean addWorkStation(int stationNumber, E_PartCategory cat) {
		//TODO Complete this method
		return data.addWorkStation(stationNumber, cat);
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
	public boolean addGuard(String id, String name, String country, String city, String street,
			int houseNumber, String zipCode, Calendar birthday, Calendar employmentDate,
			double monthlySalary, int warehouseNumber) {
		//TODO Complete this method
		return data.addGuard(id, name, country, city, street, houseNumber, zipCode, birthday, employmentDate, monthlySalary, warehouseNumber);
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
	public boolean addShiftManager(String id, String name, String country, String city, String street,
			int houseNumber, String zipCode, Calendar birthday, Calendar employmentDate,
			double hourlyWage, double extraWage) {
		//TODO Complete this method
		return data.addShiftManager(id, name, country, city, street, houseNumber, zipCode, birthday, employmentDate, hourlyWage, extraWage);
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
	public boolean addWorker(String id, String name, String country, String city, String street,
			int houseNumber, String zipCode, Calendar birthday, Calendar employmentDate,
			double hourlyWage) {
		//TODO Complete this method
		return data.addWorker(id, name, country, city, street, houseNumber, zipCode, birthday, employmentDate, hourlyWage);
	}
	/**
	 * Adds shift to the system
	 * @param startingTime Starting time
	 * @param ShiftManagerId Manager for this shift
	 * @return True if added successfully
	 */
	public boolean addShift(Calendar startingTime, String ShiftManagerId) {
		//TODO Complete this method
		return data.addShift(startingTime, ShiftManagerId);
	}
	/**
	 * Add a slot
	 * You need to determine the shift according to the slot time
	 * @param startingTime
	 * @param productionPlanSerial
	 * @return True if added successfully
	 */
	public boolean addSlot(Calendar startingTime, int productionPlanSerial) {
		//TODO Complete this method
		return data.addSlot(startingTime, productionPlanSerial);
	}
	/**
	 * Remove a manufacturer from the system
	 * If this manufacturer has orders or there are part types that can be made by this manufacturer - don't remove it
	 * @param manufacturerName Manufacturer to remove
	 * @return True if removed successfully
	 */
	public boolean removeManufacturer(String manufacturerName) {
		//TODO Complete this method
		return data.removeManufacturer(manufacturerName);
	}
	/**
	 * Remove a warehouse from the system
	 * Only if it is empty and there are no guards
	 * @param warehouseNumber
	 * @return True if removed successfully
	 */
	public boolean removeWarehouse(int warehouseNumber) {
		//TODO Complete this method
		return data.removeWarehouse(warehouseNumber);
	}
	/**
	 * Remove a production plan type
	 * Only if there are no Work stations, production plans and models
	 * @param serialNumber Serial number of the production plan type
	 * @return True if removed successfully
	 */
	public boolean removeProductionPlanType(int serialNumber) {
		//TODO Complete this method
		return data.removeProductionPlanType(serialNumber);
	}
	/**
	 * Remove production plan
	 * Only if it has no vehicles and no slots
	 * @param serialNumber production plan serial number
	 * @return True if removed successfully
	 */
	public boolean removeProductionPlan(int serialNumber) {
		//TODO Complete this method
		return data.removeProductionPlan(serialNumber);
	}
	/**
	 * Remove a model
	 * Only if there are no vehicle of this model and no manufacturer can produce it
	 * @param name Name of the model
	 * @return True if removed successfully
	 */
	public boolean removeVehicleModel(String name) {
		//TODO Complete this method
		return data.removeVehicleModel(name);
	}
	/**
	 * Remove part type
	 * Only if it is not in any model, order and warehouse
	 * @param partNumber
	 * @return True if removed successfully
	 */
	public boolean removePartType(int partNumber) {
		//TODO Complete this method
		return data.removePartType(partNumber);
	}
	/**
	 * REmove order
	 * Only if it has no vehicle and no parts
	 * @param orderNumber
	 * @return True if removed successfully
	 */
	public boolean removeOrder(int orderNumber) {
		//TODO Complete this method
		return data.removeOrder(orderNumber);
	}
	/**
	 * Remove a vehicle
	 * Only if it is not in any warehouse;
	 * You must also remove it from it's order or production plan
	 * @param vin
	 * @return True if removed successfully
	 */
	public boolean removeVehicle(String vin) {
		//TODO Complete this method
		return data.removeVehicle(vin);
	}

	/**
	 * Remove work station
	 * Only if no workers can work on it and it is not in any production plan type
	 * @param stationNumber
	 * @return True if removed successfully
	 */
	public boolean removeWorkStation(int stationNumber) {
		//TODO Complete this method
		return data.removeWorkStation(stationNumber);
	}
	/**
	 * Remove an employee
	 * Needs to work for any sub-class
	 * If he has shifts (HourlyEmployee), don't remove it
	 * @param id
	 * @return True if removed successfully
	 */
	public boolean removeEmployee(String id) {
		//TODO Complete this method
		return data.removeEmployee(id);
	}
	/**
	 * Remove shift
	 * If a worker is working in this shift, don't remove it
	 * When removing a shift, don't forget to remove it from the shift manager, and remove all slots from production plans
	 * @param startingTime
	 * @return True if removed successfully
	 */
	public boolean removeShift(Calendar startingTime) {
		//TODO Complete this method
		return data.removeShift(startingTime);
	}
	/**
	 * Adds a model to a manufacturer's list of models it can produce
	 * @param modelName Model name
	 * @param manufacturerName Manufacturer name
	 * @return True if added successfully
	 */
	public boolean addModelToManufacturer(String modelName, String manufacturerName) {
		//TODO Complete this method
		VehicleModel vm = data.getModels().get(modelName);
		if (vm == null)
			return false;
		Manufacturer m = data.getManufacturers().get(manufacturerName);
		if (m == null)
			return false;
		return m.addProducedModel(vm);
	}
	/**
	 * Adds a part category to the manufacturer's list of categories from which it can produce parts
	 * @param manufacturerName Manufacturer name
	 * @param partCategory Part Category
	 * @return True if added successfully
	 * @see E_PartCategory
	 */
	public boolean addPartCategoryToManufacturer(String manufacturerName, E_PartCategory partCategory) {
		//TODO Complete this method
		Manufacturer m = data.getManufacturers().get(manufacturerName);
		if (m == null)
			return false;
		return m.addProducedPartType(partCategory);
	}
	/**
	 * Adds a vehicle to a warehouse
	 * @param vin Vehicle identification number
	 * @param warehouseNumber Warehouse number
	 * @return True if added successfully
	 */
	public boolean addVehicleToWarehouse(String vin, int warehouseNumber) {
		//TODO Complete this method
		Vehicle v = data.getVehicles().get(vin);
		if (v == null)
			return false;
		Warehouse w = data.getWarehouses().get(warehouseNumber);
		if (w == null)
			return false;
		return w.addVehicle(v);
	}
	/**
	 * Adds part type to a warehouse
	 * @param partNumber Part type number
	 * @param amount Number of parts
	 * @param warehouseNumber Warehouse number
	 * @return True if added successfully
	 */
	public boolean addPartTypeToWarehouse(int partNumber, int amount, int warehouseNumber) {
		//TODO Complete this method
		PartType pt = data.getParts().get(partNumber);
		if (pt == null)
			return false;
		Warehouse w = data.getWarehouses().get(warehouseNumber);
		if (w == null)
			return false;
		return w.addPartType(pt, amount);
	}
	/**
	 * Adds part type to a model
	 * @param partNumber Part type number
	 * @param amount Number of parts
	 * @param modelName Model name
	 * @return True if added successfully
	 */
	public boolean addPartToModel(int partNumber, int amount, String modelName) {
		//TODO Complete this method
		PartType pt = data.getParts().get(partNumber);
		if (pt == null)
			return false;
		VehicleModel vm = data.getModels().get(modelName);
		if (vm == null)
			return false;
		return vm.addPartType(pt, amount);
	}
	/**
	 * Adds a manufacturer to the list of manufacturers capable of manufacturing this part type
	 * @param partNumber Part type number
	 * @param manufacturerName Manufacturer name
	 * @return True if added successfully
	 */
	public boolean addManufacturerToPart(int partNumber, String manufacturerName) {
		//TODO Complete this method
		PartType pt = data.getParts().get(partNumber);
		if (pt == null)
			return false;
		Manufacturer m = data.getManufacturers().get(manufacturerName);
		if (m == null)
			return false;
		return pt.addManufacturer(m);
	}
	/**
	 * Adds part type to an order
	 * @param orderNumber Order number
	 * @param partNumber Part number
	 * @param amount Amount to add
	 * @return True if added successfully
	 */
	public boolean addPartTypeToOrder(int orderNumber, int partNumber, int amount) {
		//TODO Complete this method
		Order<?, ?> ord = data.getOrders().get(orderNumber);
		if (ord == null)
			return false;
		PartType pt = data.getParts().get(partNumber);
		if (pt == null)
			return false;
		return ord.addPart(pt, amount);
	}
	/**
	 * Add a work station to a production plan type
	 * @param stationNumber
	 * @param productionSerial
	 * @param pos The position in the production line where we want the station to be added
	 * @return True if added successfully
	 */
	public boolean addWorkStationToProductionPlanType(int stationNumber, int productionSerial, int pos) {
		//TODO Complete this method
		WorkStation ws = data.getWorkStations().get(stationNumber);
		if (ws == null)
			return false;
		ProductionPlanType ppt = data.getProductionPlanTypes().get(productionSerial);
		if (ppt == null)
			return false;
		return ppt.addWorkStation(ws, pos);
	}
	/**
	 * Adds a work station to an employee
	 * @param stationNumber
	 * @param employeeId
	 * @return True if added successfully
	 */
	public boolean addWorkStationToWorker(int stationNumber, String employeeId) {
		//TODO Complete this method
		WorkStation ws = data.getWorkStations().get(stationNumber);
		if (ws == null)
			return false;
		AbstractEmployee ae = data.getEmployees().get(employeeId);
		if (!(ae instanceof Worker))
			return false;
		return ((Worker)ae).addWorkStation(ws);
	}
	/**
	 * Add a shift for a worker
	 * @param startingTime
	 * @param employeeId
	 * @return True if added successfully
	 */
	public boolean addShiftToWorker(Calendar startingTime, String employeeId) {
		//TODO Complete this method
		Shift sh = data.getShifts().get(startingTime);
		if (sh == null)
			return false;
		AbstractEmployee ae = data.getEmployees().get(employeeId);
		if (!(ae instanceof Worker))
			return false;
		return ((Worker)ae).addShift(sh);
	}
	/**
	 * Removes a model from a manufacturer's list of models it can produce
	 * @param modelName Model name
	 * @param manufacturerName Manufacturer name
	 * @return True if removed successfully
	 */
	public boolean removeModelFromManufacturer(String modelName, String manufacturerName) {
		//TODO Complete this method
		VehicleModel vm = data.getModels().get(modelName);
		if (vm == null)
			return false;
		Manufacturer m = data.getManufacturers().get(manufacturerName);
		if (m == null)
			return false;
		return m.removeProducedModel(vm);
	}
	/**
	 * Removes a part category from the manufacturer's list of categories from which it can produce parts
	 * @param manufacturerName Manufacturer name
	 * @param partCategory Part Category
	 * @return True if removed successfully
	 * @see E_PartCategory
	 */
	public boolean removePartCategoryFromManufacturer(String manufacturerName, E_PartCategory partCategory) {
		//TODO Complete this method
		Manufacturer m = data.getManufacturers().get(manufacturerName);
		if (m == null)
			return false;
		return m.removeProducedPartType(partCategory);
	}
	/**
	 * Removes a vehicle from a warehouse
	 * @param vin Vehicle identification number
	 * @param warehouseNumber Warehouse number
	 * @return True if removed successfully
	 */
	public boolean removeVehicleFromWarehouse(String vin, int warehouseNumber) {
		//TODO Complete this method
		Vehicle v = data.getVehicles().get(vin);
		if (v == null)
			return false;
		Warehouse w = data.getWarehouses().get(warehouseNumber);
		if (w == null)
			return false;
		return w.removeVehicle(v);
	}
	/**
	 * Removes part type from a warehouse
	 * @param partNumber Part type number
	 * @param amount Number of parts
	 * @param warehouseNumber Warehouse number
	 * @return True if removed successfully
	 */
	public boolean removePartTypeFromWarehouse(int partNumber, int amount, int warehouseNumber) {
		//TODO Complete this method
		PartType pt = data.getParts().get(partNumber);
		if (pt == null)
			return false;
		Warehouse w = data.getWarehouses().get(warehouseNumber);
		if (w == null)
			return false;
		return w.removePartType(pt, amount);
	}
	/**
	 * Removes part type from a model
	 * @param partNumber Part type number
	 * @param amount Number of parts
	 * @param modelName Model name
	 * @return True if removed successfully
	 */
	public boolean removePartFromModel(int partNumber, int amount, String modelName) {
		//TODO Complete this method
		PartType pt = data.getParts().get(partNumber);
		if (pt == null)
			return false;
		VehicleModel vm = data.getModels().get(modelName);
		if (vm == null)
			return false;
		return vm.removePartType(pt, amount);
	}
	/**
	 * Removes a manufacturer from the list of manufacturers capable of manufacturing this part type
	 * @param partNumber Part type number
	 * @param manufacturerName Manufacturer name
	 * @return True if added successfully
	 */
	public boolean removeManufacturerFromPart(int partNumber, String manufacturerName) {
		//TODO Complete this method
		PartType pt = data.getParts().get(partNumber);
		if (pt == null)
			return false;
		Manufacturer m = data.getManufacturers().get(manufacturerName);
		if (m == null)
			return false;
		return pt.removeManufacturer(m);
	}
	/**
	 * Removes part type from an order
	 * @param orderNumber Order number
	 * @param partNumber Part number
	 * @param amount Amount to add
	 * @return True if removed successfully
	 */
	public boolean removePartTypeFromOrder(int orderNumber, int partNumber, int amount) {
		//TODO Complete this method
		Order<?, ?> ord = data.getOrders().get(orderNumber);
		if (ord == null)
			return false;
		PartType pt = data.getParts().get(partNumber);
		if (pt == null)
			return false;
		return ord.removePart(pt, amount);
	}
	/**
	 * Remove a work station from a production plan type
	 * @param stationNumber
	 * @param productionSerial
	 * @return True if added successfully
	 */
	public boolean removeWorkStationFromProductionPlanType(int stationNumber, int productionSerial) {
		//TODO Complete this method
		WorkStation ws = data.getWorkStations().get(stationNumber);
		if (ws == null)
			return false;
		ProductionPlanType ppt = data.getProductionPlanTypes().get(productionSerial);
		if (ppt == null)
			return false;
		return ppt.removeWorkStation(ws);
	}
	/**
	 * Remove a work station from an employee
	 * @param stationNumber
	 * @param employeeId
	 * @return True if removed successfully
	 */
	public boolean removeWorkStationFromWorker(int stationNumber, String employeeId) {
		//TODO Complete this method
		WorkStation ws = data.getWorkStations().get(stationNumber);
		if (ws == null)
			return false;
		AbstractEmployee ae = data.getEmployees().get(employeeId);
		if (!(ae instanceof Worker))
			return false;
		return ((Worker)ae).removeWorkStation(ws);
	}
	/**
	 * Remove a shift for a worker
	 * @param startingTime
	 * @param employeeId
	 * @return True if added successfully
	 */
	public boolean removeShiftFromWorker(Calendar startingTime, String employeeId) {
		//TODO Complete this method
		Shift sh = data.getShifts().get(startingTime);
		if (sh == null)
			return false;
		AbstractEmployee ae = data.getEmployees().get(employeeId);
		if (!(ae instanceof Worker))
			return false;
		return ((Worker)ae).removeShift(sh);
	}
	/**
	 * List of all the warehouses located in the same country as this manufacturer
	 * @param manufacturerName Manufacturer name
	 * @return The list
	 */
	public List<Warehouse> getAllWarehousesInManufacturerCountry(String manufacturerName) {
		//TODO Complete this method
		ArrayList<Warehouse> result = new ArrayList<>();
		for (Warehouse w : Queries.getAllWarehousesInManufacturerCountry(manufacturerName))
			result.add((Warehouse)w.clone());
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
	public Vehicle findVehicleInCity(String country, String city, String model) {
		//TODO Complete this method
		return (Vehicle) Queries.findVehicleInCity(country, city, model).clone();
	}
	/**
	 * Get the most profitable manufacturer
	 * Total all orders from this manufacturer minus all orders to him
	 * @return Most profitable manufacturer
	 */
	public Manufacturer getMostProfitableManufacturer() {
		//TODO Complete this method
		return (Manufacturer) Queries.getMostProfitableManufacturer().clone();
	}
	/**
	 * Find which parts are not in stock for a production plan
	 * Find parts needed for vehicle in this plan that cannot be found in any warehouse
	 * For each part type, calculate the amount missing
	 * @param plan Production plan name
	 * @return List of parts not in stock
	 */
	public Map<PartType, Integer> getMissingPartsForProductionPlan(int plan) {
		//TODO Complete this method
		HashMap<PartType, Integer> result = new HashMap<>();
		for (Entry<PartType, Integer> entry : Queries.getMissingPartsForProductionPlan(plan).entrySet())
			result.put((PartType) entry.getKey().clone(), entry.getValue());
		return result;
	}
	/**
	 * Get the last date a vehicle from this model is expected to be produced
	 * Vehicles are expected in production plans and orders from a manufacturer
	 * @param model Model name
	 * @return Calendar of the last time a vehicle will be produced
	 */
	public Calendar getLastFutureProductionOfModel(String model) {
		//TODO Complete this method
		return (Calendar) Queries.getLastFutureProductionOfModel(model).clone();
	}
	/**
	 * Find the shift during this time 
	 * @param time The time given
	 * @return The shift, null if there is no shift in this time
	 */
	public Shift findShiftByTime(Calendar time) {
		//TODO Complete this method
		return (Shift) Queries.findShiftByTime(time).clone();
	}
	/**
	 * Order all shift by the number of production plan types
	 * @return Set of shifts
	 */
	public List<Shift> getAllShiftsOrderedByNumberOfProductionPlanTypes() {
		//TODO Complete this method
		ArrayList<Shift> result = new ArrayList<>();
		for (Shift sh : Queries.getAllShiftsOrderedByNumberOfProductionPlanTypes())
			result.add((Shift) sh.clone());
		return result;
	}
	/**
	 * Get the K models with the smallest amount of vehicles in the system
	 * @param k
	 * @return List of K models
	 */
	public List<VehicleModel> getKModelsWithLeastVehicles(int k) {
		//TODO Complete this method
		ArrayList<VehicleModel> result = new ArrayList<>();
		for (VehicleModel vm : Queries.getKModelsWithLeastVehicles(k))
			result.add((VehicleModel) vm.clone());
		return result;
	}
	/**
	 * Get all orders, for each orders count the amount of parts.
	 * Remember: each part has an amount
	 * @return Map of orders
	 */
	public Map<Order<? ,?>, Integer> getNumberOfPartsForEachOrder() {
		//TODO Complete this method
		HashMap<Order<?, ?>, Integer> result = new HashMap<>();
		for (Entry<Order<?, ?>, Integer> entry : Queries.getNumberOfPartsForEachOrder().entrySet())
			result.put((Order<?, ?>) entry.getKey().clone(), entry.getValue());
		return result;
	}
	/**
	 * Get all the employees ordered by type (class simple name) and then by id
	 * Note: this is employees natural order
	 * @return Set of employees
	 */
	public List<AbstractEmployee> getAllEmployeesOrderedByTypeAndById() {
		//TODO Complete this method
		ArrayList<AbstractEmployee> result = new ArrayList<>();
		for (AbstractEmployee ae : Queries.getAllEmployeesOrderedByTypeAndById())
			result.add((AbstractEmployee) ae.clone());
		return result;
	}
	/**
	 * Get all employees ordered by salary in given month
	 * Order can be minimum to maximum or in reverse
	 * @param month Month for salary calculations
	 * @param dir Direction of order. True for max to min, false for min to max
	 * @return Set of employees
	 */
	public List<AbstractEmployee> getAllEmployeesOrderedBySalaryInMonth(Calendar month, boolean dir) {
		//TODO Complete this method
		ArrayList<AbstractEmployee> result = new ArrayList<>();
		for (AbstractEmployee ae : Queries.getAllEmployeesOrderedBySalaryInMonth(month, dir))
			result.add((AbstractEmployee) ae.clone());
		return result;
	}
	/**
	 * Get all production plan types ordered by number of slots
	 * @return Set of production plan types
	 */
	public List<ProductionPlanType> getProductionPlanTypesOrderedByNumberOfSlots() {
		//TODO Complete this method
		ArrayList<ProductionPlanType> result = new ArrayList<>();
		for (ProductionPlanType ppt : Queries.getProductionPlanTypesOrderedByNumberOfSlots())
			result.add((ProductionPlanType) ppt.clone());
		return result;
	}
	/**
	 * Get all hourly employees
	 * For each employee get all shifts
	 * For each shift get all slots 
	 * @return Map of employees, value is map of shift and collection of slots
	 */
	public Map<HourlyEmployee, Map<Shift, Collection<Slot>>> getAllHourlyEmployeesWithShiftsAndSlots() {
		//TODO Complete this method
		HashMap<HourlyEmployee, Map<Shift, Collection<Slot>>> result = new HashMap<>();
		for (Entry<HourlyEmployee, HashMap<Shift, Collection<Slot>>> entry : Queries.getAllHourlyEmployeesWithShiftsAndSlots().entrySet()) {
			HashMap<Shift, Collection<Slot>> res = new HashMap<>();
			for (Entry<Shift, Collection<Slot>> entry1 : entry.getValue().entrySet()) {
				ArrayList<Slot> slots = new ArrayList<>();
				for (Slot s : entry1.getValue())
					slots.add((Slot) s.clone());
				res.put((Shift) entry1.getKey().clone(), slots);
			}
			result.put((HourlyEmployee) entry.getKey().clone(), res);
		}
		return result;
	}
	/**
     * Get part types' quantity from all orders, return only part types that exist in an order (quantity > 0).
     * Remember: each part has an amount
     * @return Map of PartTypes
     */
    public Map<PartType, Integer> getPartsQuantityInAllOrders() {
    	//TODO Complete this method
    	HashMap<PartType, Integer> result = new HashMap<>();
    	for (Entry<PartType, Integer> entry : Queries.getPartsQuantityInAllOrders().entrySet())
    		result.put((PartType) entry.getKey().clone(), entry.getValue());
    	return result;
    }
}
