package lesson20240110;

public class HashCodeExample {

    public static void main(String[] args) {

        Employee employee1 = new Employee("Tom", "Smith", 30, true);
        Employee employee2 = new Employee("Tom", "Smith", 30, true);

        Employee employee3 = new Employee("Tom", "Smith", 31, false);

        System.out.println(employee1.equals(employee2));
        System.out.println(employee1.hashCode());
        System.out.println(employee2.hashCode());

        System.out.println(employee1);

        System.out.println(employee1.equals(employee3));
        System.out.println(employee1.hashCode());
        System.out.println(employee3.hashCode());
    }

}
