package topic.collections.book.liang.maps;

import java.util.*;

public class TestMap1 {
	public static void main(String[] args) {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("123", "John Smith");
		map.put("111", "George Smith");
		map.put("123", "Steve Yao"); // duplicate key, previous entry will be replaced.
		map.put("222", "Steve Yao");
		System.out.println("(1) " + map);
		System.out.println("(2) " + new TreeMap<String, String>(map));
		/**
		(1) {123=Steve Yao, 111=George Smith, 222=Steve Yao}
		(2) {111=George Smith, 123=Steve Yao, 222=Steve Yao}
		 **/
		
	}
}
