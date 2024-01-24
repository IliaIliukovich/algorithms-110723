package lesson20240124;

import java.util.Arrays;
import java.util.Comparator;

public class BookShop {

    public static void main(String[] args) {
        Book book1 = new Book("Harry Potter 1", 100, true);
        Book book2 = new Book("Harry Potter 2", 100, false);
        Book book3 = new Book("Harry Potter 3", 100, true);
        Book book4 = new Book("Harry Potter 4", 50, false);
        Book book5 = new Book("Harry Potter 5", 50, true);

        Book[] books = {book1, book2, book3, book4, book5};

        SelectionSort.selectionSort(books, Comparator.comparing(book -> ((Book) book).getName()));
        System.out.println("After first sort by name:");
        for (Book b : books){
            System.out.println(b);
        }

        // selectionSort -----> unstable
        SelectionSort.selectionSort(books, Comparator.comparingInt(book -> ((Book) book).getPrice()));
        System.out.println("After second sort by price:");
        for (Book b : books){
            System.out.println(b);
        }


        // mergeSort -----> stable
        System.out.println("After second sort by price:");
        Arrays.sort(books, Comparator.comparingInt(book -> book.getPrice()));
        for (Book b : books){
            System.out.println(b);
        }

    }


}
