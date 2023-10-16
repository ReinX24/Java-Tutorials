public class MergeSort {

    public static void main(String[] args) {
        int[] numArr = { 12, 11, 13, 5, 6, 7 };
        printArray(numArr);

        // The merge sort algoritm has an upper bound of n log g. log n for splitting
        // the array into two parts and n for sorting the array.
        sort(numArr, 0, numArr.length - 1);

        printArray(numArr);
    }

    public static void printArray(int[] numArray) {
        System.out.print("[");
        for (int i = 0; i < numArray.length; i++) {
            if (i == numArray.length - 1) {
                System.out.println(numArray[i] + "]");
            } else {
                System.out.print(numArray[i] + ", ");
            }
        }
    }

    public static void sort(int[] numArr, int leftIndex, int rightIndex) {

        if (leftIndex < rightIndex) {
            // Find the middle index or middle point
            int middleIndex = (leftIndex + rightIndex) / 2;

            // Sort the first and second halves
            sort(numArr, leftIndex, middleIndex); // left side of the array
            sort(numArr, middleIndex + 1, rightIndex); // right side of the array

            // Merge the sorted halves
            merge(numArr, leftIndex, middleIndex, rightIndex);
        }

    }

    public static void merge(int[] numArr, int leftIndex, int middleIndex, int rightIndex) {

        // Sub array lengths
        int leftArrLength = middleIndex - leftIndex + 1;
        int rightArrLength = rightIndex - middleIndex;

        // Creating temp arrays
        int[] leftArr = new int[leftArrLength];
        int[] rightArr = new int[rightArrLength];

        // Copying numArr contents to leftArr and rightArr
        for (int i = 0; i < leftArrLength; i++) {
            leftArr[i] = numArr[leftIndex + i];
        }
        for (int j = 0; j < rightArrLength; j++) {
            rightArr[j] = numArr[middleIndex + 1 + j]; // start adding after the middleIndex
        }

        // Merging and sorting the arrays
        int i = 0, j = 0; // i is for leftArr and j is for rightArr
        int startIndex = leftIndex;

        while (i < leftArrLength && j < rightArrLength) {
            // Sorting the array and adding elements to numArr
            if (leftArr[i] <= rightArr[j]) {
                numArr[startIndex] = leftArr[i];
                i++;
            } else {
                numArr[startIndex] = rightArr[j];
                j++;
            }
            startIndex++;
        }

        // Adding leftover elements in leftArr and rightArr
        while (i < leftArrLength) {
            numArr[startIndex] = leftArr[i];
            i++;
            startIndex++;
        }

        while (j < rightArrLength) {
            numArr[startIndex] = rightArr[j];
            j++;
            startIndex++;
        }
    }

}
