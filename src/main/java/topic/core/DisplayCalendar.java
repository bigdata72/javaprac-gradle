package topic.core;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Take input for month and year and display the entire calendar
 */
public class DisplayCalendar {
	
	private int year;
	private int month;
	
	public DisplayCalendar(int year, int month){
		this.year = year;
		this.month = month;
		
	}
	
	private void printWeekHeader(){
	
	}
	
	private void printMonthHeader(){
	
	}
	
	private void printDates(){
		LocalDate date = LocalDate.of(year,month,1);
		
	
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the year");
		int year = input.nextInt();
		System.out.println("Enter the month (Jan is 0, Dec is 11)");
		int month = input.nextInt();
		
	}
}
