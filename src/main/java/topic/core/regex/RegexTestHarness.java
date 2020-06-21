package topic.core.regex;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTestHarness {
	public static void main(String[] args) {
		//testHarness();
		String s = "Splitting a string, it's as easy as 1 2 33!  Right?";
//		String s = "If you're happy and you know it, clap your hands";
//		String regex = "it|st";
//		String regex = "ap";
//		String regex = "[123+]";
		String regex = "[^a-z123 ]";
		System.out.println("RegexTestHarness.main");
		System.out.printf("Input string: %s, input regex:\"%s\" %n", s, regex);
		System.out.println(getTokens(s, regex));
	}
	
	private static void testHarness() {
		Console console = System.console();
		if(console == null){
			System.out.println("Console do not exist");
			System.exit(-1);
		}
		while(true){
			Pattern pattern = Pattern.compile(console.readLine("%nEnter your regex:"));
			
			Matcher matcher = pattern.matcher(console.readLine("%nEnter your string to search:"));
			
			boolean found = false;
			while(matcher.find()){
				console.format("Found the text \" %s \" starting at index %d and ending at index %d. %n",
				matcher.group(), matcher.start(), matcher.end());
				found = true;
			}
			if(! found){
				console.format("%n Input string match not found");
			}
		}
	}
	
	public static List<String> getTokens(String str, String regex){
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		List<String> list = new ArrayList<>();
		while(matcher.find()){
			list.add(matcher.group());
		}
		return list;
	}
}
