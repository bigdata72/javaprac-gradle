package topic.core.arrays;

import topic.util.StopWatch;
import topic.util.StopWatchNano;
import topic.util.RandomCharacter;

/**
 * Count occurence of each letter in an array of characters
 */
public class CharacterCount {
	private static final int NUM_CHARS = 1000000000;
	private static final int CHARS = 26;
	
	// create one array to hold random characters
	private static char [] chars = new char[NUM_CHARS];
	
	// create another array to hold the count of characters
	private static int [] counts = new int[CHARS]; // a-z
	
	// create an array for counts
	private static char [] alphabets = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
	'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	
	private static void generateCharacters() {
		for (int i = 0; i < NUM_CHARS; i++) {
			chars[i] = RandomCharacter.randomCharLowerCase();
		}
		//System.out.printf("The characters are :%s %n", Arrays.toString(chars));
		System.out.println("Characters generated = "+chars.length);
	}
	
	private static int getIndex(char c){ // brute force .. see better solution using char math
		for(int i=0;i<alphabets.length;i++){
			if(alphabets[i] == c)
				return i;
		}
		return -1;
	}
	
	private static void countCharactersBruteForce(){
		for(int i=0; i<chars.length; i++){
			
			char c = chars[i];
			int index = getIndex(c); // get the index of the character from alphabet array
			int charCount = -1;
			if(index !=-1){
				charCount = counts[index]; // get the previous count
				counts[index] = ++charCount; // increment the count for the character
			}else{
				throw new RuntimeException("this should not happen");
			}
		}
	}
	
	private static void countCharactersEfficient(){
		 //better and elegant solution below :
		for(int i=0; i<chars.length; i++) {
			counts[ chars[ i ] - 'a' ]++;
		}
	}
	
	private static void printCounts(){
		/**
		for(int i=0; i<alphabets.length; i++){
			System.out.printf("Count of character %s is %s %n",alphabets[i], counts[i]);
		}
		 */
		for(int i=0; i<counts.length; i++) {
			if ((i + 1) % 10 == 0)  // 10 characters per line
				System.out.printf("%s = %s %n", (char)(i + 'a'), counts[i]);
			else
				System.out.printf("%s = %s, ", (char) (i + 'a'), counts[i]);
		}
	}
	
	public static void main(String[] args) {
		bruteForce();
	}
	
	private static void bruteForce() {
		System.out.println("CharacterCount.bruteForce");
		StopWatch watch = new StopWatchNano();
		generateCharacters();
		watch.start();
		//countCharactersBruteForce();
		countCharactersEfficient();
		watch.stop();
		printCounts();
		System.out.println();
		System.out.println("Duration in millis ="+ watch.durationInMillis());
	}
	
	
}
