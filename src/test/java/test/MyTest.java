package test;

import mytest.AAA;
import mytest.AAAImpl;
import org.joda.time.DateTime;

public class MyTest {

    public static void main(String[] args) {
        DateTime time = new DateTime(2018, 3, 5, 0, 0, 0, 0);
        System.out.println(time.toString("yyyy-MM-dd HH:mm:ss"));
        System.out.println(time.getDayOfWeek());

        Integer a = 123;
        Integer b = 123;
        Integer c = new Integer(123);
        Integer d = 1234;
        Integer e = 1234;
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(d == e);

        new AAAImpl().print();

    }

}
