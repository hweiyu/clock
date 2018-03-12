package theoryClock;

import org.joda.time.DateTime;

/**
 * 在钟的顶端有一盏每两秒钟闪烁一次的黄灯。 前两排的灯为红色，每排4盏，共8盏，表示小时，
 * 其中第一排每盏灯代表5小时；第二排每盏灯代表1小时。（例如：第一排的两个灯和第二排的三个灯点亮，
 * 对应时间为5+5+3=13h或1 pm） 底部两排的灯表示分钟，第一排有11盏灯，每盏灯代表5分钟，
 * 其中第3、第6和第9盏的灯是红色，表示15分、30分和45分，其他的灯为黄色；
 * 最后一排有4盏灯，每盏灯代表1分钟。
 */
public class TheoryClock {

    /**
     * 时间
     */
    private DateTime dateTime;

    /**
     * 顶端的灯，每两秒钟闪烁
     */
    private LightStatusEnum top;

    /**
     * 第一排灯，每盏灯代表5小时
     */
    private LightStatusEnum[] firstRow;

    /**
     * 第二排灯，每盏灯代表1小时
     */
    private LightStatusEnum[] secondRow;

    /**
     * 第三排灯，每盏灯代表5分钟
     */
    private LightStatusEnum[] thirdRow;

    /**
     * 第四排灯，每盏灯代表1分钟
     */
    private LightStatusEnum[] fourthRow;

    public TheoryClock() {
        this(new DateTime());
    }

    public TheoryClock(DateTime dateTime) {
        this.dateTime = dateTime;
        init();
    }

    /**
     * 初始化所有灯的状态为关闭
     */
    private void init() {
        top = LightStatusEnum.OFF;
        firstRow = initArr(4);
        secondRow = initArr(4);
        thirdRow = initArr(11);
        fourthRow = initArr(4);
    }

    private LightStatusEnum[] initArr(int len) {
        LightStatusEnum[] lights = new LightStatusEnum[len];
        for(int i = 0; i < len; i++) {
            lights[i] = LightStatusEnum.OFF;
        }
        return lights;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public LightStatusEnum getTop() {
        return top;
    }

    public void setTop(LightStatusEnum top) {
        this.top = top;
    }

    public LightStatusEnum[] getFirstRow() {
        return firstRow;
    }

    public void setFirstRow(LightStatusEnum[] firstRow) {
        this.firstRow = firstRow;
    }

    public LightStatusEnum[] getSecondRow() {
        return secondRow;
    }

    public void setSecondRow(LightStatusEnum[] secondRow) {
        this.secondRow = secondRow;
    }

    public LightStatusEnum[] getThirdRow() {
        return thirdRow;
    }

    public void setThirdRow(LightStatusEnum[] thirdRow) {
        this.thirdRow = thirdRow;
    }

    public LightStatusEnum[] getFourthRow() {
        return fourthRow;
    }

    public void setFourthRow(LightStatusEnum[] fourthRow) {
        this.fourthRow = fourthRow;
    }

    public void print() {
        System.out.println("----------------------------------");
        System.out.println("time      : " + dateTime.toString("yyyy-MM-dd HH:mm:ss"));
        System.out.println("top       : " + toBit(top));
        System.out.println("firstRow  : " + toBit(firstRow));
        System.out.println("secondRow : " + toBit(secondRow));
        System.out.println("thirdRow  : " + toBit(thirdRow));
        System.out.println("fourthRow : " + toBit(fourthRow));
        System.out.println("----------------------------------");
    }

    private String toBit(LightStatusEnum light) {
        return String.valueOf(light.getStatus());
    }

    private String toBit(LightStatusEnum[] lights) {
        StringBuilder buf = new StringBuilder(20);
        for (LightStatusEnum light : lights) {
            buf.append(light.getStatus());
        }
        return buf.toString();
    }
}
