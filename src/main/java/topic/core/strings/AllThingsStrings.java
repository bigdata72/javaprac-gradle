package topic.core.strings;

public class AllThingsStrings {
	public static void main(String[] args) {
		try{
			charAtTestOutofIndex();
		}catch(StringIndexOutOfBoundsException se){
			System.out.println(se.getMessage());
		}
		
		testSubstring();
		
		System.out.println(strangeMethod().getMessage());
		
		try{
			substringOutOfIndex();
		}catch(StringIndexOutOfBoundsException se){
			System.out.println(se.getMessage());
		}
		
		testArray();
		
	}
	
	static void charAtTestOutofIndex(){
		String test = "Hello";
		for(int i=0; i<test.length();i++){
			System.out.print(test.charAt(i+1)); // elloString index out of range: 5
			// StringIndexOutOfBoundsException
		}
	}
	
	static void testSubstring(){
		String test = "strawberry";
		
		System.out.println(test.substring(5,9));	// berr
		assert test.substring(5,9).equals("berr");
	}
	
	static Exception strangeMethod() {
		return new Exception("it compiles"); // yes
	}
	
	static void substringOutOfIndex(){
		String test="strawberry";
		String msg = test.substring(5,10) + test.substring(12,5); //String index out of range: -7
		System.out.println(msg);
	}
	
	static void testArray(){
		int array[] = {1,2,3,4,5}; // array not reserved for variable name
		for(int i=0; i< array.length; i++){
			System.out.print(array[i]); //12345
		}
	}
	
	
}
