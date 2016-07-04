/**
 * 
 */

/**
 * (Palindrome number) Write a program that prompts the user
 * to enter a three-digit integer and determines whether it
 * is a palindrome number. A number is palindrome if it reads
 * the same from right to left and from left to right.
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
		
		String numberOne;
		
		//Ask user to input a 3 digit number, check to see if user input is valid input
		do{
			System.out.print("Please enter a 3 digit number: ");
			numberOne = input.nextLine();
			if (isValid(numberOne) == false)
				System.out.print("Invalid Input. ");
		}while(isValid(numberOne) == false);
		
		
		if(Integer.parseInt(numberOne) == Integer.parseInt(reverseNum(numberOne)))
			System.out.print(numberOne + " is a palindrome.");
		else
			System.out.print(numberOne + " is not a palindrome.");
	
	input.close();
	}
	
	//check user input for valid length and numeric value
	public static boolean isValid(String str){
		str.toCharArray();
		
		for (int i = 0; i < str.length() - 1; i++){
			if (str.charAt(i) < '0' || str.charAt(i) > '9')
				return false;
		}
		if(str.length() != 3)
			return false;
			
		return true;
	}
	
	//reverse the number
	public static String reverseNum(String str){
		StringBuilder userInt = new StringBuilder(str);
		userInt.reverse();
		return userInt.toString();
	}

}
