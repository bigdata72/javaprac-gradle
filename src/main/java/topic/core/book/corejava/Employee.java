package topic.core.book.corejava;

import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.StringJoiner;

public class Employee implements Comparable<Employee>, Cloneable {
	private int salary;
	private Date hireDate;
	private String name;
	private MutableProperty prop;
	
	Employee(String n, int s){
		this.name = n;
		this.salary = s;
	}
	
	@Override
	public int compareTo(@NotNull Employee o) {
		return this.salary - o.salary;
	}
	
	public void raiseSalaryBy(double percent){
		int increase = (int)(this.salary*(percent/100));
		this.salary += increase;
	}
	
	@Override
	public Employee clone() throws CloneNotSupportedException{
		Employee clone = (Employee)super.clone();
		clone.setProp(this.prop.clone());
		clone.setHireDate((Date)this.getHireDate().clone());
		return clone;
		
		//return new Employee("a", 10000, new GregorianCalendar(1970, 10, 10).getTime());
	}
	
	public int getSalary() {
		return salary;
	}
	
	public Date getHireDate() {
		return hireDate;
	}
	
	public String getName() {
		return name;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public void setHireDate(Date newDate) {
		this.hireDate = newDate;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public MutableProperty getProp() {
		return prop;
	}
	
	public void setProp(MutableProperty prop) {
		this.prop = prop;
	}
	
	@Override
	public String toString() {
		return new StringJoiner(", ", Employee.class.getSimpleName() + "[", "]")
		.add("salary=" + salary)
		.add("hireDate=" + hireDate)
		.add("name='" + name + "'")
		.add("prop='" + prop.getValue() + "'")
		.toString();
	}
}
