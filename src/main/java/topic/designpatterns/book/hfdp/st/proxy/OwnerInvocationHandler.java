package topic.designpatterns.book.hfdp.st.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class OwnerInvocationHandler implements InvocationHandler {
	private Person owner;
	
	public OwnerInvocationHandler(Person person){
		this.owner = person;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if(method.getName().startsWith("get")){
			return method.invoke(owner, args);
		}else if(method.getName().equals("setHotOrNotRating")){
			System.out.println("You cannot change your own rating");
			throw new IllegalAccessException();
		}else if(method.getName().startsWith("set")){
			return method.invoke(owner, args);
		}else return null;
	}
}
