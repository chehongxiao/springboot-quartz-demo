package com.example.springbootquartzdemo.entity;

public class ReturnMsg {
    private String code;
    private String caption;
    private String message;

    public ReturnMsg(String code, String caption) {
        this.code = code;
        this.caption = caption;
    }

    public ReturnMsg(String code, String caption, String message) {
        this.code = code;
        this.caption = caption;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
