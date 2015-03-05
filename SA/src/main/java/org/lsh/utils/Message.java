package org.lsh.utils;

/**
 * Created by lsh on 15/3/4.
 */
public class Message {

    private Object target;

    private String errorCode;

    private String message;

    public Message(Object target, String errorCode, String message) {
        this.target = target;
        this.errorCode = errorCode;
        this.message = message;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
