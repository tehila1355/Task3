import java.util.Random;
import java.util.Scanner;

public class Exercise9 {
    public static final int ARRAY_SIZE = 4;
    public static final int MAX_IN_SURPRISING_ROAD = 25;
    public static final int MIN_IN_SURPRISING_ROAD = 5;
    public static final int MAX_GUESS = 6666;
    public static final int MIN_GUESS = 1111;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean correct = false;
        int secretCode = 0;
        int guess = 0;
        int opportunities;
        int road = 0;
        int easyRoad = 20;
        int mediumRoad = 15;
        int hardRoad = 10;
        int surprisingRoad = random.nextInt(MAX_IN_SURPRISING_ROAD - MIN_IN_SURPRISING_ROAD + 1) + MIN_IN_SURPRISING_ROAD;



        while (!correct) {
            secretCode = random.nextInt(MAX_GUESS - MIN_GUESS + 1) + MIN_GUESS;
            correct = numbersSmallerThanSix(secretCode);
            if (correct){
                correct = isNotDoubleChar(secretCode);
            }
        }
        correct = false;


        while (road != 1 && road != 2 && road != 3 && road != 4) {
            System.out.println("Select a difficulty level");
            System.out.println("Enter 1 for easy road:       20 opportunities");
            System.out.println("Enter 2 for medium road:      15 opportunities");
            System.out.println("Enter 3 for hard road:        10 opportunities");
            System.out.println("Enter 4 for Surprising track:  The number of opportunities is drawn between the values 5-25");
            road = scanner.nextInt();
        }
        if (road == 1){
            opportunities = easyRoad;
        }else if (road == 2){
            opportunities = mediumRoad;
        } else if (road == 3){
            opportunities = hardRoad;
        }else {
            opportunities = surprisingRoad;
        }


        while (opportunities != 0){
            while (!correct) {
                System.out.println("Enter a guess");
                guess = scanner.nextInt();
                if (guess > MIN_GUESS && guess < MAX_GUESS){
                    correct = numbersSmallerThanSix(guess);

                    if (correct){
                        correct = isNotDoubleChar(guess);
                        if (!correct){
                            opportunities -= 2;
                            System.out.println("you have minus two chances..");
                        }
                    }
                }
            }

            if (guess == secretCode) {
                System.out.println(":) You win");
                break;
            } else {
                guess(guess,secretCode);
                opportunities -= 1;
                correct = false;
                if (road != 4) {
                    System.out.println("You have " + opportunities + " more attempts");
                }
            }
        }
        if (opportunities == 0) {
            System.out.println("failure, The secret code is " + secretCode);
        }

        System.out.println("Game over");

    }


    public static int extricationNumber(int index, int numbers) {
        int tens = 1000;
        while (index != 0) {
            tens = tens / 10;
            index--;
        }
        return (numbers / tens) % 10;
    }


    public static boolean isNotDoubleChar(int number) {
        boolean isNewChar = true;

        int [] array = new int[ARRAY_SIZE];
        for (int i = 0; i < array.length; i++) {
            array[i] = extricationNumber(i,number);
            if (i != 0) {
                for (int j = 0; j < i; j++) {
                    if (array[j] == array[i]) {
                        isNewChar = false;
                        break;
                    }
                }
            }
            if (!isNewChar) {
                break;
            }
        }
        return isNewChar;
    }

    public static boolean numbersSmallerThanSix (int number) {
        boolean smallerThanSix = false;
        int digit = 0;
        for (int i = 0; i <= 3; i++) {
            digit = extricationNumber(i, number);

            if (digit <= 6 && digit >= 1) {
                smallerThanSix = true;
            } else {
                smallerThanSix = false;
                break;
            }
        }
        return smallerThanSix;
    }

    public static void guess (int guss, int secretCode) {
        int accurateGuessing = 0;
        int partialGuess = 0;
        for (int i = 0; i < 4; i++) {
            if (extricationNumber(i,guss) == extricationNumber(i,secretCode)){
                accurateGuessing += 1;
            }else {
                for (int j = 0; j < 4; j++) {
                    if (extricationNumber(i,guss) == extricationNumber(j,secretCode)){
                        partialGuess += 1;
                    }
                }
            }
        }
        System.out.println("There is " + accurateGuessing + " accurate guessing and " + partialGuess + " Partial guess");
    }

}
