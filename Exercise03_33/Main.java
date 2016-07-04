/**
 * 
 */

/**
 * (Financial: compare costs) Suppose you shop for
 * rice in two different packages. You would like
 * to write a program to compare the cost. The program
 * prompts the user to enter the weight and price of
 * the each package and displays the one with the better price.
 * 
 * @author Kris
 * @version 1.0
 * @since 06-28-2016
 *
 */
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// prompt user for package 1 info
		System.out.print("Enter weight and price for package 1: ");
		double p1Weight = input.nextDouble();
		double p1Price = input.nextDouble();
		
		//prompt user for package 2 info
		System.out.print("Enter weight and price for package 2: ");
		double p2Weight = input.nextDouble();
		double p2Price = input.nextDouble();
		
		//calculate price per unit
		double p1PricePerUnit = (p1Price / p1Weight);
		double p2PricePerUnit = (p2Price / p2Weight);
		
		//comapre per unit price and display result
		if (p1PricePerUnit == p2PricePerUnit){
			System.out.print("Two packages have the same price.");
		}else if(p1PricePerUnit < p2PricePerUnit){
			System.out.print("Package 1 has a better price.");
		}else{
			System.out.print("Package 2 has a better price.");
		}
		
		input.close();
	}

}
