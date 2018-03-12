package theoryClock;

import org.joda.time.DateTime;

/**
 * 创建时钟类
 */
public class TheoryClockFactory {

    /**
     * 根据时间创建时钟
     * @param dateTime 时间
     * @return
     */
    public TheoryClock create(DateTime dateTime) {
        //根据时间生成时钟
        TheoryClock theoryClock = new TheoryClock(dateTime);
        //用模板方法，设置各排灯的状态
        new TheoryClockHandleImpl(theoryClock).setLights();
        return theoryClock;
    }
}
