/**
 * 
 */

/**
 * (Decimal to hex) Write a program that prompts
 * the user to enter an integer between 0 and 15
 * and displays its corresponding hex number.
 * 
 * @author Kris
 * @version 1.0
 * @since 06-28-2016
 *
 */
import java.util.Scanner;

public class Main {


	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//prompt user to enter an integer between 0 and 15
		System.out.print("Enter a decimal value (0 to 15): ");
		int userChoice = input.nextInt();
		
		//create array for hex character 0-15
		char[] hexArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		
		//check for valid input, display result from array
		if (userChoice < 0 || userChoice > 15)
			System.out.print(userChoice + " is an invalid input.");
		else
			System.out.print("The hex value is " + hexArray[userChoice]);

		input.close();
	}

}
