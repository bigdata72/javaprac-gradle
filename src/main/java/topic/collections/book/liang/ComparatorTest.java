package topic.collections.book.liang;

import java.util.Comparator;

public class ComparatorTest {
	public static void main(String[] args) {
		Employee one = new Employee("Elon", 45, 450000);
		Employee two = new Employee("Bezos", 48, 350000);
		Employee higherPaid = higherSal(one, two, new MyComparator());
		System.out.println(higherPaid);
	}
	
	private static Employee higherSal(Employee one, Employee two, Comparator<Employee> c){
		if(c.compare(one, two) > 0)
			return one;
		else if (c.compare(one, two) < 0)
			return two;
		else
			return null;
	}
}
