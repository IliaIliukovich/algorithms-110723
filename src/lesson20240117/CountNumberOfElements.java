package lesson20240117;

public class CountNumberOfElements {

    public static void main(String[] args) {
        int[] data = {1, 1, 2, 2, 2, 2, 3};
        int element = 2;

        System.out.println(countNumberOfElements(data, element));
    }

    public static int countNumberOfElements(int[] data, int element) {
        int firstIndex = getFirstIndex(data, element);
        int lastIndex = getLastIndex(data, element);

        if (firstIndex != -1) {
            return lastIndex - firstIndex + 1;
        } else {
            return 0;
        }
    }

    private static int getFirstIndex(int[] array, int x) {
        int start = 0;
        int end = array.length - 1;
        int result = -1;

        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (array[middle] == x) {
                result = middle;
                end = middle - 1;
            } else if (array[middle] < x) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return result;
    }

    private static int getLastIndex(int[] array, int x) {
        int start = 0;
        int end = array.length - 1;
        int result = -1;

        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (array[middle] == x) {
                result = middle;
                start = middle + 1;
            } else if (array[middle] < x) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return result;
    }
}