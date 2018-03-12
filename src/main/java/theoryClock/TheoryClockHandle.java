package theoryClock;

/**
 * 时钟设置模板方法接口
 */
public interface TheoryClockHandle {

    /**
     * 设置每行灯的状态
     */
    default void setLights() {
        //设置顶端灯
        setTop();
        //设置第一排灯
        setFirstRow();
        //设置第二排灯
        setSecondRow();
        //设置第三排灯
        setThirdRow();
        //设置第四排灯
        setFourthRow();
    }

    /**
     * 设置顶端灯
     */
    void setTop();

    /**
     * 设置第一排灯
     */
    void setFirstRow();

    /**
     * 设置第二排灯
     */
    void setSecondRow();

    /**
     * 设置第三排灯
     */
    void setThirdRow();

    /**
     * 设置第四排灯
     */
    void setFourthRow();
}
