package topic.util;

public class RandomCharacter {
	/**
	 * From Section 6.10 Case Study: Generating Random characters. Book Liang 10ed
	 *
	 * Every character has a unique Unicode between 0 and FFFF in hexadecimal (65535 in decimal).
	 * To generate a random character is to generate a random integer
	 * between 0 and 65535 using the following expression
	 * (note that since 0 <= Math.random() < 1.0, you have to add 1 to 65535):
	 * (int)(Math.random() * (65535 + 1))
	 *
	 * Now let’s consider how to generate a random lowercase letter. The Unicodes for lowercase
	 * letters are consecutive integers starting from the Unicode for a, then that for b, c, . . . , and z.
	 * The Unicode for a is
	 * (int)'a'
	 * Thus, a random integer between (int)'a' and (int)'z' is
	 * (int)((int)'a' + Math.random() * ((int)'z' - (int)'a' + 1))
	 *
	 * all numeric operators can be applied to the char operands.
	 * The char operand is cast into a number if the other operand is a number or a character.
	 * Therefore, the preceding expression can be simplified as follows:
	 * 'a' + Math.random() * ('z' - 'a' + 1)
	 * and a random lowercase letter is
	 * (char)('a' + Math.random() * ('z' - 'a' + 1))
	 *
	 * Hence, a random character between any two characters ch1 and ch2 with ch1 < ch2 can be
	 * generated as follows:
	 * (char)(ch1 + Math.random() * (ch2 – ch1 + 1))
	 */
	
	public static char randomCharLowerCase(){
		return randomCharacterInRange('a', 'z');
	}
	
	public static char randomCharUpperCase(){
		return randomCharacterInRange('A', 'Z');
	}
	
	public static char randomDigitAsChar(){
		return randomCharacterInRange('0', '9');
	}
	
	public static char randomChar(){
		return randomCharacterInRange('\u0000', '\uFFFF');
	}
	
	public static char randomCharacterInRange(char c1, char c2){
		if(c2 < c1) throw new IllegalArgumentException(c2 +" is less than "+c1);
		return (char)(c1 + Math.random() * (c2 - c1 + 1));
	}
}
