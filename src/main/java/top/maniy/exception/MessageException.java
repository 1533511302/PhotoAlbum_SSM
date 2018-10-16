package top.maniy.exception;

/**
 * @author liuzonghua
 * @Package top.maniy.exception
 * @Description:
 * @date 2018/10/16 22:03
 */
public class MessageException extends Exception {
    private  String msg;

    public MessageException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
