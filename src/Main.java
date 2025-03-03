import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean keepPlaying = true;

        while (keepPlaying) {
            System.out.println("\nRolling the dice...");
            int dice1 = random.nextInt(6) + 1;
            int dice2 = random.nextInt(6) + 1;
            int sum = dice1 + dice2;

            System.out.printf("Initial Roll: Die1 = %d, Die2 = %d, Sum = %d%n", dice1, dice2, sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You crapped out and found out... you lost.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! Nice one, You won!");
            } else {
                int point = sum;
                System.out.println("The point is now " + point + ". Keep rolling to match it before rolling a 7.");
                boolean tryingForPoint = true;

                while (tryingForPoint) {
                    dice1 = random.nextInt(6) + 1;
                    dice2 = random.nextInt(6) + 1;
                    sum = dice1 + dice2;

                    System.out.printf("Rolling: Dice1 = %d, Dice2 = %d, Sum = %d%n", dice1, dice2, sum);

                    if (sum == point) {
                        System.out.println("Made point You win");
                        tryingForPoint = false;
                    } else if (sum == 7) {
                        System.out.println("Got a seven You lost");
                        tryingForPoint = false;
                    } else {
                        System.out.println("Trying for point...");
                    }
                }
            }


            System.out.print("\nDo you want to play again? (y/n): ");
            String response = scanner.next().trim().toLowerCase();
            keepPlaying = response.equals("y");
        }

        System.out.println("Thanks for playing, Goodbye.");
        scanner.close();
    }
}
