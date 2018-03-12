package mytest;

public interface AAA {
    default void print() {
        System.out.println("this method is in interface");
    }
}
