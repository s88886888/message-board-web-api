package model;

public class ResultVo {

    private int code;

    private String msg;

    private Object data;


    public ResultVo(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultVo() {
    }

    public ResultVo success(Object data) {
        return new ResultVo(200, "success", data);
    }

    public ResultVo error(Object data) {
        return new ResultVo(201, "error", data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
