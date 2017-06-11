package model;

import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Order<F, T> implements Cloneable{

	protected int orderNumber;
	protected F orderedFrom;
	protected T orderedTo;
	protected Calendar dueDate;
	private HashMap<PartType, Integer> parts;
	private HashSet<Vehicle> vehicles;
	
	protected Order(int orderNumber, F orderedFrom, T orderedTo, Calendar dueDate) {
		super();
		this.orderNumber = orderNumber;
		this.orderedFrom = orderedFrom;
		this.orderedTo = orderedTo;
		this.dueDate = dueDate;
		this.parts = new HashMap<>();
		this.vehicles = new HashSet<>();
	}
	
	protected Set<Vehicle> getVehicles(){
		return Collections.unmodifiableSet(this.vehicles);
	}
	
	public Map<PartType, Integer> getParts() {
		return Collections.unmodifiableMap(this.parts);
	}

	protected boolean addVehicle(Vehicle v){
		if (orderedFrom instanceof Manufacturer)
			if (!((Manufacturer)orderedFrom).getProducedModels().contains(v.model))
				return false;
		if (orderedTo instanceof Manufacturer)
			if (!((Manufacturer)orderedTo).getProducedModels().contains(v.model))
				return false;
		return vehicles.add(v);
	}
	
	protected boolean removeVehicle(Vehicle v){
		return vehicles.remove(v);
	}
	
	protected boolean addPart(PartType pt, int amount){
		if (amount <=0)
			return false;
		if (orderedFrom instanceof Manufacturer)
			if (!((Manufacturer)orderedFrom).getProducedPartTypes().contains(pt.category))
				return false;
		if (orderedTo instanceof Manufacturer)
			if (!((Manufacturer)orderedTo).getProducedPartTypes().contains(pt.category))
				return false;
		if (parts.containsKey(pt))
			parts.put(pt, parts.get(pt) + amount);
		else parts.put(pt, amount);
		return true;
	}
	
	protected boolean removePart(PartType pt, int amount){
		if (!parts.containsKey(pt))
			return false;
		if (amount <= 0)
			return false;
		if (parts.get(pt) < amount)
			return false;
		if (parts.get(pt) > amount)
			parts.put(pt, parts.get(pt) - amount);
		if (parts.get(pt) == amount)
			parts.remove(pt);
		return true;
	}
	
	protected double getPrice(){
		double allVehicles = 0;
		for (Vehicle v : vehicles)
			allVehicles += v.model.getProductionCost();
		double allParts = 0;
		for (Entry<PartType, Integer> entry : parts.entrySet())
			allParts += entry.getKey().getProductionCost() * entry.getValue();
		if (orderedFrom instanceof Manufacturer)
			return (allVehicles + allParts)*(1 + ((Manufacturer)orderedFrom).profitPercentage);
		if (orderedTo instanceof Manufacturer)
			return (allVehicles + allParts)*(1 + ((Manufacturer)orderedTo).profitPercentage);
		return allVehicles + allParts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orderNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order<?, ?> other = (Order<?, ?>) obj;
		if (orderNumber != other.orderNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [orderNumber=" + orderNumber + ", orderedFrom=" + orderedFrom + ", orderedTo=" + orderedTo
				+ ", dueDate=" + dueDate.getTime().toString() + "]";
	}
	
	protected Object clone() {
		if (orderedFrom instanceof Manufacturer)
			return new Order<Manufacturer, AbstractEmployee>(orderNumber, (Manufacturer)((Manufacturer)orderedFrom).clone(), (AbstractEmployee)((AbstractEmployee)orderedTo).clone(), (Calendar)dueDate.clone());
		return new Order<AbstractEmployee, Manufacturer>(orderNumber, (AbstractEmployee)((AbstractEmployee)orderedFrom).clone(), (Manufacturer)((Manufacturer)orderedTo).clone(), (Calendar)dueDate.clone());
	}
}
