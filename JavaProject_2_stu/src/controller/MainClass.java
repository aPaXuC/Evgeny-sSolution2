/**
 * Main class to run this program
 */
package controller;

import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import au.com.bytecode.opencsv.CSVReader;
import utils.E_PartCategory;
import utils.E_VehicleType;
import utils.MyFileLogWriter;

/**
 * @author Java spring 2017
 * 
 */
public class MainClass {
	/** Controller instance */
	private static ControllerLogic controller;
	/**
	 * Main method to run this program
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			controller = ControllerLogic.getInstance();
			String[] line;
			CSVReader reader = new CSVReader(new FileReader(new File("input.csv")));
			while ((line = reader.readNext()) != null) {
				switch (line[0]) {
					case "addManufacturer":
						controller.addManufacturer(line[1], line[2], line[3], line[4], Integer.parseInt(line[5]), line[6], Double.parseDouble(line[7]));
						break;
					case "addWarehouse":
						controller.addWarehouse(Integer.parseInt(line[1]), line[2], line[3], line[4], Integer.parseInt(line[5]), line[6], Integer.parseInt(line[7]), Integer.parseInt(line[8]));
						break;
					case "addProductionPlanType":
						controller.addProductionPlanType(Integer.parseInt(line[1]), Integer.parseInt(line[2]));
						break;
					case "addProductionPlan":
						controller.addProductionPlan(Integer.parseInt(line[1]), Integer.parseInt(line[2]));
						break;
					case "addVehicleModel":
						controller.addVehicleModel(Integer.parseInt(line[1]), line[2], E_VehicleType.valueOf(line[3]), Integer.parseInt(line[4]), Integer.parseInt(line[5]), Integer.parseInt(line[6]), Boolean.parseBoolean(line[7]), Double.parseDouble(line[8]), getCalendar(line[9]));
						break;
					case "addPartType":
						controller.addPartType(Integer.parseInt(line[1]), line[2], E_PartCategory.valueOf(line[3]), Double.parseDouble(line[4]));
						break;
					case "addOrder":
						controller.addOrder(Integer.parseInt(line[1]), line[2], line[3], getCalendar(line[4]));
						break;
					case "addVehicle":
						controller.addVehicle(line[1], line[2], Integer.parseInt(line[3]), Integer.parseInt(line[4]));
						break;
					case "addWorkStation":
						controller.addWorkStation(Integer.parseInt(line[1]), E_PartCategory.valueOf(line[2]));
						break;
					case "addGuard":
						controller.addGuard(line[1], line[2], line[3], line[4], line[5], Integer.parseInt(line[6]), line[7], getCalendar(line[8]), getCalendar(line[9]), Double.parseDouble(line[10]), Integer.parseInt(line[11]));
						break;
					case "addShiftManager":
						controller.addShiftManager(line[1], line[2], line[3], line[4], line[5], Integer.parseInt(line[6]), line[7], getCalendar(line[8]), getCalendar(line[9]), Double.parseDouble(line[10]), Double.parseDouble(line[11]));
						break;
					case "addWorker":
						controller.addWorker(line[1], line[2], line[3], line[4], line[5], Integer.parseInt(line[6]), line[7], getCalendar(line[8]), getCalendar(line[9]), Double.parseDouble(line[10]));
						break;
					case "addShift":
						controller.addShift(getCalendar(line[1]), line[2]);
						break;
					case "addSlot":
						controller.addSlot(getCalendar(line[1]), Integer.parseInt(line[2]));
						break;
					case "removeManufacturer":
						controller.removeManufacturer(line[1]);
						break;
					case "removeWarehouse":
						controller.removeWarehouse(Integer.parseInt(line[1]));
						break;
					case "removeProductionPlanType":
						controller.removeProductionPlanType(Integer.parseInt(line[1]));
						break;
					case "removeProductionPlan":
						controller.removeProductionPlan(Integer.parseInt(line[1]));
						break;
					case "removeVehicleModel":
						controller.removeVehicleModel(line[1]);
						break;
					case "removePartType":
						controller.removePartType(Integer.parseInt(line[1]));
						break;
					case "removeOrder":
						controller.removeOrder(Integer.parseInt(line[1]));
						break;
					case "removeVehicle":
						controller.removeVehicle(line[1]);
						break;
					case "removeWorkStation":
						controller.removeWorkStation(Integer.parseInt(line[1]));
						break;
					case "removeEmployee":
						controller.removeEmployee(line[1]);
						break;
					case "removeShift":
						controller.removeShift(getCalendar(line[1]));
						break;
					case "addModelToManufacturer":
						controller.addModelToManufacturer(line[1], line[2]);
						break;
					case "addPartCategoryToManufacturer":
						controller.addPartCategoryToManufacturer(line[1], E_PartCategory.valueOf(line[2]));
						break;
					case "addVehicleToWarehouse":
						controller.addVehicleToWarehouse(line[1], Integer.parseInt(line[2]));
						break;
					case "addPartTypeToWarehouse":
						controller.addPartTypeToWarehouse(Integer.parseInt(line[1]), Integer.parseInt(line[2]), Integer.parseInt(line[3]));
						break;
					case "addPartToModel":
						controller.addPartToModel(Integer.parseInt(line[1]), Integer.parseInt(line[2]), line[3]);
						break;
					case "addManufacturerToPart":
						controller.addManufacturerToPart(Integer.parseInt(line[1]), line[2]);
						break;
					case "addPartTypeToOrder":
						controller.addPartTypeToOrder(Integer.parseInt(line[1]), Integer.parseInt(line[2]), Integer.parseInt(line[3]));
						break;
					case "addWorkStationToProductionPlanType":
						controller.addWorkStationToProductionPlanType(Integer.parseInt(line[1]), Integer.parseInt(line[2]), Integer.parseInt(line[3]));
						break;
					case "addWorkStationToWorker":
						controller.addWorkStationToWorker(Integer.parseInt(line[1]), line[2]);
						break;
					case "addShiftToWorker":
						controller.addShiftToWorker(getCalendar(line[1]), line[2]);
						break;
					case "removeModelFromManufacturer":
						controller.removeModelFromManufacturer(line[1], line[2]);
						break;
					case "removePartCategoryFromManufacturer":
						controller.removePartCategoryFromManufacturer(line[1], E_PartCategory.valueOf(line[2]));
						break;
					case "removeVehicleFromWarehouse":
						controller.removeVehicleFromWarehouse(line[1], Integer.parseInt(line[2]));
						break;
					case "removePartTypeFromWarehouse":
						controller.removePartTypeFromWarehouse(Integer.parseInt(line[1]), Integer.parseInt(line[2]), Integer.parseInt(line[3]));
						break;
					case "removePartFromModel":
						controller.removePartFromModel(Integer.parseInt(line[1]), Integer.parseInt(line[2]), line[3]);
						break;
					case "removeManufacturerFromPart":
						controller.removeManufacturerFromPart(Integer.parseInt(line[1]), line[2]);
						break;
					case "removePartTypeFromOrder":
						controller.removePartTypeFromOrder(Integer.parseInt(line[1]), Integer.parseInt(line[2]), Integer.parseInt(line[3]));
						break;
					case "removeWorkStationFromProductionPlanType":
						controller.removeWorkStationFromProductionPlanType(Integer.parseInt(line[1]), Integer.parseInt(line[2]));
						break;
					case "removeWorkStationFromWorker":
						controller.removeWorkStationFromWorker(Integer.parseInt(line[1]), line[2]);
						break;
					case "removeShiftFromWorker":
						controller.removeShiftFromWorker(getCalendar(line[1]), line[2]);
						break;
					case "getAllWarehousesInManufacturerCountry":
						controller.getAllWarehousesInManufacturerCountry(line[1]);
						break;
					case "findVehicleInCity":
						controller.findVehicleInCity(line[1], line[2], line[3]);
						break;
					case "getMostProfitableManufacturer":
						controller.getMostProfitableManufacturer();
						break;
					case "getMissingPartsForProductionPlan":
						controller.getMissingPartsForProductionPlan(Integer.parseInt(line[1]));
						break;
					case "getLastFutureProductionOfModel":
						controller.getLastFutureProductionOfModel(line[1]);
						break;
					case "findShiftByTime":
						controller.findShiftByTime(getCalendar(line[1]));
						break;
					case "getAllShiftsOrderedByNumberOfProductionPlanTypes":
						controller.getAllShiftsOrderedByNumberOfProductionPlanTypes();
						break;
					case "getKModelsWithLeastVehicles":
						controller.getKModelsWithLeastVehicles(Integer.parseInt(line[1]));
						break;
					case "getNumberOfPartsForEachOrder":
						controller.getNumberOfPartsForEachOrder();
						break;
					case "getAllEmployeesOrderedByTypeAndById":
						controller.getAllEmployeesOrderedByTypeAndById();
						break;
					case "getAllEmployeesOrderedBySalaryInMonth":
						controller.getAllEmployeesOrderedBySalaryInMonth(getCalendar(line[1]), Boolean.parseBoolean(line[2]));
						break;
					case "getProductionPlanTypesOrderedByNumberOfSlots":
						controller.getProductionPlanTypesOrderedByNumberOfSlots();
						break;
					case "getAllHourlyEmployeesWithShiftsAndSlots":
						controller.getAllHourlyEmployeesWithShiftsAndSlots();
						break;
					case "getPartsQuantityInAllOrders":
						controller.getPartsQuantityInAllOrders();
						break;
				}
			}
			reader.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			MyFileLogWriter.saveLogFile();
			System.out.println("[End process]");
			System.out.println("NOTICE: \"End process\" " +
							"does not mean that all your methods are correct.\n" +
							"You must check the output.txt file");
		}
	}
	/**
	 * Gets a calendar from string
	 * @param line String in format dd/MM/yyyy
	 * @return The calendar needed
	 * @throws ParseException
	 */
	public static Calendar getCalendar(String line) throws ParseException {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy'T'HH:mm", Locale.UK);
		cal.setTime(sdf.parse(line));
		return cal;
	}

}
