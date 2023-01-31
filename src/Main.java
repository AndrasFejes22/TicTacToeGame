import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)){
            int userProvidedNumber = readInt("Please enter a number! 1: job against machine, 2: two-person game. ", scanner);
            System.out.println("The number entered by the user: " + userProvidedNumber);

            if(userProvidedNumber == 1){
                TicTacToe tictactoe = new TicTacToe();

            }
            if(userProvidedNumber == 2){
                TicTacToeTwoPersonGame ticTacToeTwoPersonGame = new TicTacToeTwoPersonGame();

            }
        }





    }

    static int readInt(String askMessage, Scanner scanner) {
        boolean inputCorrect;
        int number = 0;
        do {
            inputCorrect = true;
            System.out.println(askMessage);
            try {
                number = scanner.nextInt();
                if(number < 1 || number > 2){
                    System.out.println("\u001b[1;31m" + "You can onyly type 1 or 2!" + "\u001b[0m"); //red letters
                    inputCorrect = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("This is not a valid integer!");
                inputCorrect = false;
            } finally {
                scanner.nextLine();
            }
        } while (!inputCorrect);
        return number;
    }
}
