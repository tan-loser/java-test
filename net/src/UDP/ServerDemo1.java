package UDP;

import java.net.*;
import java.util.Scanner;

public class ServerDemo1 {

    public static void main(String[] args) throws Exception{
        System.out.println("=================组播服务器端启动=================");
        //创建接受对象
        DatagramSocket socket = new DatagramSocket(8888);

        //多发多收
        byte[] buffer = new byte[64*1024];
        DatagramPacket packet = new DatagramPacket(buffer,buffer.length);

        while(true){
            socket.receive(packet);

            int len = packet.getLength();
            String rs = new String(buffer,0,len);
            System.out.println("=====================");
            System.out.println("ip:" + packet.getAddress());
            System.out.println("port:" + packet.getPort());
            System.out.println("data:" + rs);

        }


        //创建接受数据对象的数据包对象
        /*byte[] buffer = new byte[1024*64];
        DatagramPacket packet = new DatagramPacket(buffer,buffer.length);

        socket.receive(packet);

        int len = packet.getLength();
        String rs = new String(buffer,0,len);
        System.out.println(rs);

        //获取发送端的ip和端口
        String ip = packet.getAddress().toString();
        System.out.println("ip:" + ip);
        int port = packet.getPort();
        System.out.println(port);*/

        //socket.close();
    }
}
