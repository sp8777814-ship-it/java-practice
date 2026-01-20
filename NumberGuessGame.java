import java.util.*;

public class NumberGuessGame {
    public static void main(String s[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Eneter a number: ");

        int guess;
        Random rd = new Random();
        int num = rd.nextInt(100);
        int attempts = 0;
        System.out.println("Guess a number  1 to 100");
        while (true) {
            guess = sc.nextInt();
            attempts++;

            if (guess == num) {
                System.out.println(" guessed correct " + guess + " in number of attempts: " + attempts);
            } else {
                if (guess < num)
                    System.out.println(" low");
                else
                    System.out.println(" high");
            }
        }
    }
}