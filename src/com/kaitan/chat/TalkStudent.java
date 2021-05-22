package com.kaitan.chat;

public class TalkStudent {
    public static void main(String[] args) {
        //开两个线程
        new Thread(new TalkSend("localhost", 7376, 9398)).start();
        new Thread(new TalkReceive(8387,"老师")).start();

    }
}
