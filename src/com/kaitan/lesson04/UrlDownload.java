package com.kaitan.lesson04;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class UrlDownload {
    public static void main(String[] args) throws IOException {
        //下载地址
        URL url = new URL("https://www.w3.org/TR/PNG/iso_8859-1.txt");

        //连接到这个资源 http
        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
        InputStream intputStream =urlConnection.getInputStream();


        FileOutputStream fos =  new FileOutputStream("sample.txt");

        byte[] buffer = new byte[1024];
        int len;
        while ((len =intputStream.read(buffer))!=-1){
            fos.write(buffer, 0,len);
        }

        fos.close();
        intputStream.close();
        urlConnection.disconnect();
    }
}
