public class Exercise2 {
    public static void main(String[] args) {
        int[] arr1 = {89,36,12};
        int[] arr2 = {30,9,21,45,3,88};
        System.out.println(proximityLevel(arr1,arr2));

    }

    public static int sumNumber (int number) {
        int sum = 0;
        while (number > 0){
            sum = sum + number % 10;
            number = number / 10;
        }
        return sum;
    }


    public static int sendIntToSumNumber(int int1, int[] arr2) {
        int numberOfBrothers = 0;
        int sumNumber1 = sumNumber(int1);
        for (int i = 0; i < arr2.length; i++) {
            if (sumNumber1 == sumNumber(arr2[i])) {
                numberOfBrothers++;
            }
        }
        return numberOfBrothers;
    }


    public static int proximityLevel (int[] arr1, int[] arr2) {
        int indexLargestNumberOfBrothers = -1;
        int largestNumberOfBrothers = 0;

        for (int i = 0; i < arr1.length; i++) {
            int numberOfBrothers = sendIntToSumNumber(arr1[i], arr2);
            if (largestNumberOfBrothers < numberOfBrothers) {
                largestNumberOfBrothers = numberOfBrothers;
                indexLargestNumberOfBrothers = i;

            }
        }
        return indexLargestNumberOfBrothers;
    }

}
