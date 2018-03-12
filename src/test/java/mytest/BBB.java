package mytest;

/**
 * author : huangweiyu
 * date : 2018/3/9
 * time : 14:20
 */
public interface BBB {

    default void print() {
        System.out.println("this method is in interface BBB");
    }
}
