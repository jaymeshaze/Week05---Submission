/**
 * 
 */

/**
 * (Geometry: two circles) Write a program that prompts
 * the user to enter the center coordinates and radii of
 * two circles and determines whether the second circle
 * is inside the first or overlaps with the first, as shown
 * in Figure 3.10.
 * 
 * (Hint: circle2 is inside circle1 if the distance between
 * the two centers 6 = |r1 - r2| and circle2 overlaps circle1
 * if the distance between the two centers <= r1 + r2.
 * Test your program to cover all cases.)
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
		
		// prompt user for circle1 coordinates
		System.out.print("Enter circle1's center x-, y-coordinates, and radius (separated by spaces): ");
		double circle1X = input.nextDouble();
		double circle1Y = input.nextDouble();
		double circle1Radius = input.nextDouble();
		
		// prompt user for circle2 coordinates
		System.out.print("Enter circle2's center x-, y-coordinates, and radius (separated by spaces): ");
		double circle2X = input.nextDouble();
		double circle2Y = input.nextDouble();
		double circle2Radius = input.nextDouble();
	
		//calculate distance using formula
		double distance = Math.sqrt((Math.pow((circle2X - circle1X), 2)) + (Math.pow((circle2Y - circle1Y), 2)));
		
		//return whether inside, overlap or neither
		if (distance <= Math.abs(circle1Radius - circle2Radius)){
			System.out.print("circle2 is inside circle1.");
		}else if (distance <= (circle1Radius + circle2Radius)){
			System.out.print("circle2 overlaps circle1");
		}else{
			System.out.print("circle2 does not overlap circle1");
		}
	
		input.close();
	}

}
