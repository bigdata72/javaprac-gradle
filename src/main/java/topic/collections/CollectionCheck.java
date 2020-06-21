package topic.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CollectionCheck {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Tesla");
		map.put(2, "John");
		map.put(3, "Rob");
		map.put(4, "Bruce");
		
		Set keys = map.keySet();
		for (Object key : keys) {
			//it will throw the ConcurrentModificationException here
			map.put(5, "Leon");
		}
	}
}
