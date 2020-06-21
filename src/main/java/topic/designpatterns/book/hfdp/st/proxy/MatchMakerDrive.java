package topic.designpatterns.book.hfdp.st.proxy;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class MatchMakerDrive {
	private List<Person> personDB;
	
	public static void main(String[] args) {
		MatchMakerDrive maker = new MatchMakerDrive();
		maker.drive();
	}
	
	public void drive(){
		Person p1 = personDB.get(0);
		Person p2 = personDB.get(1);
		// get Owner Proxy for this person
		Person proxy1 = getOwnerProxy(p1);
		Person proxy2 = getOwnerProxy(p2);
		Person noProxy1 = getNonOwnerProxy(p2);
		Person noProxy2 = getNonOwnerProxy(p1);
		
		System.out.printf("Name: %s, Interests: %s, Rating: %s",
						proxy1.getName(),
						proxy1.getInterests(),
						proxy1.getRating());
		System.out.println("------");
		try{
			proxy1.setHotOrNotRating(10);
		}catch(Exception ie){
			System.out.println(ie.getCause());
		}
		proxy1.setInterests("big data");
		System.out.printf("Name: %s, Interests: %s, Rating: %s",
						proxy1.getName(),
						proxy1.getInterests(),
						proxy1.getRating());
		System.out.println("------");
		
		System.out.printf("Name: %s, Interests: %s, Rating: %s",
		proxy2.getName(),
		proxy2.getInterests(),
		proxy2.getRating());
		System.out.println("------");
		try{
			proxy2.setHotOrNotRating(10);
		}catch(Exception ie){
			System.out.println(ie.getCause());
		}
		proxy2.setInterests("sql server");
		System.out.printf("Name: %s, Interests: %s, Rating: %s",
		proxy2.getName(),
		proxy2.getInterests(),
		proxy2.getRating());
		System.out.println("------");
		
		System.out.println("Tring to Change rating and interests with non-owner proxies ...");
		noProxy1.setHotOrNotRating(8);
		noProxy2.setHotOrNotRating(7);
		try{
			noProxy1.setInterests("something else");
		}catch(Exception ie){
			System.out.println(ie.getCause());
		}
		try{
			noProxy2.setInterests("something else");
		}catch(Exception ie){
			System.out.println(ie.getCause());
		}
		
		System.out.println();
		System.out.println("After changed rating ...");
		
		System.out.printf("Name: %s, Interests: %s, Rating: %s",
		proxy1.getName(),
		proxy1.getInterests(),
		proxy1.getRating());
		System.out.println("------");
		
		System.out.printf("Name: %s, Interests: %s, Rating: %s",
		proxy2.getName(),
		proxy2.getInterests(),
		proxy2.getRating());
		System.out.println("------");
		
		
	}
	
	public MatchMakerDrive(){
		personDB = new ArrayList<>();
		initializeDatabase();
	}
	
	private void initializeDatabase(){
		Person person1 = new PersonBean("arijit", "java", 5);
		Person person2 = new PersonBean("soma", "database", 10);
		personDB.add(person1);
		personDB.add(person2);
	}
	
	private Person getOwnerProxy(Person person){
		return (Person)  Proxy.newProxyInstance(
		person.getClass().getClassLoader(),
		person.getClass().getInterfaces(),
		new OwnerInvocationHandler(person));
	}
	
	private Person getNonOwnerProxy(Person person){
		return (Person)  Proxy.newProxyInstance(
		person.getClass().getClassLoader(),
		person.getClass().getInterfaces(),
		new NonOwnerInvocationHander(person));
	}
}
