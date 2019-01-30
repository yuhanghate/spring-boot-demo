package com.example.demo.entity;

import java.io.Serializable;

public class MailEntity implements Serializable {

    private int code;

    private String message;

    private MailDataEntity data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MailDataEntity getData() {
        return data;
    }

    public void setData(MailDataEntity data) {
        this.data = data;
    }
}
