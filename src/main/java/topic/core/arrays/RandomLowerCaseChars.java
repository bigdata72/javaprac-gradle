package topic.core.arrays;

import topic.util.RandomCharacter;

/**
 * pgm displays 1000 random lower case characters
 */
public class RandomLowerCaseChars {
	private static final int NUMBER_OF_CHARS = 1000;
	private static final int CHARS_PER_LINE = 80;
	
	public static void main(String[] args) {
		for(int i=0; i<NUMBER_OF_CHARS; i++){
			char c = RandomCharacter.randomCharLowerCase();
			if((i+1)%CHARS_PER_LINE==0)
				System.out.println(c);
			else
				System.out.print(c);
		}
	}
}
