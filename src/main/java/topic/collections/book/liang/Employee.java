package topic.collections.book.liang;

import java.util.StringJoiner;

public class Employee {
	private String name;
	private int salary;
	private int age;
	
	public Employee(String name, int age, int salary){
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return new StringJoiner(", ", Employee.class.getSimpleName() + "[", "]")
		.add("name='" + name + "'")
		.add("salary=" + salary)
		.add("age=" + age)
		.toString();
	}
}
