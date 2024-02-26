import java.awt.*;
import java.sql.SQLOutput;
import java.util.*;
import java.util.List;

public class GuessingGame {

    static ArrayList<String> guessingWords = new ArrayList<>(
            List.of("Rolling Stones", "Bohemian Rhapsody", "Killer Queen", "Little Boy", "Imagine Dragons"));

    public static String getRandomWord() {
        Random random = new Random();
        int randomIndex = random.nextInt(guessingWords.size());
        return guessingWords.get(randomIndex);
    }

    public static void game() {

        String message = """
                === WELCOME TO THE GAME ===
                
                How many guesses to you want to have (4 to 10):
                """;

        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        int livesLeft;

        try {
            livesLeft = Integer.parseInt(scanner.nextLine());
            if(livesLeft > 10 || livesLeft < 4) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("\n come on no cheating; for that you get 3 tries");
            livesLeft = 3;
        }

        String secretWord = getRandomWord();
        StringBuilder guessedWord = new StringBuilder(secretWord.length());
        for (int i = 0; i < secretWord.length(); i++) {
            if(secretWord.charAt(i) == ' ') {
                guessedWord.append(' ');
            } else {
                guessedWord.append('_');
            }
        }

        HashMap<Character, Integer> incorrectGuesses = new HashMap<>();

        while(livesLeft > 0) {
            System.out.print("\033[H\033[2J");

            System.out.printf("""
                    %s
                    
                    Lives left: %d
                    Type you guess:
                    %n""", guessedWord.toString(), livesLeft);
            char guess = scanner.next().charAt(0);

            if (!Character.isLetter(guess)) {
                System.out.println("Please enter a valid letter.");
                continue;
            }

            if (secretWord.contains(String.valueOf(guess))) {
                for (int i = 0; i < secretWord.length(); i++) {
                    if (Character.toUpperCase(secretWord.charAt(i))  == Character.toUpperCase(guess)) {
                        guessedWord.setCharAt(i, guess);
                    }
                }
            } else {
                System.out.println("Incorrect guess: " + guess);
                incorrectGuesses.put(guess, livesLeft-1);
                livesLeft--;
            }

            if (secretWord.equalsIgnoreCase(guessedWord.toString())) {
                System.out.println("Congratulations! You guessed the word: " + secretWord);
                break;
            }
        }

        if (livesLeft == 0) {
            System.out.println("Game over! You've run out of attempts.");
            System.out.println("The word was: " + secretWord);
        }

        System.out.println("Incorrect guesses:");
        for (char incorrectGuess : incorrectGuesses.keySet()) {
            System.out.println(incorrectGuess + " (Attempt " + incorrectGuesses.get(incorrectGuess) + ")");
        }

        scanner.close();
    }

    public static void main(String[] args) {
        game();
    }


}
