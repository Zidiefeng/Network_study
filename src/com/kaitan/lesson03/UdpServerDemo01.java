package com.kaitan.lesson03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServerDemo01 {
    public static void main(String[] args) throws IOException {
        //开放端口
        DatagramSocket socket = new DatagramSocket(9090);
        //接收数据包
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
        socket.receive(packet);//阻塞接收
        System.out.println(packet.getAddress().getHostName());
        System.out.println(new String(packet.getData(),0,packet.getLength()));


        //close
        socket.close();
    }
}

