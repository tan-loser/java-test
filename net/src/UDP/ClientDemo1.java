package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClientDemo1{
    public static void main(String[] args) throws Exception{
        //创建客户端发送对象
        DatagramSocket socket = new DatagramSocket();

        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("请说：");
            String str = sc.nextLine();

            if("exit".equals(str)){
                System.out.println("离线成功！");;
                socket.close();
                break;
            }

            byte[] buffer = str.getBytes();
//            DatagramPacket packet = new DatagramPacket(buffer,buffer.length, InetAddress.getLocalHost(),8888);
            //广播
            DatagramPacket packet = new DatagramPacket(buffer,buffer.length, InetAddress.getByName("255.255.255.255"),8888);

            socket.send(packet);
        }




        /*
        //用于传输的数据
        byte[] buffer = "我是一个数据".getBytes();
        //创建一个数据包对象封装数据
        DatagramPacket packet = new DatagramPacket(buffer,buffer.length,InetAddress.getLocalHost(),8888);
        //发送数据
        socket.send(packet);

        //关闭
        socket.close();*/

    }
}
