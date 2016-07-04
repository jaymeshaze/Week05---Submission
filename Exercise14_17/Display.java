/**
 * (Game: hangman) Write a program that displays a
 * drawing for the popular hangman game, as shown
 * in Figure 14.48a.
 * 
 * @author Kris
 * @version 1.0
 * @since 06-28-2016
 *
 */
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Display extends Application {
	
	//launch application
	public static void main(String[] args) {
		Application.launch(args);
}
	//start method for JavaFX
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		//create hangman bar and rope
		Arc base = new Arc(40, 140, 30, 10, 0, 180); // Create an arc
		base.setStroke(Color.BLACK);
		base.setFill(null); // Set fill color
		base.setType(ArcType.OPEN); // Set arc type
		pane.getChildren().add(base); // Add arc to pane
		
		Line pole = new Line(base.centerXProperty().get(), base.centerYProperty().get() - 10, base.centerXProperty().get(), base.centerYProperty().get() - 100);
		pole.setStrokeWidth(1);
		pane.getChildren().add(pole);
		
		Line highBar = new Line(pole.getEndX(),pole.getEndY(),pole.getEndX() + 40, pole.getEndY());
		highBar.setStrokeWidth(1);
		pane.getChildren().add(highBar);
		
		Line rope = new Line(highBar.getEndX(),highBar.getEndY(),highBar.getEndX(),highBar.getEndY() + 10);
		rope.setStrokeWidth(1);
		pane.getChildren().add(rope);
		
		//create body parts to be shown for wrong guesses
		Circle head = new Circle(rope.getEndX(), rope.getEndY() + 15, 15);
		head.setStroke(Color.BLACK);
		head.setFill(null);
//		pane.getChildren().add(head);
		
		Line body = new Line(rope.getEndX(), rope.getEndY() + 30, rope.getEndX(), rope.getEndY() + 60);
		body.setStrokeWidth(1);
//		pane.getChildren().add(body);
		
		Line leftArm = new Line(body.getStartX(), body.getStartY(), body.getStartX() - 10, body.getStartY() + 20);
		leftArm.setStrokeWidth(1);
//		pane.getChildren().add(leftArm);
		
		Line rightArm = new Line(body.getStartX(), body.getStartY(), body.getStartX() + 10, body.getStartY() + 20);
		rightArm.setStrokeWidth(1);
//		pane.getChildren().add(rightArm);
		
		Line leftLeg = new Line(body.getEndX(), body.getEndY(), body.getEndX() - 10, body.getEndY() + 20);
		leftLeg.setStrokeWidth(1);
//		pane.getChildren().add(leftLeg);
		
		Line rightLeg = new Line(body.getEndX(), body.getEndY(), body.getEndX() + 10, body.getEndY() + 20);
		rightLeg.setStrokeWidth(1);
//		pane.getChildren().add(rightLeg);

		Scene scene = new Scene(pane, 250, 150);
		primaryStage.setTitle("hangman"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

		//**********//
		//GAME LOGIC//   Couldn't get method to work properly, copied within start method
		//**********//
		
				// Create Scanner
				Scanner input = new Scanner(System.in);
				

				//loop to put words into the array
				System.out.println("Please enter 3 words below");
				System.out.println("--------------------------");
				
				for(int i = 0; i < Main.words.length; i++){
					System.out.print("Enter word " + (i+1) + ": ");
					Main.words[i] = input.next();
				}
				//line break
				System.out.println("");
				
				//create variable to assist with creating a new game or ending the game when complete
				String newGame = "y";
				
				//create a game as long as the user enters "y" at the end
				while (newGame.equals("y")){
					
					//retrieve a word from list of user entered words and hide the word for console
					String word = Main.newWord();
					String hiddenWord = Main.hideWord(word);
					
					//repeat guessing until all letters have been guessed
					while(!word.equals(hiddenWord)){
						System.out.print("(Guess) Enter a letter in the word " + hiddenWord + " : ");
						char ch = input.next().charAt(0);
						
						//checks if letter has already been guessed
						if (!Main.alreadyGuessed(hiddenWord, ch)) {
			                    hiddenWord = Main.processGuess(word, hiddenWord, ch);
			                    if (Main.isCorrect == false) {
		                        System.out.println(ch + " is not in the word.");
		                        Main.wrongGuess++;
		                        
		                        //add specific body part for a wrong guess
		                        switch(Main.getWrongGuess()){
		                        case 0:
		            				break;
		            			case 1: 
		            				pane.getChildren().add(head); break;
		            			case 2: 
		            				pane.getChildren().add(body); break;
		            			case 3: 
		            				pane.getChildren().add(leftArm); break;
		            			case 4: 
		            				pane.getChildren().add(rightArm); break;
		            			case 5: 
		            				pane.getChildren().add(leftLeg); break;
		            			case 6: 
		            				pane.getChildren().add(rightLeg); break;
		                        }
		                        
		                        //update GUI
		                        primaryStage.setScene(scene); // Place the scene in the stage
		                        primaryStage.show(); // Display the stage
		                    }
						}else {
							System.out.println(ch + " is already in word.");
						}
					}
					
					//display results
					System.out.println("Congrats! The word was " + word + ". You guessed incorrectly " + Main.wrongGuess +  " times.");
					
					//line break
					System.out.println("");
					
					//user choice to start a new game or end
					System.out.print("Do you want to guess another word from the list? Enter y or n: ");
					newGame = input.next();
					}
				
				input.close();
		
	}
	
}
