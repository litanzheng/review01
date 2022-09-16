package com.tencent.internet.qq.qqclient.qqcommon;

import java.io.Serializable;

public class Message implements Serializable {
    private static final long serialVersionUid= 1L;
    private String sender;
    private String getter;
    private String conttent;
    private String sendTime;
    private String mesType;

    public Message(String sender, String getter, String conttent, String sendTime, String mesType) {
        this.sender = sender;
        this.getter = getter;
        this.conttent = conttent;
        this.sendTime = sendTime;
        this.mesType = mesType;  //可以在接口定义消息类型
    }

    public Message() {

    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public String getConttent() {
        return conttent;
    }

    public void setConttent(String conttent) {
        this.conttent = conttent;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getMesType() {
        return mesType;
    }

    public void setMesType(String mesType) {
        this.mesType = mesType;
    }
}
