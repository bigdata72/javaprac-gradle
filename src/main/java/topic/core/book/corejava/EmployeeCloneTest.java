package topic.core.book.corejava;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class EmployeeCloneTest {
	public static void main(String[] args) {
		try{
			Employee original = new Employee("arijit",140000);
			original.setHireDate(new GregorianCalendar(2014, Calendar.MAY, 6).getTime());
			MutableProperty prop = new MutableProperty(1100);
			original.setProp(prop);
			
			Employee copy = original.clone();
			System.out.println(original);
			System.out.println("Changing reference fields for cloned Employee ...");
			
			copy.raiseSalaryBy(10);
			copy.getHireDate().setTime(new GregorianCalendar(2014, Calendar.MAY, 7).getTimeInMillis());
			
			MutableProperty fromCopy = copy.getProp();
			fromCopy.setValue(15);
			copy.setName("b");
			
			System.out.println(copy);
			System.out.println("Did the change affect original Employee ?");
			System.out.println(original);
		}catch(CloneNotSupportedException ce){
			ce.printStackTrace();
		}
		
	}
}
