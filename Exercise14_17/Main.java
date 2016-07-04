import java.util.Scanner;


/**
 * 
 */

/**
 * (Game: hangman) Write a program that displays a
 * drawing for the popular hangman game, as shown
 * in Figure 14.48a.
 * 
 * @author Kris
 * @version 1.0
 * @since 06-28-2016
 */
public class Main {

	//Create an array to store user entered words
	static String[] words = new String[3];
		
	//create variable to hold 
	static boolean isCorrect = false;
	
	//track wrong guesses
	static int wrongGuess = 0;
	
	public static void hangman(){
		// Create Scanner
		Scanner input = new Scanner(System.in);
		

		//loop to put words into the array
		System.out.println("Please enter 3 words below");
		System.out.println("--------------------------");
		
		for(int i = 0; i < words.length; i++){
			System.out.print("Enter word " + (i+1) + ": ");
			words[i] = input.next();
		}
		//line break
		System.out.println("");
		
		//create variable to assist with creating a new game or ending the game when complete
		String newGame = "y";
		
		//create a game as long as the user enters "y" at the end
		while (newGame.equals("y")){
			//retrieve a word from list of user entered words and hide the word for console
			String word = newWord();
			String hiddenWord = hideWord(word);
			
			//repeat guessing until all letters have been guessed
			while(!word.equals(hiddenWord)){
				System.out.print("(Guess) Enter a letter in the word " + hiddenWord + " : ");
				char ch = input.next().charAt(0);
				

				
				//checks if letter has already been guessed
				if (!alreadyGuessed(hiddenWord, ch)) {
	                    hiddenWord = processGuess(word, hiddenWord, ch);
	                    if (isCorrect == false) {
                        System.out.println(ch + " is not in the word.");
                        wrongGuess++;
                        //add body part to drawing
                    } 
				}else {
					System.out.println(ch + " is already in word.");
				}
				}
			//display results
			System.out.println("Congrats! The word was " + word + ". You guessed incorrectly " + wrongGuess +  " times.");
			
			//line break
			System.out.println("");
			
			//user choice to start a new game or end
			System.out.print("Do you want to guess another word from the list? Enter y or n: ");
			newGame = input.next();
			}
		
		input.close();
}
		

	public static int getWrongGuess(){
		return wrongGuess;
	}
	
	public static void setWrongGuess(int wrongGuess){
		Main.wrongGuess = wrongGuess;
	}
	
	//method to retrieve a random word from the array of user entered words
	public static String newWord() {
        return words[(int) (Math.random() * words.length)];
    }
	//create hidden word to display on console
	public static String hideWord(String word) {
		
		String hidden = "";
		for (int i = 0; i < word.length(); i++) {
			hidden += "*";
		}
		return hidden;
	}
	//check if letter has already been guessed
    public static boolean alreadyGuessed(String hiddenWord, char ch) {
    	
    	for (int i = 0; i < hiddenWord.length(); i++) {
    		if (ch == hiddenWord.charAt(i)) {
    			return true;
    		}
    	}
    	return false;
    }
    //check if letter is in the word and replace * in hidden word if true
	public static String processGuess(String word, String hiddenWord, char ch){
		
		isCorrect = false;
		StringBuilder s = new StringBuilder(hiddenWord);
	        
		for (int i = 0; i < word.length(); i++) {
			if (ch == word.charAt(i) && s.charAt(i) == '*') {
	            isCorrect = true;
	            s.setCharAt(i, ch);
			}
		}
		return s.toString();
	}

}
