public class Exercise5 {
    public static void main(String[] args) {
        String str = "take this text and test it";
        System.out.println(exchangingCharactersInAString(str));
    }

    public static String exchangingCharactersInAString(String str) {
        int counter = 0;
        int biggestTimes = 0;
        int secondBiggestTines = 0;
        char biggestChar = '#';
        char secondBigChar = '$';
        String newStr = "";

        for (int i = 0; i < str.length(); i++) {
            if (isNewChar(str, i)){
                for (int j = i; j < str.length(); j++) {
                    if (str.charAt(j) == str.charAt(i)){
                        counter += 1;
                    }
                }
                if (counter > biggestTimes){
                    secondBiggestTines = biggestTimes;
                    biggestTimes = counter;
                    biggestChar = str.charAt(i);
                }else if (counter > secondBiggestTines){
                    secondBiggestTines = counter;
                    secondBigChar = str.charAt(i);
                }
                counter = 0;
            }
        }
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == secondBigChar){
                newStr = newStr + biggestChar;
            }else if (str.charAt(i) == biggestChar){
                newStr = newStr + secondBigChar;
            }else {
                newStr = newStr + str.charAt(i);
            }
        }
        return newStr;
    }



    public static boolean isNewChar(String str, int index){
        boolean isNewChar = false;
        if (str.charAt(index) != ' '){
            for (int i = 0; i < index; i++) {
                if (str.charAt(i) == str.charAt(index)){
                    isNewChar = false;
                    break;
                }else {
                    isNewChar = true;
                }
            }
        }

        if (index == 0){
            isNewChar = true;
        }
        return isNewChar;
    }
}
