package theoryClock;

/**
 * 灯的状态
 */
public enum  LightStatusEnum {

    //灯开启
    ON(1),

    //灯关闭
    OFF(0);

    private int status;

    LightStatusEnum(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
