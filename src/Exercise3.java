public class Exercise3 {
    public static void main(String[] args) {
        int number = 12600;
        int [] primeFactors = findPrimeFactors(number);
        for (int i = 0; i < primeFactors.length; i++) {
            System.out.print( primeFactors[i]+ ",");
        }


    }
    public static int[] findPrimeFactors(int number){
        int [] primeFactors = new int[number];
        int counter = 0;
        int index = -1;
        for (int i = 2; i < number ; i++) {
            while (number % i == 0){
                counter++;
                index++;
                primeFactors [index] = i;
                number = number / i;
            }
        }

        if (number!= 1){
            counter++;
            index++;
            primeFactors [index] = number;
        }

        int [] newPrimeFactors = new int[counter];
        for (int i = 0; i < newPrimeFactors.length; i++) {
            newPrimeFactors [i] = primeFactors[i];

        }
        return newPrimeFactors;
    }

}