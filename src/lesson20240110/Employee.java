package lesson20240110;

import java.util.Objects;

public class Employee {

    private String name;

    private String surname;

    private int age;

    private boolean isAtWork;

    public Employee(String name, String surname, int age, boolean isAtWork) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.isAtWork = isAtWork;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !this.getClass().equals(o.getClass())) return false;
        Employee another = (Employee) o;
        // This code can produce NullPointerException !!!
//        return this.name.equals(another.name) && this.surname.equals(another.surname)
//                && (this.age == another.age) && (this.isAtWork == another.isAtWork);
        return Objects.equals(this.name, another.name)
                && Objects.equals(this.surname, another.surname)
                && this.age == another.age
                && this.isAtWork == another.isAtWork;
    }

    @Override
    public int hashCode(){
        // This code can produce NullPointerException !!!
//        int result = name.hashCode() + 31 * surname.hashCode() + 31 * 31 * age
//                + 31 * 31 * 31 * ((isAtWork) ? 1 : 0);
        return Objects.hash(name, surname, age, isAtWork);
    }

}
