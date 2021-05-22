package com.kaitan.lesson02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServerDemo02 {
    public static void main(String[] args) throws IOException {
        // 1.创建服务
        ServerSocket serverSocket = new ServerSocket(9000);

        //监听 客户端 连接，（阻塞式），如果没连过来，一直等待客户端
        Socket socket = serverSocket.accept();

        //获取输入流
        InputStream is = socket.getInputStream();

        //文件输出,让他变得能写出来
        FileOutputStream fos = new FileOutputStream(new File("receive.jpg"));
        byte[] buffer = new byte[1024];
        int len;
        while((len=is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }

        //通知客户端 接收完毕
        OutputStream os = socket.getOutputStream();
        os.write("我接受完毕了，你可以断开了".getBytes());

        fos.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}
