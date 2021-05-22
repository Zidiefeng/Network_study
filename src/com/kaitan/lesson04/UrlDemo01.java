package com.kaitan.lesson04;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlDemo01 {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/helloworld/index.jsp?username=kaitan&password=123");
        System.out.println(url.getProtocol()); //协议 protocal: http
        System.out.println(url.getHost()); //主机 ip:  localhost
        System.out.println(url.getPort()); //端口： 8080
        System.out.println(url.getPath()); //文件：/helloworld/index.jsp
        System.out.println(url.getFile()); //全路径： /helloworld/index.jsp?username=kaitan&password=123
        System.out.println(url.getQuery()); //参数query part:  username=kaitan&password=123
    }
}
