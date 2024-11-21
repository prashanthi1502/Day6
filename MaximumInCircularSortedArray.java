public class MaximumInCircularSortedArray {
    public static int findMax(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        if (arr[low] <= arr[high]) {
            return arr[high];
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > arr[mid + 1]) {
                return arr[mid];
            }
            if (arr[mid - 1] > arr[mid]) {
                return arr[mid - 1];
            }
            if (arr[mid] >= arr[low]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // Example array
        int[] arr = {6, 7, 9, 15, 19, 2, 3};

        int max = findMax(arr);
        System.out.println("Maximum element in the circular sorted array: " + max);
    }
}