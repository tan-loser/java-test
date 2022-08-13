package TCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 同时接受多个客户端发送的消息
 */
public class ServerDemo2 {
    public static void main(String[] args) {
        try {
            ServerSocket ssocket = new ServerSocket(7777);
            while(true){
                Socket socket = ssocket.accept();
                System.out.println(socket.getRemoteSocketAddress() + "他来了，上线了");
                new ServerDemo2Thread(socket).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
