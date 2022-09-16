package com.tencent.internet.upload;

import java.io.*;
import java.util.StringTokenizer;

public class StreamUtils {
    public static void main(String[] args) {

    }

    public static byte[] streamToByteArray(InputStream is) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int len;
        while ((len = is.read(bytes))!=-1){
            bos.write(bytes,0,len);
        }
        byte[] array = bos.toByteArray();
        bos.close();
        return array;
    }

    public static String streamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine())!=null){
            builder.append(line+"\r\n");
        }
        return builder.toString();
    }
}
