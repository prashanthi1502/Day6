public class SearchRangeInSortedArray {

    public static int findFirstOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1, result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                result = mid;
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    public static int findLastOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1, result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                result = mid;
                low = mid + 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    public static int[] searchRange(int[] arr, int target) {
        int[] result = new int[2];
        result[0] = findFirstOccurrence(arr, target);
        result[1] = findLastOccurrence(arr, target);
        return result;
    }

    public static void main(String[] args) {
        // Example array
        int[] arr = {1, 2, 2, 2, 3, 4, 5, 6, 6, 6};
        int target = 2;
        int[] result = searchRange(arr, target);

        if (result[0] == -1) {
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("Range of indices for " + target + ": [" + result[0] + ", " + result[1] + "]");
        }
    }
}