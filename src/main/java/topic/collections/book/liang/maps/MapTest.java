package topic.collections.book.liang.maps;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapTest {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		Map<Integer, String> treeMap = new TreeMap<>();
		Map<Integer, String> linkedMap = new LinkedHashMap<>();
		
		map.put(null, "null test");
		System.out.println(map);
		
		//treeMap.put(null, "null test"); // treemap do not allow null keys
		//System.out.println(treeMap);
		
		linkedMap.put(null, "null test");
		System.out.println(linkedMap);
	}
}
