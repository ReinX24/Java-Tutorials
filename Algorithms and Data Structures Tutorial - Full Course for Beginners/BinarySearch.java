import java.util.Random;
import java.util.stream.IntStream;

public class BinarySearch {

    public static void main(String[] args) {

        // Binary Search is generally faster than linear search, especially when it
        // comes to large data sets. To use binary search, the data set must be sorted
        // for it to find the index of the target number properly.

        // int[] numArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        // We start at 10 since it is the end index value and we divide that by 2 in the
        // first step
        // An array with 10 elements will take 4 steps to complete, 10 > 5 > 8 > 9 > 10
        // 20 elements will take 5 steps, 20 > 10 > 15 > 18 > 19 > 20
        // 40 elements will take 6 steps, 40 > 20 > 30 > 35 > 38 > 39 > 40

        // For every 10 elements, only 1 step is added, this means that this has a upper
        // bound of O(log n)
        // log2 16 = 4, this means that we have to divide 16 4 times by 2 in order to
        // get 1

        // This is applicable in our binary search algorithm, let's say we have 16
        // elements and our target element is 16, the steps would be, 8 (start at
        // middle) > 12 > 14 > 15 > 16

        int[] numArr = IntStream.range(1, 1000).toArray();
        Random random = new Random();
        int targetNum = numArr[random.nextInt(numArr.length)];

        long startTime = System.nanoTime();
        int targetIndex = binarySearch(targetNum, numArr);
        long totalTime = System.nanoTime() - startTime;

        System.out.println(targetNum + " is found at index " + targetIndex);
        System.out.println("Runtime: " + totalTime + "ns");

    }

    public static int binarySearch(int targetNum, int[] numArr) {
        int lowIndex = 0;
        int highIndex = numArr.length - 1;
        while (lowIndex <= highIndex) {
            int middleIndex = lowIndex + (highIndex - lowIndex) / 2;
            if (numArr[middleIndex] < targetNum) {
                lowIndex = middleIndex + 1;
            } else if (numArr[middleIndex] > targetNum) {
                highIndex = middleIndex - 1;
            } else {
                return middleIndex;
            }
        }
        return -1;
    }

}
