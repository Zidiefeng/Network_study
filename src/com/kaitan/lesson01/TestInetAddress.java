package com.kaitan.lesson01;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {
    public static void main(String[] args) {
        try{
            //查本机 地址
            //new InetAddress();//无构造器，无法new
            InetAddress a1 = InetAddress.getByName("127.0.0.1"); ///127.0.0.1
            System.out.println(a1);
            InetAddress a3 = InetAddress.getByName("localhost"); //localhost/127.0.0.1
            System.out.println(a3);
            InetAddress a4 = InetAddress.getLocalHost();//DESKTOP-0JGJ8T2/192.168.1.156
            System.out.println(a4);

            //查 网站 ip地址
            InetAddress a2 = InetAddress.getByName("www.baidu.com"); //www.baidu.com/104.193.88.123
            System.out.println(a2);

            //常用方法
            System.out.println(a2.getAddress()); //[B@1b6d3586 字节地址，没啥用
            System.out.println(a2.getCanonicalHostName()); //规范 地址 104.193.88.123，没啥用
            System.out.println(a2.getHostAddress());//IP：104.193.88.123
            System.out.println(a2.getHostName()); //域名，或者 电脑 名称：www.baidu.com

        } catch (UnknownHostException e){
            e.printStackTrace();
        }

    }
}
