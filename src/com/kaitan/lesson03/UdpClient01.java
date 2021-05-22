package com.kaitan.lesson03;

import java.io.IOException;
import java.net.*;

public class UdpClient01 {
    public static void main(String[] args) throws IOException {
        //不需要连接 Server，知识发送就行了
        //建立一个Socket
        DatagramSocket socket = new DatagramSocket();

        //建立包
        String msg="Hi Server";
        //发给谁
        InetAddress localhost= InetAddress.getByName("localhost");
        int port = 9090;

        //数据，数据长度起止，发给谁
        DatagramPacket packet = new DatagramPacket(msg.getBytes(),0,msg.getBytes().length,localhost,port);

        //发送包
        socket.send(packet);

        //关闭
        socket.close();
    }
}
