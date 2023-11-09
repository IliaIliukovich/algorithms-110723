package lesson20231108;

public class RecurisiveAlgExamples {

    public static void main(String[] args) {

        f(90);

        System.out.println("Result: " + f1(15));
    }

    private static int f1(int n) {
        System.out.println("f1 function with input n = " + n);
//        if (n == 20) return 20; // base condition
        if (n >= 20) return 20; // base condition
        return f2(n + 1);
    }

    private static int f2(int n) {
        System.out.println("f2 function with input n = " + n);
        return f1(n + 1);
    }

    private static void f(int n) {
        System.out.println(n);
        if (n == 100) return; // base condition
        f(n + 1);
    }


}
