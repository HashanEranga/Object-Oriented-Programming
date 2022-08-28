public class MyMain {
    public static void main(String[] args) {
//        construct a random number array
        RandNum randNumArr = new RandNum();

//        print the number array
        randNumArr.displayArray();

//        print the maximum value
        randNumArr.displayMaximum();

//        print the minimum value
        randNumArr.displayMinimum();

//        print the average of the generated array
        randNumArr.displayAverage();
    }
}

class RandNum {
    private final int[][] arr = new int[5][5];

    public RandNum(){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
//                Random rand = new Random();
//                arr[i][j] = rand.nextInt(100-1)+1;

//                random number using random() function
                arr[i][j] = (int)Math.floor(Math.random()*(100) + 1);
            }
        }
    }

    public int calculateMinimum(){
        int minim = arr[0][0];
        for (int[] ints : arr) {
            for (int j = 0; j < arr.length; j++) {
                minim = Math.min(minim, ints[j]);
            }
        }
        return minim;
    }

    public int calculateMaximum(){
        int maxim = arr[0][0];
        for (int[] ints : arr) {
            for (int j = 0; j < arr.length; j++) {
                maxim = Math.max(maxim, ints[j]);
            }
        }
        return maxim;
    }

    public double calculateAverage(){
        int totalSum = 0;
        for (int[] ints : arr) {
            for (int j = 0; j < arr.length; j++) {
                totalSum += ints[j];
            }
        }

        return (double) totalSum / 25;
    }

    public void displayArray(){
        System.out.println("Array elements are the following.");
        for (int[] ints : arr) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(ints[j] + "\t");
            }
            System.out.println();
        }
    }

    public void displayMinimum(){
        System.out.println("The minimum value of the array will be : " + calculateMinimum());
    }

    public void displayMaximum(){
        System.out.println("The maximum value of the array will be : " + calculateMaximum());
    }

    public void displayAverage(){
        System.out.println("The Average value of the array will be : " + calculateAverage());
    }
}

