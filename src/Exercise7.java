import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args){
        System.out.println("Please enter the quadratic equation: ");
        Scanner scanner = new Scanner(System.in);

        String equation = scanner.nextLine();
        int counter = 0;
        boolean isCorrect = false;
        int startIndexA = 0;
        int endIndexA = -1;
        int startIndexB = -1;
        int endIndexB = -1;
        int startIndexC = -1;
        int endIndexC = -1;
        int a;
        int b;
        int c;


        if (equation.length() >= 9){
            int lastIndex = equation.length() -1;
            if (equation.charAt(lastIndex - counter) == '0'){
                counter += 1;
                if (equation.charAt(lastIndex - counter) == '='){
                    counter += 1;
                    endIndexC = lastIndex - counter;

                    while (isNumber((lastIndex - counter),equation)) {
                        counter += 1;
                    }
                    startIndexC = lastIndex - counter;
                    if (equation.charAt(lastIndex - counter) == '+' || equation.charAt(lastIndex - counter) == '-') {
                        counter += 1;
                        if (equation.charAt(lastIndex - counter) == 'x'){
                            counter += 1;
                            endIndexB = lastIndex - counter;
                            while (isNumber((lastIndex - counter),equation)) {
                                counter += 1;
                            }
                            startIndexB = lastIndex - counter;
                            if (equation.charAt(lastIndex -counter) == '+' || equation.charAt(lastIndex - counter) == '-') {
                                counter += 1;
                                if (equation.charAt(lastIndex -counter) == '2') {
                                    counter += 1;
                                    if (equation.charAt(lastIndex - counter) == '^') {
                                        counter += 1;
                                        if (equation.charAt(lastIndex - counter) == 'x') {
                                            counter += 1;
                                            endIndexA = lastIndex - counter;
                                            if (lastIndex - counter == -1){
                                                isCorrect = true;
                                            }else if (equation.charAt(lastIndex - counter) == '-'){
                                                isCorrect = true;
                                            }else if (isNumber(lastIndex - counter,equation)){
                                                while (isNumber(lastIndex - counter,equation)){
                                                    if ((lastIndex - counter) <= 0) {
                                                        break;
                                                    }
                                                    counter += 1;
                                                }
                                                if (equation.charAt(lastIndex - counter) == '-'){
                                                    isCorrect = true;
                                                }
                                                if (lastIndex - counter == 0){
                                                    isCorrect = true;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (isCorrect){
            a = fromStringToInt(startIndexA,endIndexA,equation);
            b = fromStringToInt(startIndexB,endIndexB,equation);
            c= fromStringToInt(startIndexC,endIndexC,equation);
            quadraticEquationResult(a,b,c);
        }
    }




    public static int fromStringToInt (int startIndex,int endIndex, String str){
        int number = 0;
        boolean isNegative = false;
        boolean isRegular = true;

        if (endIndex == -1){
            isRegular = false;
            number = 1;
        }

        if (str.charAt(startIndex) == '+' && str.charAt(endIndex) == '+'){
            isRegular = false;
            number = 1;
        }

        if (str.charAt(startIndex) == '-' && str.charAt(endIndex) == '-'){
            isRegular = false;
            number = -1;
        }

        if (isRegular) {
            if (str.charAt(startIndex) == '-'){
                isNegative = true;
                startIndex++;
            }else if (str.charAt(startIndex) == '+'){
                startIndex++;
            }

            for (int i = startIndex; i <= endIndex; i++) {
                number =  number * 10 + (str.charAt(i) - '0');
            }
            // according to AsciiTable

            if (isNegative){
                number = -1*number;
            }
        }

        return number;
    }

    public static void quadraticEquationResult (int a, int b, int c){
        double delta = ((Math.pow(b,2) - 4 * a * c));
        if (delta < 0) {
            System.out.println("No solution was found for the quadratic equation.");

        }else if (delta > 0) {
            System.out.println("Two solutions to the equation were found:");
            System.out.println("x1= "+ (-b + Math.sqrt(delta)) / 2 * a);
            System.out.println("x2= "+ (-b - Math.sqrt(delta)) / 2 * a);

        }else{
            System.out.println("Only one solution was found:");
            System.out.println("x= " + -b / 2 * a);

        }
    }


    public static boolean isNumber (int index,String str) {
        boolean isNumber = false;
        String numbers = "0123456789";

            for (int i = 0; i < numbers.length(); i++) {
                if (str.charAt(index) == numbers.charAt(i)) {
                    isNumber = true;
                    break;
                }
            }
        return isNumber;
    }
}
