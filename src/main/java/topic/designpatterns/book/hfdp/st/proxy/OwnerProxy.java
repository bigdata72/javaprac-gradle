package topic.designpatterns.book.hfdp.st.proxy;

import java.lang.reflect.Proxy;

public class OwnerProxy {
	
	public Person getOwnerProxy(Person person){
		return (Person)  Proxy.newProxyInstance(
				person.getClass().getClassLoader(),
				person.getClass().getInterfaces(),
				new OwnerInvocationHandler(person));
	}
}
