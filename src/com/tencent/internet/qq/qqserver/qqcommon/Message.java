package com.tencent.internet.qq.qqserver.qqcommon;

import java.io.Serializable;


//使用ObjectInputStream ObjectOutputStream 需要对象和其属性均实现序列化
public class Message implements Serializable {
    private static final long serialVersionUid= 1L;
    private String sender;
    private String getter;
    private String conttent;
    private String sendTime;
    private String mesType;

    private byte[] bytes;
    private int len;
    private String desc;
    private String src;

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

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
