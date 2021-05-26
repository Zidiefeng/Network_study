# 【狂】网络编程Notes

## 计算机网络

- [ ]  [P1、什么是计算机网络18:27](https://www.bilibili.com/video/BV1LJ411z7vY?p=1)

### 类比信件

- 网络通信 可以 类比 传统通信

    ![%E3%80%90%E7%8B%82%E3%80%91%E7%BD%91%E7%BB%9C%E7%BC%96%E7%A8%8BNotes%204c916832d472473bb90a8ca3d8eaba8e/Untitled.png](%E3%80%90%E7%8B%82%E3%80%91%E7%BD%91%E7%BB%9C%E7%BC%96%E7%A8%8BNotes%204c916832d472473bb90a8ca3d8eaba8e/Untitled.png)

- 发送信息，需要 对方的 地址 还要注明 自己的 地址
- 两种传统通信方式：
    - 打电话：需要接通，然后才可 交互信息：这个类比 TCP协议
    - 发短信：发了就结束了，不需要等接通，但是发送出去之后可能出现 packet丢失，受损的 情况 导致 对方收不到讯息：这个类比UDP协议

### 计算机网络

- 定义：计算机网络是指将`地理位置不同`的具有独立功能的`多台计算机及其外部设备`，通过`通信线路连接起来`，在网络操作系统，网络管理软件及`网络通信协议`的管理和协调下，实现`资源共享和信息传递`的计算机系统
- 网络编程的 目的：
    - 传播交流信息，数据交换，通信
- 想要达到这个效果 需要：
    1. 如何准确 定位 网络上的 一台主机, 定位到了 这个计算机的 某个资源（IP：端口Port）
    2. 找到了这个主机，如何传输数据？（传输介质）
- 下面 两个概念不要混淆
    - Javaweb:网页编程 B/S架构(browser/server)
    - 网络编程: TCP C/S架构（client/server）

## 网络通信

- [ ]  [P2、网络通信的两个要素08:43](https://www.bilibili.com/video/BV1LJ411z7vY?p=2)

### 网络通信 要素

- 如何实现 网络通信
- 获取 双方的 地址：IP+Port可以定位到 某台 电脑的 某个应用
    - IP（唯一）：公网上 唯一， 但是在局域网内 可以 自定，与公网的 可能重复
    - 端口
- 规则（网络通信的 协议）
    - 有若干协议 http, ftp, smtp,...
    - 有参考模型
        1. TCP/IP参考模型（四层）：真正 使用 的 
            - http网络通信协议 超文本 传输协议
            - ftp 文件上传协议（将东西上传到服务器，需要打开对应端口）
            - smtp 比如 发送QQ邮件
            - Telnet 院成登录
            - DNS域名解析
            - 应用层：比如 QQ 微信
            - 传输层：通信（这个课程重点讲这层的 TCP UDP）
            - 网络层：封包，用来 通信，广播
            - 物理层：具体的传输（网线-光纤，无线，卫星传输）

            ![%E3%80%90%E7%8B%82%E3%80%91%E7%BD%91%E7%BB%9C%E7%BC%96%E7%A8%8BNotes%204c916832d472473bb90a8ca3d8eaba8e/Untitled%201.png](%E3%80%90%E7%8B%82%E3%80%91%E7%BD%91%E7%BB%9C%E7%BC%96%E7%A8%8BNotes%204c916832d472473bb90a8ca3d8eaba8e/Untitled%201.png)

        2. OSI参考模型（七层）：理想化的

            ![%E3%80%90%E7%8B%82%E3%80%91%E7%BD%91%E7%BB%9C%E7%BC%96%E7%A8%8BNotes%204c916832d472473bb90a8ca3d8eaba8e/Untitled%202.png](%E3%80%90%E7%8B%82%E3%80%91%E7%BD%91%E7%BB%9C%E7%BC%96%E7%A8%8BNotes%204c916832d472473bb90a8ca3d8eaba8e/Untitled%202.png)

            ![%E3%80%90%E7%8B%82%E3%80%91%E7%BD%91%E7%BB%9C%E7%BC%96%E7%A8%8BNotes%204c916832d472473bb90a8ca3d8eaba8e/Untitled%203.png](%E3%80%90%E7%8B%82%E3%80%91%E7%BD%91%E7%BB%9C%E7%BC%96%E7%A8%8BNotes%204c916832d472473bb90a8ca3d8eaba8e/Untitled%203.png)

### 小结

- 网络编程中 两个主要问题：
    1. 如何 准确定位到网络上的 一台或 多台 主机

        如下，可以在terminal 用ping找到一个网址 的 IP：

        ```java
        ping [www.baidu.com](http://www.baidu.com/)
        ```

        ```java
        Pinging [www.wshifen.com](http://www.wshifen.com/) [104.193.88.123] with 32 bytes of data:
        Reply from 104.193.88.123: bytes=32 time=78ms TTL=57
        Reply from 104.193.88.123: bytes=32 time=74ms TTL=57
        Reply from 104.193.88.123: bytes=32 time=73ms TTL=57
        Reply from 104.193.88.123: bytes=32 time=73ms TTL=57

        Ping statistics for 104.193.88.123:
        Packets: Sent = 4, Received = 4, Lost = 0 (0% loss),
        Approximate round trip times in milli-seconds:
        Minimum = 73ms, Maximum = 78ms, Average = 74ms
        ```

    2. 找到主机之后 如何通信
- 网络编程中的 要素
    - IP，Port - `IP`类
    - 网络通信协议 `udp`类， `tcp`类
- 万物皆对象
    - Java 里面肯定有 相应对象表示 上面的 要件

## IP地址

- [ ]  [P3、IP地址22:34](https://www.bilibili.com/video/BV1LJ411z7vY?p=3)

Java中 网络相关的 包 :`java.net`

ip地址类：InetAddress

- IP：唯一定位一台 网络上的 计算机
- 127.0.0.1：代表 本机 localhost

    如下，没有网的时候，呼叫自己 也能成功

    ```java
    ping 127.0.0.1

    Pinging 127.0.0.1 with 32 bytes of data:
    Reply from 127.0.0.1: bytes=32 time<1ms TTL=64
    Reply from 127.0.0.1: bytes=32 time<1ms TTL=64
    Reply from 127.0.0.1: bytes=32 time<1ms TTL=64
    Reply from 127.0.0.1: bytes=32 time<1ms TTL=64

    Ping statistics for 127.0.0.1:
        Packets: Sent = 4, Received = 4, Lost = 0 (0% loss),
    Approximate round trip times in milli-seconds:
        Minimum = 0ms, Maximum = 0ms, Average = 0ms
    ```

- IP地址 分类
    - ip地址：IPV4/IPV6
        - IPV4:类似127.0.0.1 四个字节组成， 每个0-255，一共42亿个（30亿在 北美，亚洲只有4亿）所以现在 都支持 IPV6，这个在2011年就用尽了（公网没了 私网还有）
        - IPV6：8个 无符号整数，128位(16*8) 每个 16位0-9和abcde,如 `2001:0bb2:001a:1092:abcd2:eee4:1094:a194`

            `ipconfig`可以看本机ip情况：

            ```java
            Windows IP Configuration

            Ethernet adapter Ethernet 4:

               Media State . . . . . . . . . . . : Media disconnected
               Connection-specific DNS Suffix  . :

            Wireless LAN adapter Local Area Connection* 1:

               Media State . . . . . . . . . . . : Media disconnected
               Connection-specific DNS Suffix  . :

            Wireless LAN adapter Local Area Connection* 2:

               Media State . . . . . . . . . . . : Media disconnected
               Connection-specific DNS Suffix  . :

            Wireless LAN adapter Wi-Fi:

               Connection-specific DNS Suffix  . : fios-router.home
               Link-local IPv6 Address . . . . . : fe80::93e:825a:eae:5332%2
               IPv4 Address. . . . . . . . . . . : 192.168.1.156
               Subnet Mask . . . . . . . . . . . : 255.255.255.0
               Default Gateway . . . . . . . . . : 192.168.1.1

            Ethernet adapter Bluetooth Network Connection 2:

               Media State . . . . . . . . . . . : Media disconnected
               Connection-specific DNS Suffix  . :
            ```

    - 公网- 私网 分类
        - 公网：给互联网使用（42亿的那个）
        - 私网：局域网
        - 192.168.xx.xx一般是 局域网，专门给 组织内部 使用
        - ABCD类 地址

            ![%E3%80%90%E7%8B%82%E3%80%91%E7%BD%91%E7%BB%9C%E7%BC%96%E7%A8%8BNotes%204c916832d472473bb90a8ca3d8eaba8e/Untitled%204.png](%E3%80%90%E7%8B%82%E3%80%91%E7%BD%91%E7%BB%9C%E7%BC%96%E7%A8%8BNotes%204c916832d472473bb90a8ca3d8eaba8e/Untitled%204.png)

            ![%E3%80%90%E7%8B%82%E3%80%91%E7%BD%91%E7%BB%9C%E7%BC%96%E7%A8%8BNotes%204c916832d472473bb90a8ca3d8eaba8e/Untitled%205.png](%E3%80%90%E7%8B%82%E3%80%91%E7%BD%91%E7%BB%9C%E7%BC%96%E7%A8%8BNotes%204c916832d472473bb90a8ca3d8eaba8e/Untitled%205.png)

### 域名

- 记忆IP问题-出现了 域名
- IP: www.jd.com
- com国际域名 cn是中国的

### IP Class: InetAddress

- 注意，InetAddress没有构造器，所以不能new,只能调用方法 来 创建 object

    如`InetAddress.getByName` ，`InetAddress.getByName("localhost")` ，`InetAddress.getLocalHost()`

- 产生的 Object 还可以调取 信息

    `a2.getAddress()` 没什么用，获取 字节

    `a2.getCanonicalHostName()` 获取 规范名（ip）

    `a2.getHostAddress()` 获取Host Address (ip)

    `a2.getHostName()` 获取 域名，或者 电脑名称

- 使用`InetAddress` 可以配合 自带的 try catch来用
- 特殊的：`127.0.0.1` == `localhost`

```java
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
```

## 端口Port

- [ ]  [P4、端口Port17:06](https://www.bilibili.com/video/BV1LJ411z7vY?p=4)

### 端口

- 端口 表示 计算机上的 一个 程序的 进程

    如下，任务管理器 PID（Port ID）对应进程

    ![%E3%80%90%E7%8B%82%E3%80%91%E7%BD%91%E7%BB%9C%E7%BC%96%E7%A8%8BNotes%204c916832d472473bb90a8ca3d8eaba8e/Untitled%206.png](%E3%80%90%E7%8B%82%E3%80%91%E7%BD%91%E7%BB%9C%E7%BC%96%E7%A8%8BNotes%204c916832d472473bb90a8ca3d8eaba8e/Untitled%206.png)

- 抽象来说，比如 一栋楼是IP，一户就是一个port
- 不同进程，有不同的 端口号Port，不能重复，Port用来 区分软件
- 端口号被规定 `0-65535`
- 电脑上有两种端口 TCP，UDP，每个都有65535个号 （65535*2个Port）
- TCP, UDP互相独立, 如TCP80和UDP80可同时存在（单个协议下Port号不能冲突）

### 端口分类

- 公有端口：`0-1023`，一般会被 内置进程 或者 服务器用，比如：
    - http 是 80 Port
    - https 是 433 Port, 比如，输入[https://www.google.com](https://www.google.com/):443 是可以的，访问的 其实是google的443 Port
    - FTP: 21
    - Telent: 23
- 常用程序注册：`1024-49151`，分配给 用户 或者 程序
    - Tomcat: 8080
    - MySQL: 3306
    - Oracle: 1521
- 动态端口，私有端口: `49152- 65535` 尽量不要占用

### 查看命令

- 查看使用的 所有Port：`netstat -ano`

    ```java
    Active Connections

      Proto  Local Address          Foreign Address        State           PID
      TCP    0.0.0.0:135            0.0.0.0:0              LISTENING       1260
      TCP    0.0.0.0:445            0.0.0.0:0              LISTENING       4
      TCP    0.0.0.0:3306           0.0.0.0:0              LISTENING       6708
      TCP    0.0.0.0:5040           0.0.0.0:0              LISTENING       1772
      TCP    0.0.0.0:5091           0.0.0.0:0              LISTENING       17492
      TCP    0.0.0.0:7680           0.0.0.0:0              LISTENING       2440
      TCP    0.0.0.0:33060          0.0.0.0:0              LISTENING       6708
     ...
      UDP    127.0.0.1:52166        *:*                                    23920
      UDP    192.168.1.156:2177     *:*                                    21208
      UDP    192.168.1.156:50317    *:*                                    2700
      UDP    [::]:3702              *:*                                    4372
      UDP    [::]:3702              *:*                                    4372
      UDP    [::]:5353              *:*                                    3928
      UDP    [::1]:1900             *:*                                    2700
      UDP    [::1]:50316            *:*                                    2700
      UDP    [fe80::93e:825a:eae:5332%2]:1900  *:*                                    2700
      UDP    [fe80::93e:825a:eae:5332%2]:2177  *:*                                    21208
      UDP    [fe80::93e:825a:eae:5332%2]:50315  *:*                                    2700
    ```

- 查看 指定端口Port: `netstat -ano|findstr "6708"`

    ```java
    netstat -ano|findstr "6708"
    TCP    0.0.0.0:3306           0.0.0.0:0              LISTENING       6708
    TCP    0.0.0.0:33060          0.0.0.0:0              LISTENING       6708
    TCP    127.0.0.1:49681        127.0.0.1:49682        ESTABLISHED     6708
    TCP    127.0.0.1:49682        127.0.0.1:49681        ESTABLISHED     6708
    TCP    [::]:3306              [::]:0                 LISTENING       6708
    TCP    [::]:33060             [::]:0                 LISTENING       6708
    ```

- 查看某进程（根据PID）查看 指定端口的 进程:`tasklist|findstr "9000"`

    ```java
    tasklist|findstr "9000"
    chrome.exe                    9000 Console                    6     14,784 K
    ```

- control + shift + esc 任务管理器
- hosts地址 配置文件：`C:\Windows\System32\drivers\etc`中的`hosts`

### Port接收器

- 你发信息，到 IP:Port, 如果发到的 对方没有 对应的 接收器，信息就丢了，所以要制定好 要传送的 位置

## 通信协议

- [ ]  [P5、通信协议14:08](https://www.bilibili.com/video/BV1LJ411z7vY?p=5)

### 协议

- 约定，就像 我们 现在说的 是 普通话（为了能够交流）
- 网络通信协议: 速率，传输码率，代码传输结构，传输控制（问题：非常复杂)
- 大事化小-分层
- TCP/IP协议簇：有多个协议，不止两个协议，实际上是一组协议：

    （比如 出名的协议：）

    - TCP:
    - IP: 网络互联协议

### TCP UDP对比

- 两个都在 传输层
- TCP: 用户传输协议 （电话）
    - 需要连接，稳定
    - 三次握手（至少3次，才能稳定连接）

        ```java
        A: 你瞅啥 （我想连接）
        B: 瞅你咋地 （回应，你还在吗）
        A: 干吧 （在，来吧！）
        ```

        ![%E3%80%90%E7%8B%82%E3%80%91%E7%BD%91%E7%BB%9C%E7%BC%96%E7%A8%8BNotes%204c916832d472473bb90a8ca3d8eaba8e/Untitled%207.png](%E3%80%90%E7%8B%82%E3%80%91%E7%BD%91%E7%BB%9C%E7%BC%96%E7%A8%8BNotes%204c916832d472473bb90a8ca3d8eaba8e/Untitled%207.png)

    - 四次挥手：网络断开

        ```java
        A：我要走了
        B: 你真的 要走了吗？
        B: 你真的真的 要走了吗
        A: 我真的 要走了
        ```

        ![%E3%80%90%E7%8B%82%E3%80%91%E7%BD%91%E7%BB%9C%E7%BC%96%E7%A8%8BNotes%204c916832d472473bb90a8ca3d8eaba8e/Untitled%208.png](%E3%80%90%E7%8B%82%E3%80%91%E7%BD%91%E7%BB%9C%E7%BC%96%E7%A8%8BNotes%204c916832d472473bb90a8ca3d8eaba8e/Untitled%208.png)

    - 分为 客户端 和 服务端
    - 传输完成，释放连接，效率低
- UDP：用户数据包协议 （短信）
    - 不用连接，不稳定
    - 也分 客户端 和 服务端，但没有 确切的 界线（甚至可以 Client给Client发）
    - 不管有没有准备好，都可以发给你
    - UDP类似 导弹攻击
    - DDOS：洪水 攻击，给你发一大堆 垃圾包，堵住Port，网络就不行了（饱和攻击）

## TCP实现聊天

- [ ]  [P6、TCP实现聊天19:07](https://www.bilibili.com/video/BV1LJ411z7vY?p=6)

### TCP聊天

- 至少要有2个人 聊天： Client, Server（所以Java要编这两个类）
- Client
    1. 连接 服务器Socket
    2. 发送消息
- Server
    1. 建立服务端口
    2. 等待用户的 连接 accept
    3. 接收消息

这里需要IO知识，除此之外，Server如果不写while（尚未贴过来），接到一次消息就停了，写while就可以一直 接收 新消息

### Client

- 建立`Socket` ：找到 发送目的地的 网络位置：IP+Port → `Socket`，如 `new Socket(serverIP, port);`
- 建立`OutStream`：`socket.getOutputStream()` 创建 网络位置Socket的 `OutputStream` （发送过去 的 地址）
- 写入信息：`outputStream.write("Welcome to the learning".getBytes());`
- 关闭服务：
    - 先开后关
    - 目前有两个服务要关：Socket（先开后关），OutputStream（后开 先关）
    - 关闭的时候：首先要 判断是否 为 null，然后使用try catch 进行close，如`s1.close();`

    ```java
    package com.kaitan.lesson02;

    import java.io.IOException;
    import java.io.OutputStream;
    import java.net.InetAddress;
    import java.net.Socket;
    import java.net.UnknownHostException;

    //Client
    public class TcpClientDemo01 {
        public static void main(String[] args) {
            Socket s1 = null;
            OutputStream os = null;
            try {
                //Client去连接，要知道Server地址
                InetAddress serverIP=InetAddress.getByName("127.0.0.1");
                //端口号
                int port = 9999;
                //创建socket 连接
                s1 = new Socket(serverIP, port);
                //发送消息 IO流
                os = s1.getOutputStream();
                os.write("Welcome to the learning".getBytes());

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (os != null){
                    try {
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (s1 != null){
                    try {
                        s1.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
    ```

### Server

- 新建Socket 接收位置`ServerSocket`：`new ServerSocket(9999);`
- 根据ServerSocket创建 Socket，等待客户端链接过来：`socket = serverSocket.accept();` 注意，**如果 没有收到 消息，会一直 停在这步！直到接收到信息**
- （等 发过来的 时候）读取 客户端 消息，根据 socket创建`InputStream`：`socket.getInputStream();`
- 读取接收到的 信息
    - 依次将`InputStream` 读到的 每个字节 放入 `buffer`: `is.read(buffer)`
    - 建立一个新的`ByteArrayOutputStream` （用来 承接Socket接收到的讯息，怕中间出现问题）：`new ByteArrayOutputStream();`
    - 然后再从buffer导入`ByteArrayOutputStream` ：`baos.write(buffer,0,len)`
- 查看 接收到的 信息：System.out.println(`baos.toString()`);
- 依次关闭 资源（先开后关）
    - baos：`ByteArrayOutputStream`
    - is ：`InputStream`
    - socket：`socket`
    - a1：`ServerSocket`

    ```java
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
                //等待客户端链接过来
                socket = a1.accept();
                //读取 客户端 消息
                is = socket.getInputStream();
                baos = new ByteArrayOutputStream();

                byte[] buffer = new byte[1024];
                int len;
    						// read stream data into buffer: is.read(buffer)
                while((len=is.read(buffer))!=-1){
                    baos.write(buffer,0,len);
                }
                System.out.println(baos.toString());

            }catch (IOException e) {
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
    ```

- 可以改动代码，使得Server 一直循环接收 信息（每次 接收之后 重新 等待）

    使用while(true):

    ```java
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
    ```

## TCP上传

- [ ]  [P7、TCP文件上传实现17:27](https://www.bilibili.com/video/BV1LJ411z7vY?p=7)

### 从Client将文件传给Server

- 连接 都是 socket
    - Client: `Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);`
    - Server: `ServerSocket serverSocket = new ServerSocket(9000);
    Socket socket = serverSocket.accept();`
- 从Client 传文件 到 Server
    - Client: 先用FileInputStream 传入数据 到 buffer里，然后再通过 OutputStream 将buffer传出去（socket）
    - Server:`socket.getInputStream()` 将input得到的内容 写进buffer，把buffer内容放到 FileOutputStream里
- Client和Server交流 是否传输完毕
    - Client: 告诉Server 什么时候算传完

        ```java
        //通知服务器，我已经传完了
        socket.shutdownOutput();
        ```

    - Server：接收到上面传完的 信号之后，通过`OutputStream`发消息给Client

        ```java
        //通知客户端 接收完毕
        OutputStream os = socket.getOutputStream();
        os.write("我接受完毕了，你可以断开了".getBytes());
        ```

    - Client用`socket.getInputStream()` 把信息 流 存为buffer2然后包装进`ByteArrayOutputStream` 再print 出来（`baos.toString()`）

        注意，这里之所以使用`ByteArrayOutputStream` 是因为 在接受之前 不清楚 接收的 到底是什么信息，为了能顺利print出来，使用字节流

- 最后，关闭 Client 和 Server所用到的所有resource(先开后关)

```java
package com.kaitan.lesson02;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClientDemo02 {
    public static void main(String[] args) throws IOException {

        //创建一个Socket连接
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);

        //创建一个输出流
        OutputStream os = socket.getOutputStream();
        //文件流-读取文件
        FileInputStream fileIS = new FileInputStream(new File("1.jpg"));
        //写出文件
        byte[] buffer = new byte[1024];
        int len;
        while ((len=fileIS.read(buffer))!=-1){
            os.write(buffer, 0,len);
        }

        //通知服务器，我已经传完了
        socket.shutdownOutput();

        //确定服务器 接收完毕，才能断开
        InputStream inputStream = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer2 = new byte[1024];
        int len2;
        while ((len2=inputStream.read(buffer2))!=-1){
            baos.write(buffer2, 0,len2);
        }
        System.out.println(baos.toString());

        //close resource
        baos.close();
        inputStream.close();
        fileIS.close();
        os.close();
        socket.close();

    }

}
```

```java
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
```

## Tomcat

- [ ]  [P8、初识Tomcat07:38](https://www.bilibili.com/video/BV1LJ411z7vY?p=8)

### Client - Server

- （如上）自定义 Client- 自定义Server `C/S`
- 也可以Client通过浏览器 -使用Tomcat弄服务器（人家用java写好的）`B/S`

这一章节主要是 带着看了 用写好的 server-Tomcat工具 安装流程见 下面的帖子

[(6条消息) 看B站狂神说java安装Tomcat_再熬夜是小猪的博客-CSDN博客](https://www.notion.so/6-B-java-Tomcat_-CSDN-a808e836cbcd411a8754e1e2ba3a51b6)

## UDP

- [ ]  [P9、UDP消息发送12:08](https://www.bilibili.com/video/BV1LJ411z7vY?p=9)

### UDP

- 跟TCP不同，不需要 建立连接就能发消息（知道对方的地址就行）
- 重点的包：
    - 发的 包裹： `DatagramPacket`
    - 发送器： `DatagramSocket`
- 注意：上面的TCP如果没有连接到Server，client代码 会报错。但是即使server不存在，UDP client代码也不会报错

### UDP-Client

- 建立socket：`DatagramSocket socket = new DatagramSocket();`
- 建立包：`DatagramPacket packet = new DatagramPacket(发送的字节信息,起位置,止位置,对方ip,对方port);`
- 发送包：`socket.send(packet);`
- 关闭服务`socket.close();`

    ```java
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
    ```

### UDP-Server方

- 不需要真正建立Server，使用socket就行（不用socketServer） `DatagramSocket socket = new DatagramSocket(9090);`
- 没有Server概念，只有sender, receiver的 概念
- 收包的时候，建立一个空的byte数组，由此 新建一个packet接受包：`DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);`
- 接收信息 存进packet（注意，这个是阻塞接受，意味着没收到就一直等，收到了 就往下进行）:`socket.receive(packet);`
- 最后关闭服务`socket.close()`

    ```java
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
    ```

### UDP聊天

- [ ]  [P10、UDP聊天实现10:39](https://www.bilibili.com/video/BV1LJ411z7vY?p=10)

### sender 多次发送给 receiver

- Sender和Receiver都是`DatagramSocket socket = new DatagramSocket(6666);`
- sender 循环发送数据
    - 承接键盘输入的东西：`BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));` （`System.in`是键盘输入）
    - 转成String数据：`String data = reader.readLine();`
    - 然后存进 byte数组datas,再打包成`DatagramPacket`
    - `socket.send(packet);`
    - 若输出bye跳出循环，关闭资源：`socket.close();`
- Received循环接收数据
    - 新建空的 byte 接收包`DatagramPacket`
    - 将受到的data存进packet  `socket.receive(packet);`
    - 去除packet中的数据，然后print出来：`byte[] data = packet.getData();
    String receivedData = new String(data, 0, data.length);`
    - 若收到bye跳出循环，关闭资源：`socket.close();`

```java
package com.kaitan.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UdpSenderDemo01 {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(6666);

        while (true){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String data = reader.readLine();

            byte[] datas = data.getBytes();
            DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",6666));
            socket.send(packet);
            if (data.equals("bye")){
                break;
            }
        }

        socket.close();
    }
}

```

```java
package com.kaitan.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceiverDemo01 {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(6666);
        while (true){
            byte[] container = new byte[1024];
            DatagramPacket packet = new DatagramPacket(container, 0,container.length);

            socket.receive(packet);
            byte[] data = packet.getData();
            String receivedData = new String(data, 0, data.length);
            System.out.println(receivedData);

            //若bye,就停下来
            if (receivedData.equals("bye")){
                break;
            }
        }
        socket.close();

    }
}
```

### UDP多线程

- [ ]  [P11、UDP多线程在线咨询15:43](https://www.bilibili.com/video/BV1LJ411z7vY?p=11)

改造上面的代码，不止是单项发送，利用 多线程 实现 双向收发 信息

### 构思代码

- 定义两个类，分别继承Runnable接口，以支持多线程
    - 一个发送 `TalkSend("localhost", 7376, 9398)`
    - 一个接收 `TalkReceive(8387,"老师")`
- 如下，每一参与者都可以 同步收发 信息了

    靠这个 新建线程： `new Thread(new TalkSend("localhost", 7376, 9398)).start();`

    ```java
    package com.kaitan.chat;

    public class TalkStudent {
        public static void main(String[] args) {
            //开两个线程
            new Thread(new TalkSend("localhost", 7376, 9398)).start();
            new Thread(new TalkReceive(8387,"老师")).start();

        }
    }
    ```

    ```java
    package com.kaitan.chat;

    public class TalkTeacher {
        public static void main(String[] args) {
            //开两个线程
            new Thread(new TalkSend("localhost", 8387, 5354)).start();
            new Thread(new TalkReceive(7376,"学生")).start();

        }
    }
    ```

### TalkSend

- 跟上面的 变换而来

```java
package com.kaitan.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class TalkSend implements Runnable {
    DatagramSocket socket =null;
    BufferedReader reader = null;
    private String toIP;
    private int toPort;
    private int fromPort;

    public TalkSend(String toIP, int toPort, int fromPort) {
        this.toIP = toIP;
        this.toPort = toPort;
        this.fromPort = fromPort;
        try {
            socket = new DatagramSocket(fromPort);
            reader = new BufferedReader(new InputStreamReader(System.in));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        while (true){
            try {
                String data = reader.readLine();
                byte[] datas = data.getBytes();
                DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress(this.toIP,this.toPort));
                socket.send(packet);
                if (data.equals("bye")){
                    break;
                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }

        socket.close();
    }
}

```

### TalkReceive

```java
package com.kaitan.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class TalkReceive implements Runnable{
    DatagramSocket socket =null;
    private int port;
    private String msgFrom;

    public TalkReceive(int port,String msgFrom) {
        this.port = port;
        this.msgFrom=msgFrom;
        try{socket = new DatagramSocket(port);}
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true){
                byte[] container = new byte[1024];
                DatagramPacket packet = new DatagramPacket(container, 0,container.length);

                socket.receive(packet);
                byte[] data = packet.getData();
                String receivedData = new String(data, 0, data.length);

                System.out.println(msgFrom+": "+receivedData);
                //若bye,就停下来
                if (receivedData.equals("bye")){
                    break;
                }
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### URL下载资源

- [ ]  [P12、URL下载网络资源16:18](https://www.bilibili.com/video/BV1LJ411z7vY?p=12)

### URL

- 本机定位地址 也是URL
- 统一资源定位符：定位互联网上的某一个资源

### URL组成

- 例如 https://www.baidu.com
- DNS：域名解析，也就是把www.baidu.com（域名）解析成ip地址
- `协议://ip地址:端口号/项目名/资源` （5部分组成，可以少，不能多）

### URL类

可以通过各种get调取 查询的 内容

```java
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
```

### 通过URL下载到本地

- 建立URL，通过`HttpURLConnection`和`urlConnection.getInputStream();` 获取该URL的 内容
- 然后通过intputStream写进buffer，再通过FileOutputStream 导出为文件
- 注意！无论什么格式都可以通过下面的 byte 的 buffer下载！

```java
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
```