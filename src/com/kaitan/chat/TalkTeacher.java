package com.kaitan.chat;

public class TalkTeacher {
    public static void main(String[] args) {
        //开两个线程
        new Thread(new TalkSend("localhost", 8387, 5354)).start();
        new Thread(new TalkReceive(7376,"学生")).start();

    }
}
