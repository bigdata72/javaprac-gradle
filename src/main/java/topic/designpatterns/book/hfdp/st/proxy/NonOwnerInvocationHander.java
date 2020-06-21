package topic.designpatterns.book.hfdp.st.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class NonOwnerInvocationHander implements InvocationHandler {
	private Person nonOwner;
	
	public NonOwnerInvocationHander(Person p){
		this.nonOwner = p;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if(method.getName().startsWith("get")){
			return method.invoke(nonOwner, args);
		}else if(method.getName().equals("setHotOrNotRating")){
			return method.invoke(nonOwner, args);
		}else if(method.getName().startsWith("set")){
			System.out.println("You cannot change interests of others");
			throw new IllegalAccessException();
		}else return null;
	}
}
