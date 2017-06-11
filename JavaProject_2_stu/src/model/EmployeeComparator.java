package model;

import java.util.Calendar;
import java.util.Comparator;

public class EmployeeComparator implements Comparator<AbstractEmployee>{

	private Calendar month;
	private boolean direction;
	
	public EmployeeComparator(Calendar month, boolean direction) {
		this.month = month;
		this.direction = direction;
	}

	@Override
	public int compare(AbstractEmployee o1, AbstractEmployee o2) {
		// TODO Auto-generated method stub
		int dir = 1;
		if (direction)
			dir = -1;
		return dir * ((Double)o1.getSalary(month)).compareTo(o2.getSalary(month));
	}

}
