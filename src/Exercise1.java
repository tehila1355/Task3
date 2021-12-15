public class Exercise1 {
    public static void main (String []args) {
        int[] array = {444,987,4756,123};

        System.out.println(smallestAlternateNumber(array));
    }

    public static boolean isAlternate (int number) {
        boolean isAlternate = false;

        while (number > 0) {
            if (number  % 2 == 0){
                if ((number / 10) % 2 == 1){
                    isAlternate = true;
                }else {
                    isAlternate = false;
                    break;
                }
            }else {
                if ((number / 10) % 2 == 0){
                    isAlternate = true;
                }else {
                    isAlternate = false;
                    break;
                }
            }
            number = number / 10;

        }
        return isAlternate;
    }

    public static int smallestAlternateNumber (int[] array) {
        int indexSmallest = -1;
        int smallestSum = 0;
        for (int i = 0; i < array.length; i++) {
            if (isAlternate(array[i])) {
                smallestSum = sumNumber(array[i]);
                indexSmallest = i;
                break;
            }
        }

        if (indexSmallest != -1){
            for (int j = indexSmallest; j < array.length; j++) {
                if (isAlternate(array[j])){
                    if (sumNumber(array[j]) < smallestSum){
                        indexSmallest = j;
                    }
                }
            }
        }


        return indexSmallest;
    }

    public static int sumNumber (int number) {
        int sum = 0;
        while (number > 0){
            sum = sum + number % 10;
            number = number / 10;
        }
        return sum;
    }

}
