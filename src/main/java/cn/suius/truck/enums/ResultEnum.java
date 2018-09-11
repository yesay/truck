package cn.suius.truck.enums;

public enum ResultEnum {

    UNKNOW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    HIGH_SCHOOL(100, "高中生"),
    JUNIOR_SCHOOL(200, "初中生"),;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
