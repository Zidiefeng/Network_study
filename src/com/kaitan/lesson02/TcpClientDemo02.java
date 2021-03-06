package com.kaitan.lesson02;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClientDemo02 {
    public static void main(String[] args) throws IOException {
        //创建一个Socket连接
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);
        //创建一个输出流
        OutputStream os = socket.getOutputStream();

        //文件流-读取文件
        FileInputStream fileIS = new FileInputStream(new File("1.jpg"));
        //写出文件
        byte[] buffer = new byte[1024];
        int len;
        while ((len=fileIS.read(buffer))!=-1){
            os.write(buffer, 0,len);
        }

        //通知服务器，我已经传完了
        socket.shutdownOutput();

        //确定服务器 接收完毕，才能断开
        InputStream inputStream = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer2 = new byte[1024];
        int len2;
        while ((len2=inputStream.read(buffer2))!=-1){
            baos.write(buffer2, 0,len2);
        }
        System.out.println(baos.toString());

        //close resource
        baos.close();
        inputStream.close();
        fileIS.close();
        os.close();
        socket.close();

    }

}
