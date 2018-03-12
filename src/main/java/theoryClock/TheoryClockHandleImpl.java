package theoryClock;

import org.joda.time.DateTime;

/**
 * 时钟设置模版方法实现类
 */
public class TheoryClockHandleImpl implements TheoryClockHandle {

    /**
     * 步长1，用于设置灯的状态
     */
    private static final int STEP_1 = 1;

    /**
     * 步长5，用于设置灯的状态
     */
    private static final int STEP_5 = 5;

    /**
     * 因为发现每盏灯表示的时间不是以1为单位，就是5，所以当位单是5时，用于取余数
     */
    private static final int MOD = 5;

    /**
     * 时钟
     */
    private TheoryClock theoryClock;

    TheoryClockHandleImpl(TheoryClock theoryClock) {
        this.theoryClock = theoryClock;
    }

    /**
     * 设置顶端灯
     */
    @Override
    public void setTop() {
        DateTime dateTime = theoryClock.getDateTime();
        int second = dateTime.getSecondOfMinute();
        theoryClock.setTop(second % 2 == 0 ? LightStatusEnum.OFF : LightStatusEnum.ON);
    }

    /**
     * 设置第一排灯
     */
    @Override
    public void setFirstRow() {
        theoryClock.setFirstRow(analysisLightStatus(LightRowEnum.FIRST_ROW));
    }

    /**
     * 设置第二排灯
     */
    @Override
    public void setSecondRow() {
        theoryClock.setSecondRow(analysisLightStatus(LightRowEnum.SECOND_ROW));
    }

    /**
     * 设置第三排灯
     */
    @Override
    public void setThirdRow() {
        theoryClock.setThirdRow(analysisLightStatus(LightRowEnum.THIRD_ROW));
    }

    /**
     * 设置第四排灯
     */
    @Override
    public void setFourthRow() {
        theoryClock.setFourthRow(analysisLightStatus(LightRowEnum.FOURTH_ROW));
    }

    /**
     * 设置时钟每排灯的状态
     * @param row 第几排
     * @return
     */
    private LightStatusEnum[] analysisLightStatus(LightRowEnum row) {
        //从时钟中获取时间
        DateTime dateTime = theoryClock.getDateTime();
        //判断当前是第几排。第一，第二排，是设置的小时；第三，第四排是设置的分钟
        boolean isHour = isHour(row);
        //判断当前排是否要取余。第一，第三排不取余；第二，第四排要取余
        boolean isMod = isMod(row);
        //获取时间的整数类型
        int totalTime = isHour ? dateTime.getHourOfDay() : dateTime.getMinuteOfHour();
        //获取要计算的时间
        int time = isMod ? totalTime % MOD : totalTime;
        //获取步长
        int step = isMod ? STEP_1 : STEP_5;
        int index = 0;
        //获取当前排灯的数组
        LightStatusEnum[] lights = getLights(row);
        //遍历设置当前每盏灯的状态
        while ((time -= step) >= 0) {
            lights[index] = LightStatusEnum.ON;
            index++;
        }
        return lights;
    }

    /**
     * 判断当前是第几排。第一，第二排，是设置的小时；第三，第四排是设置的分钟
     * @param row 第几排枚举
     * @return
     */
    private boolean isHour(LightRowEnum row) {
        return LightRowEnum.FIRST_ROW.equals(row) || LightRowEnum.SECOND_ROW.equals(row);
    }

    /**
     * 判断当前排是否要取余。第一，第三排不取余；第二，第四排要取余
     * @param row 第几排枚举
     * @return
     */
    private boolean isMod(LightRowEnum row) {
        return LightRowEnum.SECOND_ROW.equals(row) || LightRowEnum.FOURTH_ROW.equals(row);
    }

    /**
     * 获取当前排灯的数组
     * @param row 第几排枚举
     * @return
     */
    private LightStatusEnum[] getLights(LightRowEnum row) {
        if (LightRowEnum.FIRST_ROW.equals(row)) {
            return theoryClock.getFirstRow();
        } else if (LightRowEnum.SECOND_ROW.equals(row)) {
            return theoryClock.getSecondRow();
        } else if (LightRowEnum.THIRD_ROW.equals(row)) {
            return theoryClock.getThirdRow();
        } else if (LightRowEnum.FOURTH_ROW.equals(row)){
            return theoryClock.getFourthRow();
        }
        throw new IllegalArgumentException("enum parameter error");
    }

    private enum LightRowEnum {

        //第一排灯
        FIRST_ROW,

        //第二排灯
        SECOND_ROW,

        //第三排灯
        THIRD_ROW,

        //第四排灯
        FOURTH_ROW

    }
}
