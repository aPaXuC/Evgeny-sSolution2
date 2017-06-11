/**
 * Heart of the controller module
 * Gives access to the model
 */
package controller;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import utils.E_PartCategory;
import utils.E_VehicleType;
import utils.MyFileLogWriter;
import model.AbstractEmployee;
import model.HourlyEmployee;
import model.Manufacturer;
import model.ModelLogic;
import model.Order;
import model.PartType;
import model.ProductionPlanType;
import model.Shift;
import model.Slot;
import model.Vehicle;
import model.VehicleModel;
import model.Warehouse;

/**
 * @author Java spring 2017
 *
 */
public class ControllerLogic {
	/** Singleton instance */
	private static ControllerLogic instance;
	/** ModelLogic instance */
	private ModelLogic model;
	
	/**
	 * Controller logic constructor 
	 */
	private ControllerLogic() {
		model = ModelLogic.getInstance();
		MyFileLogWriter.initializeMyFileWriter();
	}
	/**
	 * Retrieves the singleton instance of ControllerLogic
	 * @return Singleton instance
	 */
	public static ControllerLogic getInstance() {
		if (instance == null)
			instance = new ControllerLogic();
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
		boolean flag = model.addManufacturer(name, country, city, street, houseNumber, zipCode, profitPercentage);
		if (flag)
			MyFileLogWriter.writeToLogFile("Manufacturer added: " + name, true);
		else
			MyFileLogWriter.writeToLogFile("Manufacturer wasn't added", true);
		return flag;
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
		boolean flag = model.addWarehouse(warehouseNumber, country, city, street, houseNumber, zipCode, maxPartsStored, maxVehiclesStored);
		if (flag)
			MyFileLogWriter.writeToLogFile("Warehouse added: " + warehouseNumber, true);
		else
			MyFileLogWriter.writeToLogFile("Warehouse wasn't added", true);
		return flag;
	}
	/**
	 * Adds production plan type to the system only if it doesn't exists yet
	 * @param serialNumber Production plan type serial number
	 * @param numberOfSlots Number of slots
	 * @return True if added successfully
	 */
	public boolean addProductionPlanType(int serialNumber, int numberOfSlots) {
		boolean flag = model.addProductionPlanType(serialNumber, numberOfSlots);
		if (flag)
			MyFileLogWriter.writeToLogFile("Production plan type added: " + serialNumber, true);
		else
			MyFileLogWriter.writeToLogFile("Production plan type wasn't added", true);
		return flag;
	}
	/**
	 * Adds production plan to the system only if it doesn't exists yet
	 * Don't forget to retrieve the Production plan type 
	 * @param serialNumber Production plan serial number
	 * @param typeSerialNumber Production plan type serial number, this production plan will be of this type
	 * @return True if added successfully
	 */
	public boolean addProductionPlan(int serialNumber, int typeSerialNumber) {
		boolean flag = model.addProductionPlan(serialNumber, typeSerialNumber);
		if (flag)
			MyFileLogWriter.writeToLogFile("Production plan added: " + serialNumber, true);
		else
			MyFileLogWriter.writeToLogFile("Production plan wasn't added", true);
		return flag;
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
		boolean flag = model.addVehicleModel(productionPlanTypeSerial, modelName, vehicleType, hp, topSpeed, numOfSeats, isAutomatic, productionCost, enteredProduction);
		if (flag)
			MyFileLogWriter.writeToLogFile("Vehicle model added: " + modelName, true);
		else
			MyFileLogWriter.writeToLogFile("Vehicle model wasn't added", true);
		return flag;
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
		boolean flag = model.addPartType(partNumber, partName, category, productionCost);
		if (flag)
			MyFileLogWriter.writeToLogFile("Part type added: " + partNumber, true);
		else
			MyFileLogWriter.writeToLogFile("Part type wasn't added", true);
		return flag;
	}
	/**
	 * Adds order to the system only if it doesn't exists yet
	 * Don't forget to retrieve the manufacturer
	 * @param orderNumber Order number
	 * @param orderedFrom Ordering side
	 * @param orderedTo receiving side
	 * @param dueDate When the order needs to be delivered
	 * @return True if added successfully
	 */
	public boolean addOrder(int orderNumber, String orderedFrom, String orderedTo, Calendar dueDate) {
		boolean flag = model.addOrder(orderNumber, orderedFrom, orderedTo, dueDate);
		if (flag)
			MyFileLogWriter.writeToLogFile("Order added: " + orderNumber, true);
		else
			MyFileLogWriter.writeToLogFile("Order wasn't added", true);
		return flag;
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
		boolean flag = model.addVehicle(vin, modelName, productionPlanSerial, orderNumber);
		if (flag)
			MyFileLogWriter.writeToLogFile("Vehicle added: " + vin, true);
		else
			MyFileLogWriter.writeToLogFile("Vehicle wasn't added", true);
		return flag;
	}
	/**
	 * Adds a work station to the system
	 * @param stationNumber Work station number
	 * @param cat Part category of the work station
	 * @return True if added successfully
	 */
	public boolean addWorkStation(int stationNumber, E_PartCategory cat) {
		boolean flag = model.addWorkStation(stationNumber, cat);
		if (flag)
			MyFileLogWriter.writeToLogFile("Work station added: " + stationNumber, true);
		else
			MyFileLogWriter.writeToLogFile("Work station wasn't added", true);
		return flag;
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
		boolean flag = model.addGuard(id, name, country, city, street, houseNumber, zipCode, birthday, employmentDate, monthlySalary, warehouseNumber);
		if (flag)
			MyFileLogWriter.writeToLogFile("Guard added: " + id, true);
		else
			MyFileLogWriter.writeToLogFile("Guard wasn't added", true);
		return flag;
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
		boolean flag = model.addShiftManager(id, name, country, city, street, houseNumber, zipCode, birthday, employmentDate, hourlyWage, extraWage);
		if (flag)
			MyFileLogWriter.writeToLogFile("Shift manager added: " + id, true);
		else
			MyFileLogWriter.writeToLogFile("Shift manager wasn't added", true);
		return flag;
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
		boolean flag = model.addWorker(id, name, country, city, street, houseNumber, zipCode, birthday, employmentDate, hourlyWage);
		if (flag)
			MyFileLogWriter.writeToLogFile("Worker added: " + id, true);
		else
			MyFileLogWriter.writeToLogFile("Worker wasn't added", true);
		return flag;
	}
	/**
	 * Adds shift to the system
	 * @param startingTime Starting time
	 * @param ShiftManagerId Manager for this shift
	 * @return True if added successfully
	 */
	public boolean addShift(Calendar startingTime, String ShiftManagerId) {
		boolean flag = model.addShift(startingTime, ShiftManagerId);
		if (flag)
			MyFileLogWriter.writeToLogFile("Shift added: " + startingTime.getTime().toString(), true);
		else
			MyFileLogWriter.writeToLogFile("Shift wasn't added", true);
		return flag;
	}
	/**
	 * Add a slot
	 * You need to determine the shift according to the slot time
	 * @param startingTime
	 * @param productionPlanSerial
	 * @return True if added successfully
	 */
	public boolean addSlot(Calendar startingTime, int productionPlanSerial) {
		boolean flag = model.addSlot(startingTime, productionPlanSerial);
		if (flag)
			MyFileLogWriter.writeToLogFile("Slot added: " + startingTime.getTime().toString(), true);
		else
			MyFileLogWriter.writeToLogFile("Slot wasn't added", true);
		return flag;
	}
	/**
	 * Remove a manufacturer from the system
	 * If this manufacturer has orders or there are part types that can be made by this manufacturer - don't remove it
	 * @param manufacturerName Manufacturer to remove
	 * @return True if removed successfully
	 */
	public boolean removeManufacturer(String manufacturerName) {
		boolean flag = model.removeManufacturer(manufacturerName);
		if (flag)
			MyFileLogWriter.writeToLogFile("Manufacturer removed: " + manufacturerName, true);
		else
			MyFileLogWriter.writeToLogFile("Manufacturer wasn't removed", true);
		return flag;
	}
	/**
	 * Remove a warehouse from the system
	 * Only if it is empty and there are no guards
	 * @param warehouseNumber
	 * @return True if removed successfully
	 */
	public boolean removeWarehouse(int warehouseNumber) {
		boolean flag = model.removeWarehouse(warehouseNumber);
		if (flag)
			MyFileLogWriter.writeToLogFile("Warehouse removed: " + warehouseNumber, true);
		else
			MyFileLogWriter.writeToLogFile("Warehouse wasn't removed", true);
		return flag;
	}
	/**
	 * Remove a production plan type
	 * Only if there are no Work stations, production plans and models
	 * @param serialNumber Serial number of the production plan type
	 * @return True if removed successfully
	 */
	public boolean removeProductionPlanType(int serialNumber) {
		boolean flag = model.removeProductionPlanType(serialNumber);
		if (flag)
			MyFileLogWriter.writeToLogFile("Production plan type removed: " + serialNumber, true);
		else
			MyFileLogWriter.writeToLogFile("Production plan type wasn't removed", true);
		return flag;
	}
	/**
	 * Remove production plan
	 * Only if it has no vehicles and no slots
	 * @param serialNumber production plan serial number
	 * @return True if removed successfully
	 */
	public boolean removeProductionPlan(int serialNumber) {
		boolean flag = model.removeProductionPlan(serialNumber);
		if (flag)
			MyFileLogWriter.writeToLogFile("Production plan removed: " + serialNumber, true);
		else
			MyFileLogWriter.writeToLogFile("Production plan wasn't removed", true);
		return flag;
	}
	/**
	 * Remove a model
	 * Only if there are no vehicle of this model and no manufacturer can produce it
	 * @param name Name of the model
	 * @return True if removed successfully
	 */
	public boolean removeVehicleModel(String name) {
		boolean flag = model.removeVehicleModel(name);
		if (flag)
			MyFileLogWriter.writeToLogFile("Vehicle model removed: " + name, true);
		else
			MyFileLogWriter.writeToLogFile("Vehicle model wasn't removed", true);
		return flag;
	}
	/**
	 * Remove part type
	 * Only if it is not in any model, order and warehouse
	 * @param partNumber
	 * @return True if removed successfully
	 */
	public boolean removePartType(int partNumber) {
		boolean flag = model.removePartType(partNumber);
		if (flag)
			MyFileLogWriter.writeToLogFile("Part type removed: " + partNumber, true);
		else
			MyFileLogWriter.writeToLogFile("Part type wasn't removed", true);
		return flag;
	}
	/**
	 * REmove order
	 * Only if it has no vehicle and no parts
	 * @param orderNumber
	 * @return True if removed successfully
	 */
	public boolean removeOrder(int orderNumber) {
		boolean flag = model.removeOrder(orderNumber);
		if (flag)
			MyFileLogWriter.writeToLogFile("Order removed: " + orderNumber, true);
		else
			MyFileLogWriter.writeToLogFile("Order wasn't removed", true);
		return flag;
	}
	/**
	 * Remove a vehicle
	 * Only if it is not in any warehouse;
	 * You must also remove it from it's order or production plan
	 * @param vin
	 * @return True if removed successfully
	 */
	public boolean removeVehicle(String vin) {
		boolean flag = model.removeVehicle(vin);
		if (flag)
			MyFileLogWriter.writeToLogFile("Vehicle removed: " + vin, true);
		else
			MyFileLogWriter.writeToLogFile("Vehicle wasn't removed", true);
		return flag;
	}

