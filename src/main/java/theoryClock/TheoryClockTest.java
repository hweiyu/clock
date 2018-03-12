package theoryClock;

import org.joda.time.DateTime;

public class TheoryClockTest {

    public static void main(String[] args) {

        TheoryClockFactory factory = new TheoryClockFactory();

        DateTime dateTime = new DateTime();
        TheoryClock theoryClock1 = factory.create(dateTime);
        theoryClock1.print();

        dateTime = new DateTime(2018, 3, 8, 11, 23, 58, 0);
        TheoryClock theoryClock2 = factory.create(dateTime);
        theoryClock2.print();

        dateTime = new DateTime(2018, 3, 8, 0, 0, 0, 0);
        TheoryClock theoryClock3 = factory.create(dateTime);
        theoryClock3.print();

        dateTime = new DateTime(2018, 3, 8, 23, 59, 59, 0);
        TheoryClock theoryClock4 = factory.create(dateTime);
        theoryClock4.print();
    }
}
