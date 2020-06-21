package topic.core.book.corejava;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

public class ProxyTest {
	public static void main(String[] args) {
		Object[] elements = new Object[1000];
		// fill elements with proxies for the integers 1...1000
		for (int i = 0; i < elements.length ; i++) {
			Integer value = i + 1;
			
			// get the array of interfaces for the proxy
			Class [] interfaces = value.getClass().getInterfaces();
			//System.out.println(Arrays.toString(interfaces));
			
			// create the invocation handler
			InvocationHandler handler = new TraceHandler(value);
			
			// create the proxy
			Object proxy = Proxy.newProxyInstance(null, interfaces, handler);
			elements[i] = proxy;
		}
		
		// construct a random integer
		Integer key = new Random().nextInt(elements.length) + 1;
		System.out.println("the key ="+key);
		
		// search for the key using binary search
		int result = Arrays.binarySearch(elements, key);
		
		if(result >=0) System.out.println(elements[result]);
		else System.out.println("Key not found ..");
	}
}

class TraceHandler implements InvocationHandler{
	private Object target;
	
	public TraceHandler(Object obj){
		this.target = obj;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// Print the target and the method and invoke the method on the proxy
		System.out.print(target);
		System.out.print("."+method.getName() +"(");
		if(args != null) {
			for (int i = 0; i < args.length; i++) {
				System.out.print(args[i]);
				if (i < args.length - 1) // if the args length is more than 1
					System.out.print(",");
			}
		}
		System.out.println(")");
		// invoke the actual method
		return method.invoke(target, args);
	}
}
