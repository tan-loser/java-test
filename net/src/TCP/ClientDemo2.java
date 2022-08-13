package TCP;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 即时通信客户端代码
 * 相当于群聊，每个用户可以看见其它客户端发送的消息，不只有客户端可以看见
 * 客户端创建一个接通消息的进程
 * 服务端端通过转发功能，储存每个客户端的通道，挨个转发
 */
public class ClientDemo2 {

    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("127.0.0.1",6666);
        //在这里创建客户端接受消息的线程
        new ClientReaderThread(socket).start();

        //以下代码可多发多收的原理一样
        OutputStream os = socket.getOutputStream();
        PrintStream ps = new PrintStream(os);
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("请说：");
            String str = sc.nextLine();
            ps.println(str);
            ps.flush();
        }

    }
}
