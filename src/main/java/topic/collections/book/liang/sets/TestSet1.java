package topic.collections.book.liang.sets;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class TestSet1 {
	public static void main(String[] args) throws Exception {
		ObjectOutputStream output = new ObjectOutputStream(
		new FileOutputStream("C:\\Users\\Arijit\\ideaprojects\\getajob\\src\\main\\java\\book\\liang\\collections" +
		"\\sets\\test.dat"));
		LinkedHashSet<String> set1 = new LinkedHashSet<>();
		set1.add("New York");
		LinkedHashSet<String> set2 =
		(LinkedHashSet<String>)set1.clone();
		set1.add("Atlanta");
		output.writeObject(set1);
		output.writeObject(set2);
		output.close();
		ObjectInputStream input = new ObjectInputStream(
		new FileInputStream("C:\\Users\\Arijit\\ideaprojects\\getajob\\src\\main\\java\\book\\liang\\collections" +
		"\\sets\\test.dat"));
		set1 = (LinkedHashSet<String>)input.readObject();
		set2 = (LinkedHashSet<String>)input.readObject();
		System.out.println(set1);
		System.out.println(set2);
		output.close();
		
		Set<String> set = Collections.singleton("Chicago");
		List<String> list = Collections.unmodifiableList(Arrays.asList("Chicago","Boston"));
		Set<String> another = new HashSet<>(list);
		another = Collections.unmodifiableSet(another);
		
		try {
			set.add("Dallas"); // not allowed
		}catch(UnsupportedOperationException u){
			System.out.println("operation not allowed");
		}
		
		try {
			another.remove("Dallas");
		}catch(UnsupportedOperationException u){
			System.out.println("operation not allowed");
		}
		
		

	}
}
