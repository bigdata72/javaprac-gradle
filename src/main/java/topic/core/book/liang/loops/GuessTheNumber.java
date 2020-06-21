package topic.core.book.liang.loops;

import java.util.Scanner;

public class GuessTheNumber {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Guess a number between 1-100 inclusive");
		int guess = scanner.nextInt();
		System.out.println("you guessed ="+ guess);
		int computer = (int)(Math.random()*100) + 1;
		System.out.println("Computer guessed ="+computer);
		while(guess != computer){
			if(guess > computer)
				System.out.println("Your guess is too high");
			else
				System.out.println("Your guess is too low");
			System.out.println("Enter another guess");
			guess = scanner.nextInt();
		}
	}
}
