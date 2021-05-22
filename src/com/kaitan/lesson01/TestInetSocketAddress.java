package com.kaitan.lesson01;

import java.net.InetSocketAddress;

public class TestInetSocketAddress {
    public static void main(String[] args) {
        InetSocketAddress a1= new InetSocketAddress("127.0.0.1",8080);
        System.out.println(a1); ///127.0.0.1:8080

        InetSocketAddress a2= new InetSocketAddress("localhost",8080);
        System.out.println(a2); ///127.0.0.1:8080

        System.out.println(a2.getHostName()); //localhost
        System.out.println(a2.getAddress()); //localhost/127.0.0.1
        System.out.println(a2.getPort()); //8080
    }
}
