public class Exercise4 {
    public static void main (String []args) {
        int[] array = {7,5,8,4,6};
        System.out.println(isFullArray(array));
        System.out.println(isFullArrayAndDescending(array));
    }

    public static boolean isFullArray (int[] array) {
        boolean isFullArray = false;
        int biggestNumber = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] >= biggestNumber) {
                biggestNumber = array[i];
            }
        }

        int allNumbers = biggestNumber - 1;

        while (allNumbers != (biggestNumber - array.length)){
            if (isFoundInArray(array,allNumbers)){
                isFullArray = true;
            } else {
                isFullArray = false;
                break;
            }
            allNumbers--;
        }
        return isFullArray;
    }


    public static boolean isFoundInArray(int[] array, int number) {
        boolean isFound = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                isFound = true;
                break;
            }
        }
        return isFound;
    }


    public static boolean isFullArrayAndDescending (int[] array) {
        boolean isDescending = false;

            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] == (array[i + 1] + 1)) {
                    isDescending = true;
                }else {
                    isDescending = false;
                    break;
                }
            }
             return isDescending;
    }

}
