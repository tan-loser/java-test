package UDP;

import java.net.*;

public class ServerDemo2 {

    public static void main(String[] args) throws Exception{
        System.out.println("=================组播服务器端启动=================");
        //创建接受对象
        MulticastSocket socket = new MulticastSocket(8888);

        //加入组播
        socket.joinGroup(InetAddress.getByName("224.0.1.1"));

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

    }
}
