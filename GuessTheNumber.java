package guessthenumber;

import javax.swing.JOptionPane;
/**
 *
 * @author 041111101
 */
public class GuessTheNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialize variables
        int randNumber = (int)(Math.random() * 100);
        int userInput = 0;
        
        // Initialize for() loop
        // The loop will run until either
        //  a. The user inputted number matches the random number.
        //  b. They use up all 6 turns, and the program terminates.
        for(int i = 0; i < 6; i++) {
            if(i == 0) {
                // Request input of a number between 1 & 100.
                userInput = Integer.parseInt(JOptionPane.showInputDialog(null, "Guess the number! (1 - 100)"));
                    // If user input matches the random number, the loop will exit, and they win the game.
                    if(userInput == randNumber) {
                        JOptionPane.showMessageDialog(null, "Congratulations, you've won!!");
                        break;
                    }
            // This statement will only run when they have done their first guess (and failed).        
            } else if(i > 0) {
                // Prompt user for input, also displaying the amount of attempts they have done, and how many they have left.
                userInput = Integer.parseInt(JOptionPane.showInputDialog(null,  message(userInput, randNumber) + "\n"
                                                                             + "You have had " + i + " attempt(s)! You have " + (6 - i) + " attempts left!\n"
                                                                             + "Guess the number! (1 - 100)"));
                     // If user input matches the random number, the loop will exit, and they win the game.
                     if(userInput == randNumber) {
                        JOptionPane.showMessageDialog(null, "Congratulations, you've won!");
                        break;
                    }
            } else {
            // If the user uses all 6 tries without success, it will finish here and terminate.
            JOptionPane.showMessageDialog(null, "Sorry, you've reached the maximum amount of attempts without guessing right.\n"
                                                  + "Better luck next time!");
            }
        }
    }
    
    public static String message(int user, int rand) {
        // Initialize variables.
        // Maths.abs(user - rand) to make all values entered absolute, as (user - rand) could result in a negative. E.g (4 - 60)
        String message = "";
        int difference = Math.abs(user - rand);
        
        // If the user input is higher than the random number, it will parse to userHigh()
        // Else, it will parse to userLow()
        if(user > rand) {
           message = userHigh(difference);
        } else {
           message = userLow(difference);
        }
        return message;
    }
    
    public static String userHigh(int difference) {
        String message;
            
            if((difference >= 1) && (difference <= 15)) {
                message = "Your guess is somewhat high!\n";
            } else if((difference > 15) && (difference <= 30)) {
                message = "Your guess is moderately high!\n";
            } else if((difference > 30) && (difference <= 50)) {
                message = "Your guess is high!\n"; 
            } else if(difference > 50) {
                message = "Your guess is very high!\n";
            } else {
                message = "Method error\nParsed to userHigh";
            }
            
        return message;
    }
    
    public static String userLow(int difference) {
        String message;
        
            if((difference >= 1) && (difference <= 15)) {
               message = "Your guess is somewhat low!\n";
            } else if((difference > 15) && (difference <= 30)) {
                message = "Your guess is moderately low!\n";
            } else if((difference > 30) && (difference <= 50)){
                message = "Your guess is low!\n";
            } else if(difference > 50){
                message = "Your guess is very low!\n";
            } else {
                message = "Method error\nParsed to userLow";
            }
        return message;
    }
}
