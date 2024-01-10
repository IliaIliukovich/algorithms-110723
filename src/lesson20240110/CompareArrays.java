package lesson20240110;

import java.util.Arrays;

public class CompareArrays {

//      Task: Проверьте, равны ли два массива или нет
//     Учитывая два массива, arr1 и arr2, одинаковой длины N, задача состоит в том, чтобы определить,
//     равны ли данные массивы или нет.
//
//     Два массива называются равными, если:
//     оба они содержат один и тот же набор элементов,
//     расположение (или перестановки) элементов может/не может быть одинаковым.
//     Если есть повторения, то количество повторяющихся элементов также должно быть одинаковым,
//     чтобы два массива были равны.
//
//    Ввод: arr1[] = {1, 2, 5, 4, 0, 0}, arr2[] = {0, 2, 4, 5, 0, 1}
//    Вывод: Да
    public static void main(String[] args) {
        int[] array1 = {1, 2, 1, 3};
        int[] array2 = {3, 2, 1, 1};
        System.out.println(isEqual(array1, array2));
    }

    public static boolean isEqual(int[] array1, int[] array2) {  // O(n log n)
        Arrays.sort(array1); // O(n log n)
        Arrays.sort(array2); // O(n log n)
        return Arrays.equals(array1, array2); // O(n)
    }


}
