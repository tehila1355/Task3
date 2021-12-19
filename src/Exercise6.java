import java.util.Scanner;

public class Exercise6 {
    public static final int ZERO_IN_ASCII = 48;
    public static final int NINE_IN_ASCII = 57;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression;
        do {
            System.out.println("Please enter the arithmetic expression:  ");
            expression = scanner.nextLine();

        }while (!isValidExpression(expression));

        double result = calculation(expression);
        System.out.println("The result is : " +result);

    }

    public static double calculation (String expression) {
        double number1 = expression.charAt(0) - ZERO_IN_ASCII;
        double number2 = -1;
        int indexNumber2 = expression.length();
        int indexNumber1 = 1;
        int counter = 0;
        double result;


        while (indexNumber1 < expression.length() - 1) {
            for (int i = indexNumber1; i < indexNumber2; i++) {
                if (isNumber(expression,i)) {
                    number2 = expression.charAt(i) - ZERO_IN_ASCII;
                    counter = i;
                    break;
                }
            }

            for (int j = indexNumber1; j < indexNumber2; j++) {
                if (expression.charAt(j) == '+'){
                    number1 = number1 + number2;
                    break;
                }else if (expression.charAt(j) == '-') {
                    number1 = number1 - number2;
                    break;
                }else if (expression.charAt(j) == '*') {
                    number1 = number1 * number2;
                    break;
                }else if (expression.charAt(j) == '^') {
                    number1 = Math.pow(number1,number2);
                    break;
                }
            }
            indexNumber1 = counter + 1;
        }
        result = number1;

        return result;
    }




    public static boolean isNumber(String expression, int index) {
        boolean isNumber = false;
        if (expression.charAt(index) >= ZERO_IN_ASCII && expression.charAt(index) <= NINE_IN_ASCII) {
            isNumber = true;
        }
        return isNumber;
    }

    public static boolean isOperator(char charToCheck) {
        boolean isOperator = false;
        if (charToCheck == '*' || charToCheck == '+' || charToCheck == '-' || charToCheck == '^') {
            isOperator = true;

        }
        return isOperator;
    }

    public static boolean isValidExpression(String expression) {
        int openParentheses = 0;

        if (isOperator(expression.charAt(0)) || isOperator(expression.charAt(expression.length() - 1))) {
            return false;
        }

        for (int i = 0; i < expression.length(); i++) {

            //check if there are parentheses:
            if (expression.charAt(i) == '('){
                openParentheses++;

            }else if (expression.charAt(i) == ')') {
                if (openParentheses <= 0) {
                    return false;
                }

                // check if there is : " )( " without operator between:
                else if (i < (expression.length()-1)){
                    if (expression.charAt(i+1) == '(') {
                        return false;
                    }
                }
                openParentheses--;

                //check if the char is operator (+,-,*,^)
            } else if (isOperator(expression.charAt(i))) {
                if (isOperator(expression.charAt(i + 1))) {
                    return false;
                }


                //check if a char is a number:
            } else if (!isNumber(expression,i)){
                return false;

            }else {
                if (i <(expression.length()-1)){
                    //check if after a number comes '(':
                    if (expression.charAt(i+1) == '(') {
                        return false;
                    }
                }
            }

        }
        // if the parentheses are not equal it false:
        if (openParentheses !=0){
            return false;
        }
        return true;
    }

}