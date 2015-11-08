package org.eu.slice.base.common;

/**
 * 运行时异常基础类
 *
 * @author shild
 */
public class BaseRuntimeException extends RuntimeException {

    /**
     * 异常编码
     */
    private String code = "99999";


    /**
     * 构造方法
     *
     * @param msg  错误消息
     */
    public BaseRuntimeException(String msg) {
        super(msg);
    }

    /**
     * 构造方法
     *
     * @param msg  错误消息
     */
    public BaseRuntimeException(String msg, Throwable cause) {
        super(msg, cause);
    }

    /**
     * 构造方法
     *
     * @param code 返回码
     * @param msg  错误消息
     */
    public BaseRuntimeException(String code, String msg) {
        super(msg);
        this.code = code;
    }


    /**
     * 构造方法
     *
     * @param code  返回码
     * @param msg   返回消息
     * @param cause 异常堆栈
     */
    public BaseRuntimeException(String code, String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    /**
     * 返回异常消息
     *
     * @return 异常消息
     */
    public String getMessage() {
        return BaseRuntimeException.buildMessage(super.getMessage(), getCause());
    }

    /**
     * 格式为：[msg]; nested exception is [cause.toString()]"
     * @param message
     * @param cause
     * @return
     */
    public static String buildMessage(String message, Throwable cause) {
        if (cause != null) {
            StringBuilder buf = new StringBuilder();
            if (message != null) {
                buf.append(message).append("; ");
            }
            buf.append("nested exception is ").append(cause);
            return buf.toString();
        } else {
            return message;
        }
    }
}
