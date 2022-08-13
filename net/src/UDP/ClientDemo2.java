package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

/**
 组播
 */
public class ClientDemo2 {
    public static void main(String[] args) throws Exception{
        //创建客户端发送对象
        MulticastSocket socket = new MulticastSocket();

        //加入组播，
        //socket.joinGroup(InetAddress.getByName("224.0.1.1"));

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
            //组播
            DatagramPacket packet = new DatagramPacket(buffer,buffer.length, InetAddress.getByName("224.0.1.1"),8888);

            socket.send(packet);
        }


    }
}
