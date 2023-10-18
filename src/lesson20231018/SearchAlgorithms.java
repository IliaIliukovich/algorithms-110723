package lesson20231018;

public class SearchAlgorithms {

    public static void main(String[] args) {
        String[] data = new String[] {"A", "B", "Hello", "World", "!!!"};

        System.out.println(searchLinear(data, "B"));
        System.out.println(searchLinear(data, "C"));

        // binary search
        // data should be sorted!
        Integer[] intData = new Integer[] {-10, -7, 0, 12, 34, 34, 40};
        System.out.println(searchBinary(intData, 34));
    }

    // n = data.length
    // best case - 1 operation
    // worst case - log(n) operations ----> O(log n)
    public static int searchBinary(Integer[] data, int element) {
        int start = 0;
        int end = data.length - 1;
        int middle;

        while (start <= end){
            middle = start + (end - start) / 2;
            if (element == data[middle]) return middle;
            if (element > data[middle]) start = middle + 1;
            else end = middle - 1;
        }
        return -1;
    }

    // n = data.length
    // best case: 1 operation
    // worst case: n operations ----> O(n)
    public static int searchLinear(String[] data, String element){
        for (int i = 0; i < data.length; i++) {
            if (element.equals(data[i])) return i;
        }
        return -1;
    }

}
