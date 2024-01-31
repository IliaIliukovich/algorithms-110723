package lesson20240131;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class LibrarySorts {

    public static void main(String[] args) {
        int[] data = {3, 2, 6, 2};

        Arrays.sort(data); // quicksort - unstable

        String[] strings = {"One", "Two", "Three"};

        Arrays.sort(strings); // mergesort - stable

        Collections.sort(Arrays.asList(strings)); // mergesort - stable

    }



}
