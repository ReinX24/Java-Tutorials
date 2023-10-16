import java.util.Random;
import java.util.stream.IntStream;

public class LinearSearch {

    public static void main(String[] args) {

        // int[] numArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] numArr = IntStream.range(1, 1000).toArray();
        Random random = new Random();
        int targetNum = numArr[random.nextInt(numArr.length)];

        long startTime = System.nanoTime();
        int targetIndex = linearSearch(numArr, targetNum);
        long totalTime = System.nanoTime() - startTime;

        System.out.println(targetNum + " is found at index " + targetIndex);
        System.out.println("Runtime: " + totalTime + "ns");

    }

    // Returns the index of the targetNum, else return -1
    public static int linearSearch(int[] numArr, int targetNum) {
        for (int i = 0; i < numArr.length; i++) {
            if (targetNum == numArr[i]) {
                return i;
            }
        }
        return -1;
    }

}