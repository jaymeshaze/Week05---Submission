/**
 * 
 */

/**
 * (Game: scissor, rock, paper) Write a program that plays
 * the popular scissor-rockpaper game. (A scissor can cut
 * a paper, a rock can knock a scissor, and a paper can wrap
 * a rock.) The program randomly generates a number 0, 1, or
 * 2 representing scissor, rock, and paper. The program prompts
 * the user to enter a number 0, 1, or 2 and displays a message
 * indicating whether the user or the computer wins, loses, or draws.
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
		
		
		// generate computer choice
		int computerChoice = (int) (Math.random() * 3);
		int playerChoice;
		
		//prompt user to make choice and check validity
		do{
			System.out.print("Enter 0 for scissor, 1 for rock, 2 for paper: ");
			playerChoice = input.nextInt();
		
			if(playerChoice < 0 || playerChoice > 3)
				System.out.print("Invalid input. ");
		}while(playerChoice < 0 || playerChoice > 3);
		
		//create string for result statement
		String result = null;
		String player = null;
		String computer = null;
		
		//compare player to computer
		switch(playerChoice){
			case 0:
				player = "scissor";
				if(computerChoice == 1){
					result = "You lost.";
					computer = "rock";
				}else if(computerChoice == 0){
					result = "It's a draw!";
					computer = "rock";
				}else{
					result = "You won!";
					computer = "paper";
				}
				break;
			case 1:
				player = "rock";
				if(computerChoice == 2){
					result = "You lost.";
					computer = "paper";
				}else if(computerChoice == 1){
					result = "It's a draw!";
					computer = "rock";
				}else{
					result = "You won!";
					computer = "scissor";
				}
				break;
			case 2:
				player = "paper";
				if(computerChoice == 0){
					result = "You lost.";
					computer = "scissor";
				}else if(computerChoice == 2){
					result = "It's a draw!";
					computer = "paper";
				}else{
					result = "You won!";
					computer = "rock";
				}
				break;
		}
		
		//display result
		System.out.println("The computer is " + computer + " and you are " + player + ". " + result);
	input.close();
	}

}