	/**
	 * Remove work station
	 * Only if no workers can work on it and it is not in any production plan type
	 * @param stationNumber
	 * @return True if removed successfully
	 */
	public boolean removeWorkStation(int stationNumber) {
		boolean flag = model.removeWorkStation(stationNumber);
		if (flag)
			MyFileLogWriter.writeToLogFile("Work station removed: " + stationNumber, true);
		else
			MyFileLogWriter.writeToLogFile("Work station wasn't removed", true);
		return flag;
	}
	/**
	 * Remove an employee
	 * Needs to work for any sub-class
	 * If he has shifts (HourlyEmployee), don't remove it
	 * @param id
	 * @return True if removed successfully
	 */
	public boolean removeEmployee(String id) {
		boolean flag = model.removeEmployee(id);
		if (flag)
			MyFileLogWriter.writeToLogFile("Employee removed: " + id, true);
		else
			MyFileLogWriter.writeToLogFile("Employee wasn't removed", true);
		return flag;
	}
	/**
	 * Remove shift
	 * If a worker is working in this shift, don't remove it
	 * When removing a shift, don't forget to remove it from the shift manager, and remove all slots from production plans
	 * @param startingTime
	 * @return True if removed successfully
	 */
	public boolean removeShift(Calendar startingTime) {
		boolean flag = model.removeShift(startingTime);
		if (flag)
			MyFileLogWriter.writeToLogFile("Shift removed: " + startingTime.getTime().toString(), true);
		else
			MyFileLogWriter.writeToLogFile("Shift wasn't removed", true);
		return flag;
	}
	/**
	 * Adds a model to a manufacturer's list of models it can produce
	 * @param modelName Model name
	 * @param manufacturerName Manufacturer name
	 * @return True if added successfully
	 */
	public boolean addModelToManufacturer(String modelName, String manufacturerName) {
		boolean flag = model.addModelToManufacturer(modelName, manufacturerName);
		if (flag)
			MyFileLogWriter.writeToLogFile("Model " + modelName + " added to manufacturer " + manufacturerName, true);
		else
			MyFileLogWriter.writeToLogFile("Model wasn't added to manufacturer", true);
		return flag;
	}
	/**
	 * Adds a part category to the manufacturer's list of categories from which it can produce parts
	 * @param manufacturerName Manufacturer name
	 * @param partCategory Part Category
	 * @return True if added successfully
	 * @see E_PartCategory
	 */
	public boolean addPartCategoryToManufacturer(String manufacturerName, E_PartCategory partCategory) {
		boolean flag = model.addPartCategoryToManufacturer(manufacturerName, partCategory);
		if (flag)
			MyFileLogWriter.writeToLogFile("Part category " + partCategory.toString() + " added to manufacturer " + manufacturerName, true);
		else
			MyFileLogWriter.writeToLogFile("Part category wasn't added to manufacturer", true);
		return flag;
	}
	/**
	 * Adds a vehicle to a warehouse
	 * @param vin Vehicle identification number
	 * @param warehouseNumber Warehouse number
	 * @return True if added successfully
	 */
	public boolean addVehicleToWarehouse(String vin, int warehouseNumber) {
		boolean flag = model.addVehicleToWarehouse(vin, warehouseNumber);
		if (flag)
			MyFileLogWriter.writeToLogFile("Vehicle " + vin + " added to warehouse " + warehouseNumber, true);
		else
			MyFileLogWriter.writeToLogFile("Vehicle wasn't added to warehouse", true);
		return flag;
	}
	/**
	 * Adds part type to a warehouse
	 * @param partNumber Part type number
	 * @param amount Number of parts
	 * @param warehouseNumber Warehouse number
	 * @return True if added successfully
	 */
	public boolean addPartTypeToWarehouse(int partNumber, int amount, int warehouseNumber) {
		boolean flag = model.addPartTypeToWarehouse(partNumber, amount, warehouseNumber);
		if (flag)
			MyFileLogWriter.writeToLogFile("Part " + partNumber + " added to warehouse " + warehouseNumber, true);
		else
			MyFileLogWriter.writeToLogFile("Part wasn't added to warehouse", true);
		return flag;
	}
	/**
	 * Adds part type to a model
	 * @param partNumber Part type number
	 * @param amount Number of parts
	 * @param modelName Model name
	 * @return True if added successfully
	 */
	public boolean addPartToModel(int partNumber, int amount, String modelName) {
		boolean flag = model.addPartToModel(partNumber, amount, modelName);
		if (flag)
			MyFileLogWriter.writeToLogFile("Part " + partNumber + " added to model " + modelName, true);
		else
			MyFileLogWriter.writeToLogFile("Part wasn't added to model", true);
		return flag;
	}
	/**
	 * Adds a manufacturer to the list of manufacturers capable of manufacturing this part type
	 * @param partNumber Part type number
	 * @param manufacturerName Manufacturer name
	 * @return True if added successfully
	 */
	public boolean addManufacturerToPart(int partNumber, String manufacturerName) {
		boolean flag = model.addManufacturerToPart(partNumber, manufacturerName);
		if (flag)
			MyFileLogWriter.writeToLogFile("Manufacturer " + manufacturerName + " added to part " + partNumber, true);
		else
			MyFileLogWriter.writeToLogFile("Manufacturer wasn't added to part", true);
		return flag;
	}
	/**
	 * Adds part type to an order
	 * @param orderNumber Order number
	 * @param partNumber Part number
	 * @param amount Amount to add
	 * @return True if added successfully
	 */
	public boolean addPartTypeToOrder(int orderNumber, int partNumber, int amount) {
		boolean flag = model.addPartTypeToOrder(orderNumber, partNumber, amount);
		if (flag)
			MyFileLogWriter.writeToLogFile("Part type " + partNumber + " added to order " + orderNumber, true);
		else
			MyFileLogWriter.writeToLogFile("Part type wasn't added to order", true);
		return flag;
	}
	/**
	 * Add a work station to a production plan type
	 * @param stationNumber
	 * @param productionSerial
	 * @param pos The position in the production line where we want the station to be added
	 * @return True if added successfully
	 */
	public boolean addWorkStationToProductionPlanType(int stationNumber, int productionSerial, int pos) {
		boolean flag = model.addWorkStationToProductionPlanType(stationNumber, productionSerial, pos);
		if (flag)
			MyFileLogWriter.writeToLogFile("Station " + stationNumber + " added to production plan type " + productionSerial, true);
		else
			MyFileLogWriter.writeToLogFile("Station wasn't added to production plan type", true);
		return flag;
	}
	/**
	 * Adds a work station to an employee
	 * @param stationNumber
	 * @param employeeId
	 * @return True if added successfully
	 */
	public boolean addWorkStationToWorker(int stationNumber, String employeeId) {
		boolean flag = model.addWorkStationToWorker(stationNumber, employeeId);
		if (flag)
			MyFileLogWriter.writeToLogFile("Station " + stationNumber + " added to worker " + employeeId, true);
		else
			MyFileLogWriter.writeToLogFile("Station wasn't added to worker", true);
		return flag;
	}
	/**
	 * Add a shift for a worker
	 * @param startingTime
	 * @param employeeId
	 * @return True if added successfully
	 */
	public boolean addShiftToWorker(Calendar startingTime, String employeeId) {
		boolean flag = model.addShiftToWorker(startingTime, employeeId);
		if (flag)
			MyFileLogWriter.writeToLogFile("Shift " + startingTime.getTime().toString() + " added to worker " + employeeId, true);
		else
			MyFileLogWriter.writeToLogFile("Shift wasn't added to worker", true);
		return flag;
	}
	/**
	 * Removes a model from a manufacturer's list of models it can produce
	 * @param modelName Model name
	 * @param manufacturerName Manufacturer name
	 * @return True if removed successfully
	 */
	public boolean removeModelFromManufacturer(String modelName, String manufacturerName) {
		boolean flag = model.removeModelFromManufacturer(modelName, manufacturerName);
		if (flag)
			MyFileLogWriter.writeToLogFile("Model " + modelName + " removed from manufacturer " + manufacturerName, true);
		else
			MyFileLogWriter.writeToLogFile("Model wasn't revemved from manufacturer", true);
		return flag;
	}
	/**
	 * Removes a part category from the manufacturer's list of categories from which it can produce parts
	 * @param manufacturerName Manufacturer name
	 * @param partCategory Part Category
	 * @return True if removed successfully
	 * @see E_PartCategory
	 */
	public boolean removePartCategoryFromManufacturer(String manufacturerName, E_PartCategory partCategory) {
		boolean flag = model.removePartCategoryFromManufacturer(manufacturerName, partCategory);
		if (flag)
			MyFileLogWriter.writeToLogFile("Part category " + partCategory.toString() + " removed from manufacturer " + manufacturerName, true);
		else
			MyFileLogWriter.writeToLogFile("Part category wasn't revemved from manufacturer", true);
		return flag;
	}
	/**
	 * Removes a vehicle from a warehouse
	 * @param vin Vehicle identification number
	 * @param warehouseNumber Warehouse number
	 * @return True if removed successfully
	 */
	public boolean removeVehicleFromWarehouse(String vin, int warehouseNumber) {
		boolean flag = model.removeVehicleFromWarehouse(vin, warehouseNumber);
		if (flag)
			MyFileLogWriter.writeToLogFile("Vehicle " + vin + " removed from warehouse " + warehouseNumber, true);
		else
			MyFileLogWriter.writeToLogFile("Vehicle wasn't revemved from warehouse", true);
		return flag;
	}
	/**
	 * Removes part type from a warehouse
	 * @param partNumber Part type number
	 * @param amount Number of parts
	 * @param warehouseNumber Warehouse number
	 * @return True if removed successfully
	 */
	public boolean removePartTypeFromWarehouse(int partNumber, int amount, int warehouseNumber) {
		boolean flag = model.removePartTypeFromWarehouse(partNumber, amount, warehouseNumber);
		if (flag)
			MyFileLogWriter.writeToLogFile("Part " + partNumber + " removed from warehouse " + warehouseNumber, true);
		else
			MyFileLogWriter.writeToLogFile("Part wasn't revemved from warehouse", true);
		return flag;
	}
	/**
	 * Removes part type from a model
	 * @param partNumber Part type number
	 * @param amount Number of parts
	 * @param modelName Model name
	 * @return True if removed successfully
	 */
	public boolean removePartFromModel(int partNumber, int amount, String modelName) {
		boolean flag = model.removePartFromModel(partNumber, amount, modelName);
		if (flag)
			MyFileLogWriter.writeToLogFile("Part " + partNumber + " removed from model " + modelName, true);
		else
			MyFileLogWriter.writeToLogFile("Part wasn't revemved from model", true);
		return flag;
	}
	/**
	 * Removes a manufacturer from the list of manufacturers capable of manufacturing this part type
	 * @param partNumber Part type number
	 * @param manufacturerName Manufacturer name
	 * @return True if added successfully
	 */
	public boolean removeManufacturerFromPart(int partNumber, String manufacturerName) {
		boolean flag = model.removeManufacturerFromPart(partNumber, manufacturerName);
		if (flag)
			MyFileLogWriter.writeToLogFile("Manufacturer " + manufacturerName + " removed from part " + partNumber, true);
		else
			MyFileLogWriter.writeToLogFile("Manufacturer wasn't revemved from part", true);
		return flag;
	}
	/**
	 * Removes part type from an order
	 * @param orderNumber Order number
	 * @param partNumber Part number
	 * @param amount Amount to add
	 * @return True if removed successfully
	 */
	public boolean removePartTypeFromOrder(int orderNumber, int partNumber, int amount) {
		boolean flag = model.removePartTypeFromOrder(orderNumber, partNumber, amount);
		if (flag)
			MyFileLogWriter.writeToLogFile("Part " + partNumber + " removed from order " + orderNumber, true);
		else
			MyFileLogWriter.writeToLogFile("Part wasn't revemved from order", true);
		return flag;
	}
	/**
	 * Remove a work station from a production plan type
	 * @param stationNumber
	 * @param productionSerial
	 * @return True if added successfully
	 */
	public boolean removeWorkStationFromProductionPlanType(int stationNumber, int productionSerial) {
		boolean flag = model.removeWorkStationFromProductionPlanType(stationNumber, productionSerial);
		if (flag)
			MyFileLogWriter.writeToLogFile("Station " + stationNumber + " removed from production plan type " + productionSerial, true);
		else
			MyFileLogWriter.writeToLogFile("Station wasn't revemved from production plan type", true);
		return flag;
	}
	/**
	 * Remove a work station from an employee
	 * @param stationNumber
	 * @param employeeId
	 * @return True if removed successfully
	 */
	public boolean removeWorkStationFromWorker(int stationNumber, String employeeId) {
		boolean flag = model.removeWorkStationFromWorker(stationNumber, employeeId);
		if (flag)
			MyFileLogWriter.writeToLogFile("Station " + stationNumber + " removed from worker " + employeeId, true);
		else
			MyFileLogWriter.writeToLogFile("Station wasn't revemved from worker", true);
		return flag;
	}
	/**
	 * Remove a shift for a worker
	 * @param startingTime
	 * @param employeeId
	 * @return True if removed successfully
	 */
	public boolean removeShiftFromWorker(Calendar startingTime, String employeeId) {
		boolean flag = model.removeShiftFromWorker(startingTime, employeeId);
		if (flag)
			MyFileLogWriter.writeToLogFile("Shift " + startingTime.getTime().toString() + " removed from worker " + employeeId, true);
		else
			MyFileLogWriter.writeToLogFile("Shift wasn't revemved from worker", true);
		return flag;
	}
	/**
	 * List of all the warehouses located in the same country as this manufacturer
	 * @param manufacturerName Manufacturer name
	 * @return The list
	 */
	public List<Warehouse> getAllWarehousesInManufacturerCountry(String manufacturerName) {
		List<Warehouse> l = model.getAllWarehousesInManufacturerCountry(manufacturerName);
		MyFileLogWriter.writeToLogFile("getAllWarehousesInManufacturerCountry", false);
		MyFileLogWriter.writeToLogFile(l.toString(), true);
		return l;
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
		Vehicle v = this.model.findVehicleInCity(country, city, model);
		MyFileLogWriter.writeToLogFile("findVehicleInCity", false);
		MyFileLogWriter.writeToLogFile(v.toString(), true);
		return v;
	}
	/**
	 * Get the most profitable manufacturer
	 * Total all orders from this manufacturer minus all orders to him
	 * @return Most profitable manufacturer
	 */
	public Manufacturer getMostProfitableManufacturer() {
		Manufacturer m = model.getMostProfitableManufacturer();
		MyFileLogWriter.writeToLogFile("getMostProfitableManufacturer", false);
		MyFileLogWriter.writeToLogFile(m.toString(), true);
		return m;
	}
	/**
	 * Find which parts are not in stock for a production plan
	 * Find parts needed for vehicle in this plan that cannot be found in any warehouse
	 * For each part type, calculate the amount missing
	 * @param plan Production plan name
	 * @return List of parts not in stock
	 */
	public Map<PartType, Integer> getMissingPartsForProductionPlan(int plan) {
		Map<PartType, Integer> m = model.getMissingPartsForProductionPlan(plan);
		MyFileLogWriter.writeToLogFile("getMissingPartsForProductionPlan", false);
		MyFileLogWriter.writeToLogFile(m.toString(), true);
		return m;
	}
	/**
	 * Get the last date a vehicle from this model is expected to be produced
	 * Vehicles are expected in production plans and orders from a manufacturer
	 * @param model Model name
	 * @return Calendar of the last time a vehicle will be produced
	 */
	public Calendar getLastFutureProductionOfModel(String model) {
		Calendar c = this.model.getLastFutureProductionOfModel(model);
		MyFileLogWriter.writeToLogFile("getLastFutureProductionOfModel", false);
		MyFileLogWriter.writeToLogFile(c.getTime().toString(), true);
		return c;
	}
	/**
	 * Find the shift during this time 
	 * @param time The time given
	 * @return The shift, null if there is no shift in this time
	 */
	public Shift findShiftByTime(Calendar time) {
		Shift s = model.findShiftByTime(time);
		MyFileLogWriter.writeToLogFile("findShiftByTime", false);
		MyFileLogWriter.writeToLogFile(s.toString(), true);
		return s;
	}
	/**
	 * Order all shift by the number of production plan types
	 * @return Set of shifts
	 */
	public List<Shift> getAllShiftsOrderedByNumberOfProductionPlanTypes() {
		List<Shift> l = model.getAllShiftsOrderedByNumberOfProductionPlanTypes();
		MyFileLogWriter.writeToLogFile("getAllShiftsOrderedByNumberOfProductionPlanTypes", false);
		MyFileLogWriter.writeToLogFile(l.toString(), true);
		return l;
	}
	/**
	 * Get the K models with the smallest amount of vehicles in the system
	 * @param k
	 * @return List of K models
	 */
	public List<VehicleModel> getKModelsWithLeastVehicles(int k) {
		List<VehicleModel> l = model.getKModelsWithLeastVehicles(k);
		MyFileLogWriter.writeToLogFile("getKModelsWithLeastVehicles", false);
		MyFileLogWriter.writeToLogFile(l.toString(), true);
		return l;
	}
	/**
	 * Get all orders, for each orders count the amount of parts.
	 * Remember: each part has an amount
	 * @return Map of orders
	 */
	public Map<Order<? ,?>, Integer> getNumberOfPartsForEachOrder() {
		Map<Order<? ,?>, Integer> m = model.getNumberOfPartsForEachOrder();
		MyFileLogWriter.writeToLogFile("getNumberOfPartsForEachOrder", false);
		MyFileLogWriter.writeToLogFile(m.toString(), true);
		return m;
	}
	/**
	 * Get all the employees ordered by type (class simple name) and then by id
	 * Note: this is employees natural order
	 * @return Set of employees
	 */
	public List<AbstractEmployee> getAllEmployeesOrderedByTypeAndById() {
		List<AbstractEmployee> l = model.getAllEmployeesOrderedByTypeAndById();
		MyFileLogWriter.writeToLogFile("getAllEmployeesOrderedByTypeAndById", false);
		MyFileLogWriter.writeToLogFile(l.toString(), true);
		return l;
	}
	/**
	 * Get all employees ordered by salary in given month
	 * Order can be minimum to maximum or in reverse
	 * @param month Month for salary calculations
	 * @param dir Direction of order. True for max to min, false for min to max
	 * @return Set of employees
	 */
	public List<AbstractEmployee> getAllEmployeesOrderedBySalaryInMonth(Calendar month, boolean dir) {
		List<AbstractEmployee> l = model.getAllEmployeesOrderedBySalaryInMonth(month, dir);
		MyFileLogWriter.writeToLogFile("getAllEmployeesOrderedBySalaryInMonth", false);
		MyFileLogWriter.writeToLogFile(l.toString(), true);
		return l;
	}
	/**
	 * Get all production plan types ordered by number of slots
	 * @return Set of production plan types
	 */
	public List<ProductionPlanType> getProductionPlanTypesOrderedByNumberOfSlots() {
		List<ProductionPlanType> l = model.getProductionPlanTypesOrderedByNumberOfSlots();
		MyFileLogWriter.writeToLogFile("getProductionPlanTypesOrderedByNumberOfSlots", false);
		MyFileLogWriter.writeToLogFile(l.toString(), true);
		return l;
	}
	/**
	 * Get all hourly employees
	 * For each employee get all shifts
	 * For each shift get all slots 
	 * @return Map of employees, value is map of shift and collection of slots
	 */
	public Map<HourlyEmployee, Map<Shift, Collection<Slot>>> getAllHourlyEmployeesWithShiftsAndSlots() {
		Map<HourlyEmployee, Map<Shift, Collection<Slot>>> m = model.getAllHourlyEmployeesWithShiftsAndSlots();
		MyFileLogWriter.writeToLogFile("getAllHourlyEmployeesWithShiftsAndSlots", false);
		MyFileLogWriter.writeToLogFile(m.toString(), true);
		return m;
	}
	/**
     * Get part types' quantity from all orders, return only part types that exist in an order (quantity > 0).
     * Remember: each part has an amount
     * @return Map of PartTypes
     */
    public Map<PartType, Integer> getPartsQuantityInAllOrders() {
        Map<PartType, Integer> m = model.getPartsQuantityInAllOrders();
        MyFileLogWriter.writeToLogFile("getPartsQuantityInAllOrders", false);
		MyFileLogWriter.writeToLogFile(m.toString(), true);
		return m;
    }
}
