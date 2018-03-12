package mytest;

public class AAAImpl implements AAA, BBB {

    @Override
    public void print() {
        AAA.super.print();
        BBB.super.print();
        System.out.println("this is in sub class");
    }
}
