package com.kaitan.lesson02;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

//Client
public class TcpClientDemo01 {
    public static void main(String[] args) {
        Socket s1 = null;
        OutputStream os = null;
        try {
            //Client去连接，要知道Server地址
            InetAddress serverIP=InetAddress.getByName("127.0.0.1");
            //端口号
            int port = 9999;
            //创建socket 连接
            s1 = new Socket(serverIP, port);
            //发送消息 IO流
            os = s1.getOutputStream();
            os.write("Welcome to the learning".getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (s1 != null){
                try {
                    s1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}
