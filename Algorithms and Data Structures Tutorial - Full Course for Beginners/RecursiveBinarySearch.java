
public class RecursiveBinarySearch {

    public static void main(String[] args) {

        int[] numArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        boolean targetExists = recursiveBinarySearch(numArr, 0, numArr.length - 1, 10);
        verifyResult(targetExists);

        targetExists = recursiveBinarySearch(numArr, 0, numArr.length - 1, -5);
        verifyResult(targetExists);

    }

    // Returns a boolean value that tells if the value exists or not
    public static boolean recursiveBinarySearch(int[] numArr, int startIndex, int endIndex, int targetNum) {
        if (numArr.length == 0) {
            return false; // means that the targetNum is not in numArr
        }

        int midIndex = startIndex + (endIndex - startIndex) / 2;

        if (startIndex <= endIndex) {
            if (numArr[midIndex] == targetNum) {
                return true;
            } else if (numArr[midIndex] < targetNum) {
                return recursiveBinarySearch(numArr, midIndex + 1, endIndex, targetNum);
            } else if (numArr[midIndex] > targetNum) {
                return recursiveBinarySearch(numArr, startIndex, midIndex - 1, targetNum);
            }
        }

        return false;
    }

    public static void verifyResult(boolean searchResult) {
        if (searchResult) {
            System.out.println("Target Found!");
        } else {
            System.out.println("Target Not Found!");
        }
    }

}
