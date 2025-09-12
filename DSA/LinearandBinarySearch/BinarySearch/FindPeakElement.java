package LinearandBinarySearch.BinarySearch;

import java.util.Arrays;

public class FindPeakElement {

    public static int findPeakElement(int[] arr) {
        int n = arr.length;

        // Edge cases: if there's only one element or peak is at ends
        if (n == 1) return 0;
        if (arr[0] > arr[1]) return 0;
        if (arr[n - 1] > arr[n - 2]) return n - 1;

        int left = 1;
        int right = n - 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid; // Found peak
            } else if (arr[mid] < arr[mid - 1]) {
                right = mid - 1; // Search left
            } else {
                left = mid + 1; // Search right
            }
        }

        return -1; // Should not reach here if input is valid
    }

    public static void main(String[] args) {
        int[] arr = {10, 3, 20, 4, 1, 2000};
        Arrays.sort(arr);
        int peakIndex = findPeakElement(arr);
        System.out.println("Peak element found at index: " + peakIndex);
        System.out.println("Peak element value: " + arr[peakIndex]);
    }
}
