package com.tencent.wrapper;

public class StringBuffer01 {
    public static void main(String[] args) {
        String str = "hello java";

        StringBuffer stringBuffer = new StringBuffer(str);
        StringBuffer buffer = new StringBuffer();
        buffer.append(str);
        System.out.println(str);
        System.out.println(stringBuffer);

        //StringBuffer -- String
        String s = stringBuffer.toString();
        System.out.println(s);
        s = new String(buffer);
    }
}
