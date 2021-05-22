package com.kaitan.lesson02;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//Server
public class TcpServerDemo01 {
    public static void main(String[] args) {
        ServerSocket a1 = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;

        try {
            //服务器 自己需要一个地址
            //Socket插座的 意思
            a1 = new ServerSocket(9999);

            while(true){
                //等待客户端链接过来
                socket = a1.accept();

                //读取 客户端 消息
                is = socket.getInputStream();
                baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                while((len=is.read(buffer))!=-1){
                    baos.write(buffer,0,len);
                }
                System.out.println(baos.toString());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if (baos != null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (a1 != null){
                try {
                    a1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
