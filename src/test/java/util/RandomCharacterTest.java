package util;

import org.junit.Test;
import topic.util.RandomCharacter;

public class RandomCharacterTest {
	
	@Test
	public void randomCharLowerCase() {
		System.out.println("char 'a' value as int is :"+(int)'a'); // 97
		System.out.println("char 'z' value as int is :"+(int)'z'); //122
		for(int i=0; i<26; i++) {
			System.out.println("Random Character :" + RandomCharacter.randomCharLowerCase());
		}
	}
	
	@Test
	public void randomCharUpperCase() {
		System.out.println("char 'A' value as int is :"+(int)'A'); //65
		System.out.println("char 'Z' value as int is :"+(int)'Z'); //90
		for(int i=0; i<26; i++) {
			System.out.println("Random Character :" + RandomCharacter.randomCharUpperCase());
		}
	}
	
	@Test
	public void randomDigit() {
		System.out.println("'0' value as char is :"+(char)'0'); //65
		System.out.println("'9' value as char is :"+(char)'9'); //90
		for(int i=0; i<10; i++) {
			System.out.println("Random digit as char :" + RandomCharacter.randomDigitAsChar());
		}
	}
	
	@Test
	public void randomChar(){
		System.out.println("\\u0000 ="+'\u0000');
		System.out.println("\\uFFFF ="+'\uFFFF');
		for(int i=0; i<10; i++) {
			System.out.println("Random Character :" + RandomCharacter.randomChar());
		}
	}
}