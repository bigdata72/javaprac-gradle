package topic.collections.book.liang;

import java.util.Comparator;

public class MyComparator implements Comparator<Employee> {
	
	@Override
	public int compare(Employee o1, Employee o2) {
		System.out.println(o1.getSalary().compareTo(o2.getSalary()));
		return o2.getSalary().compareTo(o1.getSalary()); // reverse order
		/*if(o1.getSalary() > o2.getSalary())
			return 1;
		else if(o1.getSalary() == o2.getSalary())
			return 0;
		else return -1;*/
	}
}
