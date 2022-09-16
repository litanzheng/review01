package com.tencent.io.ouputstream;

import java.io.*;

//bufferedOutputStream bufferedinputStream文件复制
public class BufferedCopy {
    public static void main(String[] args) throws IOException {
        String srcFilePath = "d:\\小仙女.jpg";
        String descFilePath = "e:\\小仙女.jpg";
        BufferedInputStream bf = null;
        BufferedOutputStream bo = null;
        int readLen = 0;
        byte[] buf = new byte[1024];
        try {
            bf = new BufferedInputStream(new FileInputStream(srcFilePath));
            bo = new BufferedOutputStream(new FileOutputStream(descFilePath));
            while ((readLen = bf.read(buf))!=-1){
                bo.write(buf,0,readLen);
            }
            System.out.println("图片复制成功");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (bf != null){
                bf.close();
            }
            if (bo != null){
                bo.close();
            }
        }
    }
}
