package topic.collections.book.liang.maps;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CountOccurenceOfWords {
	public static void main(String[] args) {
		String text = "Complete Collections and Data Structures today May 5, 2020. " +
		"Then start on Concurent API and remember to complete your workout - abs, jumprope and " +
		"push ups !!!";
		
		String [] words = text.split("[ \n\t\r.,;:!?(){}-]");
		
		
		// create a TreeMap<String, Integer> since the occurances needs to be in sorted order
		Map<String, Integer> map = new TreeMap<>();
		
		// add the words in the map
		for (String s : words) {
			System.out.println(s);
			//if(!map.containsKey(s)){
			if(map.get(s) ==null){
				// put in map
				map.put(s,1);
			}else{
				// increase count
				int count = map.get(s);
				map.put(s,++count);
			}
		}
		
		// now print the words
		System.out.println("Now printing the words in order and their occurences");
		Set<Map.Entry<String, Integer>> entries = map.entrySet();
		
		for (Map.Entry entry : entries) {
			System.out.println(entry.getKey() +"=" + entry.getValue());
		}
		
		// TODO - now display the words in the ascending order of occurence counts
		
		
		
		
		
		
	}
}
